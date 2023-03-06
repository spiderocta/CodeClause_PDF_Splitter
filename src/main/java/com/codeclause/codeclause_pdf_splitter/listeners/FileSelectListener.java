package com.codeclause.codeclause_pdf_splitter.listeners;

import com.codeclause.codeclause_pdf_splitter.main.Main;
import com.codeclause.codeclause_pdf_splitter.utilities.PdfUtility;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class FileSelectListener implements EventHandler<ActionEvent> {
    private Text pdfFile;
    private HBox hbox;

    public FileSelectListener(Text pdfFile, HBox hbox) {
        this.pdfFile = pdfFile;
        this.hbox = hbox;
    }

    @Override
    public void handle(ActionEvent e) {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            if(getFileExtension(selectedFile.getAbsolutePath()).equals("pdf")){
                pdfFile.setText("Selected PDF : " + selectedFile.getName());
                hbox.setVisible(true);

                //Sending pdf file to model
                try {
                    Main.pdfUtility = new PdfUtility(selectedFile);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }else{
                pdfFile.setText("Invalid file format.");
            }
        }
        else {
            pdfFile.setText("File selection cancelled.");
        }
    }


    public String getFileExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i >= 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}
