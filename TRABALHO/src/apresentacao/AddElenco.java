package apresentacao;

import dados.Ator;
import dados.Conteudo;
import dados.Usuario;
import negocio.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddElenco extends JFrame {
    private JPanel AddElenco;
    private JTextField nomeField;
    private JTextField nascField;
    private JButton adicionarAoElencoPrincipalButton;
    private JButton voltarButton;
    private JButton adicionarAoElencoSecundárioButton;
    private JTextField sexoField;
    private JLabel addSucesso;
    private JLabel addErro;
    private Conteudo cont;
    private Sistema sist;
    private Usuario user;

    public AddElenco(Conteudo conteudo, Sistema sistema, Usuario usuario) {
        cont = conteudo;
        sist = sistema;
        user = usuario;
        setContentPane(AddElenco);
        setTitle("Adicionar Elenco");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        addSucesso.setVisible(false);
        addErro.setVisible(false);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConteudoDesc volta = new ConteudoDesc(cont, sist, user);
                dispose();
            }
        });
        adicionarAoElencoPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String nasc = nascField.getText();
                String sexo = sexoField.getText();
                Ator novo = new Ator(nome, nasc, sexo);
                novo.setId(cont.getElencoSecundario().size() + cont.getElencoPrincipal().size());
                sist.addToElencoPrincipal(cont, novo);
                addSucesso.setVisible(true);
            }
        });
        adicionarAoElencoSecundárioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String nasc = nascField.getText();
                String sexo = sexoField.getText();
                Ator novo = new Ator(nome, nasc, sexo);
                novo.setId(cont.getElencoSecundario().size() + cont.getElencoPrincipal().size());
                sist.addToElencoSecundario(cont, novo);
                addSucesso.setVisible(true);
            }
        });
    }
}
