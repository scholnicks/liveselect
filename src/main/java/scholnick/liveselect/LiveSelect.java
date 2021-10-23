package scholnick.liveselect;

import lombok.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;

/**
 *
 * See https://select2.org/getting-started/basic-usage
 *
 * @param <T>
 */
@Getter
@Setter
@ToString
public class LiveSelect<T> extends JTextComponent {
    private List<T>    data;
    private int        columns;
    private int        maxCharacters;
    private boolean    multiSelect;

    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    private JTextField textField;

    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    private JDialog popup;

    public LiveSelect() {
    }

    public LiveSelect(List<T> data) {
        this.data = Objects.requireNonNull(data);
    }

    private JTextField getTextField() {
        if (textField == null) {
            textField = new JTextField();
            textField.setEditable(true);
            textField.setEnabled(true);
            if (columns > 0) textField.setColumns(columns);
//            if (maxCharacters > 0) textField.setDocument(new LimitedStyledDocument(maxCharacters));

            textField.addMouseListener(new MouseAdapter() {
                @Override public void mouseClicked(MouseEvent e) {
                    popup();
                }
            });
        }
        return textField;
    }

    private void popup() {
//        if (popup == null) {
            JDialog popup = new JDialog();
            popup.setLayout(new BorderLayout());
            popup.add(new JTextField(),BorderLayout.NORTH);
            popup.add(new JComboBox<T>(new Vector<>(data)),BorderLayout.CENTER);
            popup.setVisible(true);
//        }
    }

    public void setData(List<T> data) {
        this.data = Objects.requireNonNull(data);
    }

    public String getText() {
        return getTextField().getText();
    }

    public boolean isEnabled() {
        return getTextField().isEnabled();
    }

    public void setEnabled(boolean b) {
        getTextField().setEnabled(b);
    }

    @Override
    public String getUIClassID() {
        return getTextField().getUIClassID();
    }
}
