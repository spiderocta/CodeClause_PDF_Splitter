package com.codeclause.codeclause_pdf_splitter.ui;

import com.codeclause.codeclause_pdf_splitter.handlers.InputHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PdfSplitterUI extends Application {
    private Text fileName;
    private String title = "codeclause pdf_splitter";
    public static Stage primaryStage;

    @SuppressWarnings("static-access")
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle(title);
        Label label = new Label("Select PDF File");
        label.setTextFill(Color.DARKBLUE);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
        HBox labelHb = new HBox();
        labelHb.setAlignment(Pos.CENTER);
        labelHb.getChildren().add(label);

        fileName = new Text();
        fileName.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
        fileName.setFill(Color.FIREBRICK);

        TextField fromPageNumber = new InputHandler();
        fromPageNumber.setPromptText("From Page ");
        fromPageNumber.setMaxWidth(50);

        TextField toPageNumber = new InputHandler();
        toPageNumber.setPromptText("To Page");
        toPageNumber.setMaxWidth(50);

        Button splitButton = new Button("Split PDF");

    }
}
