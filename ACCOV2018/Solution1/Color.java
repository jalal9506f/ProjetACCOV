package Solution1;

public class Color
{
    public int couleurInterieure;
    private static final int Bleu = 0;
    private static final int Rouge = 1;
    private static final int Jaune = 2;
    public static final Color BLEU = new Color(Bleu);
    public static final Color ROUGE = new Color(Rouge);
    public static final Color JAUNE = new Color(Jaune);

    public Color(int color) {
        this.couleurInterieure = color % 3;
    }

    public Color changerCouleur(Color peerColor) {
        if (this.couleurInterieure == peerColor.couleurInterieure) {
            return new Color(this.couleurInterieure);
        }
        return new Color(3 - this.couleurInterieure - peerColor.couleurInterieure);
    }

    @Override
    public String toString() {
        if (this.couleurInterieure == Bleu) {
            return "Bleu";
        } else if (this.couleurInterieure == Rouge) {
            return "Rouge";
        }
        return "Jaune";
    }
}
