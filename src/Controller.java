import javafx.scene.layout.Pane;

public class Controller {
	AffichagePlateau plateau;
	Plateau p; 
	Deplacement d;
	Timer sablier;
	Pane root;
	Button[] tabButton;
	MenuInGame menuJeu;
		Controller(Plateau p, Deplacement d,Timer sablier,Pane root,AffichagePlateau plateau,Button[] tabButton,MenuInGame menuJeu ) {
			this.menuJeu = menuJeu;
			this.plateau = plateau;
			this.p = p;
			this.d = d;
			this.sablier = sablier;
			this.root = root;
			this.tabButton = tabButton;
			
		}
		public void controllerMain(){
			root.setOnKeyPressed(keyEvent -> {
            	System.out.println(keyEvent.getText());
            	if(keyEvent.getText().equals("&")) {
            		System.out.println("vous avez sélectionner le robot rouge.");
            		p.selectionRobotCouleur(true,false,false,false);
            	}
            	if(keyEvent.getText().equals("é")) {
            		System.out.println("vous avez sélectionner le robot bleu.");
            		p.selectionRobotCouleur(false,false,true,false);
            	}
            	if(keyEvent.getText().equals("" + '"')) {
            		System.out.println("vous avez sélectionner le robot vert.");
            		p.selectionRobotCouleur(false,true,false,false);
            	}
            	if(keyEvent.getText().equals("'")) {
            		System.out.println("vous avez sélectionner le robot jaune.");
            		p.selectionRobotCouleur(false,false,false,true);
            	}
            	if(keyEvent.getText().equals("z")) {
            		System.out.println("je me déplace vers le haut");
					//plateau.getPlateau().deplacementHaut();
            	    d.deplacementr(p.getSelection(),p,plateau,"H");
				}
            	if(keyEvent.getText().equals("s")) {
            		System.out.println("je me déplace vers le bas");
						//plateau.getPlateau().deplacementBas();
            		 d.deplacementr(p.getSelection(),p,plateau,"");
				}
            	if(keyEvent.getText().equals("d")) {
            		System.out.println("je me déplace vers la droite");
						//plateau.getPlateau().deplacementdroite();
            		 d.deplacementr(p.getSelection(),p,plateau,"D");
				}
            	if(keyEvent.getText().equals("q")) {
            		System.out.println("je me déplace vers la gauche");
						//plateau.getPlateau().deplacementgauche();
            		 d.deplacementr(p.getSelection(),p,plateau,"G");
				}
            	
            });
			tabButton[0].setOnMouseClicked(event ->{
				menuJeu.setVisible(true);
				//mediaPlayer.play(); 
				plateau.setVisible(true);
				tabButton[0].setVisible(false);
				tabButton[1].setVisible(false);
				/*titre.setTranslateX(700);
				titre.setTranslateY(100);
				imgV.setFitHeight(1080);
				imgV.setFitWidth(1920);
				root.setPrefSize(1920,1080);
				plateau.setTranslateX(800);
				plateau.setTranslateY(200);*/
	  		});
			menuJeu.getSSablier().setOnMouseClicked(event ->{
	  			sablier.startTimer();
	  			long seconds = sablier.checkTimer();
	  				System.out.println(seconds);
	  		});
	  		menuJeu.getFSablier().setOnMouseClicked(event ->{
		  			sablier.checkTimer();
		  		});
			
			
		}
}
