package LogicJpanel;

import logic.SaveFileFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SaveAsTxT extends Component implements ActionListener
{
    private JTextArea jTextArea;

    SaveFileFunctions SaveFileFunctions = new SaveFileFunctions();

    public SaveAsTxT(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    { SaveFileFunctions.SaveAs(jTextArea); }

}
