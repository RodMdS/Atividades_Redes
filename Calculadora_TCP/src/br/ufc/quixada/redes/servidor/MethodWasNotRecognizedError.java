package br.ufc.quixada.redes.servidor;

public class MethodWasNotRecognizedError extends Exception{

	private static final long serialVersionUID = 1L;
	
	public MethodWasNotRecognizedError(String message) {
		super(message);
	}
}
