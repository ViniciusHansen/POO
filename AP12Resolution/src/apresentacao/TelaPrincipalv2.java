package apresentacao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipalv2 extends JFrame {
	private JButton leguas, milhasM, milhas, km, jardas, pes, polegadas, mili;
	private JTextField entrada;
	private JLabel saida;
	private JPanel painel;
	
	public TelaPrincipalv2() {
		Container c = getContentPane();

		painel = new JPanel();
		painel.setLayout(new GridLayout(4,1));

		
	    
	    entrada = new JTextField("Entrada");
	    painel.add(entrada);
	    
	    leguas = new JButton("Léguas");
	    leguas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = String.valueOf(Float.parseFloat(entrada.getText())/6600);
				saida.setText(resultado);
			}
		});
	    painel.add(leguas);

	    milhas = new JButton("Milhas");
	    milhas.addActionListener(new TrataBotaoMilhas());
	    painel.add(milhas);
	    
	    saida = new JLabel("Saída");
	    
	    painel.add(saida);
	
		c.add(painel,BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);
	}
	
	private class TrataBotaoMilhas implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			String resultado = String.valueOf(Float.parseFloat(entrada.getText())/1852);
			saida.setText(resultado);
			
		}	
	}

}
