package com.company;

import Controller.MainController;
import Model.Model;
import View.GUIPreview;
import View.MainView;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MainView view = new MainView();
        Model model = new Model();
        GUIPreview preview = new GUIPreview(view);
        MainController control = new MainController(model, view, preview);
        control.init();
    }
}
