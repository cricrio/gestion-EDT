package fournisseur;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import models.Classe;
import models.ClasseJson;
import models.Matiere;
import models.MatiereJSON;
import models.Niveau;
import models.Professeur;
import models.Salle;

public class ImportData {
	private Gson gson;
	private ArrayList<ClasseJson> classeJsons;
	private ArrayList<Classe> classes;
	private ArrayList<Salle> salles;
	private ArrayList<Niveau> niveaux;
	private ArrayList<Professeur> professeurs;
	private String folderpath;

	public ImportData(String folderpath) {
		setFolderpath(folderpath);
		gson = new GsonBuilder().setPrettyPrinting().create();
		importNiveaux();
		importProfesseurs();
		importSalles();
		importClassesJson();
		setClasses();
	}

	private void setClasses() {
		classes = new ArrayList<>();
		for(ClasseJson classeJson : getClasseJsons()) {
			classes.add(transformClasseJson(classeJson));
		}
	}
	
	private Professeur findProfesseurById(int id) {
		for(Professeur professeur : professeurs) {
			if(professeur.getId() == id) {
				return professeur;
			}
		}
		return null;
	}
	
	private Classe transformClasseJson(ClasseJson cJson) {
		Classe classe = new Classe("vgf");
		ArrayList<MatiereJSON> matiereJSONs = cJson.getMatieres();
		ArrayList<Matiere> matieres = new ArrayList<>();
		Niveau niveau = niveaux.get(niveaux.indexOf(new Niveau("", cJson.getNiveau())));
		classe.setMatieresAPlacer(matieres);
		for(MatiereJSON mJson : cJson.getMatieres()) {
			Matiere matiere = niveau.findMatiereById(mJson.getIdMatiere());
			matiere.setProfesseur(findProfesseurById(mJson.getIdProfesseur()));
			matieres.add(matiere);
		}
		return classe;
	}
	
	private ArrayList<ClasseJson> importClassesJson() {
		setClasseJsons(new ArrayList<>());
		ClasseJson classe;
		String nameFolder = folderpath+"/classes/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				classe = gson.fromJson(new FileReader(nameFolder + name), ClasseJson.class);
				getClasseJsons().add(classe);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return getClasseJsons();
	}

	private ArrayList<Niveau> importNiveaux() {
		niveaux = new ArrayList<>();
		Niveau niveau;
		String nameFolder = folderpath+"/niveaux/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				niveau = gson.fromJson(new FileReader(nameFolder + name), Niveau.class);
				niveaux.add(niveau);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return niveaux;
	}

	private ArrayList<Professeur> importProfesseurs() {
		professeurs = new ArrayList<>();
		Professeur prof;
		String nameFolder = folderpath+"/professeurs/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				prof = gson.fromJson(new FileReader(nameFolder + name), Professeur.class);
				professeurs.add(prof);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return professeurs;
	}

	private ArrayList<Salle> importSalles() {
		salles = new ArrayList<>();
		Salle salle;
		String nameFolder = folderpath+"/salles/";
		for (String name : getFileFromFolder(nameFolder)) {

			try {
				salle = gson.fromJson(new FileReader(nameFolder + name), Salle.class);
				salles.add(salle);
			} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return salles;
	}

	private String[] getFileFromFolder(String name) {
		File folder = new File(name);
		for (String dq : folder.list()) {
			System.out.println(dq);
		}
		return folder.list();
	}

	public String getFolderpath() {
		return folderpath;
	}

	public void setFolderpath(String folderpath) {
		this.folderpath = folderpath;
	}

	
	public ArrayList<Salle> getSalles() {
		return salles;
	}

	public void setSalles(ArrayList<Salle> salles) {
		this.salles = salles;
	}

	public ArrayList<Niveau> getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(ArrayList<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public ArrayList<Professeur> getProfesseurs() {
		return professeurs;
	}

	public void setProfesseurs(ArrayList<Professeur> professeurs) {
		this.professeurs = professeurs;
	}

	public ArrayList<ClasseJson> getClasseJsons() {
		return classeJsons;
	}

	public void setClasseJsons(ArrayList<ClasseJson> classeJsons) {
		this.classeJsons = classeJsons;
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}
}
