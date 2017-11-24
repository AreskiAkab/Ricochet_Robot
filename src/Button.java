import java.io.IOException;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;


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
