package apresentacao;

import dados.Conteudo;
import dados.Filme;
import dados.Serie;
import dados.Usuario;
import negocio.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConteudoDesc extends JFrame{
    private JLabel info;
    private JPanel ConteudoDesc;
    private JTextArea infoTextArea;
    private JButton excluirButton;
    private JButton voltarButton;
    private JButton adicionarElencoButton;
    private Sistema sist;
    private Usuario user;

    public ConteudoDesc(Conteudo c, Sistema s, Usuario u){
        setContentPane(ConteudoDesc);
        setTitle(c.getTitulo());
        setSize(450,600);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        sist = s;
        user = u;
        infoTextArea.setText(c.toString());
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(c instanceof Filme)
                    sist.deletarFilme(user, (Filme)c);
                if(c instanceof Serie)
                    sist.deletarSerie(user, (Serie)c);
                TelaPrincipal volta = new TelaPrincipal(sist, user);
                dispose();
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal volta = new TelaPrincipal(sist, user);
                dispose();
            }
        });
        adicionarElencoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddElenco novo = new AddElenco(c, sist, user);
                dispose();
            }
        });
    }
}
