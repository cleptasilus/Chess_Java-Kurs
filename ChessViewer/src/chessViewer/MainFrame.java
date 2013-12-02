package chessViewer;

import javax.swing.*;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 5551667245487051244L;
	private JPanel mainCon;
	
	public MainFrame()
	{
		mainCon = new JPanel();
		//Bis jetzt einfach schlieﬂen
		//Sp‰ter sollte dann eine Funktion das Spiel beenden
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainCon.setLayout(new java.awt.BorderLayout());
		mainCon.add(new Zeit(),java.awt.BorderLayout.EAST);
		mainCon.add(new Log(), java.awt.BorderLayout.SOUTH);
		mainCon.add(new DeathYard(), java.awt.BorderLayout.WEST);
		mainCon.add(new MenueBar(), java.awt.BorderLayout.NORTH);
		mainCon.add(new Board(), java.awt.BorderLayout.CENTER);
		this.getContentPane().add(mainCon);
		this.setSize(Size.windowWidth, Size.windowHigh);
		this.setResizable(true);
		//pack();
	}
}
