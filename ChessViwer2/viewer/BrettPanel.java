package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;

import board.FullMove;
import pieces.Piece;

public class BrettPanel extends JPanel
{
	Common c;
	int clickedStartX;
	int clickedStartY;
	int clickedTargetX;
	int clickedTargetY;
	boolean isClickedLegal;
	FullMove mover = new FullMove();
	private static final long serialVersionUID = 6360449232579736831L;
	
	private MouseListener listener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e)
		{
			
			if(c.isMatt)
			{
				c.gameMessages += "Spiel beendet Matt gesetzt!\n";
				if(c.isWeissGewinner)
				{
					c.gameMessages += "Weiß hat gewonnen!\n";
				}
				else
				{
					c.gameMessages += "Schwarz hat gewonnen!\n";
				}
			return;
			}
			if(c.isSpielPausiert)
			{
				c.gameMessages += "Spiel ist pausiert kein Zug möglich!\n";
				return;
			}
			if(c.isRemis)
			{
				c.gameMessages += "Remis!\n";
			}
			if(c.isFigurAusgewaehlt && c.isRunning && isClickedLegal)
			{
				//Ziel Kooridnaten bestimmen
				clickedTargetX =  e.getX();
				clickedTargetY = e.getY();
				if(clickedTargetX > Size.brettWidth || clickedTargetY > Size.brettHigh)
				{
					System.err.println("Ausserhalb des Bereichs geklickt!");
					c.isFigurAusgewaehlt = false;
				}
				else
				{
					c.zielPosX = (clickedTargetX / (Size.brettHigh/8));
					c.zielPosY = (clickedTargetY /(Size.brettHigh/8));
					c.zielPosX++;
					c.zielPosY++;
					isClickedLegal = true;
				}
				//Figur setzen
				if(isClickedLegal && c.isFigurAusgewaehlt)
				{
					
					if(c.isWeisserZug && c.schach.Squares[c.startPosX][c.startPosY].getOccupiyingPiece().getColour() == "White" || c.isWeisserZug == false && c.schach.Squares[c.startPosX][c.startPosY].getOccupiyingPiece().getColour() == "Black")
					{
						//Desired Piece Abfrage einbauen
						c.isLegalMove = mover.move(c.schach, c.schach.Squares[c.startPosX][c.startPosY], c.schach.Squares[c.zielPosX][c.zielPosY], "Q");
						if(c.isLegalMove)
						{
							if(c.schach.isChecked == true)
							{
								c.isSchach = true;
								c.gameMessages += "Schach!\n";
							}
							else
							{
								c.isSchach = false;
							}
							if(c.schach.result == 1)
							{
								c.isMatt = true;
								c.isWeissGewinner = true;
								c.isRunning = false;
								c.gameMessages += "Matt Weiß gewinnt!\n";
							}
							if(c.schach.result == 2)
							{
								c.isMatt = true;
								c.isWeissGewinner = false;
								c.isRunning = false;
								c.gameMessages += "Matt Schwarz gewinnt!\n";
							}
							if(c.schach.result == 3)
							{
								c.isRemis = true;
								c.isRunning = false;
								c.gameMessages += "Remis!\n";
							}
							
							if(c.isWeisserZug)
							{
								c.isWeisserZug = false;
								c.log += c.rundeNummer + "    " +  c.schach.Squares[c.zielPosX][c.zielPosY].toString();
							}
							else
							{
								c.isWeisserZug = true;
								c.log += "    " + c.schach.Squares[c.zielPosX][c.zielPosY].toString() +"\n";
								c.rundeNummer++;
							}
							
						}
						else
						{
							c.gameMessages += "Falscher Zug!\n";
						}
					}
					else
					{
						if(c.isWeisserZug)
						{
							c.gameMessages += "Weißer Spieler darf nur weiße Figuren bewegen!\n";
						}
						else
						{
							c.gameMessages += "Schwarzer Spieler darf nur schwarze Figuren bewegen!\n";
						}
					}
					c.startPosX = 0;
					c.startPosY = 0;
					c.zielPosX = 0;
					c.zielPosY = 0;
					c.isFigurAusgewaehlt = false;
				}
			}
			else
			{
				//Start Koordinaten bestimmen
				clickedStartX = e.getX();
				clickedStartY = e.getY();
				if(clickedStartX > Size.brettWidth || clickedStartY > Size.brettHigh)
				{
					System.err.println("Ausserhalb des Bereichs geklickt!");
					isClickedLegal = c.isFigurAusgewaehlt = false;
				}
				
					
				else
				{
					c.startPosX = (clickedStartX / (Size.brettHigh/8));
					c.startPosY = (clickedStartY /(Size.brettHigh/8));
					c.startPosX++;
					c.startPosY++;
					if(!c.schach.Squares[c.startPosX][c.startPosY].isOccupied())
					{
						c.startPosX = 0;
						c.startPosY = 0;
						c.zielPosX = 0;
						c.zielPosY = 0;
						c.isFigurAusgewaehlt = false;
						return;
					}
					else
					{
						isClickedLegal = true;
						c.isFigurAusgewaehlt = true;
					}
				}
			}
		}
	};
	
	BrettPanel(Common c)
	{
		this.c = c;
		
		this.addMouseListener(listener);
		this.setPreferredSize(new Dimension(Size.brettWidth, Size.brettHigh));
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawImage(c.boardImage, 0, 0, Size.brettWidth, Size.brettHigh, null);
		
		for(Piece temp : c.schach.pieces)
		{	
			if(temp.getPosition().getPositionx() == -20 || temp.getPosition().getPositiony() == -20)
			{
				if(temp.getColour() == "White")
				{
					switch(temp.getName())
					{
					case "Q": c.weißeToteFiguren[0]++;
					break;
					case "R": c.weißeToteFiguren[1]++;
					break;
					case "N": c.weißeToteFiguren[2]++;
					break;
					case "":  c.weißeToteFiguren[3]++;
					break;
					case "B": c.weißeToteFiguren[4]++;
					break;
					}
				}
				else
				{
					switch(temp.getName())
					{
					case "Q": c.schwarzeToteFiguren[0]++;
					break;
					case "R": c.schwarzeToteFiguren[1]++;
					break;
					case "N": c.schwarzeToteFiguren[2]++;
					break;
					case "":  c.schwarzeToteFiguren[3]++;
					break;
					case "B": c.schwarzeToteFiguren[4]++;
					break;
					}
				}
				c.schach.pieces.remove(temp);
				break;
			}
			if(temp.getColour() == "White")
			{
				switch(temp.getName())
				{
				case "K": g.drawImage(c.wKing, (temp.getPosition().getPositionx()-1)*Size.brettHigh/8, (temp.getPosition().getPositiony()-1)*Size.brettHigh/8, Size.figureWidht, Size.figureHigh, null);
					break;
				case "Q": g.drawImage(c.wQueen, (temp.getPosition().getPositionx()-1)*Size.brettHigh/8, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "R": g.drawImage(c.wRook, (temp.getPosition().getPositionx()-1)*Size.brettHigh/8, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "N": g.drawImage(c.wKnight, (temp.getPosition().getPositionx()-1)*Size.brettHigh/8, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "": g.drawImage(c.wPawn, (temp.getPosition().getPositionx()-1)*Size.brettHigh/8, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "B": g.drawImage(c.wBishop, (temp.getPosition().getPositionx()-1)*Size.brettHigh/8, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				default: System.out.println("Debug: Fehler! Bei bestimmen der Figur");
					break;
				}
			}
			else
			{
				switch(temp.getName())
				{
				case "K": g.drawImage(c.bKing, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "Q":g.drawImage(c.bQueen, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "R":g.drawImage(c.bRook, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "N":g.drawImage(c.bKnight, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "":g.drawImage(c.bPawn, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
				break;
				case "B":g.drawImage(c.bBishop, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				default: System.out.println("Debug: Fehler! Bei bestimmen der Figur");
					break;
				}
			}
		}
		if(c.isFigurAusgewaehlt)
		{
			g.setColor(Color.RED);
			g.drawRect((c.startPosX-1)*Size.figureWidht, (c.startPosY-1)*Size.figureHigh, Size.figureWidht, Size.figureHigh);
		}
	}
	
}
