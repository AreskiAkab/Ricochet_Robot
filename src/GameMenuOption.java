
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameMenuOption extends Parent {
	public GameMenu menu;
	public GameMenuOption() throws IOException {

		Pane root1 = new Pane();
		ImageView imgV = ImageBuilder.menuOption();
		imgV.setFitHeight(720);
		imgV.setFitWidth(1080);
		root1.setPrefSize(900, 700);
		VBox menuO = new VBox(30);
		menuO.setTranslateX(200);
		menuO.setTranslateY(200);
		Button Affichage = new Button("AFFICHAGE");
		root1.getChildren().addAll(imgV,menuO);
		getChildren().addAll(root1);
		Button Retour = new Button("RETOUR");
		Retour.setOnMouseClicked(event -> {
			this.setVisible(false);
			menu.setVisible(true);
			

		});

		menuO.getChildren().addAll(Affichage, Retour);

	}

	
}
