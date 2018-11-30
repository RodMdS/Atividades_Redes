package br.ufc.qxd.sd.trabalhoFinal;

public class Activity {
	private int id;
	private String title;
	private String description;
	private String status;
	private String closingDate;
	
	public Activity() {}
	
	public Activity(int id, String title, String description, String status, String closingDate) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.closingDate = closingDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", closingDate=" + closingDate + "]";
	}
}
