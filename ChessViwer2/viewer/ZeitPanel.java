package viewer;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ZeitPanel extends JPanel
{
	private static final long serialVersionUID = -1947826170751268624L;
	Common c;
	ZeitPanel(Common c)
	{
		this.c = c;
		
		this.setPreferredSize(new Dimension(Size.zeitWidth, Size.zeitHigh));
		this.setVisible(true);
	}
	@Override
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		int i = 0;
		int stunden = c.zeitWeiss / 3600;
		int minuten = (c.zeitWeiss - (stunden *3600)) /60;
		int sekunden = c.zeitWeiss % 60;
		
		g.drawString("Weiﬂe Zeit", 0, i*Size.step);
		i++;
		g.drawString("Stunden" + stunden, 0, i*Size.step);
		i++;
		g.drawString("Minuten" + minuten, 0, i*Size.step);
		i++;
		g.drawString("Sekunden" + sekunden, 0, i*Size.step);
		i++;
		i++;
		stunden = c.zeitSchwarz / 3600;
		minuten = (c.zeitSchwarz - (stunden *3600)) /60;
		sekunden = c.zeitSchwarz % 60;
		g.drawString("Schwarze Zeit", 0, i*Size.step);
		i++;
		g.drawString("Stunden" + stunden, 0, i*Size.step);
		i++;
		g.drawString("Minuten" + minuten, 0, i*Size.step);
		i++;
		g.drawString("Sekunden" + sekunden, 0, i*Size.step);
	}
}
