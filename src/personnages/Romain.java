package personnages;


public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		// TODO Auto-generated method stub
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if(force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	
	}
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2 :
			System.out.println("Le soldat " + nom + " est déjà bien équipé !");
		case 1 :
			if (equipements[0] == equipement) {
				System.out.println("Le soldat "+nom+" possède déjà un "+equipement.toString());
			}
		default :
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement.toString());
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 10);
		System.out.println(Equipement.CASQUE +" "+ Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
//		System.out.println(romain.prendreParole());
//		romain.parler("Yo");
//		romain.recevoirCoup(210);
	}
	

}
