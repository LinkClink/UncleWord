package logic;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class SetTime extends Thread
{
    int a=0;

    JLabel jLabel;

    Calendar calendar = Calendar.getInstance();
    Date dateOne;

    public SetTime(JLabel jlabel)
    { this.jLabel = jlabel; }

    public void run()
    {
        while (a==0)
        {
            try
            {
                calendar = Calendar.getInstance();
                dateOne = calendar.getTime();

                jLabel.setText(String.valueOf(dateOne));

                Thread.sleep(1000);

            } catch (InterruptedException e)
            { e.printStackTrace(); }
        }
    }
}