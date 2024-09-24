package com.example.ejerciciorepasofx.CRUD;

import com.example.ejerciciorepasofx.Main;
import com.example.ejerciciorepasofx.Model.Cliente;
import com.example.ejerciciorepasofx.Model.Usuario;
import com.example.ejerciciorepasofx.Utilities.Alertas;

import java.util.ArrayList;
import java.util.Objects;

public class CRUD_Clientes {
    public static ArrayList<Usuario> insertarUsuario(ArrayList<Usuario> lista, Usuario usuario) {
        boolean semaforo = false;
        if (!CRUD_Clientes.buscarUsuario(lista,usuario)) {
            lista.add(usuario);
            semaforo = true;
        }
        if (semaforo) {
            Alertas.alertaGeneral("Operación confirmado con éxito","CONFIRMATION");
        }
        return lista;
    }
    public static boolean buscarUsuario (ArrayList<Usuario> lista ,Usuario usuario) {
        boolean comprobacion = false;
        for (Cliente clienteactual : lista) {
                if (Objects.equals(clienteactual.getMailCl(), usuario.getMailCl())) {
                    comprobacion = true;
                    break;
                }
        }
        return comprobacion;
    }
    public static double calcularIngresos (ArrayList<Usuario> lista) {
        double sumaPremium=0;
        double sumaNoPremium=0;
        for (Usuario usuarioActual: lista) {
            if (usuarioActual.isPremiumUs()) {
                sumaPremium = 35.5 - usuarioActual.getDescuentoCl();
            } else {
                sumaNoPremium = 20.5 - usuarioActual.getDescuentoCl();
            }
        }
        return sumaPremium + sumaNoPremium;
    }
}