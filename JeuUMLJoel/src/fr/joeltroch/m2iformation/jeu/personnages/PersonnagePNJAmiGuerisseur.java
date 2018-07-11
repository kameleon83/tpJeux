package fr.joeltroch.m2iformation.jeu.personnages;

/**
 * Classe qui représente un personnage non contrôlable qui soigne le joueur et redonne sa mana.
 * @author Joël Troch
 */
public class PersonnagePNJAmiGuerisseur extends PersonnagePNJAmi {
	/**
	 * Crée un personnage amical non contrôlable guérisseur avec un nom spécifique.
	 * @param nom Le nom de ce personnage amical non contrôlable guérisseur.
	 */
	public PersonnagePNJAmiGuerisseur(String nom) {
		super(nom);
	}

	@Override
	public void parler(PersonnageJoueur joueur) {
		System.out.println(this.nom + " : \"Bonjour " + joueur.toString() + ", voici de quoi te ressourcer.\"");

		final int santeMax = joueur.getSanteMax();
		final int manaMax = joueur.getManaMax();
		joueur.setSante(santeMax);
		joueur.setMana(manaMax);

		System.out.println("Vous avez maintenant " + santeMax + "/" + santeMax + " HP et " + manaMax + "/" + manaMax + " MP.");
	}
}
