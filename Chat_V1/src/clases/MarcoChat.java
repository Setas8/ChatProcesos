package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


///////////////////////////////////////////////////////////////// implementar runnable
public class MarcoChat extends JFrame implements Runnable{
    private String nombreUsuario;
    private JPanel mainPanel;
    private JButton btnEnviar;
    private JButton btnDesconect;
    private JTextField tfChat;
    private JLabel lblChat;
    private JLabel lblUsers;
    private JTextArea taUsers;
    private JTextArea taTextoChat;

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



    private boolean desconectar = false;
    ActionListener accionDesconectar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            desconectar = true;

        }
    };

    @Override
    public void run() {

        this.taUsers.append(nombreUsuario);

        while (!desconectar){



            btnDesconect.addActionListener(accionDesconectar);



        }
    }
}
