package com.serb.sorting.opreg_test;

/**
 * Created by sbezugliy
 * Date: 30.09.2009
 */
public enum PendingMessageRowStatus {
    VALID(0), INVALID(1), OPEN(2), CLEARED(3), CANCELLED(4), OLD(5), NEARLY(6);

    private final int id;

    private PendingMessageRowStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static PendingMessageRowStatus getStatus(int id, PendingMessageRowStatus defaultStatus) {
        for (PendingMessageRowStatus status : PendingMessageRowStatus.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        return defaultStatus;
    }

    public static PendingMessageRowStatus getStatus(int id) {
        return getStatus(id, VALID);
    }
}
