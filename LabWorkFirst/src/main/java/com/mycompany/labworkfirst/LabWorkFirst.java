package com.mycompany.labworkfirst;

import controller.MainController;
import model.DataModel;
import view.MainView;

public class LabWorkFirst {
    public static void main(String[] args) {
        DataModel model = new DataModel();
        MainView view = new MainView();
        MainController controller = new MainController(view, model);
        
        view.setVisible(true);
    }
}