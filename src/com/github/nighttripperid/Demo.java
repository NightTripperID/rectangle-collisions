// A java port of OLC's arbitrary rectangle collision complete solution. Props to javidx9 for his excellent tutorial!
// watch https://youtu.be/8JJ-4JgR7Dg for reference
package com.github.nighttripperid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public final class Demo extends Canvas {

    private Thread thread;
    private String title = "";
    private boolean running;

    private final BufferedImage bufferedImage;
    private final int[] pixels;
    private ScreenBuffer screenBuffer = new ScreenBuffer(256, 256, 3);
    private JFrame jFrame;

    private List<Rect> rects = new ArrayList<>();

    public Demo(int width, int height, int scale, String title) {
        this.title = title;
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();

        setPreferredSize(new Dimension(width * scale, height * scale));

        jFrame = new JFrame();
        jFrame.setResizable(true);
        jFrame.setTitle(title);
        jFrame.add(this);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        addKeyListener(new Keyboard());

        Mouse mouse = new Mouse(scale);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        addMouseWheelListener(mouse);

        addRects();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(mainLoop, "RectangleDemo");
        thread.start();
    }

    private void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private final Runnable mainLoop = () -> {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000D / 60D;
        double delta = 0D;
        int frames = 0;
        int updates = 0;

        requestFocus();

        double before, after, elapsed = 0;
        while (running) {

            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                before = System.nanoTime() / 1000000000D;
                update(elapsed); // 60 times per second
                after = System.nanoTime() / 1000000000D;
                elapsed = after - before;
                delta--;
                updates++;
            }

            render(); // as fast as possible
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                jFrame.setTitle(title + " | " + updates + " ups " + " | " + frames + " fps");
                frames = 0;
                updates = 0;
            }
        }
        stop();
    };

    private void addRects() {
        rects.add(new Rect(new PointDouble(170D, 70D), new PointDouble(10D, 40D)));
        rects.add(new Rect(new PointDouble(150D, 50D), new PointDouble(20D, 20D)));
        rects.add(new Rect(new PointDouble(150D, 150D), new PointDouble(75D, 20D)));
        rects.add(new Rect(new PointDouble(170D, 50D), new PointDouble(20D, 20D)));
        rects.add(new Rect(new PointDouble(190D, 50D), new PointDouble(20D, 20D)));
        rects.add(new Rect(new PointDouble(110D, 50D), new PointDouble(20D, 20D)));
        rects.add(new Rect(new PointDouble(50D, 130D), new PointDouble(20D, 20D)));
        rects.add(new Rect(new PointDouble(50D, 150D), new PointDouble(20D, 20D)));
        rects.add(new Rect(new PointDouble(50D, 170D), new PointDouble(20D, 20D)));
        rects.add(new Rect(new PointDouble(150D, 100D), new PointDouble(10D, 1D)));
        rects.add(new Rect(new PointDouble(200D, 100D), new PointDouble(20D, 60D)));
    }

    private void update(double elapsedTime) {
        Arrays.fill(screenBuffer.getPixels(), 0x00008B);

        Keyboard.update();
        Mouse.update();
        PointDouble mousePt = (new PointDouble((double) Mouse.mouseX, (double) Mouse.mouseY));

        double VELOCITY = 6000;
        rects.get(0).vel.y = 0D;
        rects.get(0).vel.x = 0D;

        if (Keyboard.held(KeyEvent.VK_E))
            rects.get(0).vel.y = -VELOCITY;
        if (Keyboard.held(KeyEvent.VK_D))
            rects.get(0).vel.y = VELOCITY;
        if (Keyboard.held(KeyEvent.VK_S))
            rects.get(0).vel.x = -VELOCITY;
        if (Keyboard.held(KeyEvent.VK_F))
            rects.get(0).vel.x = VELOCITY;

        if(Mouse.button1Held)

            rects.get(0).vel
                    .set(rects.get(0).vel
                                .plus((mousePt.minus(rects.get(0).pos))
                                        .norm()
                                        .times(PointDouble.of(VELOCITY))));

        rects.forEach(rect -> DrawTools.drawRect(rect, Color.WHITE.getRGB(), screenBuffer));

        PointDouble cp = PointDouble.of(0D);
        PointDouble cn = PointDouble.of(0D);
        NumWrap<Double> t = new NumWrap<>(0D);
        NumWrap<Double> min_t = new NumWrap<>(Double.POSITIVE_INFINITY);
        List<AbstractMap.SimpleEntry<Integer, Double>> z = new ArrayList<>();

//         work out collision point, add it to vector along with rect ID
        for (int i = 1; i < rects.size(); i++) {
            if (RectangleCollisionUtils.dynamicRectVsRect(rects.get(0), elapsedTime, rects.get(i), cp, cn, t)) {
                z.add(new AbstractMap.SimpleEntry<>(i, t.num));
            }
        }

        // perform sort
        z = z.stream().sorted(Comparator.comparingDouble(AbstractMap.SimpleEntry::getValue)).collect(Collectors.toList());

        // resolve collision in correct order
        z.forEach(z1 -> RectangleCollisionUtils.resolveDynamicRectVsRect(rects.get(0), elapsedTime, rects.get(z1.getKey())));

        // embellish the "in contact" rectangles in yellow
        for (int i = 0; i < 4; i++) {
            if (rects.get(0).contact[i] != null) {
                DrawTools.drawRect(rects.get(0).contact[i], Color.YELLOW.getRGB(), screenBuffer);
                rects.get(0).contact[i] = null;
            }
        }

        // update the player rectangle's position with its modified velocity
        rects.get(0).pos.set(rects.get(0).pos.plus(rects.get(0).vel.times(PointDouble.of(elapsedTime))));
//        rects.get(0).pos.set(rects.get(0).pos.plus(rects.get(0).vel));

        // draw player's velocity vector
        if (rects.get(0).vel.mag2() > 0) {
            DrawTools.drawLine(rects.get(0).pos.plus(rects.get(0).size.div(PointDouble.of(2D))),
                               rects.get(0).pos.plus(rects.get(0).size.div(PointDouble.of(2D))).plus(rects.get(0).vel.norm().times(PointDouble.of(20D))),
                               Color.RED.getRGB(), screenBuffer);
        }
        DrawTools.renderString8x8(20, 215, Color.WHITE.getRGB(), String.valueOf(z.size()), screenBuffer);

    }

    private void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();

        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        System.arraycopy(screenBuffer.getPixels(), 0, pixels, 0, pixels.length);
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.MAGENTA);
        graphics.fillRect(0, 0, screenBuffer.getWidth(), screenBuffer.getHeight());
        graphics.drawImage(bufferedImage, 0, 0,
                screenBuffer.getWidth() * screenBuffer.getScale(),
                screenBuffer.getHeight() * screenBuffer.getScale(), null);
        graphics.dispose();
        bufferStrategy.show();
    }
}
