package SubGuiLogic;

import logic.MarkTextFunctions;
import logic.ShowErrorDialog;

import javax.swing.*;

public class FindText
{
    MarkTextFunctions markTextFunctions = new MarkTextFunctions();
    ShowErrorDialog showErrorDialog = new ShowErrorDialog();

    public void MarkSelectText(JTextField jTextField , String color , int select, JTextArea jTextArea)
    {
        try
        { markTextFunctions.MarkSelectText(jTextField,color,select,jTextArea);
        }catch (Exception e )
        { showErrorDialog.show_dialog_0(e.getMessage()); }
    }

    public void Reset(JTextArea jTextArea)
    {
        try
        { markTextFunctions.Reset(jTextArea);
        }catch (Exception e )
        { showErrorDialog.show_dialog_0(e.getMessage()); }
    }
}
