// A java port of OLC's arbitrary rectangle collision complete solution. Props to javid9x for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
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