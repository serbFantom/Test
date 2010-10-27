package com.serb.sorting;

import java.util.Random;
import java.util.Iterator;

/**
 * Created by sbezugliy
 * Date: 06.10.2009
 */
public class TestFileSort {
    public static void main(String[] args) {
        System.out.println("Test start");
        // ������ �����-�����������

        FileSort<Double> sort = new FileSort<Double>(
                // � ����������� ������� �������� - �������� ������
                // � ��� �� ������ ���������� ��������� �����
                new Iterator<Double>() {
                    private int i = 0;
                    private Random rand = new Random();

                    public boolean hasNext() {
                        if (i >= 1000) {
                            System.out.println("generator finish");
                        }
                        return i < 1000;
                    }

                    public Double next() {
                        i++;
                        return rand.nextDouble();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                });
        int i = 0;
        // ������� ��������������� ���������

        for (Double res : sort) {
            if (++i % 10000 == 0) {
                // ����� ����������� ����� ����� ����� �� ����� ���������
                // � ������ ������� ����������
                System.out.println(i);
            }
            System.out.println(" == " + res);
        }
    }
}
