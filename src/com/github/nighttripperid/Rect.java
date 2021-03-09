// A java port of OLC's arbitray rectangle collision complete solution. Props to javid9x for his excellent tutorial!
// watch https://www.youtube.com/watch?v=DPfxjQ6sqrc for reference
package com.github.nighttripperid;

public class Rect {
    public PointDouble pos;
    public PointDouble size;
    public PointDouble vel;

    public Rect[] contact = new Rect[4];

    public Rect() {
        pos = PointDouble.of(0D);
        size = PointDouble.of(0D);
        vel = PointDouble.of(0D);
    }

    public Rect(PointDouble pos, PointDouble size) {
        this.pos = pos;
        this.size = size;
        this.vel = PointDouble.of(0D);
    }
}