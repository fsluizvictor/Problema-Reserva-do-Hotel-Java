import java.util.ArrayList;

public class HotelController {

    private ClienteController cliente_controller;
    private ArrayList<Hotel> hoteis;

    HotelController(ClienteController cliente_controller, ArrayList<Hotel> hoteis) {
        this.cliente_controller = cliente_controller;
        this.hoteis = hoteis;
    }

    public void calcula_Preco(ClienteController dados_cliente, Hotel hotel) {

        Cliente cliente = dados_cliente.getCliente();
        ArrayList<Integer> dias = cliente.getDatas();

        int soma = 0;
        if (cliente.getTipo_cliente().equals("Regular")) {
            for (int dia : dias) {
                if (dia == 1 || dia == 7) {
                    soma += hotel.getTaxa_fds_normal();
                } else {
                    soma += hotel.getTaxa_semana_normal();

                }
            }
        } else if (cliente.getTipo_cliente().equals("Reward")) {
            for (int dia : dias) {
                if (dia == 1 || dia == 7) {
                    soma += hotel.getTaxa_fds_fidelidade();
                } else {
                    soma += hotel.getTaxa_semana_fidelidade();

                }
            }

        }
        hotel.setSoma(soma);
    }

    public Hotel menorPreco(ArrayList<Hotel> hoteis) {
        Hotel aux = new Hotel();
        aux.setSoma(Integer.MAX_VALUE);
        for (Hotel hotel : hoteis) {
            if (hotel.getSoma() < aux.getSoma()) {
                aux = hotel;
            } else if (hotel.getSoma() == aux.getSoma()) {
                if (hotel.getClassificacao() > aux.getClassificacao()) {
                    aux = hotel;
                }
            }
        }

        return aux;
    }

    public Hotel retornaMelhorPrecoHotel() {
        for (Hotel hotel : hoteis) {
            calcula_Preco(cliente_controller, hotel);
        }
        return menorPreco(hoteis);
    }

}