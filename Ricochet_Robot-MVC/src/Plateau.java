import javafx.scene.paint.Color;

public class Plateau {
	private Case[][] plateau;
	private Robot rouge = new Robot(Color.RED);
	private Robot jaune = new Robot(Color.YELLOW);
	private Robot vert = new Robot(Color.GREEN);
	private Robot bleu = new Robot(Color.BLUE);
	private Robot selection= new Robot(Color.WHITE);
	//private String objectif;
	private Case objectif;
	private int nbDeplacement = 1;

	public Plateau() {
		plateau = new Case[16][16];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new Case(i,j);
			}
		}
		

		// Cr�ation des murs et cibles
		plateau[8][7].casePleine();
		plateau[7][7].casePleine();
		plateau[7][8].casePleine();
		plateau[8][8].casePleine();
		plateau[3][0].setMurdroit(true);
		plateau[13][0].setMurdroit(true);
		plateau[12][1].angleBD();
		plateau[12][1].marqueruneCible("1");
		plateau[4][2].angleHG();
		plateau[4][2].marqueruneCible("2");
		plateau[2][3].angleBG();
		plateau[2][3].marqueruneCible("3");
		plateau[9][3].angleHG();
		plateau[9][3].marqueruneCible("4");
		plateau[5][4].angleHD();
		plateau[5][4].marqueruneCible("5");
		plateau[14][4].angleHD();
		plateau[14][4].marqueruneCible("6");
		plateau[0][2].setMurhaut(true);
		plateau[3][5].angleBD();
		plateau[3][5].marqueruneCible("7");
		plateau[11][6].angleBG();
		plateau[11][6].marqueruneCible("8");
		plateau[15][6].setMurhaut(true);
		plateau[1][9].angleHD();
		plateau[1][9].marqueruneCible("9");
		plateau[6][10].angleHG();
		plateau[6][10].marqueruneCible("10");
		plateau[10][10].angleBD();
		plateau[10][10].marqueruneCible("11");
		plateau[0][11].setMurhaut(true);
		plateau[3][11].angleBD();
		plateau[3][11].marqueruneCible("12");
		// System.out.println(""+plateau[11][3].getCible()+"");
		plateau[14][11].angleBD();
		plateau[14][11].marqueruneCible("13");
		// System.out.print(""+plateau[11][14].getCible()+"");
		plateau[9][12].angleBG();
		plateau[9][12].marqueruneCible("14");
		plateau[7][13].angleBD();
		plateau[7][13].marqueruneCible("15");
	//	plateau[13][15].setMurhaut(true);
		plateau[13][15].setMurhaut(true);
		plateau[5][14].angleBG();
		plateau[5][14].marqueruneCible("16");
		plateau[12][14].angleHG();
		plateau[12][14].marqueruneCible("17");
		plateau[2][15].setMurdroit(true);
		plateau[9][15].setMurdroit(true);
		// placement des robots

		plateau[15][15].ajoutRobot(rouge);
		plateau[12][5].ajoutRobot(bleu);
		plateau[12][12].ajoutRobot(jaune);
		plateau[3][6].ajoutRobot(vert);
		
		int lower = 1;
		int higher = 17;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		//this.objectif = ""+random;
		this.objectif = plateau[6][10];
		//System.out.println(this.objectif);

	}
	public void setCaseObj(String s){
		
	}
	public Robot getSelection() {
		return this.selection;
	}
	public void setSelection(Robot r) {
		 this.selection = r;
	}
	public Robot[] getAllRobot() {
		Robot[] tab = new Robot[4];
		tab[0] = this.rouge;
		tab[1] = this.bleu;
		tab[2] = this.vert;
		tab[3] = this.jaune;
		return tab;
	}
	public Case getObjectif() {
		return this.objectif;

	}
	
	public Robot getRouge() {
		return this.rouge;
	}

	public Robot getJaune() {
		return this.jaune;
	}

	public Robot getVert() {
		return this.vert;
	}

	public Robot getBleu() {
		return this.bleu;
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
public Case getCase(int i, int j) {
		return plateau[i][j];
	}
public int taillePlateau() {
	return plateau.length;
}

	public int getNbDeplacement() {
		return nbDeplacement;
	}
	public void setNbDeplacement(int nbDeplacement) {
		this.nbDeplacement = nbDeplacement;
	}
}
