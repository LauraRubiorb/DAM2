module com.example.practicajson {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.json;
    requires com.google.gson;

    opens com.example.practicajson.model to com.google.gson;
    exports com.example.practicajson.model;
    opens com.example.practicajson to javafx.fxml;
    exports com.example.practicajson;
}