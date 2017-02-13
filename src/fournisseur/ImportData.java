package fournisseur;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Classe;

public class ImportData {
	Gson gson;
	private String folderpath;
	
	public ImportData(String folderpath) {
		setFolderpath(folderpath);
		gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
	}

	public ArrayList<Classe>getClasses(){
		ArrayList<Classe> classes = new ArrayList<>();
		Classe classe;
		String path;
		for(String name : getFileFromFolder("classes")){
			path = 
			classe = gson.fromJson(new FileWriter(folderpath+"/"+name), Classe.class)
		}
	}
	
	private String[] getFileFromFolder(String name ){
		File folder = new File(name);
		return folder.list();
	}
	
	public String getFolderpath() {
		return folderpath;
	}

	public void setFolderpath(String folderpath) {
		this.folderpath = folderpath;
	}
}
