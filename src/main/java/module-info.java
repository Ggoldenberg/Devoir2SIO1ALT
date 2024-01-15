module sio.gestionpermis {
    requires javafx.controls;
    requires javafx.fxml;

    opens sio.gestionpermis.Model;
    opens sio.gestionpermis to javafx.fxml;
    exports sio.gestionpermis;
}