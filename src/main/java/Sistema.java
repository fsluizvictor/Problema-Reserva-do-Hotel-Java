import java.util.ArrayList;

public class Sistema {
    ClienteController cliente;
    ArrayList<Hotel> hoteis;

    Sistema(ClienteController cliente) {
        this.cliente = cliente;
        Hotel Lakewood = new Hotel("Lakewood", 110, 80, 90, 80, 3);
        Hotel Bridgewood = new Hotel("Bridgewood", 160, 110, 60, 50, 4);
        Hotel Ridgewood = new Hotel("Ridgewood", 220, 100, 150, 40, 5);
        this.hoteis = new ArrayList<Hotel>();
        hoteis.add(Lakewood);
        hoteis.add(Bridgewood);
        hoteis.add(Ridgewood);
    }

    public ArrayList<Hotel> getHoteis() {
        return hoteis;
    }
}
