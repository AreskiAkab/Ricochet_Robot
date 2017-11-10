import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class Button extends StackPane{
	//bonjour bitch
		  Button(String name){
			  Text text = new Text(name);
			  text.setFont(Font.font(20));
			  text.setFill(Color.WHITE);
			  
			  Rectangle rt = new Rectangle(250,30);
			  rt.setOpacity(0.8);
			  rt.setFill(Color.GREY);
			  setAlignment(Pos.CENTER);
			  getChildren().addAll(rt,text);
			  
			  setOnMouseEntered(event -> {
				  rt.setFill(Color.BLUE);
				  text.setFill(Color.WHITE);
			  });
			  setOnMouseExited(event -> {
				  rt.setFill(Color.GREY);
				  text.setFill(Color.WHITE);
			  });
			  
		  }
	  }
