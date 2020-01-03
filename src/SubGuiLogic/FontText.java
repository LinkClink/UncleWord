package SubGuiLogic;

import logic.FontSet;

import javax.swing.*;
import java.awt.*;

public class FontText
{
    Font font_1;
    FontSet fontSet = new FontSet();

    public void SetFont(JTextArea jTextArea,String name,int index,int size)
    {
        font_1 = new Font(name,index,size);
        jTextArea.setFont(font_1);
    }

    public void SetDefaultFont(JTextArea jTextArea)
    {
        font_1 = new Font(fontSet.getPrimary_font(),fontSet.getPrimary_font_style(),fontSet.getPrimary_font_size());
        jTextArea.setFont(font_1);
    }
}
