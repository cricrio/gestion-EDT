package importExport;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Classe;
import models.ClasseJson;
import models.Cours;
import models.CoursJSON;
import models.Matiere;
import models.MatiereJSON;
import models.Niveau;
import models.Professeur;
import models.Salle;

public class ExportData {
	
	private Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();
	private String folder;
	
	public ExportData(String folder) {
		setFolder(folder);
	}
	
	public void exportClasses(ArrayList<Classe> classes) {
		String path = folder+"classes/";
		for(Classe classe : classes) {
			exportClasse(path+"c"+classe.getId()+".json", classe);
		}
	}
	
	
	public void exportClasse(String filename,Classe classe){
		ClasseJson  classeJson= new ClasseJson();
		ArrayList<MatiereJSON> matiereJSONs = new ArrayList<>();
		ArrayList<CoursJSON> edt = new ArrayList<>();
		
		classeJson.setId(classe.getId());
		classeJson.setNiveau(classe.getNiveau().getId());
		for(Cours c : classe.getAllCours()) {
			CoursJSON cJson = new CoursJSON();
			cJson.setDuree(c.getDuree());
			cJson.setHeureDebut(c.getHeureDebut());
			cJson.setJourDebut(c.getJour());
			cJson.setIdprof(c.getProf().getId());
			cJson.setIdclasse(c.getClasse().getId());
			cJson.setIdsalle(c.getSalle().getId());
			edt.add(cJson);
		}
		for(Matiere matiere : classe.getMatieresAPlacer()){
			if(matiere.getProfesseur() !=null){
				matiereJSONs.add(new MatiereJSON(matiere.getId(),matiere.getProfesseur().getId()));
			}else{
				matiereJSONs.add(new MatiereJSON(matiere.getId()));
			}
			
		}
		
		classeJson.setEdt(edt);
		classeJson.setMatieres(matiereJSONs);
		
		try(Writer writer = new FileWriter(filename)){
			gson.toJson(classeJson,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void exportProfesseur(String filename,Professeur professeur){
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		try(Writer writer = new FileWriter(filename)){
			gson.toJson(professeur,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void exportNiveau(String filename,Niveau niveau){

		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		try(Writer writer = new FileWriter(filename)){
			gson.toJson(niveau,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void exportSalle(String filename, Salle salle) {

		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		try(Writer writer = new FileWriter(filename)){
			gson.toJson(salle,writer);
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
