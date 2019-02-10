import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;

import javax.swing.JPanel;

public class FormaPanel extends JPanel {
	
	private String forma;
	
	private final static Color[] cores = {Color.BLACK, Color.BLUE, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	private final SecureRandom aleatorio = new SecureRandom();
	
	public FormaPanel(String forma) {
		
		this.forma = forma;
		
	}
	
	public void paintComponent(Graphics g) {
		
		for(int i = 0; i < 20; i++) {
		
		g.setColor(cores[aleatorio.nextInt(cores.length)]);	
			
		int x = aleatorio.nextInt(getWidth());
		int y = aleatorio.nextInt(getHeight());
		int largura = aleatorio.nextInt(getWidth() - x);
		int altura = aleatorio.nextInt(getHeight() - y);
	
			if(forma.equals("Circulo")) {
				
				g.fillOval(x, y, largura, altura);
				
			}else if(forma.equals("Retangulo")) {
				
				g.fillRect(x, y, largura, altura);
				
			}else if(forma.equals("Linha")) {
				
				g.drawLine(x, y, altura, largura);
				
			}else if(forma.equals("Arco")) {
				
				g.fillArc(x, y, largura, altura, aleatorio.nextInt(360), aleatorio.nextInt(360));
			
			}
			
		}
		

		
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	
	
	
}
