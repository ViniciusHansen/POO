package apresentacao;

import javax.swing.*;

import dados.Usuario;
import negocio.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame{
    private JPanel telaPrincipal;
    private JButton addMediaButton;
    protected Sistema sist = new Sistema();
    protected Usuario user = new Usuario();

    public TelaPrincipal(){}
    public TelaPrincipal(Sistema s, Usuario user_login){
        setContentPane(telaPrincipal);
        setTitle("_____Flix");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        user = user_login;
        sist = s;
        addMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMedia telaAddMedia = new AddMedia(user);
            }
        });
    }


    public void addFilme(){
    }
    
    //Image image=GenerateImage.toImage(true);  //this generates an image file
    //ImageIcon icon = new ImageIcon(image);
    //JLabel thumb = new JLabel();
    //thumb.setIcon(icon);
}
