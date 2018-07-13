package fr.joeltroch.m2iformation.jeu.lieux;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJAmi;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJAmiGuerisseur;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJAmiMarchand;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente une ville.
 * @author Joël Troch
 */
public class LieuVille extends Lieu {
	/** Liste des personnages dans cette ville. */
	private final List<PersonnagePNJAmi> personnages = new ArrayList<>();

	/**
	 * Crée une nouvelle ville avec un nom spécifique.
	 * @param nom Le nom de la ville.
	 */
	public LieuVille(String nom) {
		super(nom);
		this.personnages.add(new PersonnagePNJAmiGuerisseur("Jean-Louis Christophe Le Soigneur"));
		this.personnages.add(new PersonnagePNJAmiMarchand("Jean-Louis David Le Marchand"));
	}

	@Override
	public void parcourir(PersonnageJoueur joueur) {
		boolean quitterVille = false;

		while (!quitterVille) {
			System.out.println("Localisation: Ville de \"" + this.nom + "\".\n");

			// Liste les personnages
			int i = 0;
			while (i < this.personnages.size()) {
				PersonnagePNJAmi personnage = this.personnages.get(i);
				System.out.println((i + 1) + ". Parler à \"" + personnage.toString() + "\".");
				i++;
			}
			// Affiche les statistiques détaillés du joueur
			System.out.println((i + 1) + ". Statistiques du joueur.");
			i++;

			// Quitte la ville
			System.out.println((i + 1) + ". Quitter la ville.");
			i++;

			// Choix joueur
			System.out.println("\nChoix ?");
			int choix = App.getScanner().nextInt();
			App.getScanner().nextLine();

			if (choix <= 0 || choix > i) {
				System.out.println("Choix invalide !");
			} else if (choix < i - 1) { // PNJ amis
				this.personnages.get(choix - 1).parler(joueur);
			} else if (choix == i - 1) { // Statistiques
				joueur.afficherDescription();
			} else { // Quitter la ville
				quitterVille = true;
			}
		}
	}
}
