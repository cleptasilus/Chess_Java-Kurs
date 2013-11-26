package game;


import board.Square;
import pieces.*;

public class CurrentBoard {
public Square[][] Squares ;

public CurrentBoard(){
	 Squares =new Square[9][9];
	for(int i = 1; i<=8; i++){
		for(int j=1;j<=8;j++){
			Squares[i][j] = new Square(i, j);
			}
		
		}
}


}
