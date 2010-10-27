package com.serb.java2D;

import java.awt.*;

/**
 * This class wraps a graphics configuration so that it can be
 * displayed nicely in components.
 */
class GCWrapper {
    private GraphicsConfiguration gc;
    private int index;

    public GCWrapper(GraphicsConfiguration gc, int index) {
        this.gc = gc;
        this.index = index;
    }

    public GraphicsConfiguration getGC() {
        return gc;
    }

    public String toString() {
        return gc.toString();
    }
}
