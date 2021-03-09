// A java port of OLC's arbitrary rectangle collision complete solution. Props to javid9x for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Mouse extends MouseAdapter {

    private static boolean button1, button2, button3;
    public static boolean button1Held, button2Held, button3Held;
    public static boolean button1Pressed, button2Pressed, button3Pressed;
    public static boolean button1Released, button2Released, button3Released;

    public static int mouseX, mouseY;

    public static boolean dragged;

    private final int screenScale;

    public Mouse(int screenScale) {
        if(screenScale < 1)
            throw new IllegalArgumentException("Screen scale must be greater than 0");

        this.screenScale = screenScale;
    }

    public static void update() {

        boolean button1Last, button2Last, button3Last;

        button1Last = button1Held;
        button2Last = button2Held;
        button3Last = button3Held;

        button1Held = button1;
        button2Held = button2;
        button3Held = button3;

        button1Pressed = button1Held && !button1Last;
        button2Pressed = button2Held && !button2Last;
        button3Pressed = button3Held && !button3Last;

        button1Released = !button1Held && button1Last;
        button2Released = !button2Held && button2Last;
        button3Released = !button3Held && button3Last;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

        int button = mouseEvent.getButton();

        if(button == MouseEvent.BUTTON1)
            button1 = true;
        if(button == MouseEvent.BUTTON2)
            button2 = true;
        if(button == MouseEvent.BUTTON3)
            button3 = true;

        dragged = true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

        int button = mouseEvent.getButton();

        if(button == MouseEvent.BUTTON1)
            button1 = false;
        if(button == MouseEvent.BUTTON2)
            button2 = false;
        if(button == MouseEvent.BUTTON3)
            button3 = false;

        dragged = false;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX() / screenScale;
        mouseY = mouseEvent.getY() / screenScale;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX() / screenScale;
        mouseY = mouseEvent.getY() / screenScale;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
    }
}
