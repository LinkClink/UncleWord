package gui;

import javax.swing.*;
import java.awt.*;

public class MainJframe extends JFrame
{
    MainJpanel panel = new MainJpanel();

    public MainJframe()
    {
        setSize(800, 650);
        setMinimumSize(new Dimension(500,500));

        setTitle("UncleWord");

        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getSize().width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add(panel);
    }
}
