
    import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application { 

		public static void main(String [] args) { 
			launch(args); 
		}
        @Override
		public void start(Stage menu) throws IOException {
        	//----------------ECRAN 1--------------------------------//
        	Pane root = new Pane();
        	Timer sablier = new Timer();
        	Plateau p = new Plateau();
        	Deplacement c = new Deplacement();
        	AffichagePlateau plateau = new AffichagePlateau(p);
        	MenuInGame menuJeu = new MenuInGame(plateau);
        	menuJeu.setVisible(false);
			ImageView imgV = ImageBuilder.imageAcceuil(); 
			imgV.setFocusTraversable(true);  
			root.setPrefSize(1920, 1080);
			GameMenu gamemenu = new GameMenu();
			GameMenuOption moption = new GameMenuOption();
			gamemenu.gamemenuoption = moption;
			moption.menu = gamemenu;
			moption.setVisible(false);
			gamemenu.setVisible(true);
			plateau.setVisible(false);
			plateau.setTranslateX(10);
			plateau.setTranslateY(100);
	  		Text titre = TextBuilder.titreFenetre();
			titre.setTranslateX(700);
			titre.setTranslateY(100);
			imgV.setFitHeight(1080);
			imgV.setFitWidth(1920);
			root.setPrefSize(1920,1080);
			plateau.setTranslateX(800);
			plateau.setTranslateY(200);
			Controller controller = new Controller(p,c,sablier,root,plateau,gamemenu, menuJeu);
			controller.controllerMain();
			root.getChildren().addAll(imgV,plateau,menuJeu,gamemenu, moption, titre);		
			Scene scene = new Scene(root);
			menu.setScene(scene);
			menu.show();
			menu.setTitle("Ricochet Robots");
		}

	

		
	
}	

