package apresentacao;

import dados.Usuario;
import negocio.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JTextField loginField;
    private JPasswordField passwordField1;
    private JButton criarContaButton;
    private JButton entrarNaContaButton;
    private JPanel Login;
    private JTextField nascField;
    private JLabel a;
    private JLabel contaCriada;
    private JLabel erroLogin;
    private JLabel loginSucesso;
    private Sistema sist = new Sistema();

    public Sistema getSist() {
        return sist;
    }

    public void setSist(Sistema sist) {
        this.sist = sist;
    }

    public Login(){
        setContentPane(Login);
        setTitle("BaldoFlix");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        contaCriada.setVisible(false);
        erroLogin.setVisible(false);
        loginSucesso.setVisible(false);
        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField1.getPassword());
                String nasc = nascField.getText();
                if(login.length() == 0 || senha.length() == 0 || nasc.length() ==0) {
                    erroLogin.setVisible(true);
                    return;
                }
                sist.criaUsuario(login, senha, nasc);
                contaCriada.setVisible(true);
            }
        });
        entrarNaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField1.getPassword());
                Usuario user = sist.loginUsuario(login,senha);
                if(user != null){
                    loginSucesso.setVisible(true);
                    TelaPrincipal telaMain = new TelaPrincipal(sist, user);
                    dispose();
                }else{
                    erroLogin.setVisible(true);
                }
            }
        });
    }
}
