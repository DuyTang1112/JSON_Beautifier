import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSON_GUI extends JFrame {
    private static final String VERSION="v1.1";
    private static final String APP_NAME="JSON Beautifier";
    private JPanel panel_main;
    private JPanel bottomPanel;
    private JButton actionBtn;
    private JTextArea input;
    private JTextArea result;
    private JPanel indentOptionPanel;
    private JRadioButton dblSpaceRadioButton;
    private JRadioButton tripleSpaceRadioButton;
    private JRadioButton oneTabRadioButton;
    private JRadioButton quadraSpaceRadioButton;
    private JRadioButton hexaSpaceRadioButton;
    private JPanel topPanel;

    public JSON_GUI() {
        super();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setContentPane(panel_main);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(screenSize.width*5/100,screenSize.height*5/100);
        pack();
        setSize(screenSize.width*90/100,screenSize.height*90/100);
        setResizable(true);
        setTitle(APP_NAME+" "+VERSION);
        setVisible(true);
        setComponentListener();
    }

    /**
     * Set GUI listener components
     */
    public void setComponentListener(){
        actionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(
                  JSON_Beautifier.beautify(input.getText(),
                    dblSpaceRadioButton.isSelected()? JSON_Beautifier.DOUBLE_SPACE:
                      tripleSpaceRadioButton.isSelected()? JSON_Beautifier.TRIPLE_SPACE:
                        oneTabRadioButton.isSelected()? JSON_Beautifier.TAB:
                          quadraSpaceRadioButton.isSelected()? JSON_Beautifier.QUAD_SPACE:
                            hexaSpaceRadioButton.isSelected()?JSON_Beautifier.HEXA_SPACE:
                              " ")
                );
            }
        });

    }
}
