package LogicJpanel;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasteText implements ActionListener

{
  private JTextArea jTextArea;

    Clipboard clipboard;
    Transferable transferable;

    public PasteText(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            transferable = clipboard.getContents(this);

            if (transferable == null) return;
            try
            {
               jTextArea.insert((String) transferable.getTransferData(DataFlavor.stringFlavor),jTextArea.getCaretPosition());
            } catch (Exception ae)
            {

            }
        }
}
