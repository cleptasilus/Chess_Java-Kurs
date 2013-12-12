package viewer;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class InfoPanel extends JPanel
{
	private static final long serialVersionUID = -8417709456427347913L;
	Common c;
	
	InfoPanel(Common c)
	{
		this.c = c;
		
		this.setPreferredSize(new Dimension(Size.infoWidth, Size.infoHigh));
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paintComponents(g);
		
		int i = 0;
		g.drawImage(c.wQueen,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.weiﬂeToteFiguren[0]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.wRook,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.weiﬂeToteFiguren[1]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.wKnight,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.weiﬂeToteFiguren[2]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.wBishop,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.weiﬂeToteFiguren[4]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.wPawn,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.weiﬂeToteFiguren[3]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		i++;
		g.drawImage(c.bQueen,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.schwarzeToteFiguren[0]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.bRook,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.schwarzeToteFiguren[1]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.bKnight,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.schwarzeToteFiguren[2]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.bBishop,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.schwarzeToteFiguren[4]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		g.drawImage(c.bPawn,0, i*Size.toteFigur,Size.toteFigur, Size.toteFigur, null);
		g.drawString(Integer.toString(c.schwarzeToteFiguren[3]), Size.toteFigur, i*Size.toteFigur+(Size.toteFigur/2));
		i++;
		i++;
		g.drawString(c.isRunning ?"Spiel l‰uft" : "Spiel beendet", 0, i*Size.toteFigur);
		i++;
		g.drawString(c.isMatt ?"Matt gesetzt" : "Kein Matt gesetzt", 0, i*Size.toteFigur);
		i++;
		g.drawString(c.isRemis ?"Remis" : "Kein Remis", 0, i*Size.toteFigur);
		i++;
		g.drawString(c.isSchach ?"Schach gesetzt" : "Kein Schach", 0, i*Size.toteFigur);
		i++;
		g.drawString(c.isSpielPausiert ? "Spiel ist pausiert" : "Spiel ist nicht pausiert", 0, i*Size.toteFigur);
		i++;
		i++;
		g.drawString(c.isWeisserZug ? "Weiﬂ ist am Zug" : "Schwarz ist am Zug", 0, i*Size.toteFigur);
		i++;
		g.drawString(c.isFigurAusgewaehlt ? "Figur zum Zug selektiert" : "Keine Figur selektiert", 0, i*Size.toteFigur);
		i++;
		if(c.isFigurAusgewaehlt)
		{
			g.drawString(c.schach.Squares[c.startPosX][c.startPosY].toString(), 0, i*Size.toteFigur);
			i++;
		}
		else
		{
			i++;
		}
		g.drawString(c.isLegalMove ? "Letzter Zug war legal" : "Letzter Zug war nicht legal", 0, i*Size.toteFigur);
		i++;
	}
}
