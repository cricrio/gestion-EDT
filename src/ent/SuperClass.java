package ent;

import java.util.ArrayList;

public class SuperClass {
	protected String nom;
	@Override
	public String toString() {
		return "SuperClass [nom=" + nom + "]";
	}

	EDT edt = new EDT();
	

	public void initialize(int nbj, int nbh) throws Exception {
		edt.initialize(nbj, nbh);
	}
	void placerCours(Cours cours){
		edt.placerCours(cours);
	}
	protected ArrayList<Disponibilite> getDisponibilite() {
		return edt.getDisponibilites();
	}
	protected ArrayList<Cours>getAllCours(){
		return edt.coursList;
	}

	protected Cours getCours(int j, int h) {
		return edt.getCours(j, h);
	}
}
