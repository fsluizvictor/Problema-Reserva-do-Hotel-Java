import java.text.ParseException;
import java.util.ArrayList;

public class SistemaController {

    private ClienteController cliente_controller;
    private Sistema sistema;

    SistemaController(String tipo_cliente, ArrayList<String> datas) throws ParseException {
        this.cliente_controller = new ClienteController(tipo_cliente, datas);
        this.sistema = new Sistema(cliente_controller);

    }

    public void executa() {
        HotelController hotel_controller = new HotelController(cliente_controller, sistema.getHoteis());
        System.out.println(hotel_controller.retornaMelhorPrecoHotel());
    }

}
