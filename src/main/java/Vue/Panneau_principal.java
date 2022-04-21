
package Vue;
import Controller.*;
import Modele.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author Mansour
 */
public class Panneau_principal extends JFrame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6966359832802654323L;
	private JButton pause;
    private JButton Startt;
    private JButton Quitter;
    private JButton Recommencer;
    private static String key;
	private static boolean clic;
    private static boolean jeu_cours;
    private static PanneauDeJeu panneau;
    private static JLabel score;
    private static JLabel meilleur_score;
   private JPanel  principal=new JPanel();
   private JPanel controle= new JPanel();
   Panneau_principal prin;

    /**
     * Creates new form Panneau_principal
     */
    public Panneau_principal() {
    	this.setSize(900, 700);
     	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     	this.toFront();
     	this.requestFocus();
     	this.setLocationRelativeTo(null);
     	prin=this;
    	  pause = new JButton("Pause");
          Startt = new JButton("Start");
          Quitter = new JButton("Quitter");
          Recommencer = new JButton("Recommencer");
          score=new JLabel("Votre socre est:");
          meilleur_score=new JLabel("votre meilleur score est: ");
          pause.setSize(30,30);
          Startt.setSize(30,30);
          Quitter.setSize(30,30);
          Startt.setSize(30,30);
          controle.setBounds(5, 5, this.getWidth(),70 );
          controle.add(Quitter);
          controle.add(Recommencer);
          controle.add(pause);
          controle.add(Startt);
          controle.add(score);
          controle.add(meilleur_score);
         controle.setBackground(Color.CYAN);
          panneau= new PanneauDeJeu();
          panneau.init();
          principal=(JPanel)getContentPane();
          principal.setLayout(null);
          panneau.setBounds(5, 85,400,400);
          panneau.setBackground(Color.black);
         principal.add(controle);
         principal.add(panneau);
         panneau.init();
         jeu_cours=false;
         Startt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clic=true;
				
			}
		});
         Startt.addKeyListener(new KeyListener()
			{@Override
          	public void keyTyped(KeyEvent e) {
          		// TODO Auto-generated method stub
          	

          	}

          	@Override
          	public void keyPressed(KeyEvent e) {
          		// TODO Auto-generated method stub
          		clic=false; 
            switch (e.getKeyCode())
            {case KeyEvent.VK_UP:
            	key="Haut";
            	Jeu.ChangerDir();
            	break;
            case KeyEvent.VK_DOWN:
            	 
            	key="Bas";
            	Jeu.ChangerDir();
            	break;
            case KeyEvent.VK_RIGHT:
            	
            	key="Droite";
            	Jeu.ChangerDir();
            	break;
            case KeyEvent.VK_LEFT:
            	
            	key="Gauche";
            	Jeu.ChangerDir();
            	break;
            	default:
            		clic=true;
            }

          	}

          	@Override
          	public void keyReleased(KeyEvent e) {
          		// TODO Auto-generated method stub
          
          	}});
         
      	this.setVisible(true);
     	
          pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clic=false;
				
				
			}
		});
      	
          Recommencer.addActionListener(new ActionListener()
        		  {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						clic=false;
						Jeu.recommencer();
		}        		  });
          Quitter.addActionListener(new ActionListener()
        		  {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						clic=false;
						prin.dispose();
						
					}
        	  
        		  });
    }
   
 
 
    
 

    public static String getdir()
  	{
  		return key;
  	}
    
   public static boolean getClic()
   {
	   return clic;
   }
   public static void changer_score(int sco)
   { score.setText("Votre score est: "+sco);
	   
   }
   public static void changerMeil(int sco)
   { meilleur_score.setText("Votre meilleur score est: "+sco);
	   
   }
    	
    public static void cliquer()
    {
    	clic=true;
    }
    public static void reset()
    {
    	panneau.init();
    	changer_score(0);
    }
}
