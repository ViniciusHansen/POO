package apresentacao;

import dados.*;
import negocio.Sistema;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AddMedia extends JFrame{
    private JTextField FilmeTitulo;
    private JTextField FilmeDur;
    private JTextField FilmeAno;
    private JTextField FilmeDesc;
    private JTextField FilmeGen;
    private JButton adicionarFilmeButton;
    private JLabel FilmeSucesso;
    private JLabel FilmeErro;
    private JTextField SerieTitulo;
    private JTextField SerieDesc;
    private JTextField SerieGen;
    private JTextField SerieAno;
    private JTextField SerieTemporada;
    private JButton adicionarSérieButton;
    private JTextField EpNumero;
    private JTextField EpDesc;
    private JTextField EpDur;
    private JButton adicionarEpisódioButton;
    private JLabel SerieSucesso;
    private JLabel SerieErro;
    private JLabel EpSucesso;
    private JLabel EpErro;
    private JPanel AddMedia;
    private JTextField EpSerie;
    private JButton voltarButton;
    private JButton FilmeCapa;
    private JButton SerieCapa;

    public AddMedia(Sistema sist, Usuario user){
        setContentPane(AddMedia);
        setTitle("Adicionar Mídia");
        setSize(800,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        FilmeErro.setVisible(false);
        FilmeSucesso.setVisible(false);
        SerieErro.setVisible(false);
        SerieSucesso.setVisible(false);
        EpErro.setVisible(false);
        EpSucesso.setVisible(false);

        FilmeCapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif");
                chooser.setFileFilter(filter);
                File arquivo = new File(".");//chooser.getSelectedFile();
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                    arquivo = chooser.getSelectedFile();
                }else{
                    return;
                }
                try {
                    byte[] capa = Files.readAllBytes(arquivo.toPath());
                    Filme procurado = null;
                    String titulo = FilmeTitulo.getText();
                    int count = 0;
                    for(Conteudo c : user.getAllConteudo()) {
                        if (c.getTitulo().equals(titulo)) {
                            procurado = (Filme) c;
                            count++;
                            break;
                        }
                    }
                    if(count == 0){
                        JOptionPane.showMessageDialog(null,"Adicione o Filme antes de adicionar a capa");
                    }
                    if(procurado != null)
                        procurado.setCapa(capa);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        SerieCapa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif");
                chooser.setFileFilter(filter);
                File arquivo = new File(".");//chooser.getSelectedFile();
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                    arquivo = chooser.getSelectedFile();
                }else{
                    return;
                }
                try {
                    byte[] capa = Files.readAllBytes(arquivo.toPath());
                    Serie procurado = null;
                    String titulo = SerieTitulo.getText();
                    int count = 0;
                    for(Conteudo c : user.getAllConteudo()) {
                        if (c.getTitulo().equals(titulo)) {
                            procurado = (Serie) c;
                            count++;
                            break;
                        }
                    }
                    if(count == 0){
                        JOptionPane.showMessageDialog(null,"Adicione a Serie antes de adicionar a capa");
                    }
                    if(procurado != null)
                        procurado.setCapa(capa);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        adicionarFilmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = FilmeTitulo.getText();
                String desc = FilmeDesc.getText();
                String gen = FilmeGen.getText();
                if(titulo.length() == 0 || desc.length() == 0 || gen.length() ==0){
                   FilmeErro.setVisible(true);
                   return;
                }
                int ano = Integer.valueOf(FilmeAno.getText());
                int dur = Integer.valueOf(FilmeDur.getText());
                Filme f = new Filme(titulo,gen,desc,ano,dur);
                sist.cadastrarFilme(user,f);
                FilmeSucesso.setVisible(true);
            }
        });
        adicionarSérieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = SerieTitulo.getText();
                String desc = SerieDesc.getText();
                String gen = SerieGen.getText();
                if(titulo.length() == 0 || desc.length() == 0 || gen.length() ==0){
                    SerieErro.setVisible(true);
                    return;
                }
                int ano = Integer.valueOf(SerieAno.getText());
                int tempo = Integer.valueOf(SerieTemporada.getText());
                Serie s = new Serie(titulo,gen,desc,ano,tempo);
                sist.cadastrarSerie(user,s);
                SerieSucesso.setVisible(true);
            }
        });
        adicionarEpisódioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serie_nome = EpSerie.getText();
                String desc = EpDesc.getText();
                if(serie_nome.length() == 0 || desc.length() == 0 ){
                    EpErro.setVisible(true);
                    return;
                }
                int numeroEp = Integer.valueOf(EpNumero.getText());
                int dur = Integer.valueOf(EpDur.getText());
                Serie serieProcurada = new Serie("null","null","null",0,0);
                for(Conteudo serie : user.getSeries())
                    if(serie.getTitulo().equals(serie_nome))
                        serieProcurada = (Serie) serie;
                Episodio ep = new Episodio();
                ep.setId(numeroEp);
                ep.setDescricao(desc);
                ep.setDuracao(dur);
                sist.cadastrarEpisodio(serieProcurada,ep);
                EpSucesso.setVisible(true);
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal nova_main = new TelaPrincipal(sist, user);
                dispose();
            }
        });
    }
}
