package scholnick.liveselect;

import lombok.*;

import javax.swing.*;
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
public class LiveSelect<T> extends JComponent {
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
            textField.setEditable(false);
            textField.setEnabled(true);
            if (columns > 0) textField.setColumns(columns);
            if (maxCharacters > 0) textField.setDocument(new LimitedStyledDocument(maxCharacters));

            textField.addMouseListener(new MouseAdapter() {
                @Override public void mouseClicked(MouseEvent e) {
                    popup();
                }
            });
        }
        return textField;
    }

    private JDialog popup() {
        if (popup == null) {
            popup = new JDialog();
            popup.setLayout(new BorderLayout());
            popup.add(new JTextField(),BorderLayout.NORTH);
            popup.add(new JComboBox<T>(new Vector<>(data)),BorderLayout.CENTER);
        }
        return popup;
    }


//    private void popUpMenu() {
//        JPopupMenu popup = new JPopupMenu();
//        data.forEach(d -> {
//            JMenuItem item = new JMenuItem(d.toString());
////            item.addActionListener(l -> createAuthorLabel(d,dataPanel,inputField,true));
//            popup.add(item);
//        });
//        popup.pack();
//        popup.show(getTextField(), 0, getTextField().getHeight());
//        popup.requestFocusInWindow();
//    }


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
}
