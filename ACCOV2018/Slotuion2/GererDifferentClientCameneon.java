package Slotuion2;


import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GererDifferentClientCameneon implements Runnable{

    private final Cameneon cameneon;
    private final GererListeCameneon listeCameneon;

    /**
     * Constructeur.
     *
     * Gerer la cameneon qui arrive au serveur est le mettre dans la liste
     * @param socket Socket de cameneon
     * @param listeCameneon Liste des cameneon courant
     * @throws java.io.IOException Exception produit par les operation lecture/ecriture
     */
    public GererDifferentClientCameneon(Socket socket, GererListeCameneon listeCameneon) throws IOException {
        this.cameneon = new Cameneon(socket);
        this.listeCameneon = listeCameneon;
        this.listeCameneon.ajouterCameneonClient(cameneon);
    }

    /**
     *
     * Pour savoir l'etat courant de serveur est l'info des client 
     * qui arrive a se serveur et pour faire la mutation des cameneon et fait 
     * attendre les cameneon qui n'ont pas des partenaire
     */
    @Override
    public void run() {

        try {
            System.out.println(this.cameneon.getCameneonClientSocket().getRemoteSocketAddress());
            String line;
            while (!(line = this.cameneon.getLecteur().readLine()).equals(".")) {
                System.out.printf("Trace de serveur la couleur est %s\n", line);
                if (this.listeCameneon.getCompteClientAttendu() == 0) {
                    this.cameneon.setCouleur(line);
                    this.listeCameneon.setCompteClientAttendu("ajouter");
                } else {
                    this.listeCameneon.faireMutation(this.cameneon, line);
                }

            }
            this.cameneon.getEcriveur().printf(".\n");
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.listeCameneon.supprimerCameneonDeListe(this.cameneon);
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}