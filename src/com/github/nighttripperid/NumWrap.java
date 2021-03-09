// A java port of OLC's arbitrary rectangle collision complete solution. Props to javidx9 for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;

public class NumWrap<T extends Number> {
    public T num;

    public NumWrap() {
    }
    public NumWrap(T num) {
        this.num = num;
    }
}
