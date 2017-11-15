import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class ButtonInGame extends StackPane {
	ImageView image;
	public ButtonInGame(ImageView img){
		 Rectangle rt = new Rectangle(100,60);
		  rt.setOpacity(0);
		  rt.setFill(Color.GREY);
		  setAlignment(Pos.CENTER);
		  image = img ;
		  image.setFitHeight(60);
		  image.setFitWidth(100);
		  getChildren().addAll(rt,image);
		
	}
}
