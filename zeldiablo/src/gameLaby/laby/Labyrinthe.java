package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char MONSTRE = 'M';

    public static final char PORTE = 'D';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    public Perso pj;
    ArrayList<Monstre> monstres;

    /**
     * les portes du labyrinthe
     */

    ArrayList<Porte> portes;

    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    public ArrayList<Integer> colVide;
    public ArrayList<Integer> ligVide;

    int nbCaseVide;

    ArrayList<Declencheur> Trigger;

    public boolean enAttaque;


    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    public static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        this.monstres = new ArrayList<Monstre>();
        this.portes = new ArrayList<Porte>();
        this.colVide = new ArrayList<Integer>();
        this.ligVide = new ArrayList<Integer>();

        enAttaque = false;


        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        int nbCaseVide = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:

                        this.murs[colonne][numeroLigne] = false;
                        this.colVide.add(colonne);
                        this.ligVide.add(numeroLigne);
                        nbCaseVide++;
                        break;
                    case ';':
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                        break;
                    case MONSTRE:
                        //pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        //ajout du monstre
                        this.monstres.add(new Monstre(colonne, numeroLigne));
                        break;
                    case PORTE:
                        //pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        //ajout de la porte
                        this.portes.add (new Porte(colonne, numeroLigne));
                        break;
                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }
            if (portes != null) {
                this.Trigger = new ArrayList<Declencheur>();
                for (int a = 0; a < this.portes.size(); a++) {
                    int var = (int) (Math.random() * nbCaseVide);
                    Declencheur d  = new Declencheur(this.colVide.get(var), this.ligVide.get(var));
                    this.Trigger.add(d);
                    //enleve la case vide de la liste
                    this.colVide.remove(var);
                    this.ligVide.remove(var);
                    nbCaseVide--;
                    this.portes.get(a).setDeclencheur(d);
                }
            }




            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }

    public void deplacerMonstreAll(){
        int alea = 0;
        for (int q = 0; q < this.monstres.size(); q++) {
            alea = (int) (Math.random() * 4);

            boolean surMonstre = false;
            boolean surPorte = false;
            boolean surPj = false;
            // case courante
            int[] courante = {this.monstres.get(q).x, this.monstres.get(q).y};

            String action = "";
            switch (alea) {
                case 0:
                    action = HAUT;
                    break;
                case 1:
                    action = BAS;
                    break;
                case 2:
                    action = DROITE;
                    break;
                case 3:
                    action = GAUCHE;
                    break;
            }

            int[] suivante = getSuivant(courante[0], courante[1], action);

            // si c'est pas un mur, on effectue le deplacement
            if (!this.murs[suivante[0]][suivante[1]]) {
                if (this.monstres != null) {
                    for (int i = 0; i < this.monstres.size(); i++) {
                        if (this.monstres.get(i).etrePresent(suivante[0], suivante[1])) {
                            // on met a jour personnage
                            surMonstre = true;
                        }
                    }
                    if (!surMonstre) {
                        if(this.portes != null){
                            for(int i = 0; i < this.portes.size(); i++){
                                if((this.portes.get(i).etrePresent(suivante[0], suivante[1])) && (!this.portes.get(i).getDeclencheur().getActive())){
                                    surPorte = true;
                                }
                            }
                        }
                        if (!surPorte) {

                            if(this.pj.etrePresent(suivante[0], suivante[1])){
                                surPj = true;
                            }
                            if(!surPj){
                                this.monstres.get(q).x = suivante[0];
                                this.monstres.get(q).y = suivante[1];
                            }
                            else{
                                surPj = false;
                            }
                        }
                        else {
                            // on met a jour personnage
                            surPorte = false;
                        }
                    }
                    else {
                        surMonstre = false;
                    }
                } else {
                    // on met a jour personnage
                    this.monstres.get(q).x = suivante[0];
                    this.monstres.get(q).y = suivante[1];
                }
            }

        }
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {

        boolean surMonstre = false;
        boolean surPorte = false;
        // case courante
        int[] courante = {this.pj.x, this.pj.y};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]] && enAttaque == false) {
            if (this.monstres != null) {
                for (int i = 0; i < this.monstres.size(); i++) {
                    if (this.monstres.get(i).etrePresent(suivante[0], suivante[1])) {
                        // on met a jour personnage
                        surMonstre = true;
                    }
                }
                if (!surMonstre) {
                    if(this.portes != null){
                        for(int i = 0; i < this.portes.size(); i++){
                            if((this.portes.get(i).etrePresent(suivante[0], suivante[1])) && (!this.portes.get(i).getDeclencheur().getActive())){
                                surPorte = true;
                            }
                        }
                    }
                    if (!surPorte) {
                        this.pj.x = suivante[0];
                        this.pj.y = suivante[1];
                    }
                    else {
                        // on met a jour personnage
                        surPorte = false;
                    }
                }
                else {
                    surMonstre = false;
                }
            } else {
                // on met a jour personnage
                this.pj.x = suivante[0];
                this.pj.y = suivante[1];
            }
        }

        if (this.Trigger != null) {
            for (int i = 0; i < this.Trigger.size(); i++) {
                if (this.Trigger.get(i).etrePresent(this.pj.x, this.pj.y)) {
                    this.Trigger.get(i).setActive();
                    System.out.println("porte active : " + this.Trigger.get(i).getActive());
                }
            }
        }
    }

    public void attaque (){
        enAttaque = true;
        String[] tab = new String[4];
        tab[0] = HAUT;
        tab[1] = BAS;
        tab[2] = DROITE;
        tab[3] = GAUCHE;

        for (int i = 0; i < 4; i++) {
            int[] suivante = getSuivant(this.pj.x, this.pj.y, tab[i]);
            if (this.monstres != null) {
                for (int j = 0; j < this.monstres.size(); j++) {
                    if (this.monstres.get(j).etrePresent(suivante[0], suivante[1])) {
                        this.monstres.get(j).subirAttaque();
                        if (this.monstres.get(j).etreMort() == true) {
                            this.monstres.remove(j);
                        }
                    }
                }
            }
        }
        enAttaque = false;
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     *
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

}
