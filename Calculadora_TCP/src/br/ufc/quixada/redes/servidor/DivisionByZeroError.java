package br.ufc.quixada.redes.servidor;

public class DivisionByZeroError extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DivisionByZeroError(String message) {
		super(message);
	}
}
