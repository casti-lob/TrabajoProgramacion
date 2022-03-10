package ejercicio5;

/**
 * 
 * @author estudiante
 *@version 1.0
 */

public class Partido {
	private static final int JORDANDAMAX=38;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private int jornada;
	private int numGolesEquipoLocal;
	private int numGolesEquipoVisitante;
	private char resultadoQuiniela;
	private boolean partidoJugado;
	
	/**
	 * 
	 * @param equipoLocal
	 * @param equipoVisitante
	 * @param jornada
	 * @throws PartidoException
	 * Comprobamos si la jornada esta comprendida entre 1-38
	 */
	//Cosntructor
	public Partido(Equipo equipoLocal, Equipo equipoVisitante, int jornada) throws PartidoException {
		super();
		if(equipoLocal.equals(equipoVisitante)) {
			throw new PartidoException("0002");
		}if(jornada <1||jornada>JORDANDAMAX) {
			throw new PartidoException("0004");
		}
		this.equipoLocal= equipoLocal;
		this.equipoVisitante=equipoVisitante;
		this.jornada = setJornada(jornada);
		this.numGolesEquipoLocal=0;
		this.numGolesEquipoVisitante=0;
		this.resultadoQuiniela=' ';
		this.partidoJugado=false;
	}

	

	/**
	 * Metodo que retorna
	 * @return numGolesEquipoLocal
	 */
	//Get & Set
	public int getNumGolesEquipoLocal() {
		return numGolesEquipoLocal;
	}



	public void setNumGolesEquipoLocal(int numGolesEquipoLocal) {
		this.numGolesEquipoLocal = numGolesEquipoLocal;
	}



	public int getNumGolesEquipoVisitante() {
		return numGolesEquipoVisitante;
	}



	public void setNumGolesEquipoVisitante(int numGolesEquipoVisitante) {
		this.numGolesEquipoVisitante = numGolesEquipoVisitante;
	}

	/**
	 * Metodo que retorna
	 * @return resultado de la quiniela
	 */
	
	public char getResultadoQuiniela() {
		return resultadoQuiniela;
	}

	/**
	 * Metodo que retorna
	 * @return jornada
	 */
	public int getJornada() {
		return jornada;
	}
	
	/**
	 * 
	 * @param jornada
	 * @return
	 * @throws PartidoException
	 * Comprobamos la jornada
	 */
	private int setJornada(int jornada) throws PartidoException {
		if(this.jornada<1&&this.jornada>38) {
			throw new PartidoException("0001");
		}else
		return  jornada;
	}

	/**
	 * Metodo para introducir la quiniela
	 * @param resultadoQuiniela
	 */
	public void setResultadoQuiniela(char resultadoQuiniela) {
		this.resultadoQuiniela = resultadoQuiniela;
	}


	/**
	 * El metodo devuelve una copia del equipo y no el objeto en si 
	 * @return
	 */
	public Equipo getEquipoLocal() {
		Equipo resultado = new Equipo(equipoLocal.getNombre(), equipoLocal.getCiudad(), equipoLocal.getEstadio());
		return resultado;
	}
	/**
	 * Metodo privado para modificar el equipo local 
	 * @param equipoLocal
	 * @throws PartidoException
	 */
	private void setEquipoLocal(Equipo equipoLocal) throws PartidoException {
		this.equipoLocal = equipoLocal;
	}
	/**
	 * El metodo devuelve una copia del equipo y no el objeto en si 
	 * @return
	 */
	public Equipo getEquipoVisitante() {
		Equipo resultado = new Equipo(equipoVisitante.getNombre(), equipoVisitante.getCiudad(), equipoVisitante.getEstadio());
		return resultado;
	}

	/**
	 * Metodo privado para modificar el equipo visitante
	 * @param equipoVisitante
	 */
	private void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	
	/**
	 * Ponermos los valores correspondientes a golesLocal y golesVisitante, 
	 * y despues ponemos el resultado a la quiniela 
	 * @param resultado
	 * @throws PartidoException
	 * Comprobamos si el formato es correcto ya que debe de ser (0-0)
	 */
	//Poner resultado
	public void ponerResultado(String resultado) throws PartidoException {
		int pos = resultado.indexOf('-');
		
		String golesLocal="",golesVisitante="";
		boolean formato=false;//Para comprobar si el formato es correcto y saber de quienes son los goles
		
		// hay que hacer un try catch para pillar todoas las exception posibles
		try {
			golesLocal+= resultado.substring(0, pos);
			golesVisitante += resultado.substring(pos+1,resultado.length());
			
			numGolesEquipoLocal=Integer.parseInt(golesLocal);
			numGolesEquipoVisitante= Integer.parseInt(golesVisitante);
			if(Integer.parseInt(golesLocal)>Integer.parseInt(golesVisitante)) {
				this.resultadoQuiniela='1';
				equipoLocal.setPartidosGanados(equipoLocal.getPartidosGanados()+1);
			}else if (Integer.parseInt(golesLocal)<Integer.parseInt(golesVisitante)) {
				this.resultadoQuiniela='2';
				equipoVisitante.setPartidosGanados(equipoVisitante.getPartidosGanados()+1);
			}else {
				this.resultadoQuiniela='X';
			}
			
		} catch (Exception e) {
			System.out.println("El formato no es correcot");
		}
		
		
	}
	
	
	

	
	@Override
	/**
	 * Si el resultado de la quiniela no esta vacio sacamos los datos del partido terminado,
	 * si no sacamos los datos de que el partido no ha comenzado
	 */
	public String toString() {
		if(this.resultadoQuiniela==' ') {
			return "Partido entre equipo local "+this.equipoLocal+" y equipo visitante "+this.equipoVisitante+" todavia no se ha jugado";
		}else {
			return "Partido entre equipo local "+this.equipoLocal+" y equipo visitante "+this.equipoVisitante+"jugado en el estadio "+this.equipoLocal.getEstadio()+" de la ciudad "+this.equipoLocal.getCiudad()+ " ha finalizado con "+ this.numGolesEquipoLocal+"  goles de equipo local y "+this.numGolesEquipoVisitante+" goles de equipo visitante. Resultado quiniela= "+this.resultadoQuiniela;
		}
		
	}




	
	
	
}