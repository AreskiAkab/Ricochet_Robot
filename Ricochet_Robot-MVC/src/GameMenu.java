    
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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration; 

public class GameMenu extends Parent {
	GameMenuOption gamemenuoption;
	Button start;
		  	public GameMenu() throws IOException {  
		  		Pane root = new Pane();
		  
		       
				  
		  		root.setPrefSize(900, 700);
				ImageView imgV = ImageBuilder.menu();
		  		VBox menu = new VBox(30);
		  		menu.setTranslateX(450);
		  		menu.setTranslateY(200);
		  		start = new Button("START");
		  		start.setOnMouseClicked(event -> {
		  		FadeTransition ft = new FadeTransition(Duration.seconds(0.75),this);
		  		ft.setFromValue(1);
		  		ft.setToValue(0);
		  		ft.setOnFinished(evt -> this.setVisible(false));
		  		ft.play();
		  		});
		  		menu.getChildren().addAll(start);
		  		root.getChildren().addAll(imgV,menu);
		  		getChildren().addAll(root);
		  		Button option = new Button("OPTION");
		  		option.setOnMouseClicked(event ->{
		  			this.setVisible(false);
		  			gamemenuoption.setVisible(true);
		  			
		  		});
		  		Button exit = new Button("QUITTER");
		  		Button Multiplayer = new Button("MULTIPLAYER");
		  		Button Test = new Button("TEST");
		  		
		  		Button IA = new Button("NIVEAU I.A");
		  		
		  		exit.setOnMouseClicked(event -> {
		  			System.exit(0);
		  		});
		  		menu.getChildren().addAll(IA);
		  		menu.getChildren().addAll(option);
		  		menu.getChildren().addAll(exit);
		  		
			}
		  	
		  	public Button getStart() {
		  		return this.start;
		  	}

			
	  }

