package LogicJpanel;

import logic.FileSet;

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

    String code_open;
    String myString;

    FileSet fileSet = new FileSet();

    ByteBuffer byteBuffer;
    StringSelection stringSelection;
    Clipboard clpbrd;

    public CopyText(JTextArea jTextArea)
    {
        this.jTextArea=jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        code_open = fileSet.getFile_code_open();

            myString = jTextArea.getSelectedText();
            if(myString != null)
            {
                byteBuffer = Charset.forName(code_open).encode(myString);
                stringSelection = new StringSelection(myString);
                clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
            }
        }
}
