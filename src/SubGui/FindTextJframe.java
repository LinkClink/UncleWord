package SubGui;

import SubGuiLogic.FindText;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindTextJframe extends JFrame
{
    private JRadioButton markRadioButton;
    private JRadioButton selectRadioButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton resetButton;
    private JButton findButton;
    private JPanel Jpanel;

    static JTextArea jTextArea = new JTextArea();
    static JFrame jFrame = new JFrame();

    private int select = 0;

    public void  create(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;

        jFrame.setContentPane(new FindTextJframe().Jpanel);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setTitle("Find:");
        jFrame.setSize(350,110);
        jFrame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - 310) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 114) / 2);
    }

    public FindTextJframe()
    {
        findButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FindText findText = new FindText();
                findText.findtext(textField1, (String) comboBox1.getSelectedItem(), select);
            }
        });

        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FindText findText = new FindText();
                findText.Reset();
            }
        });

        selectRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                markRadioButton.setEnabled(true);
                selectRadioButton.setEnabled(false);
                selectRadioButton.setSelected(true);
                markRadioButton.setSelected(false);
                select = 1;
            }
        });

        markRadioButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                markRadioButton.setEnabled(false);
                selectRadioButton.setEnabled(true);
                markRadioButton.setSelected(true);
                selectRadioButton.setSelected(false);
                select = 0;
            }
        });


    }

    public JTextArea getjTextArea()
    {
        return jTextArea;
    }
    public String getColor()
    {
        System.out.println(comboBox1.getSelectedIndex());
        return (String) comboBox1.getSelectedItem();
    }
}
