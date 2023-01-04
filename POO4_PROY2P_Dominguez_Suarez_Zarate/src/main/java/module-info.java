module com.mycompany.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.mavenproject1 to javafx.fxml;
    exports com.mycompany.mavenproject1;
}
