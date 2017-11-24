import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextBuilder {
		public TextBuilder() {
			
		}
		public static Text titreFenetre() {
			Text titre = new Text("Ricochet Robots");
			titre.setFont(Font.font("game robot", 70));
			titre.setFill(Color.WHITE);
			titre.setTranslateX(300);
			titre.setTranslateY(100);
			return titre;
		}
		public static Text menuCible() {
			Text cible = new Text("La cible est");
			cible.setFont(Font.font("game robot", 17));
			cible.setFill(Color.WHITE);
			return cible;
		}
		public static Text robotchoix() {
			Text cible = new Text("Choisissez votre robot dans \n la liste ci-dessous");
			cible.setFont(Font.font("game robot", 16));
			cible.setFill(Color.WHITE);
			return cible;
		}
		
}
