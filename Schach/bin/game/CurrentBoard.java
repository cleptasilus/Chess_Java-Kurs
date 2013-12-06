package game;

import java.util.ArrayList;
import java.util.List;

import pieces.*;
import board.Square;

public class CurrentBoard {
	public Square[][] Squares;
	public Square enPassanteSquare;
	public List<Piece> pieces = new ArrayList<Piece>();
	public Queen[] transformedQ= new Queen[16];
	public Knight[] transformedN= new Knight[16];
	public Rook[] transformedR= new Rook[16];
	public Bishop[] transformedB= new Bishop[16];
	public boolean isChecked=false;
	int transcount=1;
	public CurrentBoard() {
		Squares = new Square[9][9];
				
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				Squares[i][j] = new Square(i, j);
			}

		}
		PieceGenerator p = new PieceGenerator();
		pieces = p.GeneratePieces(this);
		
	}
	public void transform(String wantedpiece, Pawn p, Square s){
		p.setPosition(this.Squares[0][0]);
		switch(wantedpiece){
		case "Q":
			transformedQ[transcount]= new Queen(this, p.getColour(), s);
			break;
		case "R":
			transformedR[transcount]= new Rook(this, p.getColour(), s);
			break;
		case "B":
			transformedB[transcount]= new Bishop(this, p.getColour(), s);
			break;
		case "N":
			transformedN[transcount]= new Knight(this, p.getColour(), s);
			break;
		default:
			System.err.println("Error");
			transcount-=1;
			
		}
		transcount++;
	}
}
