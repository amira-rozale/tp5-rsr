package RMIstock;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {
    public static void main(String[] args) {
        try {
            Stock stock = new StockImpl();
            Registry registry = LocateRegistry.createRegistry(4099);
            registry.rebind("Stock", stock);
            System.out.println("Serveur prêt !");
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}

