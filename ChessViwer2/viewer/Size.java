package viewer;

public interface Size 
{
	//Hauptfenster
	final int windowWidth = 800;
	final int windowHigh = 600;
	
	//Brett und Figuren
	final int brettHigh = 400;
	final int brettWidth = brettHigh;
	final int figureHigh = 50;
	final int figureWidht = figureHigh;
	final int figureAbstand = 6;
	
	//Infopanel
	final int infoHigh = windowHigh;
	final int infoWidth = 150;
	final int toteFigur = 20;
	
	//Zeitpanel
	final int zeitHigh = windowHigh;
	final int zeitWidth = 100;
	final int step = 10;
	
	//LogPanel
	final int logHigh = 100;
	final int logWidth = windowWidth;
}
