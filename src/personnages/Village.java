package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;

	public Village(String nom,int nbVilMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVilMax];
	}

	public String getNom() {
		return nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterVil(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois ++;
	}
	
	public Gaulois trouverHabitant(int number) {
		return villageois[number];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef + " vivent les légendaires gaulois :");
		int i = 0;
		while(i<nbVillageois) {
			System.out.println("- " + villageois[i].getNom());
			i ++;
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		Gaulois asterix = new Gaulois("Astérix",8);
		Gaulois obelix = new Gaulois("Obélix",25);
//		Gaulois gaulois = village.trouverHabitant(30);
		Chef chef = new Chef("Abraracoursix",6,1,village);
		village.setChef(chef);
		village.ajouterVil(asterix);
		village.ajouterVil(obelix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		village.afficherVillageois();
		

		
	}
}
