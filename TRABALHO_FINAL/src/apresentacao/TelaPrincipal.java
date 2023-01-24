package apresentacao;

import dados.Conteudo;
import dados.Filme;
import dados.Serie;
import dados.Usuario;
import negocio.Sistema;
import persistencia.FilmeDAO;
import persistencia.SerieDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaPrincipal extends JFrame {
    protected Sistema sist = new Sistema();
    protected Usuario user = new Usuario();
    private JPanel telaPrincipal;
    private JButton addMediaButton;
    private JScrollPane ConteudoScrollPane;
    private JList ConteudoList;
    private JButton logOutButton;
    private JComboBox CategoriaSeletor;
    private JButton filtrarPorCategoriaButton;
    private DefaultListModel ListaConteudoModel;

    public void setUser(Usuario user) {
        this.user = user;
    }

    public TelaPrincipal(Sistema s, Usuario user_login) throws SQLException {
        setContentPane(telaPrincipal);
        setTitle("Tela Principal");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        user = user_login;
        sist = s;

        //cria a lista de Conteudo
        ListaConteudoModel = new DefaultListModel();
        ConteudoList.setModel(ListaConteudoModel);
        for (Conteudo c : sist.getAllConteudo(user))
            ListaConteudoModel.addElement(c.getTitulo());

        addMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMedia telaAddMedia = new AddMedia(sist, user);
                dispose();
            }
        });
        ConteudoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    for (Conteudo c : sist.getAllConteudo(user)) {
                        if (c.getTitulo().equals(ConteudoList.getSelectedValue())) {
                            if (c instanceof Filme) {
                                Filme filme = FilmeDAO.getInstance().carregar(c.getId());
                                new ConteudoDesc(filme, sist, user);
                            } else {
                                Serie serie = SerieDAO.getInstance().carregar(c.getId());
                                new ConteudoDesc(serie, sist, user);
                            }
                            dispose();
                            break;
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login sair = new Login(sist);
                dispose();
            }
        });
        CategoriaSeletor.addItem("Sem Filtro");
        for (String cat : sist.getAllCategorias(user))
            CategoriaSeletor.addItem(cat);
        filtrarPorCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cria a lista de Conteudo
                ListaConteudoModel = new DefaultListModel();
                ConteudoList.setModel(ListaConteudoModel);
                if (CategoriaSeletor.getSelectedItem().equals("Sem Filtro")) {
                    try {
                        for (Conteudo c : sist.getAllConteudo(user))
                            ListaConteudoModel.addElement(c.getTitulo());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        for (Conteudo c : sist.getAllConteudo(user))
                            if (c.getGenero().equals(CategoriaSeletor.getSelectedItem()))
                                ListaConteudoModel.addElement(c.getTitulo());
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
