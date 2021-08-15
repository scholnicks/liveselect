package scholnick.liveselect;

import lombok.Getter;

import javax.swing.text.*;
import java.awt.Toolkit;

@Getter
public final class LimitedStyledDocument extends DefaultStyledDocument {
    private final int maxCharacters;

    public LimitedStyledDocument(int maxChars) {
        maxCharacters = maxChars;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        // This rejects the entire insertion if it would make the contents too long. Another option would be
        // to truncate the inserted string so the contents would be exactly maxCharacters in length.
        if ((getLength() + str.length()) <= maxCharacters)
            super.insertString(offs, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
}
