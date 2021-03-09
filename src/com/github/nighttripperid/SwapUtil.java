// A java port of OLC's arbitray rectangle collision complete solution. Props to javid9x for his excellent tutorial!
// watch https://www.youtube.com/watch?v=DPfxjQ6sqrc for reference
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
