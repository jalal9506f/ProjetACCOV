package Solution1;

public class Cameneon implements Runnable
{
 public Mail mail;
 public CameneonID id;
 public Color myColor, peerColor;

 public Cameneon(Mail mail, CameneonID id, Color color) {
        this.mail = mail;
        this.id = id;
        this.myColor = color;
 }
 public void donnerInformation(String infoCourant) {
        System.out.println("Mon ID est " + this.id + " Mon Couleur est: " + this.myColor + " et " + infoCourant);
 }
 public void manger() {
        this.donnerInformation("Je mange");
 }
 public void entrainer() {
        this.donnerInformation("J'entraine");
 }
 public void allerAuMail() {
        this.donnerInformation("Allant mail");
 }
 public void faireMutation() 
 {
     this.donnerInformation("je veux faire une mutation");
     this.peerColor=mail.cooperation(this.id, myColor);
     this.myColor=this.myColor.changerCouleur(peerColor);
     this.donnerInformation("la mutation est fini");
 }
 public void run() {
      while (true) {
            manger();
            entrainer();
            allerAuMail();
            faireMutation();
      }
 }
}
