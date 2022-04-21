package Vue;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Cases extends JLabel implements Serializable {
	private int ligne,colonne;// pour la lignes te la colones de la case
	private boolean occupe;// pour savoir si la case est occupée ou pas

	public Cases(int ligne,int colonne)
	{super();
		this.ligne=ligne;
	    this.colonne=colonne;
	    this.occupe=false;
		setOpaque(true);
	}
	public void setLigne(int ligne)
	{
		this.ligne=ligne;
	}
	public void setcolone(int colonne)
	{
		this.colonne=colonne;
	}
	public int getLigne()
	{
		return ligne;
	}
	public int getColone()
	{
		return colonne;
	}
	public void occuper()
	{
		occupe=true;
	}
	public void liberer()
	{
		occupe=false;
	}
	public boolean estoccuper()
	{
		return occupe;
	}
	
}
