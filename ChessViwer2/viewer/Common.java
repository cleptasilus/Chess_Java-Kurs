package viewer;

import game.CurrentBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.Timer;
/*
 * Diese Klasse enth�lt alle Variablen und Zust�nde, die f�r alle Klassen, des Viewers relevant sind.
 */
public class Common 
{
	//Spiel Zust�nde:
	boolean isRunning;
	boolean isSchach;
	boolean isMatt;
	boolean isRemis;
	boolean isWeisserZug;
	boolean isFigurAusgewaehlt;	//Wenn f�r eine Figur f�r's Ziehen ausgew�hlt wurde
	boolean isLegalMove;		//Ist true gesetzt, wenn der letzte versuchte Zug durchgef�hrt wurde
	boolean isSpielPausiert;
	
	//Spieler Werte:
	String nameWeisserSpieler;
	String nameSchwarzerSpieler;
	boolean isWeissGewinner; 		//Wird true gesetzt, wenn das Wei� das Spiel gewonnen hat
	
	//Zug Werte
	int startPosX;
	int startPosY;
	int zielPosX;
	int zielPosY;
	
	//Spiel Werte:
	int rundeNummer;
	int zeitWeiss;				//Verbleibende Spielzeit in Sekunden
	int zeitSchwarz;
	Timer schwarzerCountdown;
	Timer weisserCountdown;
	String log;					//Ausgabe auf dem Log-Feld, (Spiel Notation)
	String gameMessages;		//Ausgabe auf dem Meldungen-Feld
	
	//Graveyard
	int wei�eToteFiguren[];
	int schwarzeToteFiguren[];
	
	//Bilder
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
	
	//Schnittstelle zur Schach Logik
	CurrentBoard schach;
	
	Common()
	{
		isRunning = true;
		isSchach = false;
		isMatt = false;
		isRemis = false;
		isWeisserZug = true;
		isFigurAusgewaehlt = false;
		isLegalMove = false;
		isSpielPausiert = false;	
		
		nameWeisserSpieler = "Wei�er Spieler";
		nameSchwarzerSpieler = "Schwarzer Spieler";
		isWeissGewinner = false;
		
		rundeNummer = 1;
		zeitWeiss = 3600;
		zeitSchwarz = 3600;
		log = "";
		gameMessages = "";
		
		wei�eToteFiguren = new int[5];
		schwarzeToteFiguren =  new int[5];
		
		schach = new CurrentBoard();
		
		//Timer starten
		schwarzerCountdown = new Timer(1000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(isRunning == false)
					{
						return;
					}
					if(isSpielPausiert == false && isWeisserZug == false && zeitSchwarz > 0 && isRunning)
					{
						zeitSchwarz--;
					}
					else
					{
						if(zeitSchwarz <= 0)
						{
							isSpielPausiert = true;
							isRunning = false;
							isWeissGewinner = true;
							gameMessages += "Schwarze Zeit abgelaufen, Wei� gewinnt!\n";
						}
					}
				}
			}	
		);
		weisserCountdown = new Timer(1000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(isRunning == false)
					{
						return;
					}
					if(isSpielPausiert == false && isWeisserZug == true && zeitWeiss > 0 && isRunning)
					{
						zeitWeiss--;
					}
					else
					{
						if(zeitWeiss <= 0)
						{
							isSpielPausiert = true;
							isRunning = false;
							isWeissGewinner = false;
							gameMessages += "Wei� Zeit abgelaufen, Schwarz gewinnt!\n";
						}
					}
				}
			}
		);
		getImages();
		schwarzerCountdown.start();
		weisserCountdown.start();
	}
	
	void getImages() {
		try {
			boardImage = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Board/board.jpg"));
			wPawn = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/white/pawn.png"));
			wRook = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/white/rook.png"));
			wKnight = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/white/knight.png"));
			wBishop = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/white/bishop.png"));
			wQueen = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/white/queen.png"));
			wKing = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/white/king.png"));

			bPawn = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/black/pawn.png"));
			bRook = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/black/rook.png"));
			bKnight = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/black/knight.png"));
			bBishop = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/black/bishop.png"));
			bQueen = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/black/queen.png"));
			bKing = ImageIO.read(new File(
					"../Chess_Java-Kurs/ChessImages/Figures/black/king.png"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	void reset()
	{
		isRunning = true;
		isSchach = false;
		isMatt = false;
		isRemis = false;
		isWeisserZug = true;
		isFigurAusgewaehlt = false;
		isLegalMove = false;
		isSpielPausiert = false;	
		
		nameWeisserSpieler = "Wei�er Spieler";
		nameSchwarzerSpieler = "Schwarzer Spieler";
		isWeissGewinner = false;
		
		rundeNummer = 1;
		zeitWeiss = 3600;
		zeitSchwarz = 3600;
		log = "";
		gameMessages = "";
		
		wei�eToteFiguren = new int[5];
		schwarzeToteFiguren =  new int[5];
		
		schach = new CurrentBoard();
	}
}
