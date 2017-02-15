package fournisseur;

public class Main {
 public static void main(String[] args) {
	ImportData importData = new ImportData("config/");
	System.out.println(importData.getClasses());
}
}
