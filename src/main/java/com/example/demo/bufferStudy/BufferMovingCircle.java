package com.example.demo.bufferStudy;

import java.awt.*;

public class BufferMovingCircle extends NoBufferMovingCircle{
    Graphics doubleBuffer = null;

    @Override
    public void init() {
        super.init();
        doubleBuffer = scrrenImage.getGraphics();
    }

    @Override
    public void paint(Graphics g){
        doubleBuffer.setColor(Color.white);
        doubleBuffer.fillRect(0, 0, 200, 100);
        drawCircle(doubleBuffer);
        g.drawImage(scrrenImage, 0, 0, this);
    }
}
