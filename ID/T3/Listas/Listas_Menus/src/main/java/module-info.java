module com.example.listas_menus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires org.json;
    requires com.google.gson;

    opens com.example.listas_menus to javafx.fxml;
    exports com.example.listas_menus;
    opens  com.example.listas_menus.model;
}