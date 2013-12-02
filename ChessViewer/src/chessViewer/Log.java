package chessViewer;
import java.awt.Color;

import javax.swing.*;

public class Log extends JPanel
{
	private static final long serialVersionUID = 3748949301973470168L;

	Log()
	{
		this.setBackground(Color.CYAN);
		JLabel zL = new JLabel("Log");
		zL.setForeground(Color.MAGENTA);
		this.add(zL);
		this.setVisible(true);
	}
}
