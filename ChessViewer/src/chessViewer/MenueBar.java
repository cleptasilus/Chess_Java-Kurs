package chessViewer;

import game.CurrentBoard;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pieces.PieceGenerator;

public class MenueBar extends JMenuBar {
	private static final long serialVersionUID = 5271549435848912197L;
	JMenu spiel;
	JMenu benutzer;
	JMenu hilfe;

	MenueBar() {
		spiel = new JMenu("Spiel");
		JMenuItem menuItem = new JMenuItem("Neues Spiel");
		menuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CurrentBoard currentBoard = new CurrentBoard();
				PieceGenerator pieceGenerator = new PieceGenerator();
				pieceGenerator.GeneratePieces(currentBoard);
			}
		});
		spiel.add(menuItem);
		spiel.add(new JMenuItem("Spiel Laden"));
		spiel.add(new JMenuItem("Spiel speichern"));
		spiel.add(new JMenuItem("Spiel Einstellungen"));
		benutzer = new JMenu("Benutzer");
		benutzer.add(new JMenuItem("Anlegen"));
		benutzer.add(new JMenuItem("Laden"));
		benutzer.add(new JMenuItem("Spiel Historie"));
		benutzer.add(new JMenuItem("Log laden"));
		hilfe = new JMenu("Hilfe");
		hilfe.add(new JMenuItem("Regeln"));
		hilfe.add(new JMenuItem("Hilfe"));
		hilfe.add(new JMenuItem("Credits"));
		this.add(spiel);
		this.add(benutzer);
		this.add(hilfe);
		this.setVisible(true);
	}
}
