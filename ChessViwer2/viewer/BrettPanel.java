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
							if(c.isWeisserZug)
							{
								c.isWeisserZug = false;
								c.log += c.rundeNummer + "    " +  c.schach.Squares[c.zielPosX][c.zielPosY].toString();
							}
							else
							{
								c.isWeisserZug = true;
								c.log += "    " + c.schach.Squares[c.zielPosX][c.zielPosY].toString() +"\n";
							}
							c.rundeNummer++;
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
							c.gameMessages += "Weiﬂer Spieler darf nur weiﬂe Figuren bewegen!\n";
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
			if(temp.getPosition() == null || temp.getPosition() == null)
			{
				if(temp.getColour() == "White")
				{
					switch(temp.getName())
					{
					case "Q": c.weiﬂeToteFiguren[0]++;
					break;
					case "R": c.weiﬂeToteFiguren[1]++;
					break;
					case "N": c.weiﬂeToteFiguren[2]++;
					break;
					case "":  c.weiﬂeToteFiguren[3]++;
					break;
					case "B": c.weiﬂeToteFiguren[4]++;
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
				case "K": g.drawImage(c.wKing, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "Q": g.drawImage(c.wQueen, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "R": g.drawImage(c.wRook, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "N": g.drawImage(c.wKnight, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "": g.drawImage(c.wPawn, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "B": g.drawImage(c.wBishop, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
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
	}
	
}
