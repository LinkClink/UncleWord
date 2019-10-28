package main;


import gui.jframeClass;

import java.awt.*;

public class mainClass

{

    public static void main(String[] args)
     {

         EventQueue.invokeLater(new Runnable()
         {
             @Override
             public void run() {
                 new jframeClass();
             }
         });


     }

}
