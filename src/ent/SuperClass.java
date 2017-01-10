package ent;

import java.util.ArrayList;

public class SuperClass {
	EDT edt = new EDT();
	//return true if dispo

	public void initialize(int nbj,int nbh) throws Exception{
		edt.initialize(nbj,nbh);
	}
	
	protected ArrayList<Cours>getDisponibilite() {
		return edt.getCrenauxLibre();
	}
	protected Cours getCours(int j,int h){
		return edt.getCours(j, h);
}}
