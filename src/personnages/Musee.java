package personnages;

public class Musee {
	private Trophee[] trophee = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		boolean tropheeAdded = false;
		for(int i = 0; i<nbTrophee; i++) {
			if(trophee[i] == null && !(tropheeAdded)) {
				trophee[i] = new Trophee(gaulois, equipement);
				tropheeAdded = true;
				nbTrophee ++;
			}
		}
	}
}
