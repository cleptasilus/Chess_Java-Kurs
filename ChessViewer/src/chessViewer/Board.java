package chessViewer;
import game.CurrentBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.*;
import javax.swing.*;

import pieces.Piece;

public class Board extends JPanel
{
	private static final long serialVersionUID = 265926406113133734L;
	ImageHandler images;
	CurrentBoard schnittstelle;
	

	public Board()
	{
		images = new ImageHandler();
		schnittstelle = new CurrentBoard();
		this.setBackground(Color.WHITE);	
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
			if(temp.getColour() == "White")
			{
				switch(temp.getName())
				{
				case "K": g.drawImage(images.wKing, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
							System.err.println("König malen");
					break;
				case "Q": g.drawImage(images.wQueen, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "R": g.drawImage(images.wRook, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "N": g.drawImage(images.wKnight, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "P": g.drawImage(images.wPawn, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "B": g.drawImage(images.wBishop, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				default: System.out.println("Debug: Fehler! Bei bestimmen der Figur");
					break;
				}
			}
			else
			{
				switch(temp.getName())
				{
				case "K": g.drawImage(images.bKing, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "Q":g.drawImage(images.bQueen, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "R":g.drawImage(images.bRook, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "N":g.drawImage(images.bKnight, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "P":g.drawImage(images.bPawn, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				case "B":g.drawImage(images.bBishop, temp.getPosition().getPositionx()*Size.figureWidht+Size.figureAbstand, temp.getPosition().getPositiony()*Size.figureHigh+Size.figureAbstand, Size.figureWidht, Size.figureHigh, null);
					break;
				default: System.out.println("Debug: Fehler! Bei bestimmen der Figur");
					break;
				}
			}
		}
	}
}
