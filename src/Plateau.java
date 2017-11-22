import javafx.scene.paint.Color;

public class Plateau {
	private AffichageCase[][] plateau;
	private Robot rouge = new Robot(Color.RED);
	private Robot jaune = new Robot(Color.YELLOW);
	private Robot vert = new Robot(Color.GREEN);
	private Robot bleu = new Robot(Color.BLUE);
	private Robot selection= new Robot(Color.WHITE);
	private String objectif;
	private int nbDeplacement = 1;

	public Plateau() {
		plateau = new AffichageCase[16][16];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new AffichageCase(i,j);
			}
		}
		

		// Création des murs et cibles
		plateau[7][8].getCase().casePleine();
		plateau[7][7].getCase().casePleine();
		plateau[8][7].getCase().casePleine();
		plateau[8][8].getCase().casePleine();
		plateau[0][3].getCase().setMurdroit(true);
		plateau[0][13].getCase().setMurdroit(true);
		plateau[1][12].getCase().angleBD();
		plateau[1][12].getCase().marqueruneCible("1");
		plateau[2][4].getCase().angleHG();
		plateau[2][4].getCase().marqueruneCible("2");
		plateau[3][2].getCase().angleBG();
		plateau[3][2].getCase().marqueruneCible("3");
		plateau[3][9].getCase().angleHG();
		plateau[3][9].getCase().marqueruneCible("4");
		plateau[4][5].getCase().angleHD();
		plateau[4][5].getCase().marqueruneCible("5");
		plateau[4][14].getCase().angleHD();
		plateau[4][14].getCase().marqueruneCible("6");
		plateau[5][0].getCase().setMurhaut(true);
		plateau[5][3].getCase().angleBD();
		plateau[5][3].getCase().marqueruneCible("7");
		plateau[6][11].getCase().angleBG();
		plateau[6][11].getCase().marqueruneCible("8");
		plateau[6][15].getCase().setMurhaut(true);
		plateau[9][1].getCase().angleHD();
		plateau[9][1].getCase().marqueruneCible("9");
		plateau[10][6].getCase().angleHG();
		plateau[10][6].getCase().marqueruneCible("10");
		plateau[10][10].getCase().angleBD();
		plateau[10][10].getCase().marqueruneCible("11");
		plateau[11][0].getCase().setMurhaut(true);
		plateau[11][3].getCase().angleBD();
		plateau[11][3].getCase().marqueruneCible("12");
		// System.out.println(""+plateau[11][3].getCible()+"");
		plateau[11][14].getCase().angleBD();
		plateau[11][14].getCase().marqueruneCible("13");
		// System.out.print(""+plateau[11][14].getCible()+"");
		plateau[12][9].getCase().angleBG();
		plateau[12][9].getCase().marqueruneCible("14");
		plateau[13][7].getCase().angleBD();
		plateau[13][7].getCase().marqueruneCible("15");
		plateau[13][15].getCase().setMurhaut(true);
		plateau[14][5].getCase().angleBG();
		plateau[14][5].getCase().marqueruneCible("16");
		plateau[14][12].getCase().angleHG();
		plateau[14][12].getCase().marqueruneCible("17");
		plateau[15][2].getCase().setMurdroit(true);
		plateau[15][9].getCase().setMurdroit(true);
		// placement des robots

		plateau[12][8].ajoutRobot(rouge);
		plateau[5][12].ajoutRobot(bleu);
		plateau[12][12].ajoutRobot(jaune);
		plateau[6][3].ajoutRobot(vert);
		
		int lower = 1;
		int higher = 17;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		this.objectif = ""+random;
		System.out.println(this.objectif);

	}
	public Robot getSelection() {
		return this.selection;
	}
	public String getObjectif() {
		return this.objectif;
	}
 Robot getRouge() {
		return rouge;
	}

	public Robot getJaune() {
		return jaune;
	}

	public Robot getVert() {
		return vert;
	}

	public Robot getBleu() {
		return bleu;
	}
    public void selectionRobotCouleur(boolean R,boolean V,boolean B,boolean J) {
    	if(R) {
    		this.selection = this.rouge;
    	}
    	if(B) {
    		this.selection = this.bleu;
    	}
    	if(V) {
    		this.selection = this.vert;
    	}
    	if(J) {
    		this.selection = this.jaune;
    	}
    	rouge.setSelection(R);
    	bleu.setSelection(B);
    	vert.setSelection(V);
    	jaune.setSelection(J);
    }
public AffichageCase getCase(int i, int j) {
		return plateau[i][j];
	}
