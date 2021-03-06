package fr.joeltroch.m2iformation.jeu.lieux;

import fr.joeltroch.m2iformation.jeu.App;
import fr.joeltroch.m2iformation.jeu.personnages.Personnage;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnageJoueur;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJEnnemi;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJEnnemiFeuFollet;
import fr.joeltroch.m2iformation.jeu.personnages.PersonnagePNJEnnemiZombie;
import fr.joeltroch.m2iformation.jeu.statistiques.Statistique;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueInitiative;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente une arène.
 * @author Joël Troch
 */
public class LieuArene extends Lieu {
	/** Liste des personnages dans cette arène. */
	private final List<Personnage> personnages = new ArrayList<>();

	/**
	 * Crée une nouvelle arène avec un nom spécifique.
	 * @param nom Le nom de l'arène.
	 */
	public LieuArene(String nom) {
		super(nom);
	}

	/**
	 * Indique si la partie est terminée ou non (le joueur est mort ou tous les ennemis sont morts).
	 * @param personnages La liste des personnages dans ce lieu.
	 * @return <code>true</code> si le joueur ou les ennemis sont morts, <code>false</code> dans le cas contraire
	 */
	boolean finDePartie(List<Personnage> personnages) {
		boolean joueurTrouve = false;
		boolean ennemiTrouve = false;

		for (Personnage personnage : personnages) {
			if (personnage.getSante() <= 0)
				continue;

			if (personnage instanceof PersonnageJoueur) {
				joueurTrouve = true;
			} else if (personnage instanceof PersonnagePNJEnnemi) {
				ennemiTrouve = true;
			}
		}

		return !joueurTrouve || !ennemiTrouve;
	}

	@Override
	public void parcourir(PersonnageJoueur joueur) {
		this.personnages.clear();
		if (App.getVagueActuelle() % 5 == 0) {
			System.out.println("UN BOSS APPARAIT !!!");
			this.personnages.add(new PersonnagePNJEnnemiZombie(true));
		} else {
			this.personnages.add(new PersonnagePNJEnnemiZombie(false));
			this.personnages.add(new PersonnagePNJEnnemiZombie(false));
			this.personnages.add(new PersonnagePNJEnnemiFeuFollet(false));
		}
		this.personnages.add(joueur);

		// Trie la liste selon l'initiative
		// Etant donné qu'il n'y a pas "d'égalité", on peut ignorer l'avertissement
		//noinspection ComparatorMethodParameterNotUsed
		this.personnages.sort((personnage1, personnage2) -> {
			Statistique s1 = null;
			for (Statistique statistique : personnage1.getListeStatistiques()) {
				if (statistique instanceof StatistiqueInitiative) {
					s1 = statistique;
					break;
				}
			}

			Statistique s2 = null;
			for (Statistique statistique : personnage2.getListeStatistiques()) {
				if (statistique instanceof StatistiqueInitiative) {
					s2 = statistique;
					break;
				}
			}

			if (s1 == null && s2 == null) { // Les 2 n'ont pas de statistique, aléatoire
				return App.genererNombreAleatoire(0, 1) == 0 ? -1 : 1;
			} else if (s1 == null) { // A n'a pas la statistique
				return 1;
			} else if (s2 == null) { // B n'a pas la statistique
				return -1;
			} else { // Les 2 ont la statistique
				if (s1.getValeur() == s2.getValeur()) { // Valeurs identiques, aléatoire
					return App.genererNombreAleatoire(0, 1) == 0 ? -1 : 1;
				} else if (s1.getValeur() > s2.getValeur()) { // A > B
					return -1;
				} else { // A < B
					return 1;
				}
			}
		});

		int tour = 0;
		while (!this.finDePartie(this.personnages)) {
			Personnage personnageActuel = this.personnages.get(tour);

			// Ignore les personnages morts !
			if (personnageActuel.getSante() > 0) {
				personnageActuel.effectuerAction(this.personnages);
			}

			tour++;
			if (tour >= this.personnages.size()) {
				tour = 0;
			}
		}

		if (joueur.getSante() > 0) {
			final int experienceADonner = App.genererNombreAleatoire(25, 50);
			final int piecesOrADonner = App.genererNombreAleatoire(50, 100);

			joueur.addPiecesOr(piecesOrADonner);
			joueur.addPointsExperience(experienceADonner);

			System.out.println("Vous avez gagné " + piecesOrADonner + " pièces d'or (PO) et " + experienceADonner + " points d'expérience (XP) !");

			App.incrementVagueActuelle();
			System.out.println("Vague #" + App.getVagueActuelle());
		}
	}
}
