package apresentacao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {
	private JButton leguas, milhasM, milhas, km, jardas, pes, polegadas, mili;
	private JTextField entrada;
	private JLabel saida;
	private JPanel painel;
	
	public TelaPrincipal() {
		
		Container c = getContentPane();
		
		painel = new JPanel();
	    painel.setLayout(new GridLayout(4,1));
	    
	    entrada = new JTextField();
	    painel.add(entrada);
	    
	    leguas = new JButton();
	    leguas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resultado = String.valueOf(Float.parseFloat(entrada.getText())/6600);
				saida.setText(resultado);
			}
		});
	    painel.add(leguas);
	    
	    milhas = new JButton();
//	    milhas.addActionListener(new TrataBotaoMilhas());
	    painel.add(milhas);
	    
	    painel.add(saida);
	    
	    c.add(painel, BorderLayout.CENTER);
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(200, 100);
	    pack();
	    setVisible(true);
	}

/*	private class TrataBotaoMilhas implements ActionListener {

	
		public void actionPerformed(ActionEvent e) {
			String resultado = String.valueOf(Float.parseFloat(entrada.getText())/1852);
			saida.setText(resultado);
			
		}
		
	} */
}
