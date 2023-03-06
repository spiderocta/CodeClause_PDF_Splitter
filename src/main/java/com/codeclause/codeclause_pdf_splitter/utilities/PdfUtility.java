package com.codeclause.codeclause_pdf_splitter.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.itextpdf.text.pdf.PdfReader;

public class PdfUtility {
    private static PdfReader pdfFile;
    private static File selectedFile;

    public PdfUtility(File selectedFile) throws IOException {
        this.selectedFile = selectedFile;
        FileInputStream inputStream = new FileInputStream(selectedFile.getAbsolutePath());
         pdfFile= new PdfReader(inputStream); pdfFile.unethicalreading = true;
    }

    public static PdfReader getPDFInput(){
        return pdfFile;
    }

    public static String getFilePath(){
        String absolutePath = selectedFile.getAbsolutePath();
        String filePath = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));
        return filePath;
    }
}
