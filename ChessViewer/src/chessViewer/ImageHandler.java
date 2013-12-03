package chessViewer;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageHandler 
{
	BufferedImage boardImage;
	
	BufferedImage wPawn;
	BufferedImage wRook;
	BufferedImage wKnight;
	BufferedImage wBishop;
	BufferedImage wQueen;
	BufferedImage wKing;
	
	BufferedImage bPawn;
	BufferedImage bRook;
	BufferedImage bKnight;
	BufferedImage bBishop;
	BufferedImage bQueen;
	BufferedImage bKing;
	
	ImageHandler()
	{
		getImages();
	}
	
	void getImages()
	{
		try
		{
		boardImage = ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Board/board.jpg"));
		
		wPawn= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/white/pawn.png"));
		wRook= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/white/rook.png"));
		wKnight= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/white/knight.png"));
		wBishop= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/white/bishop.png"));
		wQueen= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/white/queen.png"));
		wKing= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/white/king.png"));
		
		bPawn= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/black/pawn.png"));
		bRook= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/black/rook.png"));
		bKnight= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/black/knight.png"));
		bBishop= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/black/bishop.png"));
		bQueen= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/black/queen.png"));
		bKing= ImageIO.read(new File("C:/Users/jsn/Documents/GitHub/Chess_Java-Kurs/ChessImages/Figures/black/king.png"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
}
