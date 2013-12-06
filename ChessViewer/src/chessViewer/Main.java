package chessViewer;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) 
	{
		JFrame mf = new MainFrame();
		mf.setVisible(true);
		while(true)
		{
			mf.repaint();
		}
	}

}
