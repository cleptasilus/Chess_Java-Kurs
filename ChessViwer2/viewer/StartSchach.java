package viewer;

import javax.swing.JDialog;
import javax.swing.JProgressBar;

public class StartSchach {

	public static void main(String[] args) 
	{
		JDialog start = new JDialog();
		start.setSize(200,50);
		JProgressBar laden = new JProgressBar();
		start.add(laden);
		start.setVisible(true);
		for(int i = 0; i < 100; i++)
		{
			i++;
			laden.setValue(i);
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{}
		}
		start.setVisible(false);
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		new StartSchach().startPainting(mf);
	}
	
	void startPainting(MainFrame mf)
	{
		int oldLength1 = 0;
		int oldLength2 = 0;
		while(true)
		{

			if(mf.c.log.length() > oldLength1 || mf.c.gameMessages.length() > oldLength2 || mf.c.log.length() < oldLength1 || mf.c.gameMessages.length() < oldLength2)
			{
				mf.lp.refreshLog();
				oldLength1 = mf.c.log.length();
				oldLength2 = mf.c.gameMessages.length();
			}
			mf.repaint();
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{}
		}
	}
}
