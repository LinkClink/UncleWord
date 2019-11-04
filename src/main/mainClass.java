package main;

import gui.MainJframe;

import javax.swing.*;
import java.awt.*;

public class mainClass

{
    public static void main(String[] args)
     {
         EventQueue.invokeLater(new Runnable()
         {
             @Override
             public void run()
             {
                 try
                 {
                     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                 }catch (Exception e)
                 {

                 }
                 new MainJframe();
             }
         });
     }
}
