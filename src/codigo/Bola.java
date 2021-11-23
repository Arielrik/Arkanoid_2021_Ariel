package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.util.RandomGenerator;

public class Bola extends GOval{
	int dx = 2;
	int dy = 5;
	RandomGenerator aleatorio = new RandomGenerator();


	public Bola(double width, double height) {
		super(width, height);
	}
	public Bola(double width, double height, Color c, int dxnew, int dynew) {
		super(width, height);
		this.setColor(c);
		this.setFillColor(c);
		this.setFilled(true);
		dx = dxnew;
		dy=dynew;
	}

	public void movimiento(Arkanoid arkanoid){
		if(this.getY()> arkanoid.getHeight()-this.getHeight()||this.getY()< 0){
			dy=(dy*-1);
			//this.setFillColor(aleatorio.nextColor());
			//this.setColor(aleatorio.nextColor());

		}//rebote abajo y arriba
		
		if(this.getX()> arkanoid.getWidth()-this.getWidth()||this.getX() <0){
			dx=dx*-1;
			//this.setFillColor(aleatorio.nextColor());
			//this.setColor(aleatorio.nextColor());
		}//rebote derecha e izquierda
		
		//chequea la esquina superior de la bola
		if(chequeaColision(getX(), getY(),arkanoid)){
			if(chequeaColision(getX()+getWidth(), getY(),arkanoid)){
				if(chequeaColision(getX(), getY()+getHeight(),arkanoid)){
					if(chequeaColision(getX()+getWidth(), getY()+getHeight(),arkanoid)){
						
					}
				}
			}
		}
		
		this.move(dx,dy);

	}
	
	private boolean chequeaColision(double posx, double posy,Arkanoid arkanoid){
		boolean noHaChocado = true;
		//objeto auxiliar
		GObject auxiliar;
		auxiliar = arkanoid.getElementAt(posx, posy);
		//rebote micursor
		if(auxiliar == arkanoid.miCursor){//si entra aqui es que choco con el cursor
			dy *=-1;
			noHaChocado = false;
		}else if(auxiliar == null){
			
		}else if(auxiliar instanceof Ladrillo){// si es un ladrillo
			if (auxiliar.getY()+getHeight()==posy||auxiliar.getY()==posy){
				dy *=-1;
			}else if(auxiliar.getX()+getWidth()==posx||auxiliar.getX()==posx){
				dx *=-1;
			}
			arkanoid.remove(auxiliar);
			dy *=-1;
			dx=dx*-1;
			noHaChocado = false;
		}
	
		return noHaChocado;
	}
}
