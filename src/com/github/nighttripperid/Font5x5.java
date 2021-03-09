// A java port of OLC's arbitrary rectangle collision complete solution. Props to javidx9 for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;

import java.util.HashMap;
import java.util.Map;

public class Font5x5 {
    private static final Map<Character, Character[]> chars = new HashMap<>();

    private Font5x5() {
    }

    public static Character[] getChar(Character c){
        if (c == null)
            return Font5x5.SPACE;
        Character[] character = chars.get(Character.toUpperCase(c));
        return character == null ? Font5x5.SPACE : character;
    }


    private static final Character[] A = { 0 ,'#','#', 0 , 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                          '#','#','#','#', 0 ,
                                          '#', 0 , 0 ,'#', 0

    };

    private static final Character[] B = { '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#','#','#', 0 , 0

    };

    private static final Character[] C = {  0 ,'#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                            0 ,'#','#', 0 , 0

    };

    private static final Character[] D = { '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#','#','#', 0 , 0
    };

    private static final Character[] E = { '#','#','#','#', 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#','#','#','#', 0
    };

    private static final Character[] F = { '#','#','#','#', 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0
    };

    private static final Character[] G = {  0 ,'#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                            0 ,'#','#','#', 0

    };

    private static final Character[] H = { '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#','#','#','#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0
    };

    private static final Character[] I = { '#','#','#','#', 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            '#','#','#','#', 0
    };

    private static final Character[] J = { '#','#','#','#', 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                           '#', 0 ,'#', 0 , 0 ,
                                           '#','#','#', 0 , 0
    };

    private static final Character[] K = { '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 ,'#', 0 , 0 ,
                                           '#','#', 0 , 0 , 0 ,
                                           '#', 0 ,'#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0
    };

    private static final Character[] L = { '#', 0 , 0 , 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#','#','#','#', 0

    };

    private static final Character[] M = { '#', 0 , 0 ,'#', 0 ,
                                           '#','#','#','#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0

    };

    private static final Character[] N = { '#', 0 , 0 , '#', 0 ,
                                           '#','#', 0 , '#', 0 ,
                                           '#', 0 ,'#', '#', 0 ,
                                           '#', 0 , 0 , '#', 0 ,
                                           '#', 0 , 0 , '#', 0

    };

    private static final Character[] O = { 0 ,'#','#', 0 , 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                           0 ,'#','#', 0,  0
    };

    private static final Character[] P = { '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#', 0 , 0 , 0 , 0
    };

    private static final Character[] Q = { 0 ,'#','#', 0 , 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                          '#', 0 , 0 ,'#', 0 ,
                                           0 ,'#','#','#', 0 ,
    };

    private static final Character[] R = { '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#','#','#', 0 , 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
    };

    private static final Character[] S = { 0 ,'#','#','#', 0 ,
                                          '#', 0 , 0 , 0 , 0 ,
                                           0 ,'#','#', 0 , 0 ,
                                           0 , 0 , 0 ,'#', 0 ,
                                          '#','#','#', 0 , 0 ,
    };

    private static final Character[] T = { '#','#','#','#', 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0
    };

    private static final Character[] U = { '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                           '#', 0 , 0 ,'#', 0 ,
                                            0 , '#','#', 0 , 0
    };

    private static final Character[] V = { 0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 , 0 ,'#', 0 , 0

    };

    private static final Character[] W = { 0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#','#','#', 0 ,
                                           0 ,'#', 0 ,'#', 0

    };

    private static final Character[] X = { 0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 , 0 ,'#', 0 , 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,

    };

    private static final Character[] Y = { 0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 ,'#', 0 ,'#', 0 ,
                                           0 , 0 ,'#', 0 , 0 ,
                                           0 , 0 ,'#', 0 , 0
    };

    private static final Character[] Z = {'#','#','#','#', 0 ,
                                           0 , 0 , 0 ,'#', 0 ,
                                           0 , 0 ,'#', 0 , 0 ,
                                           0 ,'#', 0 , 0 , 0 ,
                                           '#','#','#','#', 0

    };

