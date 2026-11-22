package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.IngredientsModel;

public class RecipePanel extends JPanel {

    public RecipePanel() {
        JList list = new JList<>();

        add(new JScrollPane(list));
    }
}
