package chessViewer;
import java.awt.Color;

import javax.swing.*;

public class DeathYard extends JPanel
{
	private static final long serialVersionUID = -5872424093264433550L;

	DeathYard()
	{
		this.setBackground(Color.PINK);
		JLabel zL = new JLabel("Figuren\nFriedhof");
		zL.setForeground(Color.WHITE);
		this.add(zL);
		this.setVisible(true);		
	}
}
