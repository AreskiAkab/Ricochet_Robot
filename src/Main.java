    import java.io.File;
    import java.io.IOException;
    import java.io.InputStream;
    import java.nio.file.Files;
    import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        	Plateau plateau = new Plateau();
        	InputStream Acceuil = Files.newInputStream(Paths.get("./ressources/images/Background.jpg"));
	  		Image img = new Image(Acceuil);
			Acceuil.close();
			ImageView imgV = new ImageView(img);
			imgV.setFitHeight(720);
			imgV.setFitWidth(1080);
			final File file = new File("./ressources/Sons/jeux.mp3"); 
	        final Media media = new Media(file.toURI().toString()); 
	        final MediaPlayer mediaPlayer = new MediaPlayer(media); 
	        mediaPlayer.setVolume(0.1);
			root.setPrefSize(1080, 720);
			GameMenu gamemenu = new GameMenu();
			GameMenuOption moption = new GameMenuOption();
			gamemenu.gamemenuoption = moption;
			moption.menu = gamemenu;
			moption.setVisible(false);
			//moption.setOpacity(0.7);
			gamemenu.setVisible(true);
			plateau.setVisible(false);
			Button IA = new Button("I.A");
			Button couperSon = new Button("COUPER LE SON");
			Button jouerSon = new Button("Relancer");
			jouerSon.setOnMouseClicked(event ->{
				mediaPlayer.setMute(false);
			});
	  		couperSon.setOnMouseClicked(event ->{
	  		mediaPlayer.setMute(true);});
	  		jouerSon.setVisible(false);
	  		couperSon.setVisible(false);
			plateau.setTranslateX(10);
			plateau.setTranslateY(100);
	  		IA.setTranslateX(450);
	  		IA.setTranslateY(350);
			//gamemenu.setOpacity(0.7);
			Text Titre = new Text("Ricochet Robots");
			Titre.setFont(Font.font("game robot", 70));
			Titre.setFill(Color.WHITE);
			Titre.setTranslateX(300);
			Titre.setTranslateY(100);
			Button Start = new Button("JOUEUR VS JOUEUR");
			Start.setOnMouseClicked(event ->{
				mediaPlayer.play(); 
				jouerSon.setVisible(true);
				couperSon.setVisible(true);
				plateau.setVisible(true);
				//plateau.toString();
				Start.setVisible(false);
				IA.setVisible(false);
				menu.setFullScreen(true);
				Titre.setTranslateX(700);
				Titre.setTranslateY(100);
				imgV.setFitHeight(1080);
				imgV.setFitWidth(1920);
				root.setPrefSize(1920, 1080);
				plateau.setTranslateX(800);
				plateau.setTranslateY(200);
	  		});
			Start.setTranslateX(450);
	  		Start.setTranslateY(300);
	  		Button quitter = new Button("QUITTER");
			quitter.setOnMouseClicked(event ->{
				System.exit(0);
			});
			couperSon.setTranslateY(10);
			couperSon.setTranslateX(10);
			jouerSon.setTranslateY(50);
			jouerSon.setTranslateX(10);
			quitter.setTranslateY(90);
			quitter.setTranslateX(10);
			root.getChildren().addAll(imgV,plateau,IA,Start,quitter,couperSon,jouerSon,gamemenu, moption, Titre);		
			Scene scene = new Scene(root);
			menu.setScene(scene);
			menu.show();
			menu.setTitle("Ricochet Robots");
			
		}

	

		
	
}	

