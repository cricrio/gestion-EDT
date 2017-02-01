package fournisseur;

import java.util.ArrayList;

import models.Classe;
import models.Professeur;
import models.Salle;

public interface FournisseurInterface {
	public ArrayList<Classe> getClasses();
	public ArrayList<Professeur> getProfesseur();
	public ArrayList<Salle> getSalles();
	
}
