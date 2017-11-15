import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class AffichagePlateau extends StackPane {
	private Plateau plateau;
	public AffichagePlateau() throws IOException {
		plateau = new Plateau();
		final StackPane root = new StackPane(); 
		InputStream Acceuil = Files.newInputStream(Paths.get("./ressources/images/Robots.jpg"));
		Image img = new Image(Acceuil);
		Acceuil.close();
		ImageView imgV = new ImageView(img);
		imgV.setFitHeight(720);
		imgV.setFitWidth(1080);
		double posXcase = 0;
		double posYcase = 0;
		for (int i = 0; i < 16; i++) {
			posYcase = posYcase - 44.6;
			posXcase =0;
			for (int j = 0; j < 16; j++) {
				plateau.getCase(i, j).setAlignment(Pos.CENTER);
				plateau.getCase(i, j).setTranslateX(posXcase);
				plateau.getCase(i, j).setTranslateY(posYcase);
				posXcase = posXcase + 67.3;
				root.getChildren().addAll(plateau.getCase(i, j));
			}
		}
		root.setTranslateX(-502);
		root.setTranslateY(380);
		getChildren().addAll(imgV,root);
	}
	public Plateau getPlateau() {
		return plateau;
	}

}
