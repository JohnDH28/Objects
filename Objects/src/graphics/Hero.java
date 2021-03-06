package graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Hero {

	BufferedImage sprite;
	String name;
	int x;
	int y;
	
	public Hero(String name, String imageLocation, int locationX, int locationY){
		this.name = name;
		x = locationX;
		y = locationY;
		int width = 200;
		int height = 200;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageLocation);
		try{
			BufferedImage original = ImageIO.read(url); //read only to prevent image from being changed
			//draw the image file into a scaled version on the sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			//what to draw, where to start (x, y), width/height of canvas, 
			//where to start from orginal (x, y), width/height of original, null
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BufferedImage getImage() {
		return sprite;
	}

	public String getName() {
		return name;
	}
	
	public void moveUp(){
		y -= 10;
	}
	
	public void moveDown(){
		y += 10;
	}
	
	public void moveRight(){
		x += 10;
	}
	
	public void moveLeft(){
		x -= 10;
	}
}
