package com.company.homework1;

import javax.management.JMException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.jar.JarEntry;

public class GUI extends JFrame {
    GUI(Controller controller) {
        super("Homework 1-3");
        this.controller = controller;


        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        createLayout();
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem quitItem = new JMenuItem();
        quitItem.setAction(new QuitAction());

        menu.add(quitItem);
        menuBar.add(menu);
        return menuBar;
    }

    private void createLayout() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("first");
        comboBox.addItem("second");
        comboBox.addItem("third");
        comboBox.setAction(new PrintSelectedAction());
        add(comboBox);

        // LABEL AND TIMER
        JLabel label = new JLabel(Integer.toString(state));
        add(label);

        Timer stateTimer = new Timer(100, e -> {
            state++;
            label.setText(Integer.toString(state));
        });
        stateTimer.start();

        //TEXT FIELD AND PROGRESS BAR
        JProgressBar progressBar = new JProgressBar(0, 10);

        final int textColumns = 10;
        JTextField textField = new JTextField(textColumns);
        textField.addActionListener(e -> {
            progressBar.setValue(textField.getText().length());
        });

        add(progressBar);
        add(textField);

    }

    private Controller controller;
    private int state = 0;

    @Override
    public void dispose() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?"
        ,           null,
                         JOptionPane.OK_CANCEL_OPTION
        );
        if (result == JOptionPane.YES_OPTION) {
            super.dispose();
            System.exit(0);
        }
    }

    class QuitAction extends AbstractAction {
        QuitAction() {
            super("Quit");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    class PrintSelectedAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JComboBox) {
                System.out.println(((JComboBox) e.getSource()).getSelectedItem());
            }
        }
    }
}
