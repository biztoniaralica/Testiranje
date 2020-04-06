import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private int x=400;
	private int y=25;
	private int radius=20;
	private double dx=0;
	private double dy=0;            //stavljeni su double jer mogu postati veliki brojevi
	private double gravity = 15;
	private double energyloss = 1;  //private znaèi da samo ball može imati pristup ovim varijablama
	private double dt = .2;
	private double xFriction = .9;
	
	//metoda koja nam updata fiziku, dobivamo grešku nakon kopiranja tada upisujemo startingpoint u našu metodu 
	// tada mjenjamo našu metodu "this" u "sp", najbolje sa find replace alatom
	
	
	//dodavanje defaultnog konstruktora
	
	public Ball() {
		// TODO Auto-generated constructor stub
	}
	
	public Ball(int i, int j) {
		// TODO Auto-generated constructor stub
		x = i;
		y = j; //dodavanje vrijednosti kako lopta ne bi krenula sa istog položaja
	}
	
	//dodajemo metode kako bi imali poziciciju parametara u bilo kojem momentu ctrl space
	
	public int getRadius() {
		return radius;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getDx() {
		return dx;
	}
	
	public double getDy() {
		return dy;
	}
	
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public void setDy(double dy) {
		this.dy = dy;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	
	
	
	
	
	
	
	
	
	//metode za pokret lijevo ili desno dx ako se kreæe desno je pozitivan ako se kreæe lijevo je negativan
	
	public void moveRight() {
		
		if (dx+1 < 20) {
			dx += 1;			
		}
			}
	
    public void moveLeft() {
		
		if (dx-1 > -20) {
			dx -= 1;			
		}
			}
	
	
	

	public void update(StartingPoint sp) {
		
		if (x + dx > sp.getWidth() - radius -1) {
			x = sp.getWidth() - radius -1;
			dx = -dx;
		}if (x + dx < 0 + radius + 1) {
			x=0 + radius +1;
			dx = -dx;			
		} else {
		    x+=dx;				
		}
		
		//gubitak momentuma na x osi
		
		if (y == sp.getHeight()-radius-1) {
			dx*= xFriction;
			
			// absolutna vrijednost dx-a nema minusa da bi radio probleme
			
			if (Math.abs(dx)  < .8) {
				dx = 0;	
				
			}
					}
		
		
		if (y > sp.getHeight() - radius -1) {
			y = sp.getHeight() - radius -1;
			dy *= energyloss; // usporavanje radi gravitacije
			dy = -dy;	
		}	else {
			//formula za brzinu
			dy += gravity*dt;
			//pozicijska formula
			y += dy*dt + .5*gravity*dt*dt;
		}
			
	}
	
	//preseljena metoda grafike, mora se napraviti import grafike 
	
	public void paint (Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
		
		
	}
	

}
