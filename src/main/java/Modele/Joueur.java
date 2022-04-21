package Modele;

import java.io.Serializable;

public class Joueur implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 7394295211216735271L;
private String nom;
private int meilleur_score,score_courant;
public Joueur(String nom)
{this.nom=nom;
meilleur_score=0;
score_courant=0;
	}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public int getMeilleur_score() {
	return meilleur_score;
}
public void setMeilleur_score(int meilleur_score) {
	this.meilleur_score = meilleur_score;
}
public int getScore_courant() {
	return score_courant;
}
public void setScore_courant(int score_courant) {
	this.score_courant = score_courant;
}
}
