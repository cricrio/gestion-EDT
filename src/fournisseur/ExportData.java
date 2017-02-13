package fournisseur;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Classe;
import models.ClasseJson;
import models.Matiere;
import models.MatiereJSON;
import models.Niveau;
import models.Professeur;

public class ExportData {
	public static void main(String[] args) {
		ExportData.exportNiveau("niveau1.json",null);
	}
	
	public static void exportClasse(String filename,Classe classe){
		ClasseJson  classeJson= new ClasseJson();
		ArrayList<MatiereJSON> matiereJSONs = new ArrayList<>();
		classeJson.setId(classe.getId());
		classeJson.setNiveau(classe.getNiveau().getId());
		for(Matiere matiere : classe.getMatieresAPlacer()){
			if(matiere.getProfesseur() !=null){
				matiereJSONs.add(new MatiereJSON(matiere.getId(),matiere.getProfesseur().getId()));
			}else{
				matiereJSONs.add(new MatiereJSON(matiere.getId()));
			}
			
		}
		classeJson.setMatieres(matiereJSONs);
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		try(Writer writer = new FileWriter(filename)){
			gson.toJson(classeJson,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void exportProfesseur(String filename,Professeur professeur){
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		try(Writer writer = new FileWriter(filename)){
			gson.toJson(professeur,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void exportNiveau(String filename,Niveau niveau){

		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		try(Writer writer = new FileWriter(filename)){
			gson.toJson(niveau,writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
