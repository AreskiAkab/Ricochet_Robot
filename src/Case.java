import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Case extends StackPane {
	private boolean murhaut;
	private boolean murbas;
	private boolean murgauche;
	private boolean murdroit;
	private String cible;
	private Robot robot;
	private Rectangle carre;
	private int coordonneeX;
	private int coordonneeY;

	public Case(int x, int y) {
		this.coordonneeX = x ;
		this.coordonneeY = y ;
		murhaut = false;
		murbas = false;
		murgauche = false;
		murdroit = false;
		cible = "";
		carre = new Rectangle(55, 37);
		colorerCase();
		carre.setOpacity(0);
		carre.setFill(Color.WHITE);
		setAlignment(Pos.CENTER);
		getChildren().addAll(carre);
		
	}
	public void setOpacityON() {
		carre.setOpacity(1);	
	}
	public Robot getRobot() {
		return this.robot;
	}

	public void ajoutRobot(Robot r) {
		this.robot = r;
		colorerCase();
		r.setCoordonnee(this.coordonneeY, this.coordonneeX);
		System.out.println(this.coordonneeY+" "+this.coordonneeX);
	}


	public boolean possedeUnRobot() {
		return (this.robot != null);
	}
	public void colorerCase() {
		if(this.possedeUnRobot()) {
			this.carre.setOpacity(1);
			this.carre.setFill(this.robot.getColor());
		} else {
			this.carre.setFill(Color.WHITE);
		}
	}
	public void retirerrobot() {
		this.robot = null;
		this.carre.setFill(Color.WHITE);
		this.carre.setOpacity(0);
	}
	

	public void marqueruneCible(String cible) {
		this.cible = cible;
	}

	public void retireruneCible() {
		this.cible = "";
	}

	public String MaCible() {
		return this.cible;
	}

	public boolean isMurhaut() {
		return murhaut;
	}

	public boolean isMurbas() {
		return murbas;
	}

	public boolean isMurgauche() {
		return murgauche;
	}

	public boolean isMurdroit() {
		return murdroit;
	}

	public void setMurhaut(boolean murhaut) {
		this.murhaut = murhaut;
	}

	public void setMurbas(boolean murbas) {
		this.murbas = murbas;
	}

	public void setMurgauche(boolean murgauche) {
		this.murgauche = murgauche;
	}

	public void setMurdroit(boolean murdroit) {
		this.murdroit = murdroit;
	}

	public void caseRemiseAZero() {
		this.cible = "";
		this.murhaut = false;
		this.murbas = false;
		this.murgauche = false;
		this.murdroit = false;
	}

	public void casePleine() {
		this.murhaut = true;
		this.murbas = true;
		this.murgauche = true;
		this.murdroit = true;
	}

	public void angleBD() {
		this.murbas = true;
		this.murdroit = true;
	}

	public void angleBG() {
		this.murbas = true;
		this.murgauche = true;
	}

	public void angleHD() {
		this.murhaut = true;
		this.murdroit = true;
	}

	public void angleHG() {
		this.murhaut = true;
		this.murgauche = true;
	}

	public String getCible() {
		return this.cible;
	}

}
