package Modele;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

import Controller.*;
import Vue.*;
public class Nouriture implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cases casee;
    public Nouriture(Cases Case)
    {Case.setBackground(Color.GREEN);
    this.casee=Case;
    casee.occuper();
    	
    }
   
	public void setCase( Cases casee)
    {
    	this.casee=casee;
    }
    public Cases getCase()
    {
    	return this.casee;
    }
    
    public void placer()
    {int i = 0,j=0;
    	boolean trouv=false;
    	while (!trouv)
    	{
    		
    	 i = new Random().nextInt(100);
         j= new Random().nextInt(100);
    		if(!PanneauDeJeu.getCases()[i][j].estoccuper())
    			trouv=true;
    	}
    	casee.liberer();
    	casee=PanneauDeJeu.getCases()[i][j];
    	casee.occuper();
    	casee.setBackground(Color.GREEN);
    }
    
}
