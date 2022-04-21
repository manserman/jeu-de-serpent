package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PanneauDeJeu extends JPanel {
	
    private static Cases[][] cases;
    public PanneauDeJeu()
{this.setLayout(new GridLayout(100,100));
    	  cases=new Cases[100][100];
          for(int i=0;i<100;i++)
          	for(int j=0;j<100;j++)
          	{cases[i][j]= new Cases(i,j);
          		this.add(cases[i][j]);}
          	
        

    
    }
    public static Cases[][] getCases()
    {
		return cases;
    	}

 public static void peindre()
 {for(int i=0;i<100;i++)
   	for(int j=0;j<100;j++)
   		if(!cases[i][j].estoccuper())
   			cases[i][j].setBackground(Color.LIGHT_GRAY);
	 
 }
 public static void init()
 {
	 for(int i=0;i<100;i++)
       	for(int j=0;j<100;j++)
       	{
       		cases[i][j].setBackground(Color.LIGHT_GRAY);
       		cases[i][j].liberer();
       		}
       for(int i=10;i<13;i++)
       {
     	  cases[5][i].setBackground(Color.black);
     	  cases[5][i].occuper();
       }
 }
    }
