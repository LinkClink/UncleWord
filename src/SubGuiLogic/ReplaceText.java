package SubGuiLogic;

import SubGui.ReplaceTextJframe;
import gui.MainJpanel;

import javax.swing.*;

public class ReplaceText
{
    String pattern = null;
    String pattern1 = null;

    private JTextArea jTextArea = new JTextArea();

    MainJpanel mainJpanel = new MainJpanel();
    ReplaceTextJframe replaceTextJframe = new ReplaceTextJframe();



    public void ReplaceText()
    {
        pattern = replaceTextJframe.getTextField1();
        System.out.println(pattern);
        pattern1 = replaceTextJframe.getTextField2();
        //jTextArea = mainJpanel.getTextArea_redactor_1();

        if(pattern1 != null && pattern != null)
        {
            jTextArea.setText(jTextArea.getText().replaceAll(pattern, pattern1));
            //mainJpanel.setTextArea_redactor_1();
            System.out.println("112");
        }
        System.out.println("1:"+ pattern+"2:"+ pattern1+"3:"+jTextArea.getText());
    }
}

