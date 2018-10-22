package Solution1;

public class TestSolution1
{
 public static Color[] groupeCouleurs=
    {
        Color.ROUGE,
        Color.BLEU,
        Color.JAUNE,
        Color.JAUNE,
        Color.ROUGE,
        Color.BLEU
    };
 public static Cameneon[] groupeCameneons=new Cameneon[groupeCouleurs.length];
 public static void main(String args[]){
     Mail mailCourant=new Mail();
     for(int i =0;i<groupeCouleurs.length;i++){
         groupeCameneons[i]=new Cameneon(mailCourant,new CameneonID(i),groupeCouleurs[i]);
         new Thread(groupeCameneons[i]).start();
     }
 }
}
