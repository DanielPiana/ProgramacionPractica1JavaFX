package com.example.ejerciciorepasofx.Utilities;

import javafx.scene.control.Alert;

public class Alertas {
    public static void alertaGeneral(String mensaje,String tipoAlerta) {
        Alert alert = new Alert(Alert.AlertType.valueOf(tipoAlerta.toUpperCase()));
        alert.setTitle("");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
