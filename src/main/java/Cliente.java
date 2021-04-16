import java.util.ArrayList;

public class Cliente {
    private String tipo_cliente;
    private ArrayList<Integer> datas;

    Cliente(String tipo_cliente, ArrayList<Integer> datas) {
        this.tipo_cliente = tipo_cliente;
        this.datas = datas;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public void setDatas(ArrayList<Integer> datas) {
        this.datas = datas;
    }

    public ArrayList<Integer> getDatas() {
        return datas;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

}