package chessViewer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 5551667245487051244L;
	private JPanel mainCon;
	Board brett;
	private Board brett_1;
	ManuellesSetzen schieber;

	public MainFrame()
	{
		mainCon = new JPanel();
		brett = new Board();
		//Bis jetzt einfach schlieﬂen
		//Sp‰ter sollte dann eine Funktion das Spiel beenden
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		mainCon.setLayout(new java.awt.BorderLayout());
		//mainCon.add(new Zeit(),java.awt.BorderLayout.EAST);
		//mainCon.add(new Log(), java.awt.BorderLayout.SOUTH);
		//mainCon.add(new DeathYard(), java.awt.BorderLayout.WEST);
		mainCon.add(new MenueBar(), java.awt.BorderLayout.NORTH);
		brett_1 = new Board();
		mainCon.add(brett_1, java.awt.BorderLayout.CENTER);
		//schieber = new ManuellesSetzen(brett_1.schnittstelle.pieces);
		//mainCon.add(schieber, java.awt.BorderLayout.SOUTH);
		//schieber.schnittstelle = brett_1.schnittstelle;
		//schieber.callingBrett = brett_1;
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(750, 300, 50, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		brett_1.add(btnNewButton);
		this.getContentPane().add(mainCon);
		this.setSize(Size.windowWidth, Size.windowHigh);
		this.setResizable(true);
		//pack();
	}
}
