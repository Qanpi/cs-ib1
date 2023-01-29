package com.company.homework1;

import javax.swing.*;

public class Controller {
    Controller( ) {
        GUI = new GUI(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater (() -> new Controller ());
    }

    private GUI GUI;
}
