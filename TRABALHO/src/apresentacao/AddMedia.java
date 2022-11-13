package apresentacao;

import dados.Episodio;
import dados.Filme;
import dados.Serie;
import dados.Usuario;
import negocio.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMedia extends TelaPrincipal{
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

    public AddMedia(Usuario u){
        setContentPane(AddMedia);
        setTitle("Adicionar Mídia");
        setSize(800,400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        FilmeErro.setVisible(false);
        FilmeSucesso.setVisible(false);
        SerieErro.setVisible(false);
        SerieSucesso.setVisible(false);
        EpErro.setVisible(false);
        EpSucesso.setVisible(false);
        adicionarFilmeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = FilmeTitulo.getText();
                String desc = FilmeDesc.getText();
                String gen = FilmeGen.getText();
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
                int numeroEp = Integer.valueOf(EpNumero.getText());
                String desc = EpDesc.getText();
                int dur = Integer.valueOf(EpDur.getText());
                Serie serieProcurada = new Serie("null","null","null",0,0);
                for(Serie serie : u.getSeries())
                    if(serie.getTitulo().equals(serie_nome))
                        serieProcurada = serie;
                Episodio ep = new Episodio();
                ep.setId(numeroEp);
                ep.setDescricao(desc);
                ep.setDuracao(dur);
                sist.cadastrarEpisodio(serieProcurada,ep);
                EpSucesso.setVisible(true);
            }
        });
    }
}
