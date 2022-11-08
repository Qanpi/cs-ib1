package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.*;
import java.awt.*;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Graph comparison of sorting algorithms");

        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 1000, 700));
        stage.show();
    }
}
