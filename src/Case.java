import javafx.scene.layout.StackPane;


public class Case extends StackPane {
	private boolean murhaut;
	private boolean murbas;
	private boolean murgauche;
	private boolean murdroit;
	private String cible;
	private Robot robot;
	private int coordonneeX;
	private int coordonneeY;
	private int distance;

	public Case(int x, int y) {
		this.coordonneeX = x ;
		this.coordonneeY = y ;
		murhaut = false;
		murbas = false;
		murgauche = false;
		murdroit = false;
		cible = "";
		distance = 0;
		
	}
	public void setDistance(int n){
		this.distance=n;
	}
	public int getDistance(){
		return this.distance;
	}
	public Robot getRobot() {
		return this.robot;
	}

	public void ajoutRobot(Robot r) {
		this.robot = r;
		r.setCoordonnee(this.coordonneeX, this.coordonneeY);
		//System.out.println(this.coordonneeY+" "+this.coordonneeX);
	}


	public boolean possedeUnRobot() {
		return (this.robot != null);
	}
	
	public void retirerrobot() {
		this.robot = null;
		
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
	
	public int getCoordonneeX() {
		
		return this.coordonneeX;
	}
	
	public int getCoordonneeY() {
		
		return this.coordonneeY;
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
	
	public boolean equals(Object o){
		if(!(this instanceof Object)){
			return false;
		}
		Case a = (Case) o;
		if(this.coordonneeX == a.coordonneeX && this.coordonneeY == a.coordonneeY){
			return true;
		}
		else{
			return false;
		}
		
	}

}
