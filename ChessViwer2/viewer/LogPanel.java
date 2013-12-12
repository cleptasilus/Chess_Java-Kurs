package viewer;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LogPanel extends JPanel
{
	private static final long serialVersionUID = 3114052853107174578L;
	Common c;
	JTextArea spielLog;
	JTextArea spielNachrichten;
	
	LogPanel(Common c)
	{
		this.c = c;
		spielLog = new JTextArea();
		spielNachrichten = new JTextArea();
		spielLog.setEnabled(false);
		spielNachrichten.setEnabled(false);
		spielLog.setPreferredSize(new Dimension((int)(Size.logWidth* 0.3), Size.logHigh));
		spielNachrichten.setPreferredSize(new Dimension((int)(Size.logWidth* 0.6), Size.logHigh));
		spielLog.setLocation((int)(Size.logWidth* 0.4), 0);
		spielNachrichten.setLocation(0, 0);
		this.add(spielLog);
		this.add(spielNachrichten);
		this.setPreferredSize(new Dimension(Size.logWidth, Size.logHigh));
		this.setVisible(true);
	}
	void refreshLog()
	{
		spielLog.setText(c.log);
		spielNachrichten.setText(c.gameMessages);
	}

}
