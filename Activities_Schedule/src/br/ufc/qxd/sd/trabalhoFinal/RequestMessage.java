package br.ufc.qxd.sd.trabalhoFinal;

public class RequestMessage {

	private int id;
	private String op;
	private String title;
	private String description;
	private String closingDate;
	
	public RequestMessage() {}
	
	public RequestMessage(String op, String title, String description, String closingDate) {
		this.op = op;
		this.title = title;
		this.description = description;
		this.closingDate = closingDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	
}
