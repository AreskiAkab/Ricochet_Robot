import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public  class Button extends StackPane{
		  public Button(String name) throws IOException{
			  final PhongMaterial material = new PhongMaterial(Color.GREY); 
			  final Box rt = new Box(250, 30, 50);
			 /* InputStream texture = Files.newInputStream(Paths.get("./ressources/images/fondmenu.jpg"));
			  final Image diffuseMap = new Image(texture);
			  texture.close();
			  final PhongMaterial material = new PhongMaterial(Color.WHITE, diffuseMap, null, null, null);*/  
			  rt.setRotationAxis(Rotate.Y_AXIS); 
			  Text text = new Text(name);
			  text.setFont(Font.font(20));
			  text.setFill(Color.WHITE);
			  text.setRotationAxis(Rotate.Y_AXIS);
			  text.setRotate(40); 
			  rt.setMaterial(material);
			  getChildren().addAll(rt,text);
			  
			  setOnMouseEntered(event -> {
				 // rt.setMaterial(new PhongMaterial(Color.BLUE));
				  text.setFill(Color.BLACK);
			  });
			  setOnMouseExited(event -> {
				  //rt.setMaterial(new PhongMaterial(Color.GREY));
				  text.setFill(Color.WHITE);
			  });
			  
		  }
	  }
