import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageBuilder {
    public ImageBuilder() {
    	
    }
    
    public static ImageView imageAcceuil() throws IOException {
    	InputStream Acceuil = Files.newInputStream(Paths.get("./ressources/images/Background.jpg"));
  		Image img = new Image(Acceuil);
		Acceuil.close();
		ImageView imgV = new ImageView(img);
		imgV.setFitHeight(720);
		imgV.setFitWidth(1080);
		return imgV;
    	
    }
    public static ImageView menu() throws IOException {
    	InputStream Acceuil = Files.newInputStream(Paths.get("./ressources/images/Background.jpg"));
  		Image img = new Image(Acceuil);
		Acceuil.close();
		ImageView imgV = new ImageView(img);
		imgV.setFitHeight(720);
		imgV.setFitWidth(1080);
		return imgV;
    	
    }
    public static ImageView fondMenu() throws IOException {
    	InputStream fond = Files.newInputStream(Paths.get("./ressources/images/fondmenu.jpg"));
  		Image img = new Image(fond);
		fond.close();
		ImageView imgV = new ImageView(img);
		imgV.setTranslateX(440);
		imgV.setTranslateY(50);
		return imgV;
    	
    }
    public static ImageView menuOption() throws IOException {
    	InputStream option = Files.newInputStream(Paths.get("./ressources/images/optionBackground.jpg"));
  		Image img = new Image(option);
		option.close();
		ImageView imgV = new ImageView(img);
		return imgV;
    	
    }
    public static ImageView play() throws IOException {
    	InputStream play = Files.newInputStream(Paths.get("./ressources/images/play.png"));
  		Image img = new Image(play);
		play.close();
		ImageView imgV = new ImageView(img);
		return imgV;
    }
    public static ImageView pause() throws IOException {
    	InputStream pause = Files.newInputStream(Paths.get("./ressources/images/pause.png"));
  		Image img = new Image(pause);
		pause.close();
		ImageView imgV = new ImageView(img);
		return imgV;
    }
    public static ImageView off() throws IOException {
    	InputStream off = Files.newInputStream(Paths.get("./ressources/images/off.png"));
  		Image img = new Image(off);
		off.close();
		ImageView imgV = new ImageView(img);
		return imgV;
    }
    public static ImageView imageCible(String s) throws IOException {
    	InputStream off;
    	if(s.equals("1")) {
    		 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible1.png"));
    	}
    	else if(s.equals("2")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible2.png"));
        	}
    	else if(s.equals("3")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible3.png"));
        	}
    	else if(s.equals("4")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible4.png"));
        	}
    	else if(s.equals("5")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible5.png"));
        	}
    	else if(s.equals("6")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible6.png"));
        	}
    	else if(s.equals("7")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible7.png"));
        	}
    	else if(s.equals("8")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible8.png"));
        	}
    	else if(s.equals("9")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible9.png"));
        	}
    	else if(s.equals("10")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible10.png"));
        	}
    	else if(s.equals("11")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible11.png"));
        	}
    	else if(s.equals("12")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible12.png"));
        	}
    	else if(s.equals("13")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible13.png"));
        	}
    	else if(s.equals("14")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible14.png"));
        	}
    	else if(s.equals("15")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible15.png"));
        	}
    	else if(s.equals("16")) {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible16.png"));
        	}
    	else  {
        	 off = Files.newInputStream(Paths.get("./ressources/images/Cible/cible17.png"));
        	}
  		Image img = new Image(off);
		off.close();
		ImageView imgV = new ImageView(img);
		return imgV;
    }
}