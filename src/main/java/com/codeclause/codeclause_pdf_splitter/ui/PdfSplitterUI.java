package com.codeclause.codeclause_pdf_splitter.ui;

import com.codeclause.codeclause_pdf_splitter.handlers.InputHandler;
import com.codeclause.codeclause_pdf_splitter.listeners.ButtonListener;
import com.codeclause.codeclause_pdf_splitter.listeners.FileSelectListener;
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

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(25, 25, 25, 0));
        hbox.setMargin(fromPageNumber, new Insets(0, 5, 0, 0));
        hbox.setMargin(toPageNumber, new Insets(0, 5, 0, 0));
        hbox.getChildren().addAll(fromPageNumber,toPageNumber,splitButton);
        hbox.setVisible(false);
        splitButton.setOnAction(new ButtonListener(fromPageNumber,toPageNumber));

        // Pdf Chooser Button
        Button pdfChooseButton = new Button("Choose a pdf");
        pdfChooseButton.setOnAction(new FileSelectListener(fileName,hbox));

        // Vertical box
        VBox vbox = new VBox(30);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.getChildren().addAll(labelHb,pdfChooseButton,fileName,hbox);

        // Scene
        Scene scene = new Scene(vbox, 500, 400); // width x height
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
