package ent;

public class Main {

	public static void main(String[] args) {
		Generator generator = new Generator();
		try {
			generator.initialize(100, 100);
			generator.placerCours();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
