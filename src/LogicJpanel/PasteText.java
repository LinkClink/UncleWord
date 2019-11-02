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

    public PasteText(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();

            Transferable t = c.getContents(this);

            if (t == null)
                return;
            try {

               jTextArea.setText((String) t.getTransferData(DataFlavor.stringFlavor));
            } catch (Exception ae) {
                ae.printStackTrace();
            }//try

        }

}
