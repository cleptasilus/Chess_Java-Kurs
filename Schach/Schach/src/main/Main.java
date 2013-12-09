package main;

import game.CurrentBoard;
import board.Chessboard;
import board.FullMove;
import board.Square;
import pieces.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CurrentBoard s = new CurrentBoard();
		FullMove move = new FullMove();
		move.move(s, s.Squares[1][7], s.Squares[1][5]);
//		move.move(s, s.Squares[7][7], s.Squares[7][5]);
//		move.move(s, s.Squares[4][1], s.Squares[7][4]);
//		move.move(s, s.Squares[5][2], s.Squares[5][3]);
//		move.move(s, s.Squares[5][3], s.Squares[5][2]);
//		move.move(s, s.Squares[6][1], s.Squares[3][4]);
//		move.move(s, s.Squares[5][3], s.Squares[5][4]);
//		move.move(s, s.Squares[5][4], s.Squares[5][5]);
//		move.move(s, s.Squares[5][5], s.Squares[5][6]);
//		move.move(s, s.Squares[5][6], s.Squares[6][7]);
//		

//		Bishop a = new Bishop(s, "White", s.Squares[8][8]);
//		System.out.println(a.toString());
//		a.Move(s.Squares[1][1]);
//		System.out.println(a.toString());
//		a.Move(s.Squares[1][3]);
//		System.out.println(a.toString());
//
//		Bishop b = new Bishop(s, "Black", s.Squares[5][5]);
//		System.out.println(b.toString());
//		b.Move(s.Squares[4][5]);
//		System.out.println(b.toString());
//
//		a.Move(s.Squares[1][1]);
//		System.out.println(a.toString());
//		a.Move(s.Squares[5][5]);
//		System.out.println(a.toString());
//		System.out.println(b.toString());
//		Bishop c = new Bishop(s, "Black", s.Squares[1][8]);
//		a.Move(s.Squares[6][6]);
//		Rook f = new Rook(s, "White", s.Squares[6][6]);
//		Rook d = new Rook(s, "White", s.Squares[1][6]);
//		Rook e = new Rook(s, "Black", s.Squares[1][1]);
//		System.out.println(c.toString());
//		System.out.println(d.toString());
//		d.Move(s.Squares[8][8]);
//		System.out.println(d.toString());
//		d.Move(s.Squares[6][6]);
//		System.out.println(d.toString());
//		d.Move(s.Squares[1][8]);
//		System.out.println(c.toString());
//		System.out.println(d.toString());
//		System.out.println(e.toString());
//		d.Move(s.Squares[1][1]);
//		System.out.println(d.toString());
//		System.out.println(e.toString());
	}

}
