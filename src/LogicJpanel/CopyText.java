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

    private String code_save;
    private String myString;

    FileSet fileSet = new FileSet();

    private ByteBuffer byteBuffer;
    private StringSelection stringSelection;
    private Clipboard clpbrd;

    public CopyText(JTextArea jTextArea)
    {
        this.jTextArea=jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        code_save = fileSet.getFile_code_save();

            myString = jTextArea.getSelectedText();
            if(myString != null)
            {
                byteBuffer = Charset.forName(code_save).encode(myString);
                stringSelection = new StringSelection(myString);
                clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);
            }
        }
}