    private static final Character[] _0 = { 0 ,'#','#','#',0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                           '#', 0 , 0 , 0 ,'#',
                                           '#', 0 , 0 , 0 ,'#',
                                            0 ,'#','#','#', 0
    };

    private static final Character[] _1 = { 0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0 ,
                                            0 , 0 ,'#', 0 , 0
    };

    private static final Character[] _2 = { 0 ,'#','#','#', 0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                            0 ,'#','#','#', 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#','#','#','#','#',
    };

    private static final Character[] _3 = { 0 ,'#','#','#', 0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                            0 , 0 ,'#','#', 0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                            0 ,'#','#','#', 0
    };

    private static final Character[] _4 = { '#', 0 , 0 , 0 ,'#',
                                            '#', 0 , 0 , 0 ,'#',
                                            '#','#','#','#','#',
                                             0 , 0 , 0 , 0 ,'#',
                                             0 , 0 , 0 , 0 ,'#',
                                             0 , 0 , 0 , 0 ,'#',
    };

    private static final Character[] _5 = { '#','#','#','#','#',
                                            '#', 0 , 0 , 0 , 0 ,
                                            '#','#','#','#', 0 ,
                                             0 , 0 , 0 , 0 ,'#',
                                            '#','#','#','#', 0
    };

    private static final Character[] _6 = { 0 ,'#','#','#', 0 ,
                                           '#', 0 , 0 , 0 , 0 ,
                                           '#','#','#','#', 0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                            0 ,'#','#','#', 0

    };

    private static final Character[] _7 = { '#','#','#','#','#',
                                             0 , 0 , 0 , 0 ,'#',
                                             0 , 0 , 0 ,'#', 0 ,
                                             0 , 0 ,'#', 0 , 0 ,
                                             0 , 0 ,'#', 0 , 0
    };

    private static final Character[] _8 = { 0 ,'#','#','#', 0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                            0 ,'#','#','#', 0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                            0 ,'#','#','#', 0
    };

    private static final Character[] _9 = { 0 ,'#','#','#', 0 ,
                                           '#', 0 , 0 , 0 ,'#',
                                           '#','#','#','#','#',
                                            0 , 0 , 0 , 0 ,'#',
                                           '#','#','#','#', 0

    };

    private static final Character[] SPACE = { 0 , 0 , 0 , 0 , 0 ,
                                               0 , 0 , 0 , 0 , 0 ,
                                               0 , 0 , 0 , 0 , 0 ,
                                               0 , 0 , 0 , 0 , 0 ,
                                               0 , 0 , 0 , 0 , 0
    };

    static {
        chars.put('A', Font5x5.A);
        chars.put('B', Font5x5.B);
        chars.put('C', Font5x5.C);
        chars.put('D', Font5x5.D);
        chars.put('E', Font5x5.E);
        chars.put('F', Font5x5.F);
        chars.put('G', Font5x5.G);
        chars.put('H', Font5x5.H);
        chars.put('I', Font5x5.I);
        chars.put('J', Font5x5.J);
        chars.put('K', Font5x5.K);
        chars.put('L', Font5x5.L);
        chars.put('M', Font5x5.M);
        chars.put('N', Font5x5.N);
        chars.put('O', Font5x5.O);
        chars.put('P', Font5x5.P);
        chars.put('Q', Font5x5.Q);
        chars.put('R', Font5x5.R);
        chars.put('S', Font5x5.S);
        chars.put('T', Font5x5.T);
        chars.put('U', Font5x5.U);
        chars.put('V', Font5x5.V);
        chars.put('W', Font5x5.W);
        chars.put('X', Font5x5.X);
        chars.put('Y', Font5x5.Y);
        chars.put('Z', Font5x5.Z);
        chars.put('0', Font5x5._0);
        chars.put('1', Font5x5._1);
        chars.put('2', Font5x5._2);
        chars.put('3', Font5x5._3);
        chars.put('4', Font5x5._4);
        chars.put('5', Font5x5._5);
        chars.put('6', Font5x5._6);
        chars.put('7', Font5x5._7);
        chars.put('8', Font5x5._8);
        chars.put('9', Font5x5._9);
        chars.put(' ', Font5x5.SPACE);
    }
}

