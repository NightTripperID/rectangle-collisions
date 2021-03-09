// A java port of OLC's arbitrary rectangle collision complete solution. Props to javid9x for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;

public class PointDouble {

    public Double x;
    public Double y;

    public PointDouble(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public PointDouble plus(PointDouble that) {
        return new PointDouble(this.x + that.x, this.y + that.y);
    }

    public PointDouble minus(PointDouble that) {
        return new PointDouble(this.x - that.x, this.y - that.y);
    }

    public PointDouble times(PointDouble that) {
        return new PointDouble(this.x * that.x, this.y * that.y);
    }

    public PointDouble div(PointDouble that) {
        return new PointDouble(this.x / that.x, this.y / that.y);
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(PointDouble p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void set(PointDoubleW p) {
        this.x = p.x.num;
        this.y = p.y.num;
    }

    public PointDoubleW wrap() {
        return new PointDoubleW(this.x, this.y);
    }

    public Double mag() {
        return Math.sqrt(x * x + y * y);
    }

    public Double mag2() {
        return x * x + y * y;
    }

    public PointDouble norm() {
        double r = 1 / mag();
        return new PointDouble(x * r, y * r);
    }

    public static PointDouble of(Double num) {
        return new PointDouble(num, num);
    }
}
