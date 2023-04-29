package RMIstock;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Stock extends Remote {
    List<Produit> getListeProduits() throws RemoteException;
    void ajouterProduit(Produit produit) throws RemoteException;
    void supprimerProduit(Produit produit) throws RemoteException;
    //
    int getNombreProduits() throws RemoteException;
    Produit chercherProduit(String nomProduit) throws RemoteException;
    }
