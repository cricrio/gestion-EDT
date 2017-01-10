package ent;

import java.util.ArrayList;

public class Classe  extends SuperClass{
	private ArrayList<Matiere> matieresAPlacer;
	
	
	public void ajouterMatiere(Matiere matiere){
		matieresAPlacer.add(matiere);
	}
	
	public ArrayList<Cours> getDisponibilite(Matiere matiere){
		int pos=0;
		ArrayList<Cours> disponibiliteProf = matiere.getProfesseur().getDisponibilite();
		ArrayList<Cours> disponibiliteBoth = new ArrayList<Cours>();
		
		for(Cours cours: disponibiliteProf){
		
			Cours c = this.getCours(cours.getJour(), cours.getHeure());
			
			if(c.getProf() == null){
				disponibiliteBoth.add(c);
			}
		}
		return disponibiliteBoth;	
	}
	

	
	public void addCours(Cours cours,Matiere matiere){
		cours.setProf(matiere.getProfesseur());
		matiere.getProfesseur().getCours(cours.getJour(),cours.getHeure()).setClasse(this);
		
	}
	public void addCours(int j,int h,Matiere matiere){
		this.getCours(j, h).setProf(matiere.getProfesseur());
		matiere.getProfesseur().getCours(j, h).setClasse(this);
		
	}

	public ArrayList<Matiere> getMatieresAPlacer() {
		return matieresAPlacer;
	}

	public void setMatieresAPlacer(ArrayList<Matiere> matieresAPlacer) {
		this.matieresAPlacer = matieresAPlacer;
	}
}
