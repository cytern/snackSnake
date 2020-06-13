package snack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @Author: cytern
 * @Date: 2020/6/13 9:02
 */
public class GamePanel extends JPanel implements KeyListener,ActionListener {
    int length;
    int[] snakeX =new int[600];
    int[] snakeY = new int[500];
    String fx;
    int lv ;
    int score;
    boolean isStart;
    int foodX;
    int foodY;
    int delay = 100;
    boolean isFai;
    Timer timer = new Timer(100,  this);
    Random random = new Random();
      //初始化
    public void init(){
        length = 3;
        snakeY[0] = 100;snakeX[0] = 100;  //头部坐标
        snakeY[1] = 100;snakeX[1] = 75;  //第一个身体坐标
        snakeY[2] = 100;snakeX[2] = 50;  //第二个坐标
        fx = "r";
        lv = 1;
        score = 0;
        isStart = false;
        isFai = false;
        foodX = 25 + 25*random.nextInt(34);
        foodY = 75 + 25*random.nextInt(24);
        timer.start();
    }
    public GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    //画板
    //graph画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        Data.header.paintIcon(this,g,25,11);

        g.fillRect(25,75,850,600);

        //静态小蛇
        Data.rightStart.paintIcon(this,g,snakeX[0],snakeY[0]);
        Data.body.paintIcon(this,g,snakeX[1],snakeY[1]);
        Data.rightEnd.paintIcon(this,g,snakeX[2],snakeY[2]);
        for (int i = 0;i<length;i++){
            if (i == 0){
              getFxStart(i,g);
            }else if (i==length-1){
               getFxEnd(i,g);
            }else {
                Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
            }
        }
        Data.food.paintIcon(this,g,foodX,foodY);
        g.setColor(Color.black);
        g.setFont(new Font("微软雅黑",Font.BOLD,30));
          g.drawString("当前游戏难度："+lv,300,30);
          g.drawString("当前得分:"+score,300,60);
        if (isStart == false){
            g.setColor(Color.white);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }
        if (isFai){
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏失败，enter键重新开始",300,300);
        }
    }

    public void getFxStart (int i,Graphics g){
        if(fx.equals("r")){
            Data.rightStart.paintIcon(this,g,snakeX[i],snakeY[i]);
        }else if (fx.equals("l")){
            Data.leftStart.paintIcon(this,g,snakeX[i],snakeY[i]);
        }else if (fx.equals("u")){
            Data.upStart.paintIcon(this,g,snakeX[i],snakeY[i]);
        }else if (fx.equals("d")){
            Data.downStart.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
    }
    public void getFxEnd (int i,Graphics g){
        if(fx.equals("r")){
            Data.rightEnd.paintIcon(this,g,snakeX[i],snakeY[i]);
        }else if (fx.equals("l")){
            Data.leftEnd.paintIcon(this,g,snakeX[i],snakeY[i]);
        }else if (fx.equals("u")){
            Data.upEnd.paintIcon(this,g,snakeX[i],snakeY[i]);
        }else if (fx.equals("d")){
            Data.downEnd.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
           //键盘按下
        int keyCode = e.getKeyCode();
        if (keyCode ==KeyEvent.VK_SPACE){
            isStart = !isStart;
            repaint();
        }
        if (keyCode ==KeyEvent.VK_W){
            if (fx.equals("d")){
                fx = "d";
            }else {
                fx="u";
            }
            repaint();
        }
        if (keyCode ==KeyEvent.VK_S){
            if (fx.equals("u")){

            }else {
                fx = "d";
            }
            repaint();
        }
        if (keyCode ==KeyEvent.VK_A){
            if (fx.equals("r")){

            }else {
                fx="l";
            }

            repaint();
        }
        if (keyCode ==KeyEvent.VK_D){
            if (fx.equals("l")){

            }else {
                fx="r";
            }
            repaint();
        }
        if (keyCode ==KeyEvent.VK_ENTER){
            init();
            repaint();
        }




    }

    @Override
    public void keyReleased(KeyEvent e) {
        //释放

    }


    //定时器 监听时间,执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        //游戏开始 蛇蛇前进
        if (isStart && !isFai){
            for (int i =length -1;i>0;i--){
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }
            if (fx == "r"){
                snakeX[0] = snakeX[0] + 25;
            }else if (fx == "l"){
                snakeX[0] = snakeX[0] - 25;
            }else if (fx =="u"){
                snakeY[0] = snakeY[0] - 25;
            }else if (fx =="d"){
                snakeY[0] = snakeY[0] + 25;
            }
            isEnd();
            repaint();
        }
        //如果二者坐标重复
        if (snakeX[0]==foodX&& snakeY[0]==foodY){
            length++;
            foodX = 25 + 25*random.nextInt(34);
            foodY = 75 + 25*random.nextInt(24);
            score++;
        }
        for (int i=1;i<length;i++){
            if (snakeX[0] == snakeX[i] &&snakeY[0] == snakeY[i]){
                isFai = true;
            }
        }
        repaint();
        timer.start();
    }

    public boolean isEnd(){
        if (snakeX[0]>850){
            snakeX[0] = 25;
            isFai=true;
            return false;
        }
        if (snakeX[0]<25){
            snakeX[0] = 850;
            isFai=true;
            return false;
        }
        if (snakeY[0]>650){
            snakeY[0] = 75;
            isFai=true;
            return false;
        }
        if (snakeY[0] <75){
            snakeY[0] = 650;
            isFai=true;
            return false;
        }
        return true;
    }

    public void endGame(){

    }
}
