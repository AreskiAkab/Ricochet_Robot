
public class MainTest {
	public static void main(String[] args) {
		
		Plateau p=new Plateau();
		
		Deplacement d = new Deplacement(p.getRouge(),p);
		
		//Case[] tableau=d.calculDeplacer(d.getPlateau().getCase(15,15));
		//System.out.println("case robot  " + d.getPlateau().getCase(d.r.getCoordonneeX(),d.r.getCoordonneeY()));
		//System.out.println("case robot x= " + d.r.getCoordonneeX() + " y =  " + d.r.getCoordonneeY());
		/*for(int i=0;i<=3;i++) {
			System.out.println("Coordonnee x : "+tableau[i].getCoordonneeX()+" Coordonnee y : "+tableau[i].getCoordonneeY());
		}*/
		//System.out.println("case x " + tableau[2].getCoordonneeX() + " y  " + tableau[2].getCoordonneeY());
		//System.out.println(p);
		System.out.println(d.calculChemin());
	}
}
