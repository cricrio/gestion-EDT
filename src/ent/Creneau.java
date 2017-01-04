package ent;

public class Creneau {
	private int heure;
	private int jour;
	public Creneau(int jour,int heure){
		this.heure = heure;
		this.jour = jour;
	}
	
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
}
