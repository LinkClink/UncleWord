package SubGuiLogic;

import logic.FileSet;
import logic.MarkTextFunctions;

import javax.swing.*;

public class ReplaceText
{
    String pattern = null;
    String pattern1 = null;

    MarkTextFunctions markTextFunctions = new MarkTextFunctions();
    FileSet fileSet = new FileSet();

    String flag_text_replace = null;

    public void ReplaceAll(JTextField textField1,JTextField textField2,String color,int select,JTextArea jTextArea)
    {
        pattern =  textField1.getText();
        pattern1 = textField2.getText();

        if(pattern1 != null && pattern != null)
        {
             flag_text_replace = jTextArea.getText();
             jTextArea.setText(jTextArea.getText().replaceAll(pattern, pattern1));
             if(!flag_text_replace.equals(jTextArea.getText()))
             if(select >=0 && select <= 1)
             markTextFunctions.MarkSelectText(textField2,color,select,jTextArea);
        }
    }

    public void Replace(JTextField textField1,JTextField textField2,JTextArea jTextArea, int select, String color)
    {
        pattern =  textField1.getText();
        pattern1 = textField2.getText();

        if(pattern1 != null && pattern != null)
        {
            markTextFunctions.Reset(jTextArea);

            flag_text_replace = jTextArea.getText();
            jTextArea.setText(jTextArea.getText().replaceFirst(pattern, pattern1));
            if(!flag_text_replace.equals(jTextArea.getText()))
            {
                switch (select)
                {
                    case 0:
                        markTextFunctions.PaintTextFirst(color,jTextArea,pattern1,select);
                        break;
                    case 1:
                        markTextFunctions.SelectTextFirst(pattern1,jTextArea);
                        break;
                }
            } else fileSet.setMark_text_position(0);
        }
    }
}

