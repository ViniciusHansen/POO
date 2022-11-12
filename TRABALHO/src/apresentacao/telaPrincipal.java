package apresentacao;

import javax.swing.*;

import dados.Usuario;
import negocio.Sistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaPrincipal extends JFrame{
    private JPanel telaPrincipal;
    private JButton adicionarMídiaButton;
    private Usuario user = new Usuario();

    public telaPrincipal(Usuario user_login){
        setContentPane(telaPrincipal);
        setTitle("BaldoFlix");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        user = user_login;
    }
    
    //Image image=GenerateImage.toImage(true);  //this generates an image file
    //ImageIcon icon = new ImageIcon(image);
    //JLabel thumb = new JLabel();
    //thumb.setIcon(icon);
}
