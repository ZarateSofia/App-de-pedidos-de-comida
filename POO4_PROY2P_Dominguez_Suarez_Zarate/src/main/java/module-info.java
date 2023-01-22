module com.pooespol.poo2p {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.pooespol.poo2p to javafx.fxml;
    exports com.pooespol.poo2p;
}
