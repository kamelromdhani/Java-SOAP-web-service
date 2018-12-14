package ws;

public class Avis {
	private int note;
	private String commentaire;
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Avis() {
		super();
	}
	public Avis(int note, String commentaire) {
		super();
		this.note = note;
		this.commentaire = commentaire;
	}
	
}
