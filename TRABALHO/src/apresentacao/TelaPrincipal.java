package apresentacao;

import javax.swing.*;

import dados.Conteudo;
import dados.Usuario;
import negocio.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaPrincipal extends JFrame{
    protected Sistema sist = new Sistema();
    protected Usuario user = new Usuario();
    private JPanel telaPrincipal;
    private JButton addMediaButton;
    private JScrollPane ConteudoScrollPane;
    private JList ConteudoList;
    private JButton debugButton;
    private DefaultListModel ListaConteudoModel;

    public void setUser(Usuario user) {
        this.user = user;
    }

    public TelaPrincipal(){}
    public TelaPrincipal(Sistema s, Usuario user_login){
        setContentPane(telaPrincipal);
        setTitle("_____Flix");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        user = user_login;
        sist = s;

        //cria a lista de Conteudo
        ListaConteudoModel = new DefaultListModel();
        ConteudoList.setModel(ListaConteudoModel);
        for(Conteudo c : user.getAllConteudo())
            ListaConteudoModel.addElement(c.getTitulo());

        addMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMedia telaAddMedia = new AddMedia(sist, user);
                dispose();
            }
        });
        debugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Lista de conteudos");
                System.out.println(user.getAllConteudo());
            }
        });
    }



    //Image image=GenerateImage.toImage(true);  //this generates an image file
    //ImageIcon icon = new ImageIcon(image);
    //JLabel thumb = new JLabel();
    //thumb.setIcon(icon);
}
