package models;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import exception.DispoNonCommuneExeption;

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

	public void placerCours(Cours cours) {
		edt.placerCours(cours);
	}

	protected ArrayList<Disponibilite> getDisponibilite() {
		return edt.getDisponibilites();
	}

	public ArrayList<Disponibilite> getSharedDisponibilite(ArrayList<Disponibilite> dispoSource) throws DispoNonCommuneExeption  {
		return edt.getSharedDisponibilite(dispoSource);
	}

	public ArrayList<Cours> getAllCours() {
		return edt.getCoursList();
	}

	protected Cours getCours(int j, int h) {
		return edt.getCours(j, h);
	}

	/**
	 * @return false s'il y a plusieurs cours à la même heure
	 */
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
