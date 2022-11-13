package apresentacao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dados.Conteudo;
import dados.Usuario;
import negocio.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame{
    protected Sistema sist = new Sistema();
    protected Usuario user = new Usuario();
    private JPanel telaPrincipal;
    private JButton addMediaButton;
    private JScrollPane ConteudoScrollPane;
    private JList ConteudoList;
    private JButton logOutButton;
    private JComboBox CategoriaSeletor;
    private JButton filtrarPorCategoriaButton;
    private JButton debugButton;
    private DefaultListModel ListaConteudoModel;

    public void setUser(Usuario user) {
        this.user = user;
    }

    public TelaPrincipal(Sistema s, Usuario user_login){
        setContentPane(telaPrincipal);
        setTitle("_____Flix");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        user = user_login;
        sist = s;

        //cria a lista de Conteudo
        ListaConteudoModel = new DefaultListModel();
        ConteudoList.setModel(ListaConteudoModel);
        for (Conteudo c : user.getAllConteudo())
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
                Conteudo procurado = null;
                for(Conteudo c : user.getAllConteudo())
                    if(c.getTitulo() == ConteudoList.getSelectedValue()) {
                        procurado = c;
                        break;
                    }
                ConteudoDesc desc = new ConteudoDesc(procurado, sist, user);
                dispose();
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
        for(String cat : user.getAllCategorias())
            CategoriaSeletor.addItem(cat);
        filtrarPorCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cria a lista de Conteudo
                ListaConteudoModel = new DefaultListModel();
                ConteudoList.setModel(ListaConteudoModel);
                if(CategoriaSeletor.getSelectedItem().equals("Sem Filtro")) {
                    for (Conteudo c : user.getAllConteudo())
                        ListaConteudoModel.addElement(c.getTitulo());
                }else{
                    for (Conteudo c : user.getAllConteudo())
                        if(c.getGenero().equals(CategoriaSeletor.getSelectedItem()))
                            ListaConteudoModel.addElement(c.getTitulo());
                }
            }
        });
    }



    //Image image=GenerateImage.toImage(true);  //this generates an image file
    //ImageIcon icon = new ImageIcon(image);
    //JLabel thumb = new JLabel();
    //thumb.setIcon(icon);
}
