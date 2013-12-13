package viewer;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogPanel extends JPanel
{
	private static final long serialVersionUID = 3114052853107174578L;
	Common c;
	JTextArea spielLog;
	JTextArea spielNachrichten;
	JScrollPane spielLogCon;
	JScrollPane spielNachrichtenCon;
	
	LogPanel(Common c)
	{
		this.c = c;
		spielLog = new JTextArea();
		spielNachrichten = new JTextArea();
		spielLogCon = new JScrollPane();
		spielNachrichtenCon = new JScrollPane();
		spielLog.setEnabled(false);
		spielNachrichten.setEnabled(false);
		spielLog.setPreferredSize(new Dimension((int)(Size.logWidth* 0.3), Size.logHigh-5));
		spielNachrichten.setPreferredSize(new Dimension((int)(Size.logWidth* 0.6), Size.logHigh-5));
		spielLog.setLocation((int)(Size.logWidth* 0.4), 0);
		spielNachrichten.setLocation(0, 0);
		
		//spielLogCon.setPreferredSize(new Dimension((int)(Size.logWidth* 0.3), Size.logHigh-5));
		//spielLogCon.setLocation((int)(Size.logWidth* 0.4), 0);
		//spielNachrichtenCon.setPreferredSize(new Dimension((int)(Size.logWidth* 0.6), Size.logHigh-5));
		//spielNachrichtenCon.setLocation(0, 0);


		//spielLogCon.add(spielLog);
		//spielNachrichtenCon.add(spielNachrichten);
		
		this.add(spielLog);
		this.add(spielNachrichten);
		this.setPreferredSize(new Dimension(Size.logWidth, Size.logHigh));
		this.setVisible(true);
	}
	void refreshLog()
	{
		spielLog.setText(c.log);
		spielNachrichten.setText(c.gameMessages);
		//spielLogCon.repaint();
		//spielNachrichtenCon.repaint();
	}

}
