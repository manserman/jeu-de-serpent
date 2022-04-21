
package Controller;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import Modele.*;
import Vue.*;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class Jeu {
   private static ArrayList<Cases> nouvelle; 
  private static Serpent serp; 
  static Chrono chro;
  private static Nouriture nour;
  static Joueur j=new Joueur("Joueur");
  public static void init()
  {
 nour=new Nouriture(PanneauDeJeu.getCases()[10][20]);
 Panneau_principal.changer_score(0);
 Panneau_principal.changerMeil(j.getMeilleur_score());
 
  }
 public static void ChangerDir()// Déplacemnt provoqué par un changement de direction
	{if(!Panneau_principal.getdir().equals(serp.getDirection()))//Si la direction est différente de celle dans laquelle le serpent se dirige déjà
	  {switch (Panneau_principal.getdir())
		{
	  case "Droite":
		  if(!serp.getDirection().equals("Gauche"))
		  { if(serp.getTete().getLigne()==nour.getCase().getLigne() && serp.getTete().getColone()+1==nour.getCase().getColone())// Si la case cible contient une nouriture
			  {rencontrerNouriture();
		   serp.setdirection(Panneau_principal.getdir());
		   }
		  else  if(!serp.deplacement(Panneau_principal.getdir()))
			 perdre();}
		 
		  break;
	  case "Gauche":
		  if(!serp.getDirection().equals("Droite"))
		  {if(serp.getTete().getLigne()==nour.getCase().getLigne() && serp.getTete().getColone()-1==nour.getCase().getColone())
		  {rencontrerNouriture();
		  serp.setdirection(Panneau_principal.getdir());
		 } else  if(!serp.deplacement(Panneau_principal.getdir()))
			 perdre();}
		 
		  break;
	  case "Haut":
		  if(!serp.getDirection().equals("Bas"))
		  {if(serp.getTete().getLigne()-1==nour.getCase().getLigne() && serp.getTete().getColone()==nour.getCase().getColone())
		  { rencontrerNouriture();
		   serp.setdirection(Panneau_principal.getdir());}
		  else  if(!serp.deplacement(Panneau_principal.getdir()))
				 perdre();}
		 
		  break;
	  case "Bas":
		  if(!serp.getDirection().equals("Haut"))
		  {if(serp.getTete().getLigne()+1==nour.getCase().getLigne() && serp.getTete().getColone()==nour.getCase().getColone())
		  {rencontrerNouriture();
		   serp.setdirection(Panneau_principal.getdir());
		 }
		  else  if(!serp.deplacement(Panneau_principal.getdir()))
				 perdre();
		  }
		  
		  break;
		}
		
	  
	  }
	
	Panneau_principal.cliquer();
	}
  static Panneau_principal pan;
   private static boolean premiere=true;// Variable pour savoir si c'est le premier lancement du jeu;

  public static void serialiser()
  {
	  try {
		FileOutputStream file1=new FileOutputStream("C:\\Users\\Public\\FichierSerp.txt");
		 ObjectOutputStream os=new ObjectOutputStream(file1);
		  os.writeObject(j.getMeilleur_score());
		  os.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }
  public static void deserialiser()
  {
	  try {
		FileInputStream file1=new FileInputStream("C:\\Users\\Public\\FichierSerp.txt");
		 ObjectInputStream os=new ObjectInputStream(file1);
		
		  j.setMeilleur_score((int)os.readObject());
		
		  os.close();
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }
  public static void recommencer()
  {Panneau_principal.reset();
  j.setScore_courant(0);
  init();
  serp=new Serpent();
 
  } 
  public static void perdre()
  {new JOptionPane().showMessageDialog( pan, "Vous avez perdu");
  recommencer();

  }
  public static void rencontrerNouriture()
  {
	  serp.manger(nour);
	  nour.placer();
	  j.setScore_courant(serp.getScore());
	   if(j.getScore_courant()>j.getMeilleur_score())
	   {
		   j.setMeilleur_score(j.getScore_courant());
		   Panneau_principal.changerMeil(j.getMeilleur_score());
		   serialiser();
	   }
	   Panneau_principal.changer_score(j.getScore_courant());
  }
  
  public static void main(String args[]) throws InterruptedException {
	  try {FileInputStream file1=new FileInputStream("C:\\Users\\Public\\Fichierprem.txt");

		 ObjectInputStream os=new ObjectInputStream(file1);
		
		  premiere=(boolean)os.readObject();
		  os.close();
		
 		  
 	  }
 	  catch(Exception e)
 	  {e.printStackTrace();
 		  
 	  }
	  if(!premiere)
	  {deserialiser();}
	  java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
      pan= new Panneau_principal();
      init();
      serp=new Serpent();
      chro=new Chrono();
      chro.start();
      premiere=false;
      try {FileOutputStream file1=new FileOutputStream("C:\\Users\\Public\\Fichierprem.txt");

		 ObjectOutputStream os=new ObjectOutputStream(file1);
		
		  os.writeObject(premiere);
		  os.close();
		
		  }
	  catch(Exception e)
	  {e.printStackTrace();
		  
	  }}});
        	 
 }

  
  
  private static class Chrono extends Thread{// Class pour faire ne sorte que le serpent se déplace dans le temps
		private TimerTask tache=new TimerTask()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(Panneau_principal.getClic())
				{ {switch (serp.getDirection())
					{
					  case "Droite":
						  if(serp.getTete().getLigne()==nour.getCase().getLigne() && serp.getTete().getColone()+1==nour.getCase().getColone())
							  {rencontrerNouriture(); }
						 
						 
						  break;
					  case "Gauche":
						  if(serp.getTete().getLigne()==nour.getCase().getLigne() && serp.getTete().getColone()-1==nour.getCase().getColone())
						  { rencontrerNouriture();
						 }
						 
						  break;
					  case "Haut":
						  if(serp.getTete().getLigne()-1==nour.getCase().getLigne() && serp.getTete().getColone()==nour.getCase().getColone())
						  { rencontrerNouriture();}
						  break;
					  case "Bas":
						  if(serp.getTete().getLigne()+1==nour.getCase().getLigne() && serp.getTete().getColone()==nour.getCase().getColone())
						  {
							  rencontrerNouriture();
						  }
						  
						  
						  break;
						}
						
					  
					  }
				  if(!serp.deplacement(serp.getDirection()))
					 perdre();
				 }
				
				
			}
			};
			
		public void run()
		{Timer chrono= new Timer();
		
			
		chrono.schedule(tache,0,100);
			
		}
		
		}
  
}
 
    
