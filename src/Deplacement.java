

public class Deplacement {
	int coordonneX ;
	int coordonneY ;
	Plateau plateau;
	AffichagePlateau affplateau;
	Robot r;
	public Deplacement() {
 	  
 }
	    public Deplacement(Robot robot,Plateau p) {
	    	   plateau = p;
			    r = robot;
	    }
		public Case deplacementr(Robot robot,Plateau p,AffichagePlateau affp,String s) {
			this.affplateau = affp;
			 r = robot;
			int coordonneX = 0;
			int coordonneY = 0;
			if(s.equals("H")) {
				if(r.getCoordonneeY() < p.taillePlateau() -1) {
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					while(!p.getCase(coordonneY,coordonneX).isMurhaut()&&!p.getCase(coordonneY+1,coordonneX).isMurbas()&&!p.getCase(coordonneY+1,coordonneX).possedeUnRobot()) {
						//p.getCase(coordonneY,coordonneX).retirerrobot();
						affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
						p.getCase(coordonneY+1,coordonneX).ajoutRobot(r);
						affplateau.getAffCase(coordonneY+1,coordonneX).colorerCase();
						//plateau.getCase(coordonneY+1,coordonneX).colorerCase();
						if(p.getCase(coordonneY+1,coordonneX).getCible().equals(p.getObjectif())) {
							
							System.out.println("Vous avez atteint l'objectif avec le robot "+r.getColor()+" en "+ p.getNbDeplacement());
							break;
						}
						coordonneX = r.getCoordonneeX();
						coordonneY = r.getCoordonneeY();
						if(coordonneY == p.taillePlateau() -1) {
							
							break;
						}
					}
					p.setNbDeplacement(p.getNbDeplacement()+1);
				}
				return p.getCase(coordonneY,coordonneX);
				
			}
			else if(s.equals("D")) {
				if(r.getCoordonneeX() < p.taillePlateau() -1) {
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					while(!p.getCase(coordonneY,coordonneX).isMurdroit()&&!p.getCase(coordonneY,coordonneX+1).isMurgauche()&&!p.getCase(coordonneY,coordonneX+1).possedeUnRobot()) {
						//p.getCase(coordonneY,coordonneX).retirerrobot();
						affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
						p.getCase(coordonneY,coordonneX+1).ajoutRobot(r);
						affplateau.getAffCase(coordonneY,coordonneX+1).colorerCase();
						//plateau.getCase(coordonneY,coordonneX+1).colorerCase();
						if(p.getCase(coordonneY,coordonneX+1).getCible().equals(p.getObjectif())) {
							
							System.out.println("Vous avez atteint l'objectif avec le robot "+r.getColor()+" en "+ p.getNbDeplacement());
							break;
						}
						coordonneX = r.getCoordonneeX();
						coordonneY = r.getCoordonneeY();
						if(coordonneX == p.taillePlateau() -1) {
							
							break;
						}
					}
					p.setNbDeplacement(p.getNbDeplacement()+1);
				}
				return p.getCase(coordonneY,coordonneX);
				
			}
			else if(s.equals("G")) {
				if(r.getCoordonneeX() != 0 ) {
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					while(!p.getCase(coordonneY,coordonneX).isMurgauche()&&!p.getCase(coordonneY,coordonneX-1).isMurdroit()&&!p.getCase(coordonneY,coordonneX-1).possedeUnRobot()) {
						//p.getCase(coordonneY,coordonneX).retirerrobot();
						affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
						p.getCase(coordonneY,coordonneX-1).ajoutRobot(r);
						affplateau.getAffCase(coordonneY,coordonneX-1).colorerCase();
						//plateau.getCase(coordonneY,coordonneX-1).colorerCase();
						if(p.getCase(coordonneY,coordonneX-1).getCible().equals(p.getObjectif())) {
							
							System.out.println("Vous avez atteint l'objectif avec le robot "+r.getColor()+" en "+ p.getNbDeplacement());
							break;
						}
						coordonneX = r.getCoordonneeX();
						coordonneY = r.getCoordonneeY();
						if(coordonneX == 0) {
							
							break;
						}
					}
					p.setNbDeplacement(p.getNbDeplacement()+1);
				}
				return p.getCase(coordonneY,coordonneX);
				
			}
			// bas
			else {
				if(r.getCoordonneeY() != 0) {
					coordonneX = r.getCoordonneeX();
					coordonneY = r.getCoordonneeY();
					while(!p.getCase(coordonneY,coordonneX).isMurbas()&&!p.getCase(coordonneY-1,coordonneX).isMurhaut()&&!p.getCase(coordonneY-1,coordonneX).possedeUnRobot()) {
						//p.getCase(coordonneY,coordonneX).retirerrobot();
						affplateau.getAffCase(coordonneY,coordonneX).retirerrobot();
						p.getCase(coordonneY-1,coordonneX).ajoutRobot(r);
						affplateau.getAffCase(coordonneY-1,coordonneX).colorerCase();
						//plateau.getCase(coordonneY-1,coordonneX).colorerCase();
						if(p.getCase(coordonneY-1,coordonneX).getCible().equals(p.getObjectif())) {
							
							System.out.println("Vous avez atteint l'objectif avec le robot "+r.getColor()+" en "+ p.getNbDeplacement());
							break;
						}
						coordonneX = r.getCoordonneeX();
						coordonneY = r.getCoordonneeY();
						if(coordonneY == 0) {
							
							break;
						}
					}
					p.setNbDeplacement(p.getNbDeplacement()+1);
				}
				return p.getCase(coordonneY,coordonneX);
				
			}
			}
		public Case[] calculDeplacer() {
			   int x=r.getCoordonneeX(),y=r.getCoordonneeY();
			   Case[] tab=new Case[4];
			   plateau.setSelection(r);
			   tab[0]=deplacementr(r,plateau,affplateau,"H");
			   r.setCoordonnee(x, y);
			   tab[1]=deplacementr(r,plateau,affplateau,"D");
			   r.setCoordonnee(x, y);
			   tab[2]=deplacementr(r,plateau,affplateau,"");
			   r.setCoordonnee(x, y);
			   tab[3]=deplacementr(r,plateau,affplateau,"G");;
			   r.setCoordonnee(x, y);
			   return tab;
		   }
		

}
