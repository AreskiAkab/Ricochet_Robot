
import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaBuilder {
	public MediaBuilder() {
	}
	 public static MediaPlayer sonJeu(){
		 final File file = new File("./ressources/Sons/jeux.mp3"); 
	        final Media media = new Media(file.toURI().toString()); 
	        final MediaPlayer mediaPlayer = new MediaPlayer(media); 
	        mediaPlayer.setVolume(0.1);
			return mediaPlayer;
	    	
	    }
}
