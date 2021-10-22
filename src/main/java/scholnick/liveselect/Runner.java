package scholnick.liveselect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Runner extends JFrame {
    public static void main(String ...args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Runner();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public Runner() throws HeadlessException {
        setSize(new Dimension(900, 700));
        Dimension d = getSize();
        Dimension screenSize = getToolkit().getScreenSize();
        setLocation((screenSize.width - d.width) / 2, (screenSize.height - d.height) / 2);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel content = (JPanel) getContentPane();
        content.setLayout(new BorderLayout());
        content.add(new LiveSelect<>(List.of("Waters", "Gilmour", "Mason", "Wright")));

        setVisible(true);
    }
}
