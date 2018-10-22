package Solution1;

public class Mail
{
    public Color color1, color2;
    public Boolean premiereAppelCameneon = true;
    public Boolean hold = false;

    public synchronized Color cooperation(CameneonID id, Color color) {
        Color gainedColor;
        while (hold) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        if (this.premiereAppelCameneon) {
            this.color1 = color;
            this.premiereAppelCameneon = false;
            while (!this.premiereAppelCameneon) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            this.hold=false;
            gainedColor=this.color2;
            notifyAll();
        }
        else{
            this.color2=color;
            gainedColor=this.color1;
            this.premiereAppelCameneon=true;
            this.hold=true;
            notifyAll();
        }
        return gainedColor;
    }
}
