package LogicJpanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplaceText implements ActionListener

{
    private JTextArea jTextArea;



    public ReplaceText(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
            String pattern = null;
            String pattern1 = null;

            pattern = JOptionPane.showInputDialog(null, "Text to replace: ");

            if (pattern != null)
            {
                pattern1 = JOptionPane.showInputDialog(null, "To: ");
                if (pattern1 != null)
                {
                    jTextArea.setText(jTextArea.getText().replaceAll(pattern, pattern1));
                }
            }

    }
}
