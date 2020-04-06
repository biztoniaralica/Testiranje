import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	
	int dx;
	int x , y , width , height ;
	
	//konstruktor je blok naredbi koji inicijalizira stvar
	
	
	public Platform() {
		// TODO Auto-generated constructor stub
		dx = -10;	
		x = 300;
		y = 300;
		width = 120;
		height = 40;
	}
		
	public Platform (int x,int y){
			this.x = x;
			this.y = y;
			width = 120;
			height = 40;
			dx = -10;
			
		
	}
	
	//tu æemo privjeravat koliziju
	
public void update(StartingPoint sp, Ball b) {
	checkForColision(b);
				
	}	
	
	private void checkForColision(Ball b) {
		// TODO Auto-generated method stub
		int ballx = b.getX();
		int bally = b.getY();
		int radius = b.getRadius();
		
		if (bally + radius > y && bally + radius < y + height) {
			if (ballx > x && ballx < x + width) {
				
				double newDY = b.getGameDy();
				b.setY(	y-radius);
			     b.setDy(newDY);
		}
		
		
		}		
		
	}

	public void paint (Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
		g.fillRect(x, y, width, height);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
