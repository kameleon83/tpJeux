package fr.joeltroch.m2iformation.jeu;

import fr.joeltroch.m2iformation.jeu.caracteristiques.Caracteristique;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementArmeEpee;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementObjetPotionMana;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementObjetPotionVie;
import fr.joeltroch.m2iformation.jeu.lieux.Lieu;
import fr.joeltroch.m2iformation.jeu.magie.MagieSortGlace;
import fr.joeltroch.m2iformation.jeu.magie.MagieSortSoins;
import fr.joeltroch.m2iformation.jeu.lieux.LieuArene;
import fr.joeltroch.m2iformation.jeu.lieux.LieuVille;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe principale de l'application.
 * @author Joël Troch
 */
public class Main {
	/** Numéro de la vague en cours. */
	private static int vagueActuelle = 1;

	/** Unique instance de la classe Scanner pour toute l'application (singleton). */
	private static final Scanner SCANNER = new Scanner(System.in);

	/**
	 * Retourne une liste des cibles potentielles.
	 * @param personnages La liste des personnages.
	 * @return La liste des cibles potentielles.
	 */
	public static List<Personnage> getListeCiblesPossibles(List<Personnage> personnages) {
		List<Personnage> resultat = new ArrayList<>();

		int j = 1;
		for (Personnage personnageActuel : personnages) {
			if (personnageActuel.getSante() > 0) {
				resultat.add(personnageActuel);
				System.out.println(j + ". " + personnageActuel.toString());
				j++;
			}
		}

		return resultat;
	}

	/**
	 * Retoune la seule instance de la classe Scanner (singleton).
	 * @return L'unique instance de Scanner utilisée dans toute le programme.
	 */
	public static Scanner getScanner() {
		return SCANNER;
	}

	public static int getVagueActuelle() {
		return vagueActuelle;
	}

	/**
	 * Crée un joueur et l'initialise (demande du nom, attribution des compétences...)
	 * @return Le joueur initialisé.
	 */
	private static PersonnageJoueur creerJoueur() {
		// Demande le nom du joueur
		System.out.println("Votre nom ?");
		final String nomJoueur = getScanner().nextLine();

		PersonnageJoueur joueur = new PersonnageJoueur(nomJoueur);

		System.out.println("\nBienvenue \"" + nomJoueur + "\" !");
		System.out.println("Vous allez dépenser " + Configuration.JOUEUR_DEPART_QUANTITE_POINTS_CARACTERISTIQUES +
				" points de compétences pour définir votre personnage.");
		System.out.println("Choissisez bien car vous ne pourrez pas revenir en arrière !\n");
		System.out.println("La Force (FOR) détermine votre capacité à manipuler les armes.");
		System.out.println("L'Intelligence (INT) détermine votre puissance de manipulation des sorts de magie.");
		System.out.println("La Mémoire (FOR) détermine votre capacité à manipuler des sorts de magie.");
		System.out.println("La Vitalité (VIT) détermine votre renforcement aux dégâts adverses.\n");

		depenserPointsCompetences(Configuration.JOUEUR_DEPART_QUANTITE_POINTS_CARACTERISTIQUES, joueur);

		final int santeMax = joueur.getSanteMax();
		final int manaMax = joueur.getManaMax();
		joueur.setSante(santeMax);
		joueur.setMana(manaMax);

		donnerEquipementDeDepart(joueur);
		donnerSortsDeDepart(joueur);

		return joueur;
	}

