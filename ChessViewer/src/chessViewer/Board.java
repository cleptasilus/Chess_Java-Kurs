package chessViewer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.*;
import javax.swing.*;

public class Board extends JPanel
{
	private static final long serialVersionUID = 265926406113133734L;
	ImageHandler images;
	

	public Board()
	{
		
		images = new ImageHandler();
		this.setBackground(Color.WHITE);	
		this.setOpaque(true);
		this.setVisible(true);
		this.repaint();
	}
	@Override
	public void paint(Graphics g) {
		super.paintComponents(g);
		g.drawImage(images.boardImage, 0, 0, Size.brettWidth, Size.brettHigh, null);
		g.drawImage(images.bRook, 10, 10, Size.figureWidht, Size.figureHigh, null);
		drawFigures(g);
	}
	
	void drawFigures(Graphics g)
	{
		g.drawImage(images.bRook, 10, 10, Size.figureWidht, Size.figureHigh, null);
	}
}
