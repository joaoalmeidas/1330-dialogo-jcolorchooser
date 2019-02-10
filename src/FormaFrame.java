import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormaFrame extends JFrame{
	
	private final static String[] formas = {"Circulo", "Retangulo", "Linha", "Arco"};
	
	private JComboBox<String> boxCores;
	private JColorChooser cores;
	private Color cor;
	
	private JPanel panelBox;
	private FormaPanel panelForma;
	
	public FormaFrame() {
		
		boxCores = new JComboBox<String>(formas);
		boxCores.setMaximumRowCount(3);
		
		cores = new JColorChooser();
		cor = cores.getColor();
		
		panelBox = new JPanel(new FlowLayout());
		panelForma = new FormaPanel(boxCores.getItemAt(0), cor);
		
		panelBox.add(boxCores);
		panelBox.add(cores);
		
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
		
	}
}
