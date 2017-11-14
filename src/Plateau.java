import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class Plateau extends StackPane {
	private Case[][] plateau;
	private Robot rouge = new Robot(Color.RED);
	private Robot jaune = new Robot(Color.YELLOW);
	private Robot vert = new Robot(Color.GREEN);
	private Robot bleu = new Robot(Color.BLUE);
	private Robot selection;
	private String objectif;
	private int nbDeplacement = 0;

	public Plateau() throws IOException {
		final StackPane root = new StackPane(); 
		InputStream Acceuil = Files.newInputStream(Paths.get("./ressources/images/Robots.jpg"));
		Image img = new Image(Acceuil);
		Acceuil.close();
		ImageView imgV = new ImageView(img);
		imgV.setFitHeight(720);
		imgV.setFitWidth(1080);
		root.setTranslateX(0);
		/*Rectangle rt = new Rectangle(1080, 720);
		rt.setOpacity(0);
		rt.setFill(Color.BLACK);*/
		//setAlignment(Pos.CENTER);
		plateau = new Case[16][16];
		//root.getChildren().addAll(imgV);
		double posXcase = 0;
		double posYcase = 0;
		for (int i = 0; i < plateau.length; i++) {
			posYcase = posYcase - 44.6;
			posXcase =0;
			for (int j = 0; j < plateau.length; j++) {
				plateau[i][j] = new Case(i,j);
				plateau[i][j].setAlignment(Pos.CENTER);
				plateau[i][j].setTranslateX(posXcase);
				plateau[i][j].setTranslateY(posYcase);
				posXcase = posXcase + 67.3;
				root.getChildren().addAll(plateau[i][j]);
			}
		}
		root.setTranslateX(-502);
		root.setTranslateY(380);
		
		getChildren().addAll(imgV,root);
		
		

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
/*	public Case getCase(int i, int j) {
		return plateau[i][j];
	}*/
	public void deplacementBas(){
		int coordonneX = 0;
		int coordonneY = 0;
		    if(this.selection.getCoordonneeY() != 0) {
		    	coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].isMurbas()&&!plateau[coordonneY-1][coordonneX].isMurhaut()&&!plateau[coordonneY-1][coordonneX].possedeUnRobot()) {
					plateau[coordonneY][coordonneX].retirerrobot();
					this.selection.seDeplaceBas();
					plateau[coordonneY-1][coordonneX].ajoutRobot(selection);
					plateau[coordonneY-1][coordonneX].colorerCase();
					if(plateau[coordonneY-1][coordonneX].getCible().equals(objectif)) {
						System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
						break;
					}
					coordonneX = this.selection.getCoordonneeX();
					coordonneY = this.selection.getCoordonneeY();
					if(coordonneY == 0) {
						this.nbDeplacement ++;
						break;
					}
			    }	
		    }
	   }
	public void deplacementHaut() {
		int coordonneX = 0;
		int coordonneY = 0;
			if(this.selection.getCoordonneeY() < plateau.length -1) {
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].isMurhaut()&&!plateau[coordonneY+1][coordonneX].isMurbas()&&!plateau[coordonneY+1][coordonneX].possedeUnRobot()) {
					plateau[coordonneY][coordonneX].retirerrobot();
					this.selection.seDeplaceHaut();
					plateau[coordonneY+1][coordonneX].ajoutRobot(selection);
					plateau[coordonneY+1][coordonneX].colorerCase();
					if(plateau[coordonneY+1][coordonneX].getCible().equals(objectif)) {
						System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
						break;
					}
					coordonneX = this.selection.getCoordonneeX();
					coordonneY = this.selection.getCoordonneeY();
					if(coordonneY == plateau.length -1) {
						this.nbDeplacement ++;
						break;
					}
				}
				
			}
	}
	public void deplacementdroite(){
		int coordonneX = 0;
		int coordonneY = 0;
			if(this.selection.getCoordonneeX() < plateau.length -1) {
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].isMurdroit()&&!plateau[coordonneY][coordonneX+1].isMurgauche()&&!plateau[coordonneY][coordonneX+1].possedeUnRobot()) {
					plateau[coordonneY][coordonneX].retirerrobot();
					this.selection.seDeplaceDroite();
					plateau[coordonneY][coordonneX+1].ajoutRobot(selection);
					plateau[coordonneY][coordonneX+1].colorerCase();
					if(plateau[coordonneY][coordonneX+1].getCible().equals(objectif)) {
						System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
						break;
					}
					coordonneX = this.selection.getCoordonneeX();
					coordonneY = this.selection.getCoordonneeY();
					if(coordonneX == plateau.length - 1) {
						this.nbDeplacement ++;
						break;
					}
				
			    }
			}
	}
	public void deplacementgauche(){
		int coordonneX = 0;
		int coordonneY = 0;
			if(this.selection.getCoordonneeX() != 0) {
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				while(!plateau[coordonneY][coordonneX].isMurgauche()&&!plateau[coordonneY][coordonneX-1].isMurdroit()&&!plateau[coordonneY][coordonneX-1].possedeUnRobot()) {
				plateau[coordonneY][coordonneX].retirerrobot();
				this.selection.seDeplaceDroite();
				plateau[coordonneY][coordonneX-1].ajoutRobot(selection);
				plateau[coordonneY][coordonneX-1].colorerCase();
				if(plateau[coordonneY][coordonneX-1].getCible().equals(objectif)) {
					System.out.println("Vous avez atteint l'objectif avec le robot "+this.selection.getColor()+" en "+ this.nbDeplacement);
					break;
				}
				coordonneX = this.selection.getCoordonneeX();
				coordonneY = this.selection.getCoordonneeY();
				if(coordonneX == 0) {
					this.nbDeplacement ++;
					break;
				}
			  }
			}
			
	}
}
