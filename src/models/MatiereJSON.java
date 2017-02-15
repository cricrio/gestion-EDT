package models;

public class MatiereJSON {
	@Override
	public String toString() {
		return "MatiereJSON [idMatiere=" + idMatiere + ", idProfesseur=" + idProfesseur + "]";
	}
	private int idMatiere;
	private int idProfesseur;
	
	public MatiereJSON(){
		
	}
	public MatiereJSON(int idMatiere, int idProfesseur) {
		super();
		this.idMatiere = idMatiere;
		this.idProfesseur = idProfesseur;
	}
	public MatiereJSON(int id) {
		this.idMatiere =id;
	}
	public int getIdProfesseur() {
		return idProfesseur;
	}
	public void setIdProfesseur(int idProfesseur) {
		this.idProfesseur = idProfesseur;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
}
