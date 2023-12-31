module com.example.estructura {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.estructura to javafx.fxml;
    exports com.example.estructura;
    exports com.example.estructura.controller;
    opens com.example.estructura.controller to javafx.fxml;
}