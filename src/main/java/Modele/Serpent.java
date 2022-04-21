
package Modele;
import Vue.*;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import Controller.*;
public class Serpent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4798029764674548385L;
	private int score;
	private ArrayList<Cases> cases;
	private String direction;
	private int i=0;
	public Serpent()
	{score=0;
		direction="Droite";
		cases= new ArrayList();
		cases.add(0,PanneauDeJeu.getCases()[5][10]);
		cases.add(0,PanneauDeJeu.getCases()[5][11]);
		cases.add(0,PanneauDeJeu.getCases()[5][12]);
		this.cases=cases;
		  for(int i=0;i<cases.size();i++)
			  cases.get(i).occuper();
	}
	public int getScore()
	{
		return score;
	}
	public String  getDirection()
	{
		return direction;
	}
	public ArrayList<Cases> getCases()
	{ return cases;
		
	}
	public Cases getTete()
	{
		return cases.get(0);
	}
	public Cases getQueue(){
		return cases.get(cases.size()-1); 
	}
	public void augementerScore(int t) {
		score=score+t;
		
	}
	public void setCase(Cases nouvelletete)
	{
		this.cases.add(0, nouvelletete);
	}

	public boolean deplacement( String directi)
	{if(i==0)
		{cases.get(cases.size()-1).liberer();
		PanneauDeJeu.peindre();}
		switch (directi) {
		case "Gauche":
			if(!this.direction.equals("Droite"))
		{if(getTete().getColone()==0)
			return false;
				cases.get(cases.size()-1).setBackground(Color.LIGHT_GRAY);
				cases.get(cases.size()-1).liberer();
		cases.remove(cases.size()-1);
		Cases ca=PanneauDeJeu.getCases()[getTete().getLigne()][getTete().getColone()-1];
		cases.add(0,ca);// ajout de la case d'à gauche
			this.direction=directi;
			for(int i=0;i<cases.size();i++)
				cases.get(i).setBackground(Color.black);
			return netouchesUneAutreparite();}
			break;
		case "Droite":
			if(!this.direction.equals("Gauche"))
		{
				if(getTete().getColone()==99)
					return false;
		cases.get(cases.size()-1).setBackground(Color.LIGHT_GRAY);
		cases.get(cases.size()-1).liberer();
		cases.remove(cases.size()-1);
		Cases ca=PanneauDeJeu.getCases()[getTete().getLigne()][getTete().getColone()+1];
		ca.occuper();
				cases.add(0,ca);// ajout de la case d'à droite	
			this.direction=directi;
			for(int i=0;i<cases.size();i++)
				cases.get(i).setBackground(Color.black);
			return netouchesUneAutreparite();}
			break;
		case "Haut":
			if(!this.direction.equals("Bas"))
		{if(getTete().getLigne()==0)
			return false;
				cases.get(cases.size()-1).setBackground(Color.LIGHT_GRAY);
		cases.get(cases.size()-1).liberer();
		cases.remove(cases.size()-1);
		Cases ca=PanneauDeJeu.getCases()[getTete().getLigne()-1][getTete().getColone()];
		cases.add(0,ca);// ajout de la case d'à gauche// ajout de la case d'à droite	
			this.direction=directi;
			for(int i=0;i<cases.size();i++)
				cases.get(i).setBackground(Color.black);
			return netouchesUneAutreparite();}
			break;
		case "Bas":
			i++;
			if(!this.direction.equals("Haut"))
		{if(getTete().getLigne()==99)
			return false;
				cases.get(cases.size()-1).setBackground(Color.LIGHT_GRAY);
		cases.get(cases.size()-1).liberer();
		cases.remove(cases.size()-1);
		Cases ca=PanneauDeJeu.getCases()[getTete().getLigne()+1][getTete().getColone()];
		cases.add(0,ca);// ajout de la case d'à gauche/ ajout de la case d'à droite
		this.direction=directi;
			for(int i=0;i<cases.size();i++)
			cases.get(i).setBackground(Color.black);
			return netouchesUneAutreparite();}
			break;
			
		}
		
		
	return true;	
		
	}
	public void manger(Nouriture n)
	{
		cases.add(0,n.getCase());
		this.score+=10;
		n.getCase().setBackground(Color.black);
		
	}
	public boolean netouchesUneAutreparite()
	{
		for(int i=1;i<cases.size();i++)
			if(cases.get(i).getLigne()==cases.get(0).getLigne() && cases.get(i).getColone()==cases.get(0).getColone() )
				return false;
		return true;
	}
	public void setdirection(String dir)
	{
		direction=dir;
	}
    
}
