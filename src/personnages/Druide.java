package personnages;
import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private Random random = new Random();

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		while(forcePotion < effetPotionMin) {
			forcePotion = random.nextInt(effetPotionMax);
		}
		if (forcePotion > 7) {
			parler("J'ai pr�par� une super potion de force "+ forcePotion);
		}
		else {
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force "+ forcePotion);
		}
	}
	
	public void booster(Gaulois gaulois) {
		if(gaulois.getNom() == "Ob�lix") {
			parler("� Non, Ob�lix !... Tu n�auras pas de potion magique !");
			gaulois.parler("� Par B�l�nos, ce n'est pas juste !");
		}
		else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix",5,10);
		Gaulois obelix = new Gaulois("Ob�lix",25);
		Gaulois asterix = new Gaulois("Ast�rix",8);
		Romain minus = new Romain("Minus",6);
		druide.parler("Je vais aller pr�parer une petite potion...");
		druide.preparerPotion();
		druide.booster(obelix);
		druide.booster(asterix);
		asterix.parler("Bonjour !");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		
		
	}
}
