package SubGui;

import SubGuiLogic.FontText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class FontTextJframe extends  JFrame
{

    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String styles[] = {"Plain","Bold","Italic"};

    private JPanel panel1;
    private JButton applyButton;
    private JButton resetButton;
    private JScrollPane jscrollpane;
    private JScrollPane jscrollpane1;
    private JScrollPane jscrollpane2;
    private JList list1;
    private JList list2;
    private JList list3;
    private JLabel exampleLabel;
    private JLabel textLabel;

    Font font;

    int a,i=0;

    DefaultListModel defaultListModel = new DefaultListModel();
    DefaultListModel defaultListModel1 = new DefaultListModel();
    DefaultListModel defaultListModel2 = new DefaultListModel();

    static JTextArea jTextArea;
    static JFrame jFrame = new JFrame();

    public void create(JTextArea jTextArea)
    {
        this.jTextArea = jTextArea;

        jFrame.setContentPane(new FontTextJframe().panel1);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setTitle("Find:");
        jFrame.setSize(450,300);
        jFrame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - 450) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - 300) / 2);

    }

    public FontTextJframe()
    {
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e)
            {
                GeneratesFonts();
                super.windowActivated(e);
            }
        });

        applyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FontText fontText = new FontText();
                fontText.SetFont(jTextArea, (String) list1.getSelectedValue(), (int) list3.getSelectedIndex(), (int) list2.getSelectedValue());
            }
        });
        resetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                FontText fontText = new FontText();
                fontText.SetDefaultFont(jTextArea);
            }
        });

        MouseListener mouseListener = new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                font = new Font((String) list1.getSelectedValue(), (int) list3.getSelectedIndex(), (int) list2.getSelectedValue());
                textLabel.setFont(font);
            }
        };

        list1.addMouseListener(mouseListener);
        list2.addMouseListener(mouseListener);
        list3.addMouseListener(mouseListener);
    }

    public void GeneratesFonts()
    {
        // reset
        defaultListModel2.clear();
        defaultListModel.clear();
        defaultListModel1.clear();
        //1
        defaultListModel.addAll(Arrays.asList(fonts));
        list1.setModel(defaultListModel);
        list1.setSelectedIndex(2);
        //2
        for(a=8;a<=35;a++)
        { defaultListModel1.addElement(a); }
        list2.setModel(defaultListModel1);
        list2.setSelectedIndex(8);
        //3
        defaultListModel2.addAll(Arrays.asList(styles));
        list3.setModel(defaultListModel2);
        list3.setSelectedIndex(0);
    }
}
