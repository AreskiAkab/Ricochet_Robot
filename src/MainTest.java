
public class MainTest {
	public static void main(String[] args) {
		
		Plateau p=new Plateau();
		Deplacement d = new Deplacement(p.getBleu(),p);
		Case[] tableau=d.calculDeplacer();
		for(int i=0;i<=3;i++) {
			System.out.println("Coordonnee x : "+tableau[i].getCoordonneeX()+" Coordonnee y : "+tableau[i].getCoordonneeY());
			
		}
	}
}
