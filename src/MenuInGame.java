import java.io.IOException;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;


public class MenuInGame extends Parent {
	AffichagePlateau plateau ;
	ImageView couleurRobot;
	ButtonInGame play;
	ButtonInGame pause;
	ButtonInGame quitter;
	Button startSablier;
	Button finSablier;
	Pane root;
	ChoiceBox<String> boxrobot = new ChoiceBox<>();
		public MenuInGame(AffichagePlateau plateau) throws IOException {
			Pane root = new Pane();
			final MediaPlayer mediaPlayer = MediaBuilder.sonJeu();
	  		root.setPrefSize(300,1920);
	  		root.setStyle("-fx-background-color: #808080;");
	  		root.setOpacity(0.6);
	  		this.plateau = plateau;
	  		ChoiceBox<String> boxrobot = new ChoiceBox<>();
	  		boxrobot.getItems().add("rouge");
	  		boxrobot.getItems().add("bleu");
	  		boxrobot.getItems().add("vert");
	  		boxrobot.getItems().add("jaune");
	  		VBox box = new VBox(10);
	  		box.setPadding(new Insets(20,20,20,20));
	  		box.getChildren().addAll(boxrobot);
	  		ImageView imgCible = ImageBuilder.imageCible(this.plateau.getPlateau().getObjectif());
	  		Text cibleT = TextBuilder.menuCible();
	  		Text robotchoix = TextBuilder.robotchoix();
			imgCible.setFitHeight(50);
			imgCible.setFitWidth(50);
	  		pause = new ButtonInGame(ImageBuilder.pause());
	  		pause.setOnMouseClicked(event ->{
		  		mediaPlayer.setMute(true);
		  		});
			play = new ButtonInGame(ImageBuilder.play());
			play.setOnMouseClicked(event ->{
				mediaPlayer.play();
			});
			quitter = new ButtonInGame(ImageBuilder.off());
			quitter.setOnMouseClicked(event ->{
				System.exit(0);
			});
			startSablier = new Button("Activer sablier");
		  	finSablier = new Button("Stopper sablier");
		  	imgCible.setTranslateX(150);
			imgCible.setTranslateY(390);
			cibleT.setTranslateX(5);
			cibleT.setTranslateY(430);
			robotchoix.setTranslateX(5);
			robotchoix.setTranslateY(470);
			boxrobot.setTranslateX(5);
			boxrobot.setTranslateY(480);
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
		  	root.getChildren().addAll(imgCible,cibleT,box,robotchoix,pause,play,quitter,startSablier,finSablier);
			getChildren().addAll(root);
			boxrobot.getSelectionModel().selectedItemProperty().addListener( (v,OldValue , NewValue) ->{
		  		if(NewValue.equals("rouge")) {
		  			System.out.println("vous avez sélectionner le robot rouge.");
		  			plateau.getPlateau().selectionRobotCouleur(true,false,false,false);
		  		}
		  		else if (NewValue.equals("bleu")) {
		  			System.out.println("vous avez sélectionner le robot bleu.");
		  			plateau.getPlateau().selectionRobotCouleur(false,false,true,false);
		  		}
		  		else if (NewValue.equals("vert")) {
		  			System.out.println("vous avez sélectionner le robot vert.");
		  			plateau.getPlateau().selectionRobotCouleur(false,true,false,false);
		  		}
		  		else {
		  			System.out.println("vous avez sélectionner le robot jaune.");
		  			plateau.getPlateau().selectionRobotCouleur(false,false,false,true);
		  		}
		  		});
		}
		public String choixrobot() {
			String robot = boxrobot.getValue();
			return robot;
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

		public Pane getroot() {
			return root;
		}
		
}
