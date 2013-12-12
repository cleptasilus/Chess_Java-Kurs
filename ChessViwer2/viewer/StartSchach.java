package viewer;

public class StartSchach {

	public static void main(String[] args) 
	{
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

			if(mf.c.log.length() > oldLength1 || mf.c.gameMessages.length() > oldLength2)
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
