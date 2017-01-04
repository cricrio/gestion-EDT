package ent;

public class SuperClass {
	EDT edt = new EDT();
	//return true if dispo
	
	public boolean checkDispo(Cours cours){
		return ! edt.contains(cours);
	}
	public void  addCours(Cours cours){
		edt.add(cours);
	}
	
	
	public boolean addCoursInAllIntervenants(Cours cours){
		
		if(cours.getClasse().checkDispo(cours) && cours.getProf().checkDispo(cours) && cours.getSalle().checkDispo(cours)){
			cours.getClasse().addCours(cours);
			cours.getProf().addCours(cours);
			cours.getSalle().addCours(cours);
			return true;
		} else{
			return false;
		}
	}
}
