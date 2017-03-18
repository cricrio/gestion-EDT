package main.java.importExport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.java.models.Classe;
import main.java.models.ClasseJson;
import main.java.models.Cours;
import main.java.models.CoursJSON;
import main.java.models.Matiere;
import main.java.models.MatiereJSON;
import main.java.models.Niveau;
import main.java.models.Professeur;
import main.java.models.Salle;

public class ExportData {

	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private String folder;

	public ExportData(String folder) {
		setFolder(folder);
	}

	public void exportClasses(ArrayList<Classe> classes) {
		String path = folder + "classes/";
		for (Classe classe : classes) {
			exportClasse(path + "c" + classe.getId() + ".json", classe);
		}
	}

	public void exportProfs(ArrayList<Professeur> profs) {
		String path = folder + "professeurs/";
		for (Professeur prof : profs) {
			exportProfesseur(path + "c" + prof.getId() + ".json", prof);
		}
	}

	public void exportSalles(ArrayList<Salle> salles) {
		String path = folder + "salles/";
		for (Salle salle : salles) {
			exportSalle(path + "c" + salle.getId() + ".json", salle);
		}
	}

	public void exportClasse(String filename, Classe classe) {
		ClasseJson classeJson = new ClasseJson();
		ArrayList<MatiereJSON> matiereJSONs = new ArrayList<>();
		ArrayList<CoursJSON> edt = new ArrayList<>();

		classeJson.setId(classe.getId());
		classeJson.setNiveau(classe.getNiveau().getId());
		for (Cours c : classe.getAllCours()) {
			CoursJSON cJson = new CoursJSON();
			cJson.setDuree(c.getDuree());
			cJson.setHeureDebut(c.getHeureDebut());
			cJson.setJourDebut(c.getJour());
			cJson.setIdprof(c.getProf().getId());
			cJson.setIdclasse(c.getClasse().getId());
			cJson.setIdsalle(c.getSalle().getId());
			edt.add(cJson);
		}
		for (Matiere matiere : classe.getMatieresAPlacer()) {
			if (matiere.getProfesseur() != null) {
				matiereJSONs.add(new MatiereJSON(matiere.getId(), matiere.getProfesseur().getId()));
			} else {
				matiereJSONs.add(new MatiereJSON(matiere.getId()));
			}

		}

		classeJson.setEdt(edt);
		classeJson.setMatieres(matiereJSONs);

		try (Writer writer = new FileWriter(filename)) {
			gson.toJson(classeJson, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void exportProfesseur(String filename, Professeur professeur) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter(filename)) {
			gson.toJson(professeur, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exportNiveau(String filename, Niveau niveau) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter(filename)) {
			gson.toJson(niveau, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void exportSalle(String filename, Salle salle) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Writer writer = new FileWriter(filename)) {
			gson.toJson(salle, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}
}
