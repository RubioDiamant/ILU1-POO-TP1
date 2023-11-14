package personnages;

public class Gaulois {

	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbtrophees;
	private Equipement[] trophees = new Equipement[100];
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

//	private String prendreParole() {
//
//		return "Le gaulois " + nom + " : ";
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoi un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3 + effetPotion);
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
	
	public void frapper(Romain romain) {
		Equipement[] trophees; //important de ne pas creer le tableau !
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbtrophees++) {
			this.trophees[nbtrophees] = trophees[i];
		}
	}


	
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("« Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée");
	}
	
	public void faireUneDonnation(Musee musee) {
		String elemTrophee = "";
		for(int i=0; i < nbtrophees; i ++) {
			elemTrophee += "- " +trophees[i].toString() + "\n";
			musee.donnerTrophee(this, trophees[i]);
		}
		parler("Je donne au musee tous mes trophees :\n" + elemTrophee);
		
	}
	
	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Asterix",8);
//		Romain romain = new Romain("test",8);
//		System.out.println(asterix.getNom());
//		System.out.println(asterix);
//		System.out.println(asterix.prendreParole());
//		asterix.parler("Yo");
//		asterix.frapper(romain);
//		asterix.boirePotion(6);
//		

		
		
	}

	
}
