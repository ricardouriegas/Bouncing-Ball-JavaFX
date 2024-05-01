module test {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens test to javafx.fxml;
    exports test;
}
