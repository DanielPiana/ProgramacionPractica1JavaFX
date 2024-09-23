package com.example.ejerciciorepasofx.Controller;

import com.example.ejerciciorepasofx.CRUD.CRUD_Clientes;
import com.example.ejerciciorepasofx.Model.Cliente;
import com.example.ejerciciorepasofx.Utilities.Alertas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientesCtrller {
    @FXML
    private ToggleGroup clientePremium;
    @FXML
    private TextField contraseñaTxt;
    @FXML
    private TextField descuentoTxt;
    @FXML
    private TextField usuarioTxt;

    ArrayList<Cliente> listaClientes = new ArrayList<>();

    Scanner reader = new Scanner(System.in);

    @FXML
    void onAñadirBtt(ActionEvent event) {
        Cliente cliente = new Cliente(usuarioTxt.getText(),contraseñaTxt.getText(),Double.parseDouble(descuentoTxt.getText()));
        CRUD_Clientes.insertarUsuario(listaClientes,cliente);
    } // METODO PARA INSERTAR UN NUEVO CLIENTE

    @FXML
    void onBuscarBtt(ActionEvent event) {
        Cliente cliente = new Cliente(usuarioTxt.getText(),contraseñaTxt.getText(),Double.parseDouble(descuentoTxt.getText()));
        if (CRUD_Clientes.buscarCliente(listaClientes,cliente)) {
            Alertas.alertaGeneral("El usuario ha sido encontrado","INFORMATION");
        } else {
            Alertas.alertaGeneral("El usuario no ha sido encontrado","INFORMATION");
        }
    } // METODO PARA BUSCAR UN USUARIO POR MAIL

    @FXML
    void onIngresoBtt(ActionEvent event) {
        Alertas.alertaGeneral("Los ingresos totales son: ","INFORMATION");
    } // METODO PARA CALCULAR EL TOTAL DE INGRESOS DE LOS USUARIOS


    @FXML
    void onLimpiarBtt(ActionEvent event) {

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