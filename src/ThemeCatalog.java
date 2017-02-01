import javax.swing.*;
import java.util.ArrayList;


public class ThemeCatalog extends AbstractListModel implements ComboBoxModel {
    private ArrayList<IThemeFactory> themes = new ArrayList();
    private IThemeFactory selectedTheme = null;

    public ThemeCatalog() {
        themes.add(new MarioTheme());
        themes.add(new StarWarsTheme());
        selectedTheme = themes.get(0);
    }


    public Object getElementAt(int index) {
        return themes.get(index);
    }

    public int getSize() {
        return themes.size();
    }

    // Methods implemented from the interface ComboBoxModel
    public Object getSelectedItem() {
        return selectedTheme; // to add the selection to the combo box
    }

    public void setSelectedItem(Object anItem) {
        selectedTheme = (IThemeFactory) anItem;
    } // item from the pull-down list
}
