
public class Solver {
	final static int maxCoups = 20; // si il n'y à pas de solution évite de bouclé à l'infni
	Plateau plateau;
	Robot[] tabRobots;
	Case[] chemin ;
	Case objectif;
	
	public Solver(Plateau plateau,Robot[] tabRobots,Case[] chemin) {
		this.plateau = plateau;
		this.tabRobots = tabRobots;
		this.chemin = chemin;
	}

}
