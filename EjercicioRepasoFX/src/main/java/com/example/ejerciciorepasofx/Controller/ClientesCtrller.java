package com.example.ejerciciorepasofx.Controller;

import com.example.ejerciciorepasofx.CRUD.CRUD_Clientes;
import com.example.ejerciciorepasofx.Model.Cliente;
import com.example.ejerciciorepasofx.Model.Usuario;
import com.example.ejerciciorepasofx.Utilities.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientesCtrller {
    @FXML
    private RadioButton siPremium;
    @FXML
    private RadioButton noPremium;
    @FXML
    private ToggleGroup clientePremium;
    @FXML
    private TextField contraseñaTxt;
    @FXML
    private TextField descuentoTxt;
    @FXML
    private TextField usuarioTxt;

    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    Scanner reader = new Scanner(System.in);

    @FXML
    void onAñadirBtt(ActionEvent event) {
        boolean premium;
        if (usuarioTxt.getText().isEmpty() || contraseñaTxt.getText().isEmpty() || descuentoTxt.getText().isEmpty()) {
            Alertas.alertaGeneral("Tiene que rellenar todos los campos","WARNING");
        } else {
            try {
                if (siPremium.isSelected()) {
                    premium = true;
                } else {
                    premium = false;
                }
                Usuario usuario = new Usuario(usuarioTxt.getText(),contraseñaTxt.getText(),Double.parseDouble(descuentoTxt.getText()),premium);
                CRUD_Clientes.insertarUsuario(listaUsuarios,usuario);
            }catch (NumberFormatException e) {
                Alertas.alertaGeneral("El recuadro descuento solo admite números.","WARNING");
            }
        }
    } // METODO PARA INSERTAR UN NUEVO CLIENTE

    @FXML
    void onBuscarBtt(ActionEvent event) {
        if (usuarioTxt.getText().isEmpty()) {
            Alertas.alertaGeneral("Debe insertar un usuario para buscar","WARNING");
        } else {
            Usuario usuario = new Usuario(usuarioTxt.getText());
            if (CRUD_Clientes.buscarUsuario(listaUsuarios,usuario)) {
                Alertas.alertaGeneral("El usuario ha sido encontrado","INFORMATION");
            } else {
                Alertas.alertaGeneral("El usuario no ha sido encontrado","INFORMATION");
            }
        }

    } // METODO PARA BUSCAR UN USUARIO POR MAIL

    @FXML
    void onIngresoBtt(ActionEvent event) {
        double ingresos = CRUD_Clientes.calcularIngresos(listaUsuarios);
        Alertas.alertaGeneral("Los ingresos totales son: " + ingresos,"INFORMATION");
    } // METODO PARA CALCULAR EL TOTAL DE INGRESOS DE LOS USUARIOS


    @FXML
    void onLimpiarBtt(ActionEvent event) {
        usuarioTxt.setText("");
        contraseñaTxt.setText("");
        descuentoTxt.setText("");
        clientePremium.selectToggle(null);
    }

    @FXML
    void onSalirBtt(ActionEvent event) {
        int opcion = JOptionPane.showConfirmDialog(null,
                "¿Está seguro de que desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0); // CERRAR APLICACIÓN
        }
    } // SALIR DE LA APLICACIÓN
}