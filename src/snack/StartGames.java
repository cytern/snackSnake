package snack;

import javax.swing.*;

/**
 * @Author: cytern
 * @Date: 2020/6/13 8:58
 */

public class StartGames {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("贪吃蛇");
        jFrame.setBounds(10,10,900,720);
        jFrame.setResizable(false);  //设置可变大小
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭事件

        jFrame.add(new GamePanel());
        //将画布添加入窗口中


        jFrame.setVisible(true);  //展示窗口
    }
}
