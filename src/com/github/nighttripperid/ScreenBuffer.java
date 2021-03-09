// A java port of OLC's arbitray rectangle collision complete solution. Props to javid9x for his excellent tutorial!
// watch https://www.youtube.com/watch?v=DPfxjQ6sqrc for reference
package com.github.nighttripperid;

public class ScreenBuffer {
    private int width;
    private int height;
    private int scale;
    private int[] pixels;
    private PointDouble scroll = new PointDouble(0D, 0D);

    public ScreenBuffer(int width, int height, int scale) {
        this.width = width;
        this.height = height;
        this.scale = scale;
        this.pixels = new int[width * height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    public PointDouble getScroll() {
        return scroll;
    }

    public void setScroll(PointDouble scroll) {
        this.scroll = scroll;
    }
}
