package Controller;

import Model.Model;
import View.GUIPreview;
import View.MainView;

public class MainController {
    private Model model;
    private MainView view;
    private GUIPreview preview;

    public MainController(Model model, MainView view, GUIPreview preview) {
        this.model = model;
        this.view = view;
        this.preview = preview;
    }

    public void init() {
        view.getJbAdd().addActionListener(e -> addToOptionList());
        view.getJbutton().addActionListener(e -> addToPreview());

        view.getJcbSwingComp().addActionListener(e -> updateViewComponentType());
    }

    private void addToOptionList() {
        view.addToOptionList(view.getJtfAddText());
    }

    private void updateViewComponentType() {
        view.updateViewComponentType();
    }

    public void addToPreview() {
        preview.addGUI(view.getSelectedComponent(), view.getSelectedPosition());
    }
}
