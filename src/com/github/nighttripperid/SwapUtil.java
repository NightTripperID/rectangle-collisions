// A java port of OLC's arbitrary rectangle collision complete solution. Props to javidx9 for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;


public class SwapUtil {
    private SwapUtil() {
    }
    public static <T extends Number> void swap(NumWrap<T> n1, NumWrap<T> n2) {
        NumWrap<T> temp = new NumWrap<>();
        temp.num = n1.num;
        n1.num = n2.num;
        n2.num = temp.num;
    }
}
