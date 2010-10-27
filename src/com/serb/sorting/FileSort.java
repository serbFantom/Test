package com.serb.sorting;

/**
 * Created by SBezugliy
 * Date: 21.08.2009
 */
import com.serb.sorting.util.FileSortStorage;
import com.serb.sorting.util.FileSortStorageObject;

import java.io.*;
import java.util.*;

/**
* ����� ��� ���������� ������� ������ ������ � �������������� �������� ��������
 * ����� �� http://habrahabr.ru/blogs/java/65612/
 */
//todo:play with it
public class FileSort<T extends Comparable<T>> implements Iterable<T> {
    private int bufferSize = 10000;
    private List<FileSortStorage> partFiles = new LinkedList<FileSortStorage>();
    private Iterator<T> source;
    private List<T> part = new LinkedList<T>();
    /**
     * ����������� �� ���������, ������ �� ������
     */
    public FileSort() {
    }
    /**
     * ����������� � ���������� - ����������
     */
    public FileSort(Iterator<T> newSource) {
        setSource(newSource);
    }
    /**
     * ����������� � ����� ����������� - ���������� � ����������� �������� �� ����
     */
    public FileSort(Iterator<T> newSource, Integer newSize) {
        this(newSource);
        setBufferSize(newSize);
    }
    /**
     * ��������� ���������� �������� �� ���� ����
     */
    public void setBufferSize(int newSize) {
        bufferSize = newSize;
    }
    /**
     * ��������� ��������� ������, ������������ ��������
     */
    public void setSource(Iterator<T> newSource) {
        source = newSource;
        try {
            sortParts();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(part);
    }
    /**
     * ��������� ���������� � ���� ���������
     */
    public Iterator<T> iterator() {
        if (partFiles.size() == 0) {
            // ��������� �����������, ���� �� ���������� � ������
            return part.iterator();
        }
        return new Iterator<T>() {
            Long t = 0L;
            List<T> items = new ArrayList<T>();
            List<Iterator<T>> iterators = new ArrayList<Iterator<T>>();
            Integer minIdx = null;
            // ������������ ������������� ���������, ������ ������������
            // ������ ������ ���������� �� ������ �� ����, �� ������� ����� ��������� �������� ��� �������
            {
                iterators.add(part.iterator());
                for (FileSortStorage f : partFiles) {
                    iterators.add(f.iterator());
                }
                for (Iterator<T> item : iterators) {
                    if (item.hasNext()) {
                        items.add(item.next());
                    } else {
                        throw new RuntimeException("failed to get first for iterator");
                    }
                }
            }
            /**
             * ������� ����� �������� �����������, ���������� ����������� ���������� �������
             */
            public boolean hasNext() {
                if (minIdx == null) {
                    for (int i = 0; i < items.size(); i++) {
                        if (items.get(i) != null &&
                                (minIdx == null ||
                                 items.get(i).compareTo(items.get(minIdx)) < 0)) {
                            minIdx = i;
                        }
                    }
                }
                return minIdx != null;
            }
            /**
             * ���� ���� ��������� ������ - ����������,
             * ������� ��� � ��������� �� ��������� �� �����
             */
            public T next() {
                T res = null;
                if (hasNext()) {
                    res = items.get(minIdx);
                    if (iterators.get(minIdx).hasNext()) {
                        items.set(minIdx, iterators.get(minIdx).next());
                    } else {
                        items.set(minIdx, null);
                    }
                }
                minIdx = null;
                return res;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    /**
     * ���������� ������ �������� ������ � ����������� ������ �� ��������� �����
     * @throws java.io.IOException
     */
    void sortParts() throws IOException {
        while (source.hasNext()) {
            part.add((T)source.next());
            if (part.size() >= bufferSize && source.hasNext()) {
                Collections.sort(part);
                partFiles.add(new FileSortStorageObject(part));
                part.clear();
            }
        }
    }
}