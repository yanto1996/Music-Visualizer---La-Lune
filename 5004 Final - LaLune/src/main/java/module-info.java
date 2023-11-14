module Project {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.graphics;
  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;
  requires java.desktop;
  requires junit;
  exports Project to javafx.graphics;
  exports test to junit;
  opens Project to javafx.fxml;
  opens test to junit;
}