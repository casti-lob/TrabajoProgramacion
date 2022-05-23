package elementos;

import logicaJuego.Constantes;

public class Jugador extends Element {
	private int dinero;
	private int pocion;
	private int gemas;
	private PlayerType player;
	
	public Jugador(ElementType type, PlayerType player) {
		super(type);
		this.player = player;
	}
	
	public String getNombre() {
		return player.name();
	}
	
	public int getFuerzaParaLuchar() {
		return (int) Math.round(Math.random()*player.getFuerza()+1);
	}
	private int getFuerza() {
		return player.getFuerza();
	}
	private int getMagia() {
		return player.getMagia();
	}
	public int getMagiaParaLuchar() {
		return (int)Math.round(Math.random()*player.getMagia()+1);
	}
	private int getVelocidad() {
		return player.getVelocidad();
	}
	public int getVelocidadParaLuchar() {
		return (int)Math.round(Math.random()*player.getVelocidad()+1);
	}

	public int getDinero() {
		return this.dinero;
	}
	
	public void setDinero(int dinero) throws JugadorException {
		if(dinero>Constantes.NUM_DINERO) {
			throw new JugadorException("Esa cantidad de dinero es mayor al maximo");
		}
		this.dinero += dinero;
	}
	
	public int getPociones() {
		return this.pocion;
	}
	public void setPociones(int pocion) throws JugadorException {
		if(pocion>Constantes.NUM_POCIONES) {
			throw new JugadorException("Esa cantidad de pociones es mayor al maximo");
		}
		this.pocion+=pocion;
	}
	
	public int getGemas() {
		return this.gemas;
	}
	
	public void setGemas(int gema) throws JugadorException {
		if(gema > Constantes.NUM_GEMAS) {
			throw new JugadorException("Esa cantidad de gemas es mayor al maximo");
		}
		this.gemas+=gemas;
	}
	
	public String resume() {
		return player+ "dinero= "+dinero+"pociones= "+pocion+"gemas= "+gemas;
	}
	
	public PlayerType getPlayer() {
		return player;
	}
	
	public int lucha(Jugador enemigo) throws JugadorException {
		int resultado=0;
		if(getFuerzaParaLuchar()==enemigo.getFuerzaParaLuchar()) {
			resultado=Constantes.EMPATE;
			
		}else if(getFuerzaParaLuchar()>enemigo.getFuerzaParaLuchar()&& enemigo.getPociones()>0) {
			resultado = Constantes.GANA_USA_POCIMA;
			enemigo.setPociones(-1);
		}else if(getFuerzaParaLuchar()>enemigo.getFuerzaParaLuchar()&& enemigo.getDinero()>0) {
			resultado =Constantes.GANA_DINERO;
			enemigo.setDinero(-getDinero());
		}else if()
		
		return resultado;
	}
}
