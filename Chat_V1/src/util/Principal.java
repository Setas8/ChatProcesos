package util;

import clases.Cliente;
import clases.MarcoChat;
import clases.Servidor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal {
    static Set<String> nombresUsuarios = new HashSet<>();

    public static void main(String[] args) {


        Servidor server = new Servidor();
        server.lanzarServer();

        String nombreUser = "";

        //Si el nombre está en el conjunto, se repite el JOptionPane
        do{
            nombreUser = JOptionPane.showInputDialog("Escribe tu nick");
            MarcoChat chat = new MarcoChat(nombreUser);
            chat.lanzarChat();
        } while(!addUsuarios(nombreUser));


    }
    //Añadir usuarios
    private  static boolean addUsuarios(String nombre) {

        boolean insertado = false;
        if (nombresUsuarios.add(nombre))
            insertado = true;

        return insertado;
    }
}
