package util.graph;

import util.intset.IntSet;

import java.util.*;
import java.util.List;


public class ColorGraph {
    public  Graph          G;
    public  int            R;
    public  int            K;
    private Stack<Integer> pile; // c'est une file pas une pile :D
    public  IntSet         enleves;
    public  IntSet         deborde;
    public  int[]          couleur;
    public  Node[]         int2Node;
    static  int            NOCOLOR = -1;

    public ColorGraph(Graph G, int K, int[] phi){
        this.G       = G;
        this.K       = K;
        pile         = new Stack<>();
        R            = G.nodeCount();
        couleur      = new int[R];
        enleves      = new IntSet(R);
        deborde        = new IntSet(R);
        int2Node     = G.nodeArray();
        for(int v=0; v < R; v++){
            int preColor = phi[v];
            if(preColor >= 0 && preColor < K) {
                enleves.add(v);
                couleur[v] = phi[v];
            }
            else
                couleur[v] = NOCOLOR;
        }
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* associe une couleur à tous les sommets se trouvant dans la pile */
    /*-------------------------------------------------------------------------------------------------------------*/

    public void selection() {
        while (!pile.isEmpty()) {
            int i = pile.pop();
            IntSet c = this.couleursVoisins(i);
            if(c.getSize() != this.K)
                couleur[i] = choisisCouleur(couleursVoisins(i));
        }
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* récupère les couleurs des voisins de t */
    /*-------------------------------------------------------------------------------------------------------------*/

    public IntSet couleursVoisins(int t) {
        Node node = G.nodeArray()[t];
        IntSet color = new IntSet(K);
        var nodes = List.of(int2Node);
        for(var succ = node.succ() ; succ != null ; succ = succ.tail) {
            int index = nodes.indexOf(succ.head);
            int c = couleur[index];
            if(c >= 0)
                color.add(c);
        }
        return color;
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* recherche une couleur absente de colorSet */
    /*-------------------------------------------------------------------------------------------------------------*/

    public int choisisCouleur(IntSet colorSet){
        for (int i = 0; i < colorSet.getSize(); i++)
            if(!colorSet.isMember(i))
                return i;
        return NOCOLOR;
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /* calcule le nombre de voisins du sommet t */
    /*-------------------------------------------------------------------------------------------------------------*/

    public int nbVoisins(int t) {
        Node node = int2Node[t];
        return node.len(node.adj());
    }


    private int nbPreCo() {
        int nb = 0;
        for (int c : couleur)
            if (c != NOCOLOR)
                nb++;

        return nb;
    }
    /*-------------------------------------------------------------------------------------------------------------*/
    /* simplifie le graphe d'interférence g                                                                        */
    /* la simplification consiste à enlever du graphe les temporaires qui ont moins de k voisins                   */
    /* et à les mettre dans une pile                                                                               */
    /* à la fin du processus, le graphe peut ne pas être vide, il s'agit des temporaires qui ont au moins k voisin */
    /*-------------------------------------------------------------------------------------------------------------*/

    public void simplification() {
        boolean asChanged = true;
        while (pile.size() != (this.R - this.nbPreCo()) && asChanged) {
            asChanged = false;
            for (int i=0 ; i < R ; i++) {
                if (!enleves.isMember(i)) {
                    if (nbVoisins(i) < K && couleur[i] == NOCOLOR) {
                        pile.push(i);
                        enleves.add(i);
                        asChanged = true;
                    }
                }
            }
        }
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/

    public void debordement() {
        while(pile.size() != 0){
            for(Node node : int2Node){
                if(enleves.isMember(node.mykey)){
                    pile.push(node.mykey);
                    enleves.add(node.mykey);
                    deborde.add(node.mykey);
                    simplification();
                    break;
                }
            }
        }
    }


    /*-------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/

    public void coloration() {
        this.simplification();
        this.debordement();
        this.selection();
    }

    void affiche() {
        System.out.println("vertex\tcolor");
        for(int i = 0; i < R; i++){
            System.out.println(i + "\t" + couleur[i]);
        }
    }



}
