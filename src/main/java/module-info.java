module com.codeclause.codeclause_pdf_splitter {
    requires javafx.controls;
    requires javafx.fxml;
    requires itextpdf;


    opens com.codeclause.codeclause_pdf_splitter to javafx.fxml;
    exports com.codeclause.codeclause_pdf_splitter;
    exports com.codeclause.codeclause_pdf_splitter.handlers;
    opens com.codeclause.codeclause_pdf_splitter.handlers to javafx.fxml;
    exports com.codeclause.codeclause_pdf_splitter.ui;
    opens com.codeclause.codeclause_pdf_splitter.ui to javafx.fxml;
}