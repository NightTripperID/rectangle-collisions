// A java port of OLC's arbitrary rectangle collision complete solution. Props to javidx9 for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;

import java.util.Arrays;

public class DrawTools {
    
    private DrawTools() {
    }
    
    public static void fill(int col, ScreenBuffer screenBuffer) {
        Arrays.fill(screenBuffer.getPixels(), col);
    }

    // source: https://stackoverflow.com/questions/8113629/simplified-bresenhams-line-algorithm-what-does-it-exactly-do
    public static void drawLine(PointDouble start, PointDouble end, int col, ScreenBuffer screenBuffer) {
        int x1 = (int)(double) start.x;
        int x2 = (int)(double) end.x;
        int y1 = (int)(double) start.y;
        int y2 = (int)(double) end.y;
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int err = dx - dy;

        while (true) {
            renderPixel(x1, y1, col, screenBuffer);
            if (x1 == x2 && y1 == y2) {
                break;
            }
            int e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x1 = x1 + sx;
            }
            if (e2 < dx) {
                err = err + dx;
                y1 = y1 + sy;
            }
        }
    }
    
    public static void drawRect(Rect rect, int col, ScreenBuffer screenBuffer) {
        for (int y = (int)(double) rect.pos.y; y < (int)(double) rect.pos.y + rect.size.y; y++) {
            if (y < 0 || y >= screenBuffer.getHeight())
                continue;
            for (int x = (int)(double)rect.pos.x; x < (int)(double) rect.pos.x + rect.size.x; x++) {
                if (x < 0 || x >= screenBuffer.getWidth())
                    continue;
                if (x == (int)(double) rect.pos.x || x == (int)(double) rect.pos.x + rect.size.x - 1 || 
                        y == (int)(double) rect.pos.y || y == (int)(double) rect.pos.y + rect.size.y - 1)
                    screenBuffer.getPixels()[x + y * screenBuffer.getWidth()] = col;
            }
        }
    }

    public static void drawRect(double x, double y, int width, int height, int col, ScreenBuffer screenBuffer) {
        for (int yy = (int) y; yy < (int) y + height; yy++) {
            if (yy < 0 || yy >= screenBuffer.getHeight())
                continue;
            for (int xx = (int) x; xx < (int) x + width; xx++) {
                if (xx < 0 || xx >= screenBuffer.getWidth())
                    continue;
                if (xx == (int) x || xx == (int) x + width - 1 || yy == (int) y || yy == (int) y + height - 1)
                    screenBuffer.getPixels()[xx + yy * screenBuffer.getWidth()] = col;
            }
        }
    }

    public static void fillRect(Rect rect, int col, ScreenBuffer screenBuffer) {
        for (int y = (int)(double) rect.pos.y; y < (int)(double) rect.pos.y + rect.size.y; y++) {
            if (y < 0 || y >= screenBuffer.getHeight())
                continue;
            for (int x = (int)(double) rect.pos.x; x < (int)(double) rect.pos.x + rect.size.x; x++) {
                if (x < 0 || x >= screenBuffer.getWidth())
                    continue;
                screenBuffer.getPixels()[x + y * screenBuffer.getWidth()] = col;
            }
        }
    }


        public static void fillRect(double x, double y, int width, int height, int col, ScreenBuffer screenBuffer) {
        for (int yy = (int) y; yy < (int) y + height; yy++) {
            if (yy < 0 || yy >= screenBuffer.getHeight())
                continue;
            for (int xx = (int) x; xx < (int) x + width; xx++) {
                if (xx < 0 || xx >= screenBuffer.getWidth())
                    continue;
                screenBuffer.getPixels()[xx + yy * screenBuffer.getWidth()] = col;
            }
        }
    }

    private static void renderChar8x8(double x, double y, int col, Character[] character, ScreenBuffer screenBuffer) {
        for (int yy = 0; yy < 8; yy++)
            for (int xx = 0; xx < 8; xx++)
                if (character[xx + (yy << 3)] == '#')
                    renderPixel(x + xx, y + yy, col, screenBuffer);
    }

    private static void renderChar5x5(double x, double y, int col, Character[] character, ScreenBuffer screenBuffer) {
        for (int yy = 0; yy < 5; yy++)
            for (int xx = 0; xx < 5; xx++)
                if (character[xx + yy * 5] == '#')
                    renderPixel(x + xx, y + yy, col, screenBuffer);
    }

    public static void renderString8x8(double x, double y, int col, String string, ScreenBuffer screenBuffer) {
        for (int i = 0; i < string.length(); i++)
            renderChar8x8(x + (i << 3), y, col, Font8x8.getChar(string.charAt(i)), screenBuffer);
    }

    public static void renderString5x5(double x, double y, int col, String string, ScreenBuffer screenBuffer) {
        for (int i = 0; i < string.length(); i++)
            renderChar5x5(x + (i * 5), y, col, Font5x5.getChar(string.charAt(i)), screenBuffer);
    }

    public static void renderPixels(int[] pixels, ScreenBuffer screenBuffer) {
        if (pixels.length != screenBuffer.getPixels().length)
            throw new IllegalArgumentException("pixel lengths (i.e. screen dimensions) must match.");

        System.arraycopy(pixels, 0, screenBuffer.getPixels(), 0, pixels.length);
    }

    public static void renderPixel(int index, int col, ScreenBuffer screenBuffer) {
        if (index < 0 || index >= screenBuffer.getWidth() * screenBuffer.getHeight())
            return;

        screenBuffer.getPixels()[index] = col;
    }

    public static void renderPixel(double x, double y, int col, ScreenBuffer screenBuffer) {
        if (x < 0 || x >= screenBuffer.getWidth() || y < 0 || y >= screenBuffer.getHeight())
            return;

        screenBuffer.getPixels()[(int) x + (int) y * screenBuffer.getWidth()] = col;
    }

}
