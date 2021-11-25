package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Arkanoid extends GraphicsProgram{
	
	static final int ladrilloAncho = 35;
	static final int ladrilloAlto = 15;
	
	static final int anchoPantalla = 500;
	static final int altoPantalla = 500;
	
	int cursorAncho = 60;
	int cursorAlto = 10;
	int cursorX = 350;
	int cursorY = 350;
	Cursor miCursor = new Cursor(cursorX,cursorY,cursorAncho,cursorAlto, Color.GREEN);

	
	int bolaX = 10;
	int bolaY = 10;
	Bola bola1 = new Bola(bolaX,bolaY, Color.PINK, 1,1);
	//Bola bola2 = new Bola(bolaX,bolaY, Color.BLUE, 1,1);
	//Bola bola3 = new Bola(bolaX,bolaY, Color.BLUE, 1,1);

	GImage fondo = new GImage("imagenes/borders_positioned.png");
		
	public void init(){
		add(fondo);
		addMouseListeners();
		add(miCursor);
		//add(r2, 0, 0);
		//r2.setColor(Color.GREEN);
		//r2.setFillColor(Color.GRAY);
		//r2.setFilled(true);
	
		add(bola1, 50,50);
		//add(bola2, 200,200);
		//add(bola3, 50,500);
		setSize(anchoPantalla, altoPantalla);
		
	}
	
	public void run(){
		creaPiramide();
		while(true){
			bola1.movimiento(this);
			//bola2.movimiento(this);
			//bola3.movimiento(this);
			pause(1);
			miCursor.movimiento(anchoPantalla,(int) bola1.getX());
		}
	}
	
	public void mouseMoved(MouseEvent evento){
		miCursor.movimiento(getWidth(), evento.getX());
	}
	public void creaPiramide(){
		int numeroLadrillos= 14;
		int desplazamiento_inicial_X = 100;
		int desplazamiento_inicial_Y = 25;
		
		for(int j=0 ; j<numeroLadrillos; j++){
			for(int i=j;i<numeroLadrillos; i++){
				Ladrillo miladrillo = new Ladrillo(ladrilloAncho*i-ladrilloAncho/2*j +desplazamiento_inicial_X,
													ladrilloAlto*j + desplazamiento_inicial_Y,
													ladrilloAncho,
													ladrilloAlto, 
													Color.RED);
				add(miladrillo);
			}
		}
	}
}