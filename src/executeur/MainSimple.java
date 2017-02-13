package executeur;

import java.util.ArrayList;

import ent.GeneratorEDTs;
import fournisseur.ExportData;
import models.Classe;
import models.Matiere;
import models.Niveau;
import models.Professeur;
import models.Salle;

/**
 * 
 * Avec cette utilisation du main les donnée sont prédéfini par le générateur
 * Les informations sont codés en dure dans le code
 * 
 * @author christo
 *
 */
public class MainSimple {
	
	private ArrayList<Classe> classes = new ArrayList<Classe>();
	private ArrayList<Salle> salles = new ArrayList<Salle>();
	private ArrayList<Professeur> professeurs = new ArrayList<Professeur>();

	public static void main(String[] args) {
		MainSimple ms = new MainSimple();
		GeneratorEDTs generator = new GeneratorEDTs();
		try {
			ms.initialize(5, 10);
//			ExportImportData.exportClasse(ms.getClasses().get(0)+".json",ms.getClasses().get(0));
			generator.setProfesseurs(ms.getProfesseurs());
			generator.setClasses(ms.getClasses());
			generator.setSalles(ms.getSalles());
			generator.placerCours();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

	/**
	 * Initialise les profs, classes et salles
	 * 
	 * @param nbJours
	 *            dans la semaine
	 * @param nbHeures
	 *            dans la journée
	 * @throws Exception
	 * 
	 */
	public void initialize(int nbJours, int nbHeures) throws Exception {
		Professeur profFrancais = new Professeur("franceP");
		Professeur profMath = new Professeur("mathP");
		Professeur profAnglais = new Professeur("angilasP");

		getProfesseurs().add(profFrancais);
		getProfesseurs().add(profAnglais);
		getProfesseurs().add(profMath);

		getClasses().add(new Classe("classe1"));
		getClasses().add(new Classe("classe2"));
		getClasses().add(new Classe("classe3"));

		getSalles().add(new Salle("IO1"));
		getSalles().add(new Salle("IO2"));
		getSalles().add(new Salle("IO3"));

		// les classes doivent connaitre l'ensemble des salles
		getClasses().get(0).setSalles(getSalles());
		Matiere francais = new Matiere("francais", 3);
		Matiere math = new Matiere("math", 3);
		Matiere anglais = new Matiere("anglais", 3);

		francais.setProfesseur(profFrancais);
		anglais.setProfesseur(profAnglais);
		math.setProfesseur(profMath);

		for (Classe classe : getClasses()) {
			classe.initialize(nbJours, nbHeures, getClasses().size());
			classe.ajouterMatiere(math);
			classe.ajouterMatiere(anglais);
			classe.ajouterMatiere(francais);
		}
		for (Professeur professeur : getProfesseurs()) {
			professeur.initialize(nbJours, nbHeures);
		}
		for (Salle salle : getSalles()) {
			salle.initialize(nbJours, nbHeures);
		}
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}

	public ArrayList<Salle> getSalles() {
		return salles;
	}

	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}

	public ArrayList<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(ArrayList<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

}
