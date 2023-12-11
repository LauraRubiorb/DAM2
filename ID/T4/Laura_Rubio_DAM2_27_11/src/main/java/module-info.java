module com.example.laura_rubio_dam2_27_11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.json;
    requires com.google.gson;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.laura_rubio_dam2_27_11.model;
    opens com.example.laura_rubio_dam2_27_11 to javafx.fxml;
    exports com.example.laura_rubio_dam2_27_11;
    exports com.example.laura_rubio_dam2_27_11.model;

}