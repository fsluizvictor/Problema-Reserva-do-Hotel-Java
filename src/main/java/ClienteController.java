import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ClienteController {
    private String tipo;
    private ArrayList<String> datas;
    private ArrayList<String> datas_formatadas;
    private ArrayList<Integer> dias_da_semana;
    Cliente cliente;

    ClienteController(String tipo, ArrayList<String> datas) throws ParseException {
        this.tipo = tipo;
        this.datas = datas;
        this.datas_formatadas = new ArrayList<String>();
        formataDatas(datas);
        this.dias_da_semana = new ArrayList<Integer>();
        diasDaSemana(datas_formatadas);
        corrigeEntradaTipoCliente(tipo);
        this.cliente = new Cliente(getTipo(), getDias_da_semana());
    }

    public ArrayList<Integer> getDias_da_semana() {
        return dias_da_semana;
    }

    public ArrayList<String> getDatas_formatadas() {
        return datas_formatadas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDatas(ArrayList<String> datas) {
        this.datas = datas;
    }

    public ArrayList<String> getDatas() {
        return datas;
    }

    public String getTipo() {
        return tipo;
    }

    public void diasDaSemana(ArrayList<String> datas_formatadas) throws ParseException {
        for (String data : datas_formatadas) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data_correta = sdf.parse(data);
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(data_correta);
            int dia_da_semana = gc.get(GregorianCalendar.DAY_OF_WEEK);
            this.dias_da_semana.add(dia_da_semana);
        }
    }

    public void formataDatas(ArrayList<String> datas) {
        String formato_data = new String();
        for (String str : datas) {
            String dia = str.substring(0, 2);

            formato_data += dia;
            formato_data += "/";

            String mes = str.substring(2, 5);

            if (mes.equals("Jan")) {
                formato_data += "01";
            } else if (mes.equals("Fer")) {
                formato_data += "02";
            } else if (mes.equals("Mar")) {
                formato_data += "03";
            } else if (mes.equals("Abr")) {
                formato_data += "04";
            } else if (mes.equals("Mai")) {
                formato_data += "05";
            } else if (mes.equals("Jun")) {
                formato_data += "06";
            } else if (mes.equals("Jul")) {
                formato_data += "07";
            } else if (mes.equals("Ago")) {
                formato_data += "08";
            } else if (mes.equals("Set")) {
                formato_data += "09";
            } else if (mes.equals("Out")) {
                formato_data += "10";
            } else if (mes.equals("Nov")) {
                formato_data += "11";
            } else if (mes.equals("Dez")) {
                formato_data += "12";
            }

            formato_data += "/";

            String ano = str.substring(5, 9);
            formato_data += ano;

            // String aux = str.substring(10, 13);
            datas_formatadas.add(formato_data);
            formato_data = new String();
        }
    }

    public void corrigeEntradaTipoCliente(String tipo) {
        String aux = getTipo();
        aux = aux.replaceAll(":", "");
        setTipo(aux);
    }

}
