package ent;

import java.util.ArrayList;

public abstract class SuperClass {
	protected String nom;

	

	@Override
	public String toString() {
		return "[nom=" + nom + "]";
	}

	EDT edt = new EDT();

	public void initialize(int nbj, int nbh) throws Exception {
		edt.initialize(nbj, nbh);
	}

	void placerCours(Cours cours) {
		edt.placerCours(cours);
	}

	protected ArrayList<Disponibilite> getDisponibilite() {
		return edt.getDisponibilites();
	}

	public ArrayList<Disponibilite> getSharedDisponibilite(ArrayList<Disponibilite> dispoSource) throws Exception {
		return edt.getSharedDisponibilite(dispoSource);
	}

	protected ArrayList<Cours> getAllCours() {
		return edt.getCoursList();
	}

	protected Cours getCours(int j, int h) {
		return edt.getCours(j, h);
	}

	public boolean checkIntegrite() {
		return edt.checkIntegrite();
	}
}
