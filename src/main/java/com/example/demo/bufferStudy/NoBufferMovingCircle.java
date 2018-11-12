package com.example.demo.bufferStudy;

import javax.swing.*;
import java.awt.*;

public class NoBufferMovingCircle extends JApplet implements Runnable{
    Image scrrenImage = null;
    Thread thread;
    int x = 5;
    int move = 1;

    @Override
    public void init(){
        scrrenImage = createImage(230, 160);
    }

    @Override
    public void start(){
        if(thread == null){
            thread = new Thread(this);
            thread.start();
        }
    }
    @Override
    public void run() {
        try{
            while (true)
            {
                x += move;
                if( (x > 105) || (x < 5)){
                    move *= -1;
                }
                repaint();
                Thread.sleep(10);
            }
        } catch (Exception e){

        }
    }

    public void drawCircle(Graphics gc){
        Graphics2D g = (Graphics2D) gc;
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 200, 100);
        g.setColor(Color.RED);
        g.fillOval(x, 5, 90, 90);
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        drawCircle(g);
    }
}
