package apresentacao;

import dados.Usuario;
import negocio.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Login extends JFrame {
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
    private JButton deletarContaButton;
    private JLabel ContaDeletada;
    private Sistema sist = new Sistema();

    public Login() {
        setContentPane(Login);
        setTitle("Login");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        contaCriada.setVisible(false);
        erroLogin.setVisible(false);
        loginSucesso.setVisible(false);
        ContaDeletada.setVisible(false);
        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField1.getPassword());
                String nasc = nascField.getText();
                if (login.length() == 0 || senha.length() == 0 || nasc.length() == 0) {
                    erroLogin.setVisible(true);
                    return;
                }
                try {
                    sist.criaUsuario(login, senha, nasc);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                contaCriada.setVisible(true);
            }
        });
        entrarNaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField1.getPassword());
                Usuario user = null;
                try {
                    user = sist.loginUsuario(login, senha);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (user != null) {
                    loginSucesso.setVisible(true);
                    try {
                        TelaPrincipal telaMain = new TelaPrincipal(sist, user);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    dispose();
                } else {
                    erroLogin.setVisible(true);
                }
            }
        });
    }

    public Login(Sistema sistema) {
        sist = sistema;
        setContentPane(Login);
        setTitle("Login");
        setSize(450, 300);
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
                if (login.length() == 0 || senha.length() == 0 || nasc.length() == 0) {
                    erroLogin.setVisible(true);
                    return;
                }
                try {
                    sist.criaUsuario(login, senha, nasc);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                contaCriada.setVisible(true);
            }
        });
        entrarNaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField1.getPassword());
                Usuario user = null;
                try {
                    user = sist.loginUsuario(login, senha);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (user != null) {
                    loginSucesso.setVisible(true);
                    try {
                        TelaPrincipal telaMain = new TelaPrincipal(sist, user);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    dispose();
                } else {
                    erroLogin.setVisible(true);
                }
            }
        });
        deletarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField1.getPassword());
                try {
                    for (Usuario us : sist.getUsers())
                        if (us.getNome().equals(login) && us.getSenha().equals(senha)) {
                            sist.deletarUsuario(us);
                            ContaDeletada.setVisible(true);
                            break;
                        }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
