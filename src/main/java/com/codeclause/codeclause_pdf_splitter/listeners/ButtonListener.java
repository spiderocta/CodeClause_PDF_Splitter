package com.codeclause.codeclause_pdf_splitter.listeners;

import com.codeclause.codeclause_pdf_splitter.main.Main;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ButtonListener implements EventHandler<ActionEvent> {
    private TextField startPage;
    private TextField endPage;

    public ButtonListener(TextField startPage, TextField endPage) {
        this.startPage = startPage;
        this.endPage = endPage;
    }

    @Override
    public void handle(ActionEvent arg0) {
        if (startPage.getText().isEmpty() || endPage.getText().isEmpty()) {
            System.out.println("Error");
        } else if (
                Integer.parseInt(startPage.getText().trim())
                        -
                        Integer.parseInt(endPage.getText().trim())
                        > 0
        ) {

            System.out.println("Error");

        } else {

            int start = Integer.parseInt(startPage.getText().trim());
            int end = Integer.parseInt(endPage.getText().trim());

            Document document = new Document();
            FileOutputStream outputStream = createOutputStream();
            outputPdf(start, end, document, outputStream);
        }

    }
    public FileOutputStream createOutputStream() {
        String outputPath = Main.pdfUtility.getFilePath() + "\\outputFile.pdf";
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(outputPath);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        return outputStream;
    }
    public void outputPdf(int start, int end, Document document, FileOutputStream outputStream) {
        PdfWriter writer = null;
        try {
            writer = PdfWriter.getInstance(document, outputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.open();
        PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
        PdfImportedPage page;
        PdfReader inputPDF = Main.pdfUtility.getPDFInput();


        while (start <= end) {
            document.newPage();
            page = writer.getImportedPage(inputPDF, start);
            cb.addTemplate(page, 0, 0);
            start++;
        }

        closeFileOutput(document, outputStream);
    }

    public void closeFileOutput(Document document, FileOutputStream outputStream) {
        try {
            outputStream.flush();
            document.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
