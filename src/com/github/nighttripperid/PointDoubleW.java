// A java port of OLC's arbitrary rectangle collision complete solution. Props to javidx9 for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;

public class PointDoubleW {

    public NumWrap<Double> x;
    public NumWrap<Double> y;

    public PointDoubleW(){
        x = new NumWrap<>(0D);
        y = new NumWrap<>(0D);
    }

    public PointDoubleW(Double x, Double y) {
        this();
        if (x == null) this.x = null;
        else this.x.num = x;
        if (y == null) this.y = null;
        else this.y.num = y;
    }

    public PointDoubleW plus(PointDoubleW that) {
        return new PointDoubleW(this.x.num + that.x.num, this.y.num + that.y.num);
    }

    public PointDoubleW minus(PointDoubleW that) {
        return new PointDoubleW(this.x.num - that.x.num, this.y.num - that.y.num);
    }

    public PointDoubleW times(PointDoubleW that) {
        return new PointDoubleW(this.x.num * that.x.num, this.y.num * that.y.num);
    }

    public PointDoubleW div(PointDoubleW that) {
        return new PointDoubleW(this.x.num / that.x.num, this.y.num / that.y.num);
    }

    public void set(Double x, Double y) {
        this.x.num = x;
        this.y.num = y;
    }

    public void set(PointDouble p) {
        this.x.num = p.x;
        this.y.num = p.y;
    }

    public void set(PointDoubleW p) {
        this.x.num = p.x.num;
        this.y.num = p.y.num;
    }

    public static PointDoubleW of (Double d) {
        return new PointDoubleW(d, d);
    }


    public PointDouble unwrap() {
        return new PointDouble(x.num, y.num);
    }

    @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (p == null || getClass() != p.getClass()) return false;
        PointDoubleW that = (PointDoubleW) p;
        return Double.compare(that.x.num, this.x.num) == 0 && Double.compare(that.y.num, this.y.num) == 0;
    }
}