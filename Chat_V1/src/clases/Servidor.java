package clases;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor  {

    public static void main(String[] args) {
        Servidor server = new Servidor();
        server.lanzarServer();
    }

    private final int PUERTO_SERVER = 6001;
    private List<Cliente> listaClientes = new ArrayList<>();

    public  void lanzarServer(){

        try {
            ServerSocket scServer = new ServerSocket(PUERTO_SERVER);
            System.out.println("Servidor escuchando en puerto " + PUERTO_SERVER);

            //Siempre escuchando
            while (true) {
                Socket scCliente = scServer.accept();
                System.out.println("Nuevo cliente conectado!");

                Cliente cli = new Cliente(scCliente, this);
                listaClientes.add(cli);
                Thread hiloCliente = new Thread (cli);
                hiloCliente.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void emitirMensaje(String mensaje) {
        for (Cliente cl : listaClientes) {
            cl.mandarMensaje(mensaje);
        }
    }

    public void eliminarClienteLista(Cliente cl) {
        listaClientes.remove(cl);
    }


}
