package logicGui;

import gui.MainJframe;

import java.awt.*;

public class ProgramWindowCenter extends MainJframe

{


    public static void centerWindow(int width , int height)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth() - width / 2);
        int y = (int) (dimension.getHeight() - height / 2);
        //er.setLocation(x, y);
    }


}
