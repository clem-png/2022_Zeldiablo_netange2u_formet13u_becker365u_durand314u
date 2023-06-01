package gameLaby.laby;

public class Porte {
     int x , y ;
     private Declencheur declencheur;
     private boolean ouvert ;

     public Porte(int x , int y , Declencheur dec){
          this.x = x ;
          this.y = y ;
          this.declencheur = dec ;
          this.ouvert = false ;
     }

     public boolean etrePresent(int x , int y ){
          boolean b = false;
          if (this.x ==x && this.y == y ) {
               b = true;
          }
          return b ;
     }

     public void ouvrir(){
          if (this.declencheur.getActive()){
               this.ouvert=true;
          }
     }

     public boolean getOuvert(){
          return this.ouvert ;
     }

     public Declencheur getDeclencheur(){
          return this.declencheur;
     }

}
