import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAlertDecorator extends JButton {



    public ButtonAlertDecorator(final JButton DecoratedButton)
    {
        super(DecoratedButton.getText());
        final JFrame frame = new JFrame();
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame.getComponent(0),"Alert");
                String text = new String(DecoratedButton.getText());
                setText(text.toUpperCase());
            }
        });
    }
}