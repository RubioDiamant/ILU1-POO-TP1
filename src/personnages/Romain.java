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
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		// TODO Auto-generated method stub
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		force -= forceCoup;
//		if(force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//	
//	}
	
	public void sEquiper(Equipement equipementEntre) {
		switch (nbEquipement) {
		case 2 :
			System.out.println("Le soldat " + nom + " est d�j� bien �quip� !");
			break;
		case 1 :
			if (equipements[0] == equipementEntre) {
				System.out.println("Le soldat "+nom+" poss�de d�j� un "+ equipementEntre);
			}
			else {
				equipements[nbEquipement] = equipementEntre;
				System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipementEntre);
				nbEquipement ++;
			}
			break;
		default :
			equipements[nbEquipement] = equipementEntre;
			nbEquipement++;
			System.out.println("Le soldat " + nom + " s'�quipe avec un " + equipementEntre);
		}
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de "  + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else if (equipements[i] != null && equipements[i].equals(Equipement.CASQUE)) {
			
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}


	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		//pr�condition
		assert force > 0;
		int oldForce = force;
		
		forceCoup = calculResistanceEquipement(forceCoup);
		if(forceCoup < 0) {forceCoup = 0;}
		
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminu�e
		assert force < oldForce;
		return equipementEjecte;
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
