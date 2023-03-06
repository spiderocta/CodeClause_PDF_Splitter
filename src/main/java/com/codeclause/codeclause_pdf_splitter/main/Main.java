package com.codeclause.codeclause_pdf_splitter.main;

import com.codeclause.codeclause_pdf_splitter.ui.PdfSplitterUI;
import com.codeclause.codeclause_pdf_splitter.utilities.PdfUtility;

import java.io.IOException;

public class Main {
    public static PdfUtility pdfUtility;

    public static void main(String[] args) throws IOException {

        PdfSplitterUI.launch(PdfSplitterUI.class);

    }
}
