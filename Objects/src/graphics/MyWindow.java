package graphics;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class MyWindow extends JFrame implements KeyListener{
	
	int width = 1000;
	int height = 800;
	Hero coolDoge;
	Hero doge;
	boolean itemPickedUp;
	BufferedImage landscape;
	
	public static void main(String[] args){
		new MyWindow();
	}
	
	public MyWindow(){
		//the following are JFrame methods
		coolDoge = new Hero("Girl", "/images/heroes/doge.png", 650, 500);
		doge = new Hero("Girl", "/images/heroes/doge2.png", 50, 50);
		itemPickedUp = false;
		landscape = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		
		setVisible(true);
		setSize(width, height); //units in px
		setLocation(200, 150); //200 px right, 150 px down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //static constant reference for special close operation
		addKeyListener(this);
	}
	
	public void paint(Graphics g){
		//Graphics is a crayon box
		//Graphics2d is like an art kit
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();
//		g2.setColor(Color.white);
//		g2.fillRect(0, 0, width, height);
//		
//		g2.setColor(Color.blue);
//		g2.fillOval(50, 100, 100, 100);
//		g2.setColor(Color.blue);
//		g2.drawOval(50, 100, 100, 100);
//		g2.setColor(Color.blue);
//		g2.fillOval(250, 100, 100, 100);
//		g2.setColor(Color.blue);
//		g2.drawOval(250, 100, 100, 100);
//		
//		g2.drawArc(50, 300, 300, 100, 180, 180); //x, y, width, height, startDEG, lengthDEG
//		
//		g2.drawString("Stringsssss", 300, 300); //string, x, y
		
//		g2.drawLine(0, 0, width, height); //startX, startY, endX, endY
		
//		g2.setColor(Color.blue);
//		int squareD = 20;
//		int margin = 2;
//		for(int x = 0; x < width; x += squareD + margin){
//			for(int y = 0; y < height; y += squareD + margin){
//				g2.fillRect(x, y, squareD, squareD);
//				int r = (int)(Math.random() * (255 + 1));
//				int b = (int)(Math.random() * (255 + 1));
//				int a = (int)(Math.random() * (255 + 1));
//				g2.setColor(new Color(r, b, a));
//			}
//		}
		
		g2.setColor(new Color(50, 100, 200));
		g2.fillRect(0, 0, width, height);
		g2.drawImage(landscape, 0, 0, null);		
		//paintLandscape(g2);
		g2.drawImage(coolDoge.getImage(), coolDoge.getX(), coolDoge.getY(), null);
		if(Math.abs(coolDoge.getX() - doge.getX()) + Math.abs(coolDoge.getY() - doge.getY()) < 35) itemPickedUp = true;
		if(!itemPickedUp) g2.drawImage(doge.getImage(), doge.getX(), doge.getY(), null);
		g.drawImage(image, 0, 0, null); //draw the bufferedimage on the canvas
	}

	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if(key == KeyEvent.VK_UP){
			coolDoge.moveUp();
		} else if(key == KeyEvent.VK_DOWN){
			coolDoge.moveDown();
		} else if(key == KeyEvent.VK_RIGHT){
			coolDoge.moveRight();
		} else if(key == KeyEvent.VK_LEFT){
			coolDoge.moveLeft();
		}
		repaint();
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
