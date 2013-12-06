package players;

public class Player extends game.Game{
String colour;
String name;
int wins;
int losses;
int draws;
//TODO
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getWins() {
	return wins;
}
public void setWins(int wins) {
	this.wins = wins;
}
public int getLosses() {
	return losses;
}
public void setLosses(int losses) {
	this.losses = losses;
}
public int getDraws() {
	return draws;
}
public void setDraws(int draws) {
	this.draws = draws;
}

}
