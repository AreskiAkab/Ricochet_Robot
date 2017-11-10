import javafx.scene.paint.Color;
public class Robot {
	private int cX;
	private int cY;
	private Color color;
	private boolean selection; 
	public Robot(Color color) {
		this.selection = false;
		this.color = color;	
	}
	public Color getColor() {
		return this.color;
	}
	public void setCoordonnee(int x,int y) {
		cX = x;
		cY = y;
	}
public void setSelection(boolean b) {
	this.selection = b;
}
	public int getCoordonneeX() {
		return this.cX;
	}
	public int getCoordonneeY() {
		return this.cY;
	}
	public void seDeplace() {
	
		
	}

}
