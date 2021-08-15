package scholnick.liveselect;

import lombok.*;

import javax.swing.*;
import java.util.*;

@Getter
@Setter
@ToString
public class LiveSelect<T> extends JComponent {
    private List<T> data;
    private JTextField textField;
    private int columns;
    private int maxCharacters;

    public LiveSelect(List<T> data) {
        this.data = Objects.requireNonNull(data);
    }

    public JTextField getTextField() {
        if (textField == null) {
            textField = new JTextField();
            if (columns > 0) textField.setColumns(columns);
            if (maxCharacters > 0) textField.setDocument(new LimitedStyledDocument(maxCharacters));
        }
        return textField;
    }

    public void setData(List<T> data) {
        this.data = Objects.requireNonNull(data);
    }

}
