package LogicJpanel;

import logic.FileSet;
import logic.SaveFileFunctions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CloseProgram implements ActionListener
{
    JTextArea jTextArea;

    public CloseProgram(JTextArea jTextArea)
    { this.jTextArea = jTextArea; }

    FileSet fileSet = new FileSet();
    SaveFileFunctions SaveFileFunctions = new SaveFileFunctions();

    private String code_save;
    private String buffer_file;
    private String text;

    private int switch_result;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        code_save = fileSet.getFile_code_save();
        buffer_file = fileSet.getBuffer_file();

        if(buffer_file != null )
        {
            switch_result = JOptionPane.showConfirmDialog(
                    new JPanel(),
                    "Save changes " + buffer_file,
                    "UncleWord",
                    JOptionPane.YES_NO_OPTION);
            switch (switch_result)
            {
                case 0:
                    SaveFileFunctions.Save(jTextArea);
                    break;

                default: break;
            }
        }

        text = jTextArea.getText();
        if(!text.equals("") && buffer_file == null)
           SaveFileFunctions.SaveAs(jTextArea);

        System.exit(0); // Exit
    }
}
