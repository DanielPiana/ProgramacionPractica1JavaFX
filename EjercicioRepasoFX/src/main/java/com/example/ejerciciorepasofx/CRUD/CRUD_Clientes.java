package com.example.ejerciciorepasofx.CRUD;

import com.example.ejerciciorepasofx.Main;
import com.example.ejerciciorepasofx.Model.Cliente;
import com.example.ejerciciorepasofx.Utilities.Alertas;

import java.util.ArrayList;
import java.util.Objects;

public class CRUD_Clientes {
    public static ArrayList<Cliente> insertarUsuario(ArrayList<Cliente> lista,Cliente cliente) {
        boolean semaforo = false;
        if (!CRUD_Clientes.buscarCliente(lista,cliente)) {
            lista.add(cliente);
            semaforo = true;
            System.out.println("prueba commit");
        }
        if (semaforo) {
            Alertas.alertaGeneral("Operación confirmado con éxito","CONFIRMATION");
        }
        return lista;
    }
    public static boolean buscarCliente (ArrayList<Cliente> lista ,Cliente cliente) {
        boolean comprobacion = false;
        for (Cliente clienteactual : lista) {
                if (Objects.equals(clienteactual.getMailCl(), cliente.getMailCl())) {
                    comprobacion = true;
                    Alertas.alertaGeneral("Ese usuario ya está en uso","WARNING");
                    break;
                }
        }
        return comprobacion;
    }
}