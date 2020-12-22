
package javafxapplication2;

public class Voiture {
    private int matricule;
    private String modele;
    private String marque;
    private float kilometrage;
    private String couleur;
    
public Voiture(){super();}    
    
public Voiture(int i,String n,String m,float k,String c)
{
    matricule =i;
    modele=n;
    marque=m;
    kilometrage=k;
    couleur=c;
}
    
 public void setMatricule (int i) {matricule=i;}
 public void setModele(String n){modele=n;}
 public void setMarque(String m){marque=m;}
 public void setKilometrage(float k){kilometrage=k;}
 public void setCouleur(String c){couleur=c;}
 
 public int getMatricule(){return matricule;}
 public String getModele(){return modele;}
 public String getMarque(){return marque;}
 public float getKilometrage(){return kilometrage ;}
 public String getCouleur(){return couleur;}


    
}
