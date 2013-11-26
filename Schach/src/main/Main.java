package main;
import game.CurrentBoard;
import board.Chessboard;
import board.Square;
import pieces.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

CurrentBoard s = new CurrentBoard();		
		
		
		Bishop a = new Bishop(s, "White", s.Squares[8][8]);
//		System.out.println(a.toString());
//		a.Move(s.Squares[1][1]);
//		System.out.println(a.toString());
//		a.Move(s.Squares[1][3]);
//		System.out.println(a.toString());
		
		Bishop b = new Bishop(s, "Black", s.Squares[5][5]);
//		System.out.println(b.toString());
//		b.Move(s.Squares[4][5]);
//		System.out.println(b.toString());
//		
		a.Move(s.Squares[1][1]);
		System.out.println(a.toString());
		a.Move(s.Squares[5][5]);
		System.out.println(a.toString());
	}

}
