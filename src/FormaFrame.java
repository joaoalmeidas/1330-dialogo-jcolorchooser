import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormaFrame extends JFrame{
	
	private final static String[] formas = {"Circulo", "Retangulo", "Linha", "Arco"};
	
	private JComboBox<String> boxCores;
	private Color cor;
	private JButton botao;
	
	private JPanel panelBox;
	private FormaPanel panelForma;
	
	public FormaFrame() {
		
		boxCores = new JComboBox<String>(formas);
		boxCores.setMaximumRowCount(3);
		
		botao = new JButton("Cor");
		
		cor = Color.GRAY;
		
		panelBox = new JPanel(new FlowLayout());
		panelForma = new FormaPanel(boxCores.getItemAt(0), cor);
		
		panelBox.add(boxCores);
		panelBox.add(botao);
		
		add(panelBox, BorderLayout.NORTH);
		add(panelForma);
		
		boxCores.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				
				panelForma.setForma(arg0.getItem().toString());
				panelForma.setCor(cor);
				
				repaint();
			}
			
		});
		
		botao.addActionListener(
				
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						cor = JColorChooser.showDialog(FormaFrame.this, "Excolha uma cor", cor);
						
						if(cor == null) {
							
							cor = Color.LIGHT_GRAY;
							
						}
						
						panelForma.setCor(cor);
						
						repaint();
						
					}
					
					
				}
		);
		
	}
}
