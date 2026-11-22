package view;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.RecipeListModel;

public class RecipePanel extends JPanel {

    public RecipePanel(RecipeListModel model) {
        setLayout(new BorderLayout());

        JList<String> list = new JList<>();
        list.setModel(model);

        add(new JScrollPane(list), BorderLayout.CENTER);
    }
}
