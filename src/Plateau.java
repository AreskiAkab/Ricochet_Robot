import javafx.scene.paint.Color;

public class Plateau {
	private Case[][] plateau;
	private Robot rouge = new Robot(Color.RED);
	private Robot jaune = new Robot(Color.YELLOW);
	private Robot vert = new Robot(Color.GREEN);
	private Robot bleu = new Robot(Color.BLUE);
	private Robot selection= new Robot(Color.WHITE);
	private String objectif;
	private int nbDeplacement = 1;

	public Plateau() {
		plateau = new Case[16][16];
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new Case(i,j);
			}
		}
		

		// Création des murs et cibles
		plateau[7][8].casePleine();
		plateau[7][7].casePleine();
		plateau[8][7].casePleine();
		plateau[8][8].casePleine();
		plateau[0][3].setMurdroit(true);
		plateau[0][13].setMurdroit(true);
		plateau[1][12].angleBD();
		plateau[1][12].marqueruneCible("1");
		plateau[2][4].angleHG();
		plateau[2][4].marqueruneCible("2");
		plateau[3][2].angleBG();
		plateau[3][2].marqueruneCible("3");
		plateau[3][9].angleHG();
		plateau[3][9].marqueruneCible("4");
		plateau[4][5].angleHD();
		plateau[4][5].marqueruneCible("5");
		plateau[4][14].angleHD();
		plateau[4][14].marqueruneCible("6");
		plateau[5][0].setMurhaut(true);
		plateau[5][3].angleBD();
		plateau[5][3].marqueruneCible("7");
		plateau[6][11].angleBG();
		plateau[6][11].marqueruneCible("8");
		plateau[6][15].setMurhaut(true);
		plateau[9][1].angleHD();
		plateau[9][1].marqueruneCible("9");
		plateau[10][6].angleHG();
		plateau[10][6].marqueruneCible("10");
		plateau[10][10].angleBD();
		plateau[10][10].marqueruneCible("11");
		plateau[11][0].setMurhaut(true);
		plateau[11][3].angleBD();
		plateau[11][3].marqueruneCible("12");
		// System.out.println(""+plateau[11][3].getCible()+"");
		plateau[11][14].angleBD();
		plateau[11][14].marqueruneCible("13");
		// System.out.print(""+plateau[11][14].getCible()+"");
		plateau[12][9].angleBG();
		plateau[12][9].marqueruneCible("14");
		plateau[13][7].angleBD();
		plateau[13][7].marqueruneCible("15");
		plateau[13][15].setMurhaut(true);
		plateau[14][5].angleBG();
		plateau[14][5].marqueruneCible("16");
		plateau[14][12].angleHG();
		plateau[14][12].marqueruneCible("17");
		plateau[15][2].setMurdroit(true);
		plateau[15][9].setMurdroit(true);
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
	public String getObjectif() {
		return this.objectif;
	}
 Robot getRouge() {
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
