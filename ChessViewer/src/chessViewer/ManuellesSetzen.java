package chessViewer;

import game.CurrentBoard;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Piece;
import chessrules.CheckMove;

public class ManuellesSetzen extends JPanel implements ActionListener {
	private static final long serialVersionUID = -4082366959896181136L;
	List<Piece> pieces;
	CurrentBoard schnittstelle;
	Board callingBrett;
	JComboBox<String> startXAuswahl;
	JComboBox<String> startYAuswahl;
	JComboBox<String> zielXAuswahl;
	JComboBox<String> zielYAuswahl;
	JButton setzten;

	String ziele[] = { "1", "2", "3", "4", "5", "6", "7", "8" };

	ManuellesSetzen(List<Piece> pieces) {
		this.pieces = pieces;
		zielXAuswahl = new JComboBox<String>(ziele);
		zielYAuswahl = new JComboBox<String>(ziele);
		startYAuswahl = new JComboBox<String>(ziele);
		startXAuswahl = new JComboBox<String>(ziele);
		setzten = new JButton("Setzen");

		setzten.addActionListener(this);
		this.add(new JLabel("Start Position:"));
		this.add(startXAuswahl);
		this.add(startYAuswahl);

		this.add(new JLabel("Ziel Position"));
		this.add(zielXAuswahl);
		this.add(zielYAuswahl);

		this.add(setzten);
		this.setBackground(Color.PINK);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == this.setzten) {
			int sX = this.startXAuswahl.getSelectedIndex() + 1;
			int sY = this.startYAuswahl.getSelectedIndex() + 1;
			int zX = this.zielXAuswahl.getSelectedIndex() + 1;
			int zY = this.zielYAuswahl.getSelectedIndex() + 1;
			Piece temp;

			if (schnittstelle.Squares[sX][sY].isOccupied()) {
				temp = schnittstelle.Squares[sX][sY].getOccupiyingPiece();
				//temp.Move(schnittstelle.Squares[zX][zY]);
				
				System.out.println("tttteeesst");
				callingBrett.repaint();
			} else {
				System.err.println("Keine Figur auf dem Feld!");
			}
		} else {
			// Fehler
			System.err.println("Fehlerhaftes Event ausgelöst!");
		}
	}

}
