import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//dodaju se dodatci za aplet runnable i key listener kako bi èuli tipkovnicu, pritom pri dnu dobijamo još novih metoda 

public class StartingPoint extends Applet implements Runnable, KeyListener {
	
	
	
	private Image i;
	private Graphics doubleG;
	Ball b;

	Platform p,p2,p3;

	
	
	// INIT METODA INICIJALIZACIJE (inicijalizira ekran od 800 600)
	
	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);  
	}
	
	
	// START METODA STARTANJA LOPTI UNUTAR OKVIRA 
	
	@Override
	public void start() {	
		
		b = new Ball();
		 
		p = new Platform();//platforma 
		p2= new Platform(100, 425);
		p3= new Platform(500, 200);
		
		Thread thread = new Thread(this);
		thread.start(); 
							
		}
	
	// UPDATE METODA SREÐIVANJA GRAFIKE POKRETA
	
	@Override
	public void update(Graphics g) {
		
		// TODO Auto-generated method stub
		if (i == null) {
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();			
		}
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		
		g.drawImage(i, 0, 0, this);
		
	}		
	
	//RUN METODA ZAKONITOSTI KRETANJA
	
	@Override
		public void run() {
		
			// TODO Auto-generated method stub
			//tread information
			
		while (true) {
			
			b.update(this);
		
			p.update(this, b); //stavili smo b jer pri updateu kontroliramo loptu b
			p2.update(this, b);
			p3.update(this, b);
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		}
	
	
	@Override
	public void stop() {
		
		super.stop();
	}
	
	@Override
	public void destroy() {
	
		super.destroy();
	}
	
	// METODA GRAFIKE
	
	@Override
	public void paint(Graphics g) {
		b.paint(g);
		
		p.paint(g);
		p2.paint(g);
		p3.paint(g);
	
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			b.moveLeft();
			break;
			
		case KeyEvent.VK_RIGHT:
			b.moveRight();
			break;			
			
			
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
