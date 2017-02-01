import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


interface IThemeFactory {
    public String getName();
    public JButton createButton(String text);
}

public class Main {

    public static void main(String[] args) {
        final ThemeCatalog themes = new ThemeCatalog();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //On crée une nouvelle instance de notre JDialog
                JDialog dialog = new JDialog();
                dialog.setSize(300, 200);//On lui donne une taille
                dialog.setTitle("Première fenêtre"); //On lui donne un titre
                dialog.setVisible(true);//On la rend visible


                final JPanel pan = new JPanel();
                pan.setLayout(new FlowLayout());

                dialog.add(pan);

                JComboBox themeSelector = new JComboBox(themes);

                themeSelector.setRenderer(new ThemeCellRenderer());
                final IThemeFactory theme = new MarioTheme();


                //pan.remove(1);
                JButton button = theme.createButton("Hello");
                pan.add(themeSelector);
                pan.add(button);

                JButton button1 = new JButton("UpperCase");
                JButton button2 = new JButton("Alert");
                JButton button3 = new JButton("Visible");
                UpperCaseDecorator UCD = new UpperCaseDecorator(button1);
                ButtonAlertDecorator BAD = new ButtonAlertDecorator(button2);
                ButtonVisibleDecorator BVD = new ButtonVisibleDecorator(button3);
                pan.add(UCD);
                pan.add(BAD);
                pan.add(BVD);

                dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
            }
        });
    }
}


class ThemeCellRenderer extends JLabel implements ListCellRenderer<Object> {
    public ThemeCellRenderer() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList<?> list,
                                                  Object theme,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        setText(((IThemeFactory) theme).getName());
        return this;
    }
}

class StarWarsTheme implements IThemeFactory {
    @Override
    public String getName() {
        return "Star Wars";
    }

    public JButton createButton(String text) {
        return new StarWarsThemeButton(text);
    }
}

class MarioTheme implements IThemeFactory {
    @Override
    public String getName() {
        return "Mario";
    }

    public JButton createButton(String text) {
        return new MarioThemeButton(text);
    }
}

class StarWarsThemeButton extends JButton {
    public StarWarsThemeButton(String text) {
        super();
        this.setText(text);
        this.setBackground(new Color(100, 100, 100));
    }
}

class MarioThemeButton extends JButton {
    public MarioThemeButton(String text) {
        super();
        this.setText(text);
        this.setBackground(new Color(200, 200, 200));
    }
}
