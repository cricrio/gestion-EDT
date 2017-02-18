package ent;

import java.util.ArrayList;

import exception.AucuneSalleLibreException;
import exception.DispoNonCommuneExeption;
import models.Classe;
import models.Cours;
import models.Disponibilite;
import models.Matiere;
import models.Professeur;
import models.Salle;
import models.SalleAndDispo;

/**
 * Réalise la génération de l'emploi du temps pour les classes, salles et
 * professeurs fournis
 * 
 * @author christo
 *
 */
public class GeneratorEDTs {

	private int nombreClasseNonTraite = 0; // uilisé pour savoir quend finir et initialisé par setClasses((
	private ArrayList<Classe> classes = new ArrayList<Classe>();
	private ArrayList<Salle> salles = new ArrayList<Salle>();
	private ArrayList<Professeur> professeurs = new ArrayList<Professeur>();

	/**
	 * @return true quand le générateur à placer les cours de toutes les classes
	 */
	private boolean isFinish() {
		return nombreClasseNonTraite == 0;
	}

	/**
	 * Place aléatoirement les cours pour chaque classes
	 * 
	 * @throws Exception
	 */
	public void genererEmploiDuTemps() throws Exception {
		while (isFinish() == false) {
			for (Classe classe : getClasses()) {
				if (classe.toutLesCoursPlacer() == false) {
					placerAleatoirementUnCours(classe);
				}
			}
		}
		System.out.println("Work done ! Tout les cours sont placées !");
		for (Classe classe : getClasses()) {
			System.out.println(classe.getAllCours());
		}
	}

	private void placerAleatoirementUnCours(Classe classe) throws DispoNonCommuneExeption, AucuneSalleLibreException {
		Cours cours = trouverAleatoirementUnCoursAleatoirement(classe);
		positionnementDuCours(cours);
		if(classe.toutLesCoursPlacer()) {
			nombreClasseNonTraite=nombreClasseNonTraite-1;
		}
	}

	/**
	 * Choisi aleatoirement une matiere puis recherche les disponibilitées de la
	 * classe et du professeur s'il y a une ou des disponibilitées communes
	 * recherche une salle libre. En cas d'échec lance une exception
	 * correspondant à la cause
	 * 
	 * @param classe
	 * @return cours - le crenaux ou il est possible de placer le cours
	 * @throws DispoNonCommuneExeption
	 *             s'il n'y a pas de disponibilité entre la classe et le prof de
	 *             la matière
	 * @throws AucuneSalleLibreException
	 *             s'il n'y a pas de salle de libre sur les disponibilité
	 *             commune
	 */
	private Cours trouverAleatoirementUnCoursAleatoirement(Classe classe)
			throws DispoNonCommuneExeption, AucuneSalleLibreException {
		// recuperer la positionnementDuCours(cours);matiere à placer
		Matiere matiere = classe.getRandomMatiere();
		// une exception sont lancée s'il n'y a pas de disponilité entre le prof
		// et la classes
		ArrayList<Disponibilite> dispoProfEtClasse = classe.getDisponibilite(matiere);
		// une exception est lancée s'il n'y a pas de salle libre sur les
		// disponibilité trouvées
		SalleAndDispo salleAndDispo = findSalleLibre(dispoProfEtClasse, matiere.getDuree());
		// Creation du cours
		Cours cours = new Cours(salleAndDispo.getDisponibilite().getJour(),
				salleAndDispo.getDisponibilite().getHeureDebut(), matiere.getDuree());
		cours.setMatiere(matiere);
		cours.setClasse(classe);
		cours.setProf(matiere.getProfesseur());
		cours.setSalle(salleAndDispo.getSalle());

		return cours;

	}

	/**
	 * @param dispoClasseProf
	 *            : disponibilitées du prof et de la classe
	 * @param duree
	 *            : du cours
	 * @return la première salle trouvé avec sa première disponibilité
	 * @throws AucuneSalleLibreException
	 *             si aucune salle n'a été trouvée
	 */
	private SalleAndDispo findSalleLibre(ArrayList<Disponibilite> dispoClasseProf, int duree)
			throws AucuneSalleLibreException {
		for (Salle salle : salles) {
			try {
				ArrayList<Disponibilite> dispoSalle = salle.getSharedDisponibilite(dispoClasseProf);
				for (Disponibilite dispo : dispoSalle) {
					if (dispo.getDuree() >= duree) {
						return new SalleAndDispo(salle, dispo);
					}
				}
			} catch (DispoNonCommuneExeption e) {
				// lorsque la salle n'a pas de disponibilité commune avec les
				// disponibilité passées en paramètre on catch l'exception mais
				// ne
				// fait rien avec puisque ce n'est pas un problème
			}
		}
		// si on est là aucune salle libre n'a été trouvée. On lance donc une
		// exception
		throw new AucuneSalleLibreException();
	}

	/**
	 * Positionne le cours dans l'emploi du temps du prof,de la classe et de la
	 * salle
	 * 
	 * @param cours
	 */
	private void positionnementDuCours(Cours cours) {
		Professeur professeur = cours.getProf();
		Salle salle = cours.getSalle();
		Classe classe = cours.getClasse();

		professeur.placerCours(cours);
		salle.placerCours(cours);
		classe.placerCours(cours);
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	/**
	 * Initialize les classes et lenombre de classes à traitées
	 * @param classes
	 */
	public void setClasses(ArrayList<Classe> classes) {
		setNombreClasseNonTraite(classes.size());
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

	public int getNombreClasseNonTraite() {
		return nombreClasseNonTraite;
	}

	public void setNombreClasseNonTraite(int nombreClasseNonTraite) {
		this.nombreClasseNonTraite = nombreClasseNonTraite;
	}

}
