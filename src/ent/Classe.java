package ent;

import java.util.ArrayList;

public class Classe  extends SuperClass{
	private ArrayList<Matiere> matieresAPlacer = new ArrayList<Matiere>();
	public static int nbClasse;
	
	public void initialize(int nbj,int nbh, int nbClasse) throws Exception{
		this.nbClasse = nbClasse;
		initialize(nbj, nbh);
	}
	
	public void ajouterMatiere(Matiere matiere){
		matieresAPlacer.add(matiere);
	}
	
	private Matiere getRandomMatiere(){
		int index = (int) (Math.random()*matieresAPlacer.size());
		return matieresAPlacer.get(index);
	}
	public void placerRandomCours(){
		Matiere matiere = getRandomMatiere();
		System.out.println(getDisponibilite(matiere).size());
		Cours cours = getDisponibilite(matiere).get(0);
		placerCours(cours, matiere);
		//System.out.println(matiere);
	}
	public boolean toutLesCoursPlacer(){
		return matieresAPlacer.isEmpty();
	}
	
	public ArrayList<Cours> getDisponibilite(Matiere matiere){
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
	

	
	public void placerCours(Cours cours,Matiere matiere){
		cours.setProf(matiere.getProfesseur());
		matiere.getProfesseur().getCours(cours.getJour(),cours.getHeure()).setClasse(this);
		matiere.decremanter();
		if(matiere.toutLesCoursPlacer()){
			matieresAPlacer.remove(matiere);
			if(matieresAPlacer.isEmpty()){
				nbClasse --;
			}
		}
	}
	public void placerCours(int j,int h,Matiere matiere){
		this.getCours(j, h).setProf(matiere.getProfesseur());
		matiere.getProfesseur().getCours(j, h).setClasse(this);
		matiere.decremanter();
		if(matiere.toutLesCoursPlacer()){
			matieresAPlacer.remove(matiere);
		}
		
	}

	public ArrayList<Matiere> getMatieresAPlacer() {
		return matieresAPlacer;
	}

	public void setMatieresAPlacer(ArrayList<Matiere> matieresAPlacer) {
		this.matieresAPlacer = matieresAPlacer;
	}
}
