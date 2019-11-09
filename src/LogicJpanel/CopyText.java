package LogicJpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class CopyText implements ActionListener
{
    private JTextArea jTextArea;

    String code_open = "Cp1251";

    public CopyText(JTextArea jTextArea)
    {
        this.jTextArea=jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            String myString = jTextArea.getSelectedText();
            if(myString != null)
            {
                ByteBuffer byteBuffer = Charset.forName(code_open).encode(myString);
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
            }
        }
}
