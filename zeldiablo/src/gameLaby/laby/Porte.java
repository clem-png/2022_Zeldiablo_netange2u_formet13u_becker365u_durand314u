package gameLaby.laby;

public class Porte extends Entite{
     private Declencheur declencheur;

     public Porte(int x , int y ){
          super(x,y);
          this.declencheur = null ;
     }

     public Declencheur getDeclencheur(){
          return this.declencheur;
     }
     public void setDeclencheur(Declencheur d){
          this.declencheur = d ;
     }

}
