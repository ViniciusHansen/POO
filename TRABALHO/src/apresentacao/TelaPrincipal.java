package apresentacao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dados.Conteudo;
import dados.Usuario;
import negocio.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        for(Conteudo c : user.getAllConteudo())
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
    }



    //Image image=GenerateImage.toImage(true);  //this generates an image file
    //ImageIcon icon = new ImageIcon(image);
    //JLabel thumb = new JLabel();
    //thumb.setIcon(icon);
}
