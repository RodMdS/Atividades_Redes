package br.ufc.quixada.redes.servidor;

public class MathsOperation {
	private String message;
	
	public MathsOperation(String message) {
		this.message = message;
	}
	
	public String answer() throws MethodWasNotRecognizedError {
		String[] aux = message.split(" ");
		String response = "";
		
		if(aux[0].equals("add")) {
			response = "c " + message + " " + add(Float.parseFloat(aux[1]), Float.parseFloat(aux[2]));
		} else if(aux[0].equals("sub")) {
			response = "c " + message + " " + sub(Float.parseFloat(aux[1]), Float.parseFloat(aux[2]));
		} else if(aux[0].equals("mpy")) {
			response = "c " + message + " " + mpy(Float.parseFloat(aux[1]), Float.parseFloat(aux[2]));
		} else if(aux[0].equals("div")) {
			try {
				response = "c " + message + " " + div(Float.parseFloat(aux[1]), Float.parseFloat(aux[2]));
			} catch (DivisionByZeroError e) {
				response = "e " + e.getMessage();
			}
		} else throw new MethodWasNotRecognizedError("Method was not recognized.");
		
		return response;
	}
	
	private float add(float op1, float op2) {
		return op1 + op2;
	}
	private float sub(float op1, float op2) {
		return op1 - op2;
	}
	private float mpy(float op1, float op2) {
		return op1 * op2;
	}
	private float div(float op1, float op2) throws DivisionByZeroError {
		if(op2 == 0) throw new DivisionByZeroError("Division by zero.");
		return op1 / op2;
	}

}
