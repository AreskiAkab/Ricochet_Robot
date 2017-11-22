    import java.io.File;
    import java.io.IOException;
    import java.io.InputStream;
    import java.nio.file.Files;
    import java.nio.file.Paths;
import java.util.Scanner;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration; 
public class Main extends Application { 

		public static void main(String [] args) { 
			launch(args); 
		}
        @Override
		public void start(Stage menu) throws IOException {
        	//----------------ECRAN 1--------------------------------//
        	Pane root = new Pane();
        	Timer sablier = new Timer();
        	AffichagePlateau plateau = new AffichagePlateau();
        	MenuInGame menuJeu = new MenuInGame(plateau);
        	menuJeu.setVisible(false);
			ImageView imgV = ImageBuilder.imageAcceuil(); 
			imgV.setFocusTraversable(true); 
			root.setOnKeyPressed(keyEvent -> {
            	System.out.println(keyEvent.getText());
            	if(keyEvent.getText().equals("&")) {
            		System.out.println("vous avez sélectionner le robot rouge.");
            		plateau.getPlateau().selectionRobotCouleur(true,false,false,false);
            	}
            	if(keyEvent.getText().equals("é")) {
            		System.out.println("vous avez sélectionner le robot bleu.");
            		plateau.getPlateau().selectionRobotCouleur(false,false,true,false);
            	}
            	if(keyEvent.getText().equals("" + '"')) {
            		System.out.println("vous avez sélectionner le robot vert.");
            		plateau.getPlateau().selectionRobotCouleur(false,true,false,false);
            	}
            	if(keyEvent.getText().equals("'")) {
            		System.out.println("vous avez sélectionner le robot jaune.");
            		plateau.getPlateau().selectionRobotCouleur(false,false,false,true);
            	}
            	if(keyEvent.getText().equals("z")) {
            		System.out.println("je me déplace vers le haut");
					plateau.getPlateau().deplacementHaut();
				}
            	if(keyEvent.getText().equals("s")) {
            		System.out.println("je me déplace vers le bas");
						plateau.getPlateau().deplacementBas();
				}
            	if(keyEvent.getText().equals("d")) {
            		System.out.println("je me déplace vers la droite");
						plateau.getPlateau().deplacementdroite();
				}
            	if(keyEvent.getText().equals("q")) {
            		System.out.println("je me déplace vers la gauche");
						plateau.getPlateau().deplacementgauche();
				}
            	
            });
	        final MediaPlayer mediaPlayer = MediaBuilder.sonJeu(); 
			root.setPrefSize(1080, 720);
			GameMenu gamemenu = new GameMenu();
			GameMenuOption moption = new GameMenuOption();
			gamemenu.gamemenuoption = moption;
			moption.menu = gamemenu;
			moption.setVisible(false);
			gamemenu.setVisible(true);
			plateau.setVisible(false);
			Button IA = new Button("I.A");
			menuJeu.getPlay().setOnMouseClicked(event ->{
				mediaPlayer.setMute(false);
			});
			menuJeu.getPause().setOnMouseClicked(event ->{
	  		mediaPlayer.setMute(true);
	  		});
			plateau.setTranslateX(10);
			plateau.setTranslateY(100);
	  		IA.setTranslateX(450);
	  		IA.setTranslateY(350);
	  		menuJeu.getSSablier().setOnMouseClicked(event ->{
	  			sablier.startTimer();
	  			long seconds = sablier.checkTimer();
	  				System.out.println(seconds);
	  		});
	  		menuJeu.getFSablier().setOnMouseClicked(event ->{
		  			sablier.checkTimer();
		  		});
	  		Text titre = TextBuilder.titreFenetre();
			Button Start = new Button("JOUEUR VS JOUEUR");
			Start.setOnMouseClicked(event ->{
				menuJeu.setVisible(true);
				mediaPlayer.play(); 
				plateau.setVisible(true);
				Start.setVisible(false);
				IA.setVisible(false);
				titre.setTranslateX(700);
				titre.setTranslateY(100);
				imgV.setFitHeight(1080);
				imgV.setFitWidth(1920);
				root.setPrefSize(1920,1080);
				plateau.setTranslateX(800);
				plateau.setTranslateY(200);
	  		});
			Start.setTranslateX(450);
	  		Start.setTranslateY(300);
	  		
			menuJeu.getQuitter().setOnMouseClicked(event ->{
				System.exit(0);
			});
			root.getChildren().addAll(imgV,plateau,IA,Start,menuJeu,gamemenu, moption, titre);		
			Scene scene = new Scene(root);
			menu.setScene(scene);
			menu.show();
			menu.setTitle("Ricochet Robots");
		}

	

		
	
}	

