import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonVisibleDecorator extends JButton {
    public ButtonVisibleDecorator(JButton decoratedButton){
        super(decoratedButton.getText());
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
