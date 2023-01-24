package apresentacao;

import dados.Conteudo;
import dados.Filme;
import dados.Serie;
import dados.Usuario;
import negocio.Sistema;
import persistencia.FilmeDAO;
import persistencia.SerieDAO;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

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

    public ConteudoDesc(Conteudo c, Sistema s, Usuario u) throws SQLException {
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
        infoTextArea.setText(sist.descricaoString(c));
        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (c instanceof Filme) {
                    try {
                        sist.deletarFilme((Filme) c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if (c instanceof Serie) {
                    try {
                        sist.deletarSerie((Serie) c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    TelaPrincipal volta = new TelaPrincipal(sist, user);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TelaPrincipal volta = new TelaPrincipal(sist, user);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
                try {
                    sist.deletarEpisodio(sist.getEpisodio(s, nb));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
                    if (c instanceof Filme)
                        FilmeDAO.getInstance().alterar((Filme) c);
                    else
                        SerieDAO.getInstance().alterar((Serie) c);
                    new ConteudoDesc(c, sist, user);
                } catch (IOException | SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
            }
        });
    }
}
