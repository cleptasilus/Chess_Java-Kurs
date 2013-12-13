package viewer;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenueBar extends JMenuBar
{
	private static final long serialVersionUID = -3587357033078223782L;
	Common c;
	JMenu spiel;
	JMenuItem pausieren;
	JMenuItem fortsetzten;
	JMenuItem reset;
	
	MenueBar(final Common c)
	{
		this.c = c;
		spiel = new JMenu("Spiel");
		pausieren = new JMenuItem("Spiel pausieren");
		fortsetzten = new JMenuItem("Spiel fortsetzten");
		reset = new JMenuItem("Spiel zurücksetzten");
		pausieren.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.isSpielPausiert = true;
				c.gameMessages += "Spiel pausiert!\n";
				
			}
		});
		fortsetzten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.isSpielPausiert = false;
				c.gameMessages += "Spiel fortgesetzt!\n";
				
			}
		});
		
		reset.addActionListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.reset();				
			}
		});
		spiel.add(fortsetzten);
		spiel.add(pausieren);
		spiel.add(reset);
		this.add(spiel);
		this.setVisible(true);
	}
	@Override 
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		if(c.isSpielPausiert)
		{
			pausieren.setEnabled(false);
			fortsetzten.setEnabled(true);
		}
		else
		{
			pausieren.setEnabled(true);
			fortsetzten.setEnabled(false);
		}
	}
}
