package ent;

import java.util.ArrayList;

public class SuperClass {
	EDT edt = new EDT();
	// return true if dispo

	public void initialize(int nbj, int nbh) throws Exception {
		edt.initialize(nbj, nbh);
	}
	void placerCours(Cours cours){
		edt.placerCours(cours);
	}
	protected ArrayList<Disponibilite> getDisponibilite() {
		return edt.getDisponibilites();
	}

	protected Cours getCours(int j, int h) {
		return edt.getCours(j, h);
	}
}
