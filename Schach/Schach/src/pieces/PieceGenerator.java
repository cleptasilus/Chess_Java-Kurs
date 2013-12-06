package pieces;

import game.CurrentBoard;
import java.util.List;
import java.util.ArrayList;
public class PieceGenerator {
public List<Piece> GeneratePieces(CurrentBoard board){
	List<Piece> dong = new ArrayList<Piece>();
	//WEISS
		Rook WAR = new Rook(board, "White" , board.Squares[1][1]);
		Knight WBN = new Knight (board, "White" , board.Squares[2][1]);
		Bishop WCB =new Bishop (board, "White" , board.Squares[3][1]);
		Queen WDQ = new Queen(board, "White" , board.Squares[4][1]);
		King WEK = new King(board, "White" , board.Squares[5][1]);
		Bishop WFB =new Bishop (board, "White" , board.Squares[6][1]);
		Knight WGN = new Knight (board, "White" , board.Squares[7][1]);
		Rook WHR = new Rook(board, "White" , board.Squares[8][1]);
		WHR.setName("P");
		Pawn WAP = new Pawn(board, "White" , board.Squares[1][2]);
		WAP.setName("P");
		Pawn WBP = new Pawn(board, "White" , board.Squares[2][2]);
		WBP.setName("P");
		Pawn WCP = new Pawn(board, "White" , board.Squares[3][2]);
		WCP.setName("P");
		Pawn WDP = new Pawn(board, "White" , board.Squares[4][2]);
		WDP.setName("P");
		Pawn WEP = new Pawn(board, "White" , board.Squares[5][2]);
		WEP.setName("P");
		Pawn WFP = new Pawn(board, "White" , board.Squares[6][2]);
		WFP.setName("P");
		Pawn WGP = new Pawn(board, "White" , board.Squares[7][2]);
		WGP.setName("P");
		Pawn WHP = new Pawn(board, "White" , board.Squares[8][2]);
		WHP.setName("P");
		
	//SCHWARZ
		Rook BAR = new Rook(board, "Black" , board.Squares[1][8]);
		Knight BBN = new Knight (board, "Black" , board.Squares[2][8]);
		Bishop BCB =new Bishop (board, "Black" , board.Squares[3][8]);
		Queen BDQ = new Queen(board, "Black" , board.Squares[4][8]);
		King BEK = new King(board, "Black" , board.Squares[5][8]);
		Bishop BFB =new Bishop (board, "Black" , board.Squares[6][8]);
		Knight BGN = new Knight (board, "Black" , board.Squares[7][8]);
		Rook BHR = new Rook(board, "Black" , board.Squares[8][8]);
		BHR.setName("P");
		Pawn BAP = new Pawn(board, "Black" , board.Squares[1][7]);
		BAP.setName("P");
		Pawn BBP = new Pawn(board, "Black" , board.Squares[2][7]);
		BBP.setName("P");
		Pawn BCP = new Pawn(board, "Black" , board.Squares[3][7]);
		BCP.setName("P");
		Pawn BDP = new Pawn(board, "Black" , board.Squares[4][7]);
		BDP.setName("P");
		Pawn BEP = new Pawn(board, "Black" , board.Squares[5][7]);
		BEP.setName("P");
		Pawn BFP = new Pawn(board, "Black" , board.Squares[6][7]);
		BFP.setName("P");
		Pawn BGP = new Pawn(board, "Black" , board.Squares[7][7]);
		BGP.setName("P");
		Pawn BHP = new Pawn(board, "Black" , board.Squares[8][7]);
		BHP.setName("P");
					//	INDEX        FIGUR
		dong.add(WEK); //0			KÖNIG WEISS
		dong.add(BEK); //1			KÖNIG SCHWARZ
		
		dong.add(WDQ); //2			DAME WEISS
		dong.add(BDQ); //3			DAME SCHWARZ
		
		dong.add(WAR); //4			A-TURM WEISS
		dong.add(WHR); //5			H-TURM WEISS
		dong.add(BAR); //6			A-TURM SCHWARZ
		dong.add(BHR); //7			H-TURM SCHWARZ
		
		dong.add(WCB); //8			C-LÄUFER WEISS
		dong.add(WFB); //9			F-LÄUFER WEISS
		dong.add(BCB); //10			C-LÄUFER SCHWARZ
		dong.add(BFB); //11			F-LÄUFER SCHWARZ
		
		dong.add(WBN); //12			B-SPRINGER WEISS
		dong.add(WGN); //13			G-SPRINGER WEISS
		dong.add(BBN); //14			B-SPRINGER SCHWARZ
		dong.add(BGN); //15			G-SPRINGER SCHWARZ
		
		dong.add(WAP); //16			A-BAUER WEISS
		dong.add(WBP); //17			B-BAUER WEISS
		dong.add(WCP); //18			C-BAUER WEISS
		dong.add(WDP); //19			D-BAUER WEISS
		dong.add(WEP); //20			E-BAUER WEISS
		dong.add(WFP); //21			F-BAUER WEISS
		dong.add(WGP); //22			G-BAUER WEISS
		dong.add(WHP); //23			H-BAUER WEISS
		dong.add(BAP); //24			A-BAUER SCHWARZ
		dong.add(BBP); //25			B-BAUER SCHWARZ
		dong.add(BCP); //26			C-BAUER SCHWARZ
		dong.add(BDP); //27			D-BAUER SCHWARZ
		dong.add(BEP); //28			E-BAUER SCHWARZ
		dong.add(BFP); //29			F-BAUER SCHWARZ
		dong.add(BGP); //30			G-BAUER SCHWARZ
		dong.add(BHP); //31			H-BAUER SCHWARZ
					   //32-47		UMGEWANDELTE FIGUREN
	

	
	return dong;
	
	
	}
	
}

