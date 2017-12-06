import java.util.ArrayList;

public class Deplacement {
	public int coordonneX;
	public int coordonneY;
	public Plateau plateau;
	public AffichagePlateau affplateau;
	public Robot r;

	public Plateau getPlateau() {
		return this.plateau;
	}

	public Deplacement() {
	}

	public Deplacement(Robot robot, Plateau p) {
		plateau = p;
		r = robot;
	}

	public Case deplacementr(Robot robot, Plateau p, AffichagePlateau affp,
			String s) {
		this.affplateau = affp;
		r = robot;
		int coordonneX = 0;
		int coordonneY = 0;
		if (s.equals("H")) {
			if (r.getCoordonneeY() < p.taillePlateau() - 1) {
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!p.getCase(coordonneX,coordonneY).isMurhaut()
						&& !p.getCase(coordonneX,coordonneY + 1 ).isMurbas()
						&& !p.getCase(coordonneX,coordonneY + 1)
								.possedeUnRobot()) {
					p.getCase(coordonneX,coordonneY).retirerrobot();
					//affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					p.getCase(coordonneX,coordonneY + 1).ajoutRobot(r);
					// affplateau.getAffCase(coordonneY+1,coordonneX).colorerCase();
					// plateau.getCase(coordonneY+1,coordonneX).colorerCase();
					if (p.getCase(coordonneX,coordonneY + 1).getCible().equals(p.getObjectif())) {

						System.out.println("Vous avez atteint l'objectif avec le robot "+ r.getColor()+ " en "+ p.getNbDeplacement());
						break;
					}
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					if (coordonneY == p.taillePlateau() - 1) {

						break;
					}
				}
				p.setNbDeplacement(p.getNbDeplacement() + 1);
			}
			return p.getCase(coordonneX,coordonneY);

		} else if (s.equals("D")) {
			if (r.getCoordonneeX() < p.taillePlateau() - 1) {
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!p.getCase(coordonneX,coordonneY).isMurdroit()
						&& !p.getCase(coordonneX + 1,coordonneY).isMurgauche()
						&& !p.getCase( coordonneX + 1,coordonneY)
								.possedeUnRobot()) {
					p.getCase(coordonneX,coordonneY).retirerrobot();
					 //affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					p.getCase( coordonneX + 1,coordonneY).ajoutRobot(r);
					//affplateau.getAffCase(coordonneY,coordonneX+1).colorerCase();
					//plateau.getCase(coordonneY,coordonneX+1).colorerCase();
					if (p.getCase( coordonneX + 1,coordonneY).getCible()
							.equals(p.getObjectif())) {

						System.out
								.println("Vous avez atteint l'objectif avec le robot "
										+ r.getColor()
										+ " en "
										+ p.getNbDeplacement());
						break;
					}
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					if (coordonneX == p.taillePlateau() - 1) {

						break;
					}
				}
				p.setNbDeplacement(p.getNbDeplacement() + 1);
			}
			return p.getCase(coordonneX,coordonneY);

		} else if (s.equals("G")) {
			if (r.getCoordonneeX() != 0) {
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!p.getCase( coordonneX,coordonneY).isMurgauche()
						&& !p.getCase( coordonneX - 1,coordonneY).isMurdroit()
						&& !p.getCase( coordonneX - 1,coordonneY)
								.possedeUnRobot()) {
					p.getCase(coordonneX,coordonneY).retirerrobot();
					//affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					p.getCase( coordonneX - 1,coordonneY).ajoutRobot(r);
					// affplateau.getAffCase(coordonneY,coordonneX-1).colorerCase();
					// plateau.getCase(coordonneY,coordonneX-1).colorerCase();
					if (p.getCase(coordonneX - 1,coordonneY).getCible()
							.equals(p.getObjectif())) {

						System.out
								.println("Vous avez atteint l'objectif avec le robot "
										+ r.getColor()
										+ " en "
										+ p.getNbDeplacement());
						break;
					}
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					if (coordonneX == 0) {

						break;
					}
				}
				p.setNbDeplacement(p.getNbDeplacement() + 1);
			}
			return p.getCase(coordonneX,coordonneY);

		}
		// bas
		else {
			if (r.getCoordonneeY() != 0) {
				coordonneX = r.getCoordonneeX();
				coordonneY = r.getCoordonneeY();
				while (!p.getCase(coordonneX,coordonneY).isMurbas()
						&& !p.getCase(coordonneX,coordonneY - 1).isMurhaut()
						&& !p.getCase(coordonneX,coordonneY - 1)
								.possedeUnRobot()) {
					 p.getCase(coordonneX,coordonneY).retirerrobot();
					 //affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
					p.getCase(coordonneX,coordonneY - 1).ajoutRobot(r);
					// affplateau.getAffCase(coordonneY-1,coordonneX).colorerCase();
					// plateau.getCase(coordonneY-1,coordonneX).colorerCase();
					if (p.getCase(coordonneX,coordonneY - 1).getCible()
							.equals(p.getObjectif())) {

						System.out
								.println("Vous avez atteint l'objectif avec le robot "
										+ r.getColor()
										+ " en "
										+ p.getNbDeplacement());
						break;
					}
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					if (coordonneY == 0) {

						break;
					}
				}
				p.setNbDeplacement(p.getNbDeplacement() + 1);
			}
			return p.getCase(coordonneX,coordonneY);

		}
	}

	public Case[] calculDeplacer(Case c) {
		int xr = r.getCoordonneeX(), yr = r.getCoordonneeY();
		int x = c.getCoordonneeX(), y = c.getCoordonneeY();
		Case[] tab = new Case[4];
		plateau.setSelection(r);
		r.setCoordonnee(x, y);
		tab[0] = deplacementr(r, plateau, affplateau, "H");
		r.setCoordonnee(x, y);
		tab[1] = deplacementr(r, plateau, affplateau, "D");
		r.setCoordonnee(x, y);
		tab[2] = deplacementr(r, plateau, affplateau, "");
		r.setCoordonnee(x, y);
		tab[3] = deplacementr(r, plateau, affplateau, "G");
		r.setCoordonnee(xr, yr);
		// Case[] tabc =
		// {this.plateau.getCase(tab[0].getCoordonneeX(),tab[0].getCoordonneeY()),this.plateau.getCase(tab[1].getCoordonneeX(),tab[1].getCoordonneeY()),this.plateau.getCase(tab[2].getCoordonneeX(),tab[2].getCoordonneeY()),this.plateau.getCase(tab[3].getCoordonneeX(),tab[3].getCoordonneeY())};
		return tab;
	}

	public int calculChemin() {
		// System.out.println("plateau : " + this.plateau);
		ArrayList<Case> listeV = new ArrayList<Case>(); // à regarder
		ArrayList<Case> listeR = new ArrayList<Case>(); // déjà vu
		// colorer case de départ
		Case a = this.plateau.getCase(this.r.getCoordonneeX(),
				this.r.getCoordonneeY());
		listeV.add(a);
		int indice = 0;
		Case courant = a;

		while (!(listeV.isEmpty())) {
			// System.out.println("liste verte : " + listeV.size() +
			// " listeR : " + listeR.size());

			// selection du chemin le plus court
			courant = listeV.get(0);
			for (int i = 1; i < listeV.size(); i++) {
				if (courant.getDistance() > listeV.get(i).getDistance()) {
					courant = listeV.get(i);
					indice = i;
				}
			}

			if (courant.equals(this.plateau.getObjectif())) {
				return courant.getDistance();
			}
			System.out.println("courant x : " + courant.getCoordonneeX()
					+ "  y : " + courant.getCoordonneeY());
			System.out.println("objectif x : "
					+ this.plateau.getObjectif().getCoordonneeX() + "  y : "
					+ this.plateau.getObjectif().getCoordonneeY());
			System.out.println("---------------------------------------------");
			// stock tout les voisins de x
			Case[] tabc = this.calculDeplacer(courant);
			for (int i = 0; i < 4; i++) {
				if (!(listeR.contains(tabc[i])) && !(listeV.contains(tabc[i]))) {
					tabc[i].setDistance(courant.getDistance() + 1);
					listeV.add(tabc[i]);
				}
			}
			// passe x de vert à rouge
			listeR.add(courant);
			listeV.remove(indice);
		}
		return 0;
	}

}
