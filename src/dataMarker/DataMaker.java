package dataMarker;

import java.util.ArrayList;

import fournisseur.ExportData;
import models.Classe;
import models.Matiere;
import models.Niveau;
import models.Professeur;
import models.Salle;

public class DataMaker {
	Niveau ter = new Niveau("ter");
	Niveau sec = new Niveau("sec");
	Niveau prim =  new Niveau("prim");
	
	
	
	public static void main(String[] args){
		DataMaker dataMaker = new DataMaker();
		dataMaker.writeSomeSalle();
		//dataMaker.writeSomeNiveau();
	//	dataMaker.writeSomeClasse();
///		dataMaker.writeSomeProfesseur();
	}
	public  void writeSomeNiveau(){
		ArrayList<Matiere> terMat = new ArrayList<>();
		ArrayList<Matiere> secMat = new ArrayList<>();
		ArrayList<Matiere> primMat = new ArrayList<>();
		Matiere francais1 = new Matiere("Francais", 4);
		terMat.add(francais1);
		Matiere francais2 = new Matiere("Francais", 2);
		secMat.add(francais2);
		Matiere francais3 = new Matiere("Francais", 4);
		primMat.add(francais3);
		Matiere math1 = new Matiere("Mat", 4);
		terMat.add(math1);
		Matiere math2 = new Matiere("Mat", 2);
		secMat.add(math2);
		Matiere math3 = new Matiere("Mat", 4);
		primMat.add(math3);
		
		ter.setMatieres(terMat);
		prim.setMatieres(primMat);
		sec.setMatieres(secMat);
		
		ExportData.exportNiveau("n"+ter.getId()+".json", ter);
		ExportData.exportNiveau("n"+sec.getId()+".json", sec);
		ExportData.exportNiveau("n"+prim.getId()+".json", prim);
	}

	public void writeSomeClasse(){
		Classe classe1 = new Classe("ter1", ter);
		Classe classe2 = new Classe("sec1", sec);
		Classe classe3 = new Classe("prim", prim);
		
		ExportData.exportClasse("c"+classe1.getId()+".json", classe1);
		ExportData.exportClasse("c"+classe2.getId()+".json", classe3);
		ExportData.exportClasse("c"+classe3.getId()+".json", classe3);

	}
	public void writeSomeSalle(){
		Salle classe1 = new Salle("ter1");
		Salle classe2 = new Salle("sec1");
		Salle classe3 = new Salle("prim");
		
		ExportData.exportSalle("s"+classe1.getId()+".json", classe1);
		ExportData.exportSalle("s"+classe2.getId()+".json", classe3);
		ExportData.exportSalle("s"+classe3.getId()+".json", classe3);

	}
	public void writeSomeProfesseur(){
		Professeur profFrancais = new Professeur("franceP");
		Professeur profMath = new Professeur("mathP");
		Professeur profAnglais = new Professeur("angilasP");
		
		ExportData.exportProfesseur("p"+profAnglais.getId()+".json", profAnglais);
		ExportData.exportProfesseur("p"+profMath.getId()+".json", profMath);
		ExportData.exportProfesseur("p"+profFrancais.getId()+".json", profFrancais);

	}
}
