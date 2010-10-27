package com.serb.sorting;

/**
 * Created by SBezugliy
 * Date: 21.08.2009
 */
public class ByteArraySorter {
    private static final int BYTE_MODEL_SIZE = 256;
    private static final int BYTE_MASK = 0xFF;
    private static final int BYTE_SIGNED_MIN_VALUE = -128;
    private static final int BYTE_SIGNED_MAX_VALUE = 127;
    private static final int BYTE_UNSIGNED_MIN_VALUE = 0;
    private static final int BYTE_UNSIGNED_MAX_VALUE = 255;

    public static void sort(byte[] buffer) {
        sort(buffer, BYTE_SIGNED_MIN_VALUE, BYTE_SIGNED_MAX_VALUE);
    }

    public static void sortUnsigned(byte[] buffer) {
        sort(buffer, BYTE_UNSIGNED_MIN_VALUE, BYTE_UNSIGNED_MAX_VALUE);
    }

    private static void sort(byte[] buffer, int fromValue, int toValue) {

        if (buffer == null) {
            return;
        }

        int length = buffer.length;

        if (length == 0) {
            return;
        }

        int[] model = new int[BYTE_MODEL_SIZE];

        for (int i = 0; i < length; i++) {
            model[buffer[i] & BYTE_MASK]++;
        }
        
        int index = 0;

        for (int i = fromValue; i <= toValue; i++) {
            int toIndex = index + model[i & BYTE_MASK];
            while (index < toIndex) {
                buffer[index] = (byte) i;
                index++;
            }
        }
    }
}
