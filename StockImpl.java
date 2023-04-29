package RMIstock;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StockImpl extends UnicastRemoteObject implements Stock {
    private List<Produit> listeProduits = new ArrayList<>();

    public StockImpl() throws RemoteException {
        super();
    }

    
    public synchronized List<Produit> getListeProduits() throws RemoteException {
        return listeProduits;
    }

    
    public synchronized void ajouterProduit(Produit produit) throws RemoteException {
        listeProduits.add(produit);
    }

    
    public synchronized void  supprimerProduit(Produit produit) throws RemoteException {
        listeProduits.remove(produit);
        
    }
    //
    public synchronized int getNombreProduits() {
        return listeProduits.size();
    }

    public synchronized Produit chercherProduit(String nomProduit) {
        for (Produit produit : listeProduits) {
            if (produit.getNom().equals(nomProduit)) {
                return produit;
            }
        }
        return null;
        }
    }

