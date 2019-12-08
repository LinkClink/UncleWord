package logic;

import gui.MainJpanel;

import java.util.Calendar;

import static java.lang.Thread.sleep;

public class ShowTimeClock

{

boolean exp = true;
MainJpanel mainJpanel = new MainJpanel();




    public void run() throws InterruptedException
    {
        for(;;)
        {
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);

            //mainJpanel.setLabel_1(hour + ":" + minute + ":" + second);
            sleep(1000);
        }
    }

}




