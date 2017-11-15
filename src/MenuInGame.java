import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MenuInGame extends Parent {
	ButtonInGame play;
	ButtonInGame pause;
	ButtonInGame quitter;
	Button startSablier;
	Button finSablier;
		public MenuInGame(AffichagePlateau plateau) throws IOException {
			Pane root = new Pane();
	  		root.setPrefSize(300,1920);
	  		root.setStyle("-fx-background-color: #808080;");
	  		root.setOpacity(0.6);
	  		ImageView imgCible = ImageBuilder.imageCible(plateau.getPlateau().getObjectif());
	  		Text cibleT = TextBuilder.menuCible();
			imgCible.setFitHeight(50);
			imgCible.setFitWidth(50);
	  		pause = new ButtonInGame(ImageBuilder.pause());
			play = new ButtonInGame(ImageBuilder.play());
			quitter = new ButtonInGame(ImageBuilder.off());
			startSablier = new Button("Activer sablier");
		  	finSablier = new Button("Stopper sablier");
		  	imgCible.setTranslateX(150);
			imgCible.setTranslateY(390);
			cibleT.setTranslateX(5);
			cibleT.setTranslateY(430);
		  	pause.setTranslateX(190);
		  	pause.setTranslateY(10);
		  	play.setTranslateX(95);
		  	play.setTranslateY(10);
		  	quitter.setTranslateX(0);
		  	quitter.setTranslateY(10);
		  	startSablier.setTranslateX(10);
		  	startSablier.setTranslateY(100);
		  	finSablier.setTranslateX(10);
		  	finSablier.setTranslateY(150);
		  	root.getChildren().addAll(imgCible,cibleT,pause,play,quitter,startSablier,finSablier);
			getChildren().addAll(root);	
		}
		public Button getSSablier() {
			return startSablier;
		}
		public Button getFSablier() {
			return finSablier;
		}
		public ButtonInGame getPlay() {
			return play;
		}
		public ButtonInGame getPause() {
			return pause;
		}
		public ButtonInGame getQuitter() {
			return quitter;
		}
		
}
