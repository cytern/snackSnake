package snack;

import javax.swing.*;
import java.net.URL;

/**
 * @Author: cytern
 * @Date: 2020/6/13 9:06
 */
public class Data {

    public static URL headerUrl = Data.class.getResource("/static/snake_body.png");
    public  static ImageIcon header = new ImageIcon(headerUrl);


    public static  URL upStartUrl = Data.class.getResource("/static/snake_head_up.png");
    public  static ImageIcon upStart = new ImageIcon(upStartUrl);
    public static  URL downStartUrl = Data.class.getResource("/static/snake_head_down.png");
    public  static ImageIcon downStart = new ImageIcon(downStartUrl);
    public static  URL leftStartUrl = Data.class.getResource("/static/snake_head_left.png");
    public  static ImageIcon leftStart = new ImageIcon(leftStartUrl);
    public static  URL rightStartUrl = Data.class.getResource("/static/snake_head_right.png");
    public  static ImageIcon rightStart = new ImageIcon(rightStartUrl);
    public static  URL bodyUrl = Data.class.getResource("/static/snake_body.png");
    public  static ImageIcon body = new ImageIcon(bodyUrl);
    public static  URL upEndUrl = Data.class.getResource("/static/snake_weiba_up.png");
    public  static ImageIcon upEnd = new ImageIcon(upEndUrl);
    public static  URL downEndUrl = Data.class.getResource("/static/snake_weiba_down.png");
    public  static ImageIcon downEnd = new ImageIcon(downEndUrl);
    public static  URL leftEndUrl = Data.class.getResource("/static/snake_weiba_left.png");
    public  static ImageIcon leftEnd = new ImageIcon(leftEndUrl);
    public static  URL rightEndUrl = Data.class.getResource("/static/snake_weiba_right.png");
    public  static ImageIcon rightEnd = new ImageIcon(rightEndUrl);
    public static  URL foodUrl = Data.class.getResource("/static/dag.png");
    public  static ImageIcon food = new ImageIcon(foodUrl);
}
