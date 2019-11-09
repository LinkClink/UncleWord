package SubGuiLogic;

import LogicJpanel.ReplaceTextJpanel;
import SubGui.ReplaceTextJframe;
import gui.MainJpanel;

import javax.swing.*;

public class ReplaceText
{
    String pattern = null;
    String pattern1 = null;

    JTextArea jTextArea = new JTextArea();

    ReplaceTextJframe replaceTextJframe = new ReplaceTextJframe();

    public void ReplaceText(JTextField textField1,JTextField textField2)
    {
        pattern =  textField1.getText();
        pattern1 = textField2.getText();
        jTextArea = replaceTextJframe.getjTextArea();


        if(pattern1 != null && pattern != null)
        {
             jTextArea.setText(jTextArea.getText().replaceAll(pattern, pattern1));
        }
    }
}

