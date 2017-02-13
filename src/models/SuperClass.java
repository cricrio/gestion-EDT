package models;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import ent.EDT;

public abstract class SuperClass {
	protected String nom;
	private static final AtomicInteger COUNTER = new AtomicInteger();
	private final int id;
	
	public SuperClass() {
		this.id = COUNTER.incrementAndGet();
	}
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

	public ArrayList<Cours> getAllCours() {
		return edt.getCoursList();
	}

	protected Cours getCours(int j, int h) {
		return edt.getCours(j, h);
	}

	public boolean checkIntegrite() {
		return edt.checkIntegrite();
	}

	public static AtomicInteger getCounter() {
		return COUNTER;
	}

	public int getId() {
		return id;
	}
}
