package com.jacaranda.notas;

import java.time.LocalDateTime;

public class NotaAlarma extends Nota implements Activable {
	
	private LocalDateTime fechaAlarma;
	private static final int MINUTOS_REPETIR_POR_DEFECTO=5;
	private int minutosRepetir;
	private boolean activado;
	
	/*
	 * Cosntructor que hereda texto de nota y pone por defecto 
	 * los minutos de repeticion
	 */
	public NotaAlarma(String texto, LocalDateTime fechaAlarma,boolean activado) throws NotaAlarmaException {
		super(texto);
		setFechaAlarma(fechaAlarma);
		this.activado= activado;
		this.minutosRepetir= MINUTOS_REPETIR_POR_DEFECTO;
	}

	public NotaAlarma(String texto, LocalDateTime fechaAlarma, int minutosRepetir) throws NotaAlarmaException {
		super(texto);
		setFechaAlarma(fechaAlarma);
		this.minutosRepetir = minutosRepetir;
		this.activado = true;
	}

	private void setFechaAlarma(LocalDateTime fechaAlarma) throws NotaAlarmaException {
		if(fechaAlarma.isBefore(getFechaUltimaModificacion())) {//se compara a la de modificación ya que es la fecha mas proxima
			throw new NotaAlarmaException("No puedes poner una alarma para una fecha anterior a la de creacion");
		}
		
		
		this.fechaAlarma = fechaAlarma;
	}

	public static int getMinutosRepetirPorDefecto() {
		return MINUTOS_REPETIR_POR_DEFECTO;
	}
	
	@Override
	public  void activar() {
		this.activado=true;
	}
	
	@Override
	public void desactivar() {
		this.activado=false;
	}
	
	public boolean isActivado() {
		return this.activado;
		}

	@Override
	public String toString() {
		return super.toString()+"Fecha alarma"+this.fechaAlarma+" alarma activada " +this.activado;
	}
	@Override
	public NotaAlarma clone() {
		NotaAlarma resultado = null;
		try {
			resultado = new NotaAlarma(this.texto, this.fechaAlarma, this.activado);
		} catch (NotaAlarmaException e) {
			
			System.out.println(e.getMessage());;
		}
		resultado.activado=this.activado;
		return resultado;
	}
	
	
	
	
	
	
}
