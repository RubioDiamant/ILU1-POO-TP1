package histoire;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

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
