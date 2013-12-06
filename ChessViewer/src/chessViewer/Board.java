package chessViewer;
import game.CurrentBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

import board.FullMove;
import pieces.Piece;


public class Board extends JPanel
{
	
	private static final long serialVersionUID = 265926406113133734L;
	ImageHandler images;
	CurrentBoard schnittstelle;
	FullMove mover = new FullMove();
	private boolean isStartClicked = false;
	private boolean isClickedLegal = false;
	int clickedStartX;
	int clickedStartY;
	int posStartY;
	int posStartX;
	int clickedTargetX;
	int clickedTargetY;
	int posTargetX;
	int posTargetY;
	
	private MouseListener listener = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e)
		{
			if(isStartClicked && isClickedLegal)
			{
				//Ziel Kooridnaten bestimmen
				clickedTargetX =  e.getX();
				clickedTargetY = e.getY();
				if(clickedTargetX > Size.brettWidth || clickedTargetY > Size.brettHigh)
				{
					System.err.println("Ausserhalb des Bereichs geklickt!");
					isClickedLegal = isStartClicked = false;
				}
				else
				{
					posTargetX = (clickedTargetX / (Size.brettHigh/8));
					posTargetY = (clickedTargetY /(Size.brettHigh/8));
					posTargetX++;
					posTargetY++;
					isClickedLegal = true;
				}
				//Figur setzen
				if(isClickedLegal)
				{
					System.out.println("want to move");
					System.out.println("Move from: "+ posStartX +" "+ posStartY +" to "+ posTargetX + " "+ posTargetY);
					mover.move(schnittstelle, schnittstelle.Squares[posStartX][posStartY], schnittstelle.Squares[posTargetX][posTargetY]);
					isStartClicked = false;
					/*
					if (schnittstelle.Squares[posStartX][posStartY].isOccupied()) {
						System.out.println("want to move");
						temp = schnittstelle.Squares[posStartX][posStartY].getOccupiyingPiece();
						.Move(schnittstelle.Squares[posTargetX][posTargetY]);
						System.out.println("gemoved");
						System.out.println("tttteeesst");
						isStartClicked = false;
					} else {
						System.err.println("Keine Figur auf dem Feld!");
						isStartClicked = false;
					}
					*/
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
					isClickedLegal = isStartClicked = false;
				}
				else
				{
					posStartX = (clickedStartX / (Size.brettHigh/8));
					posStartY = (clickedStartY /(Size.brettHigh/8));
					posStartX++;
					posStartY++;
					isClickedLegal = true;
				}
				isStartClicked = true;
			}
		}
	};
	
	
	public Board()
	{
		images = new ImageHandler();
		schnittstelle = new CurrentBoard();
		this.setBackground(Color.WHITE);	
		this.addMouseListener(listener);
		this.setOpaque(true);
		this.setVisible(true);
		this.repaint();
	}
	

	
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawImage(images.boardImage, 0, 0, Size.brettWidth, Size.brettHigh, null);
		
		for(Piece temp : schnittstelle.pieces)
		{	
			if(temp.getPosition().getPositiony() == 0 || temp.getPosition().getPositionx() == 0)
			{
				System.out.println("test");
				//Graveyard;
				break;
			}
			if(temp.getColour() == "White")
			{
				switch(temp.getName())
				{
				case "K": g.drawImage(images.wKing, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "Q": g.drawImage(images.wQueen, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "R": g.drawImage(images.wRook, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "N": g.drawImage(images.wKnight, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "P": g.drawImage(images.wPawn, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "B": g.drawImage(images.wBishop, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				default: System.out.println("Debug: Fehler! Bei bestimmen der Figur");
					break;
				}
			}
			else
			{
				switch(temp.getName())
				{
				case "K": g.drawImage(images.bKing, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "Q":g.drawImage(images.bQueen, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "R":g.drawImage(images.bRook, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "N":g.drawImage(images.bKnight, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "P":g.drawImage(images.bPawn, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
				break;
				case "B":g.drawImage(images.bBishop, (temp.getPosition().getPositionx()-1)*Size.figureWidht+Size.figureAbstand, (temp.getPosition().getPositiony()-1)*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				default: System.out.println("Debug: Fehler! Bei bestimmen der Figur");
					break;
				}
			}
		}
	}
}
