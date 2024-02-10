package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


///////////////////////////////////////////////////////////////// implementar runnable
public class MarcoChat extends JFrame {
    private String nombreUsuario;
    private JPanel mainPanel;
    private JButton btnEnviar;
    private JButton btnDesconect;
    private JTextField tfChat;
    private JLabel lblChat;
    private JLabel lblUsers;
    private JTextArea taUsers;
    private JTextArea taTextoChat;
    private boolean desconectar = false;

    public MarcoChat(String nombreUsuario) {

        this.setContentPane(mainPanel);
        this.setVisible(true);
        this.setTitle("CHAT DE  " + nombreUsuario.toUpperCase());

        Toolkit pantalla = Toolkit.getDefaultToolkit();

        // Coger la dimension de la pantalla 1900X1000
        Dimension pantallaSize = pantalla.getScreenSize();

        // Extraer el alto y el ancho (ejes x, y)
        int anchoPantalla = pantallaSize.width;
        int alturaPantalla = pantallaSize.height;

        this.setSize(anchoPantalla / 2, alturaPantalla / 2);
        this.setLocation(anchoPantalla / 4, alturaPantalla / 4);

        // Imagen
        Image icono = pantalla.getImage("seta.gif"); // gif pesa menos
        this.setIconImage(icono);

        //Impedir que se redimensione
        this.setResizable(false);

        this.darNombreChat(nombreUsuario.toUpperCase());

        // Añadir usuario ///////Mandarlo por TCP/UDP
        taUsers.setText(nombreUsuario);


        //
        String user = nombreUsuario + "$-> ";

        //Enviar mensajes al panel del chat   ///MAndarlo por TCP/UDP
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Sacar el texto a
                //taTextoChat.setText(user + tfChat.getText() + "\n");
                taTextoChat.append(user + tfChat.getText() + "\n");
                //Limpiar el área de texto
                tfChat.setText("");
            }
        });


        //Desconectar usuario
        btnDesconect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                desconectar = true;
                System.exit(0);
            }
        });

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private String darNombreChat(String nombre) {

        this.lblChat.setText(nombre);

        return this.lblChat.getText();
    }

    public JTextArea getTaUsers() {
        return taUsers;
    }
    public void setTaUsers(JTextArea tfChat) {
        this.taUsers = tfChat;
    }

    public JButton getBtnDesconect() {
        return btnDesconect;
    }

    public JButton getBtnEnviar() {
        return btnEnviar;
    }

    public JTextField getTfChat() {
        return tfChat;
    }

    public void setTfChat(JTextField tfChat) {
        this.tfChat = tfChat;
    }


}
