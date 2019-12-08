package logic;

import javax.swing.*;

public class ShowErrorDialog
{

    public void show_dialog_0(String dialog_err)
    {
        JOptionPane.showMessageDialog(new JPanel(),
                "Error:"+dialog_err,
                "UncleWord",
                JOptionPane.YES_NO_OPTION);
    }

}
