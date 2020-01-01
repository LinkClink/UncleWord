package LogicJpanel;

import logic.ShowErrorDialog;

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

    private Clipboard clipboard;
    private Transferable transferable;

    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

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
            { showErrorDialog.show_dialog_0(ae.getMessage()); }
        }
}
