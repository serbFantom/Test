package com.serb.sorting.util;

/**
 * Created by SBezugliy
 * Date: 21.08.2009
 */
import java.util.List;
import java.io.IOException;

public interface FileSortStorage<T> extends Iterable<T> {
    public void setObjects(List<T> objects) throws IOException;
}