/*public Case[] calculDeplacement(){
	
	
	
}*/
	public Case deplacementBas(){
		int coordonneX = 0;
		int coordonneY = 0;
		    if(this.selection.getCoordonneeY() != 0) {
		    	coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].getCase().isMurbas()&&!plateau[coordonneY-1][coordonneX].getCase().isMurhaut()&&!plateau[coordonneY-1][coordonneX].getCase().possedeUnRobot()) {
					plateau[coordonneY][coordonneX].retirerrobot();
					plateau[coordonneY-1][coordonneX].ajoutRobot(selection);
					plateau[coordonneY-1][coordonneX].colorerCase();
					if(plateau[coordonneY-1][coordonneX].getCase().getCible().equals(objectif)) {
						
						System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
						break;
					}
					coordonneX = this.selection.getCoordonneeX();
					coordonneY = this.selection.getCoordonneeY();
					if(coordonneY == 0) {
						
						break;
					}
			    }
				this.nbDeplacement ++;
		    }
		    return this.plateau[coordonneX][coordonneY].getCase();
	   }
	public Case deplacementHaut() {
		int coordonneX = 0;
		int coordonneY = 0;
			if(this.selection.getCoordonneeY() < plateau.length -1) {
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].getCase().isMurhaut()&&!plateau[coordonneY+1][coordonneX].getCase().isMurbas()&&!plateau[coordonneY+1][coordonneX].getCase().possedeUnRobot()) {
					plateau[coordonneY][coordonneX].retirerrobot();
					plateau[coordonneY+1][coordonneX].ajoutRobot(selection);
					plateau[coordonneY+1][coordonneX].colorerCase();
					if(plateau[coordonneY+1][coordonneX].getCase().getCible().equals(objectif)) {
						
						System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
						break;
					}
					coordonneX = this.selection.getCoordonneeX();
					coordonneY = this.selection.getCoordonneeY();
					if(coordonneY == plateau.length -1) {
						
						break;
					}
				}
				this.nbDeplacement ++;
			}
			return this.plateau[coordonneX][coordonneY].getCase();
	}
	public Case deplacementdroite(){
		int coordonneX = 0;
		int coordonneY = 0;
			if(this.selection.getCoordonneeX() < plateau.length -1) {
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].getCase().isMurdroit()&&!plateau[coordonneY][coordonneX+1].getCase().isMurgauche()&&!plateau[coordonneY][coordonneX+1].getCase().possedeUnRobot()) {
					plateau[coordonneY][coordonneX].retirerrobot();
					plateau[coordonneY][coordonneX+1].ajoutRobot(selection);
					plateau[coordonneY][coordonneX+1].colorerCase();
					if(plateau[coordonneY][coordonneX+1].getCase().getCible().equals(objectif)) {
						
						System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
						break;
					}
					coordonneX = this.selection.getCoordonneeX();
					coordonneY = this.selection.getCoordonneeY();
					if(coordonneX == plateau.length - 1) {
						
						break;
					}
				
			    }
				this.nbDeplacement ++;
			}
			return this.plateau[coordonneX][coordonneY].getCase();
	}
	public Case deplacementgauche(){
		int coordonneX = 0;
		int coordonneY = 0;
			if(this.selection.getCoordonneeX() != 0) {
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].getCase().isMurgauche()&&!plateau[coordonneY][coordonneX-1].getCase().isMurdroit()&&!plateau[coordonneY][coordonneX-1].getCase().possedeUnRobot()) {
				plateau[coordonneY][coordonneX].retirerrobot();
				plateau[coordonneY][coordonneX-1].ajoutRobot(selection);
				plateau[coordonneY][coordonneX-1].colorerCase();
				if(plateau[coordonneY][coordonneX-1].getCase().getCible().equals(objectif)) {
					System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
					break;
				}
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				if(coordonneX == 0) {
					break;
				}
			  }
				this.nbDeplacement ++;
			}
			return this.plateau[coordonneX][coordonneY].getCase();
			
	}
	   public Case[] calculDeplacer(Robot r) {
		   int x=r.getCoordonneeX(),y=r.getCoordonneeY();
		   Case[] tab=new Case[4];
		   this.selection=r;
		   tab[0]=deplacementHaut();
		   this.selection.setCoordonnee(x, y);
		   tab[1]=deplacementdroite();
		   this.selection.setCoordonnee(x, y);
		   tab[2]=deplacementBas();
		   this.selection.setCoordonnee(x, y);
		   tab[3]=deplacementgauche();
		   this.selection.setCoordonnee(x, y);
		   return tab;
	   }
}
