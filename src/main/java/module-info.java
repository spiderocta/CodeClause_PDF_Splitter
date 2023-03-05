module com.codeclause.codeclause_pdf_splitter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.codeclause.codeclause_pdf_splitter to javafx.fxml;
    exports com.codeclause.codeclause_pdf_splitter;
}