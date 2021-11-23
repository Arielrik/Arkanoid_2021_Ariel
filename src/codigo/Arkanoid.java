package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Arkanoid extends GraphicsProgram{
	
	static final int ladrilloAncho = 35;
	static final int ladrilloAlto = 15;
	
	int anchoPantalla = 800;
	int altoPantalla = 800;
	
	int cursorAncho = 60;
	int cursorAlto = 10;
	int cursorX = 350;
	int cursorY = 500;
	Cursor miCursor = new Cursor(cursorX,cursorY,cursorAncho,cursorAlto, Color.GREEN);

	
	int bolaX = 10;
	int bolaY = 10;
	Bola bola1 = new Bola(bolaX,bolaY, Color.BLUE, 1,1);
	//Bola bola2 = new Bola(bolaX,bolaY, Color.BLUE, 1,1);
	//Bola bola3 = new Bola(bolaX,bolaY, Color.BLUE, 1,1);

		
	public void init(){
		setSize(anchoPantalla, altoPantalla);
		addMouseListeners();
		add(miCursor);
		//add(r2, 0, 0);
		//r2.setColor(Color.GREEN);
		//r2.setFillColor(Color.GRAY);
		//r2.setFilled(true);
	
		add(bola1, 50,50);
		//add(bola2, 200,200);
		//add(bola3, 50,500);
		
		
	}
	
	public void run(){
		creaPiramide();
		while(true){
			bola1.movimiento(this);
			//bola2.movimiento(this);
			//bola3.movimiento(this);
			pause(1);
			miCursor.movimiento(getWidth(),(int) bola1.getX());
		}
	}
	
	public void mouseMoved(MouseEvent evento){
		miCursor.movimiento(getWidth(), evento.getX());
	}
	public void creaPiramide(){
		int numeroLadrillos= 14;
		
		for(int j=0 ; j<numeroLadrillos; j++){
			for(int i=j;i<numeroLadrillos; i++){
				Ladrillo miladrillo = new Ladrillo(ladrilloAncho*i-ladrilloAncho/2*j,
													ladrilloAlto*j,
													ladrilloAncho,
													ladrilloAlto, 
													Color.BLUE);
				add(miladrillo);
			}
		}
	}
}