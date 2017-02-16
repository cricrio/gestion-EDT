package fournisseur;

import java.util.ArrayList;

import models.Classe;

public class Main {
 public static void main(String[] args) {
	ImportData importData = new ImportData("config/");
	System.out.println(importData.getProfesseurs());
	ArrayList<Classe> classes =  importData.getClasses();
	for(Classe classe : classes) {
		System.out.println(classe.getMatieresAPlacer());
	}
}
}