	/**
	 * Permet au joueur de dépenser ses points de compétences.
	 * @param pointsADepenser Le nombre de points de compétences à dépenser.
	 * @param joueur Le joueur concerné.
	 */
	public static void depenserPointsCompetences(int pointsADepenser, PersonnageJoueur joueur) {
		// Prépare une liste d'incréments
		List<Integer> resultat = new ArrayList<>();
		for (int i = 0; i < joueur.getListeCaracteristiques().size(); i++) {
			resultat.add(0);
		}

		// Tant qu'on a des points à dépenser
		while (pointsADepenser > 0) {
			System.out.println("Vous pouvez dépenser " + pointsADepenser + " points de compétences.\n");

			// Affiche les caractéristiques
			for (int i = 0; i < joueur.getListeCaracteristiques().size(); i++) {
				Caracteristique caracteristique = joueur.getListeCaracteristiques().get(i);

				System.out.println((i + 1) + ". " + caracteristique.toString() + " (" + caracteristique.getNomCourt() + ") - "
						+ (caracteristique.getNiveau() + resultat.get(i)) + "/"
						+ Configuration.CARACTERISTIQUE_NIVEAU_MAX);
			}

			// Demande de faire un choix
			System.out.println("\nChoix ?");
			int choix = getScanner().nextInt();
			getScanner().nextLine();

			// Le choix est valide
			if (choix > 0 && choix <= joueur.getListeCaracteristiques().size()) {
				// Vérifie qu'on ne dépasse pas le niveau maximum
				Caracteristique caracteristique = joueur.getListeCaracteristiques().get(choix - 1);
				final int niveauTest = caracteristique.getNiveau() + resultat.get(choix - 1) + 1;

				if (niveauTest <= Configuration.CARACTERISTIQUE_NIVEAU_MAX) {
					resultat.set(choix - 1, resultat.get(choix - 1) + 1);
					pointsADepenser--;
				} else {
					System.out.println("Niveau maximal atteint !");
				}
			} else {
				System.out.println("Choix invalide !");
			}
		}

		// Ajoute les points
		for (int i = 0; i < joueur.getListeCaracteristiques().size(); i++) {
			joueur.getListeCaracteristiques().get(i).addNiveau(resultat.get(i));
		}
	}

	/**
	 * Donne l'équipement de départ à un joueur spécifique.
	 * @param joueur Le joueur concerné.
	 */
	private static void donnerEquipementDeDepart(PersonnageJoueur joueur) {
		System.out.println("\nVous allez commencer une épée de faible qualité trouvée sur un champ de bataille abandonné.");
		System.out.println("Votre soeur vous a également confectionné une potion de soins et une potion de mana.");
		joueur.getListeEquipements().add(new EquipementArmeEpee());
		joueur.getListeEquipements().add(new EquipementObjetPotionVie());
		joueur.getListeEquipements().add(new EquipementObjetPotionMana());
	}

	/**
	 * Donne les sorts de départ à un joueur spécifique.
	 * @param joueur Le joueur concerné.
	 */
	private static void donnerSortsDeDepart(PersonnageJoueur joueur) {
		System.out.println("Durant votre enfance, votre grand-père vous a appris l'usage des sorts \"Soins\" et \"Glace\".");
		joueur.getListeSorts().add(new MagieSortSoins());
		joueur.getListeSorts().add(new MagieSortGlace());
	}

	/**
	 * Génère un nombre aléatoire entre un minimum et un maximum spécifique.
	 * @param min Le nombre minimum.
	 * @param max Le nombre maximum.
	 * @return Le nombre aléatoire généré.
	 */
	public static int genererNombreAleatoire(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

	public static void incrementVagueActuelle() {
		vagueActuelle++;
	}

	/**
	 * Point d'entrée de l'application.
	 * @param args Arguments de la ligne de commande.
	 */
	public static void main(String[] args) {
		// Initialise le joueur
		PersonnageJoueur joueur = creerJoueur();

		// Initialise les lieux
		int lieuActuel = 0;
		List<Lieu> lieux = new ArrayList<>();
		lieux.add(new LieuVille("Wolfenstein"));
		lieux.add(new LieuArene("Arène de la Badassitude"));

		// Introduction
		System.out.println("\nVous allez commencer dans la ville de \"Wolfenstein\" et la défendre de ses démons dans \"l'Arène de la Badassitude\".");
		System.out.println("Dès que vous êtes prêt(e), appuyez sur une touche et survivez le plus longtemps possible !");
		getScanner().nextLine();

		// Boucle principale du jeu
		System.out.println("Vague #" + vagueActuelle);
		boolean partieTerminee = joueur.getSante() < 0;
		while (!partieTerminee) {
			lieux.get(lieuActuel).parcourir(joueur);

			// Passe au lieu suivant (ou revient au point de départ en incrémentant la vague si on a tout fait)
			lieuActuel++;
			if (lieuActuel >= lieux.size()) {
				lieuActuel = 0;
			}

			partieTerminee = joueur.getSante() <= 0;
		}

		// Fin du jeu
		System.out.println("\"" + joueur.toString() + "\" est mort !");
		System.out.println("Partie terminée à la vague numéro " + vagueActuelle);
		getScanner().close();
	}
}
