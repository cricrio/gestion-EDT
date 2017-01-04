package ent;

public class SuperClass {
	EDT edt = new EDT();
	//return true if dispo
	
	public boolean checkDispo(Cours cours){
		return ! edt.contains(cours);
	}
	public boolean ajouterCours(Cours cours){
		
		if(cours.getClasse().checkDispo(cours) && cours.getProf().checkDispo(cours) && cours.getSalle().checkDispo(cours)){
			cours.getClasse().ajouterCours(cours);
			cours.getProf().ajouterCours(cours);
			//vcours.getSalle().ajouterCours(cours);
			return true;
		} else{
			return false;
		}
	}
}
