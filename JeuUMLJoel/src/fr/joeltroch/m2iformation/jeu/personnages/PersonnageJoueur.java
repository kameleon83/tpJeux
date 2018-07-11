package fr.joeltroch.m2iformation.jeu.personnages;

import fr.joeltroch.m2iformation.jeu.Configuration;
import fr.joeltroch.m2iformation.jeu.Main;
import fr.joeltroch.m2iformation.jeu.caracteristiques.*;
import fr.joeltroch.m2iformation.jeu.competences.*;
import fr.joeltroch.m2iformation.jeu.equipements.Equipement;
import fr.joeltroch.m2iformation.jeu.equipements.EquipementArme;
import fr.joeltroch.m2iformation.jeu.magie.MagieSort;
import fr.joeltroch.m2iformation.jeu.statistiques.Statistique;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueInitiative;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueMana;
import fr.joeltroch.m2iformation.jeu.statistiques.StatistiqueVie;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente un personnage joueur.
 * @author Joël Troch
 */
public class PersonnageJoueur extends Personnage {
	/** Liste de l'équipement (inventaire) de ce joueur. */
	private final List<Equipement> listeEquipements = new ArrayList<>();
	/** Quantité de pièces d'or du joueur. */
	private int piecesOr;
	/** Quantité d'expérience du joueur. */
	private int pointsExperience;
	/** Expérience maximum pour passer au niveau suivant. */
	private int experienceMax;

	/**
	 * Crée un nouveau personnage joueur avec un nom spécifique.
	 * @param nom Le nom du joueur.
	 */
	public PersonnageJoueur(String nom) {
		super(nom);

		// Caractéristiques
		CaracteristiqueForce caracteristiqueForce = new CaracteristiqueForce(Configuration.JOUEUR_DEPART_NIVEAU_CARACTERISTIQUES);
		CaracteristiqueIntelligence caracteristiqueIntelligence = new CaracteristiqueIntelligence(Configuration.JOUEUR_DEPART_NIVEAU_CARACTERISTIQUES);
		CaracteristiqueMemoire caracteristiqueMemoire = new CaracteristiqueMemoire(Configuration.JOUEUR_DEPART_NIVEAU_CARACTERISTIQUES);
		CaracteristiqueVitalite caracteristiqueVitalite = new CaracteristiqueVitalite(Configuration.JOUEUR_DEPART_NIVEAU_CARACTERISTIQUES);
		this.listeCaracteristiques.add(caracteristiqueForce);
		this.listeCaracteristiques.add(caracteristiqueIntelligence);
		this.listeCaracteristiques.add(caracteristiqueMemoire);
		this.listeCaracteristiques.add(caracteristiqueVitalite);

		// Statistiques
		StatistiqueInitiative statistiqueInitiative = new StatistiqueInitiative(caracteristiqueForce, caracteristiqueIntelligence);
		StatistiqueMana statistiqueMana = new StatistiqueMana(caracteristiqueMemoire);
		StatistiqueVie statistiqueVie = new StatistiqueVie(caracteristiqueVitalite);
		this.listeStatistiques.add(statistiqueInitiative);
		this.listeStatistiques.add(statistiqueMana);
		this.listeStatistiques.add(statistiqueVie);

		// Compétences
		this.listeCompetences.add(new CompetenceAttaquer());
		this.listeCompetences.add(new CompetenceMagie());
		this.listeCompetences.add(new CompetenceObserver());
		this.listeCompetences.add(new CompetenceUtiliserObjet());

		// Attributs spécifiques au joueur
		this.piecesOr = Configuration.JOUEUR_DEPART_QUANTITE_PIECES_OR;
		this.experienceMax = Configuration.JOUEUR_EXPERIENCE_PAR_NIVEAU;
	}

	public List<Equipement> getListeEquipements() {
		return this.listeEquipements;
	}

	public int getPiecesOr() {
		return this.piecesOr;
	}

	public void addPiecesOr(int quantite) {
		this.piecesOr += quantite;
	}

	public void addPointsExperience(int quantite) {
		this.pointsExperience += quantite;
		if (this.pointsExperience > this.experienceMax) {
			this.niveau++;
			this.experienceMax = this.niveau * Configuration.JOUEUR_EXPERIENCE_PAR_NIVEAU;
			this.pointsExperience = 0;
			Main.depenserPointsCompetences(Configuration.JOUEUR_NIVEAU_SUP_QUANTITE_POINTS_CARACTERISTIQUES, this);
		}
	}

	@Override
	public void effectuerAction(List<Personnage> personnages) {
		boolean choixCorrect = false;

		while (!choixCorrect) {
			System.out.println(this.getSante() + "/" + this.getSanteMax() + " HP - " +  this.getMana() + "/" + this.getManaMax() + " MP.");
			System.out.println("Que souhaitez-vous faire ?");

			for (int i = 0; i < this.listeCompetences.size(); i++) {
				System.out.println((i + 1) + ". " + this.listeCompetences.get(i).toString());
			}

			System.out.println("\nChoix ?");
			int choix = Main.getScanner().nextInt();
			Main.getScanner().nextLine();

			if (choix > 0 && choix <= this.listeCompetences.size()) {
				if (this.listeCompetences.get(choix - 1).preparerCompetenceJoueur(this, personnages)) {
					choixCorrect = true;
				}
			} else {
				System.out.println("Choix invalide !");
			}
		}
	}

	/** Affiche la description complète du joueur (ses caractéristiques, statistiques...) */
	public void afficherDescription() {
		System.out.println("\nCaractéristiques :");
		for (Caracteristique caracteristique : this.listeCaracteristiques) {
			System.out.println(caracteristique.toString() + " - " + caracteristique.getNiveau());
		}

		System.out.println("\nStatistiques :");
		for (Statistique statistique : this.listeStatistiques) {
			System.out.println(statistique.toString() + " - " + statistique.getValeur());
		}

		System.out.println("\nEquipement :");
		for (Equipement equipement : this.listeEquipements) {
			if (equipement instanceof EquipementArme) {
				System.out.println("Arme - \"" + equipement.toString() + "\" - ~" + ((EquipementArme)equipement).getMoyenneDegats() + " DMG");
			} else {
				System.out.println("Objet - \"" + equipement.toString() +"\".");
			}
		}

		System.out.println("\nSorts :");
		for (MagieSort magieSort : this.listeSorts) {
			System.out.println("\"" + magieSort.toString() + "\" - consomme " + magieSort.getManaRequise() + " MP.");
		}

		System.out.println("\nPoints de vie : " +  this.getSante() + "/" + this.getSanteMax() + " HP.");
		System.out.println("Points de mana : " +  this.getMana() + "/" + this.getManaMax() + " MP.");
		System.out.println("Pièces d'or : " +  this.piecesOr + ".\n");
	}
}
