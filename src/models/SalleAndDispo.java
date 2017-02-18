package models;

public class SalleAndDispo {
	private Salle salle;
	private Disponibilite disponibilite;

	public SalleAndDispo(Salle salle, Disponibilite disponibilite) {
		this.setSalle(salle);
		this.setDisponibilite(disponibilite);
	}

	public Disponibilite getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(Disponibilite disponibilite) {
		this.disponibilite = disponibilite;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
}
