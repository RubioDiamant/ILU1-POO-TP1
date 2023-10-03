package histoire;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix",5,10);
		Gaulois obelix = new Gaulois("Obélix",25);
		Gaulois asterix = new Gaulois("Astérix",8);
		Romain minus = new Romain("Minus",6);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		druide.booster(obelix);
		druide.booster(asterix);
		asterix.parler("Bonjour !");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);

	}

}
