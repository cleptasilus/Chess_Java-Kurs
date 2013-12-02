package chessViewer;
import java.awt.Color;

import javax.swing.*;
public class Zeit extends JPanel
{
	private static final long serialVersionUID = -183408787168898254L;

	public Zeit()
	{
		this.setBackground(Color.BLACK);
		JLabel zL = new JLabel("Zeit");
		zL.setForeground(Color.WHITE);
		this.add(zL);
		this.setVisible(true);
	}
}
