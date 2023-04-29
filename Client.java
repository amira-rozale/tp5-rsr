package RMIstock;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4099);
            Stock stock = (Stock) registry.lookup("Stock");
            List<Produit> listeProduits = stock.getListeProduits();
            System.out.println("Liste des produits : ");
            for (Produit produit : listeProduits) {
                System.out.println(produit.getNom() + " - " + produit.getPrix() + "da");
            }
            Produit nouveauProduit = new Produit("produit 1", 200);
            stock.ajouterProduit(nouveauProduit);
            System.out.println("Produit ajouté : " + nouveauProduit.getNom() + " - " + nouveauProduit.getPrix() + "da");
            stock.supprimerProduit(nouveauProduit);
            System.out.println("Produit supprimé : " + nouveauProduit.getNom() + " - " + nouveauProduit.getPrix() + "da");
            //
            int nombreProduits = stock.getNombreProduits();
            System.out.println("Nombre de produits : " + nombreProduits);
            //
            Produit produitCherche = stock.chercherProduit("produit 2");
            System.out.println("Produit cherché : " + produitCherche);
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}
