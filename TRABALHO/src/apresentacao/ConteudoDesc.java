package apresentacao;

import dados.Conteudo;
import dados.Filme;
import dados.Serie;
import dados.Usuario;
import negocio.Sistema;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConteudoDesc extends JFrame {
    private JLabel info;
    private JPanel ConteudoDesc;
    private JTextArea infoTextArea;
    private JButton excluirButton;
    private JButton voltarButton;
    private JButton adicionarElencoButton;
    private JSpinner spinner;
    private JButton deletarEpisódioButton;
    private JLabel EpDeletadoSucesso;
    private JLabel capa;
    private JButton mudarCapaButton;
    private Sistema sist;
    private Usuario user;

    public ConteudoDesc(Conteudo c, Sistema s, Usuario u) {
        setContentPane(ConteudoDesc);
        setTitle(c.getTitulo());
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        EpDeletadoSucesso.setVisible(false);
        if (c instanceof Serie) {
            spinner.setVisible(true);
            deletarEpisódioButton.setVisible(true);
        } else {
            spinner.setVisible(false);
            deletarEpisódioButton.setVisible(false);
        }
        if (c.getCapa() != null)
            capa.setIcon(c.getCapa());

        sist = s;
        user = u;
        infoTextArea.setText(c.toString());
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (c instanceof Filme)
                    sist.deletarFilme(user, (Filme) c);
                if (c instanceof Serie)
                    sist.deletarSerie(user, (Serie) c);
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
        deletarEpisódioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nb = (Integer) spinner.getValue();
                Serie s = (Serie) c;
                sist.deletarEpisodio(s, s.getEpisodio(nb));
                EpDeletadoSucesso.setVisible(true);
            }
        });
        mudarCapaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif");
                chooser.setFileFilter(filter);
                File arquivo = new File(".");//chooser.getSelectedFile();
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                    arquivo = chooser.getSelectedFile();
                }
                try {
                    byte[] capa = Files.readAllBytes(arquivo.toPath());
                    c.setCapa(capa);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                ConteudoDesc atualzia = new ConteudoDesc(c, sist, user);
                dispose();
            }
        });
    }
}
