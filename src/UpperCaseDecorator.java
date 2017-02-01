
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpperCaseDecorator extends JButton {


    public UpperCaseDecorator(final JButton b) {
        super(b.getText());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setText(b.getText().toUpperCase());
            }
        });
    }
}
