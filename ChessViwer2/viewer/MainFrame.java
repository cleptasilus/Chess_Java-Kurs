package viewer;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1976436575714174983L;
	Common c;
	BrettPanel bp;
	InfoPanel ip;
	ZeitPanel zp;
	LogPanel lp;
	
	public MainFrame()
	{
		c = new Common();
		bp = new BrettPanel(c);
		ip = new InfoPanel(c);
		zp = new ZeitPanel(c);
		lp = new LogPanel(c);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new java.awt.BorderLayout());
		
		this.add(bp, java.awt.BorderLayout.CENTER);
		this.add(ip, java.awt.BorderLayout.WEST);
		this.add(zp, java.awt.BorderLayout.EAST);
		this.add(lp, java.awt.BorderLayout.SOUTH);
		
		this.setSize(Size.windowWidth, Size.windowHigh);
	}
}
