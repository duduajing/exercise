package com.example.demo.bufferStudy;

import javax.swing.*;
import java.awt.*;

/**
 * 心型图
 */
public class Cardioid extends JFrame {
    private static final int WIDTH = 480;
    private static final int HEIGHT = 600;

    private static int WINDOW_WIDTH = Toolkit.getDefaultToolkit()
            .getScreenSize().width;

    private static int WINDOW_HEIGHT = Toolkit.getDefaultToolkit()
            .getScreenSize().height;

    public Cardioid() {
        //设置窗口标题
        super("❤形线");
        //设置背景色
        this.setBackground(Color.BLACK);
        //设置窗口位置
        this.setLocation((WINDOW_WIDTH - WIDTH)/2, (WINDOW_HEIGHT - HEIGHT)/2);
        //设置窗口大小
        this.setSize(WIDTH, HEIGHT);
        //设置窗口布局
        this.setLayout(getLayout());
        //设置窗口可见
        this.setVisible(true);
        //设置窗口默认关闭方式
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g){
        double x,y,r;
        Image image = this.createImage(WIDTH, HEIGHT);
        Graphics pic = image.getGraphics();

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                r = Math.PI / 45 + Math.PI / 45 * i *(1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i)  + WIDTH / 2;
                y = -r*Math.sin(Math.PI / 45 *j) + HEIGHT / 2;

                pic.setColor(Color.magenta);
                pic.fillOval((int)x,(int)y,2,2);
            }
            g.drawImage(image, 0, 0, this);
        }

    }


}
