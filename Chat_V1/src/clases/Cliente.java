package clases;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Observable;

public class Cliente implements Runnable {

    private Socket scCliente;
    private Servidor server;
    private PrintWriter out;


    public Cliente(Socket scCliente, Servidor server){
        this.scCliente = scCliente;
        this.server = server;

        try {
            out = new PrintWriter(scCliente.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mandarMensaje(String mensaje){
        out.println(mensaje);
    }
    @Override
    public void run() {
        BufferedReader in;

        try {
            InputStreamReader input = new InputStreamReader(scCliente.getInputStream());
            in = new BufferedReader(input);
            String nombreUser = in.readLine();
            server.emitirMensaje(nombreUser + " se unió al chat");

            String texto;
            while ((texto = in.readLine()) != null){

                server.emitirMensaje(nombreUser + "$-> "+ texto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                scCliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            server.eliminarClienteLista(this);
            server.emitirMensaje("Usuario desconectado");
        }

    }
}


