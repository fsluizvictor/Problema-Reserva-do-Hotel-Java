import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Principal {
    public void executaCasosTeste() {
        String caminho = "/home/luiz_victor/Projects/Syngenta/java-test-project/src/main/java/entrada.txt";
        ArrayList<String> datas = new ArrayList<String>();
        String tipo_cliente = new String();

        try {
            FileReader arquivo = new FileReader(caminho);
            BufferedReader ler_arquivo = new BufferedReader(arquivo);

            String linha = ler_arquivo.readLine();

            int cont = 0;

            while (linha != null) {

                if ((linha.equals("Regular:") || linha.equals("Rewards:")) && datas.isEmpty()) {
                    tipo_cliente = linha;
                } else if ((linha.equals("Regular:") || linha.equals("Rewards:") || linha.equals(""))
                        && !datas.isEmpty()) {

                    cont++;
                    System.out.println("-----------------------------");
                    System.out.println("Caso teste " + cont + ": ");
                    System.out.println(tipo_cliente);

                    for (String str : datas) {
                        System.out.println(str);
                    }

                    SistemaController sistema = new SistemaController(tipo_cliente, datas);
                    System.out.println("Resultado: ");
                    sistema.executa();
                    tipo_cliente = linha;
                    datas = new ArrayList<String>();
                } else if (!linha.equals("Regular:") && !linha.equals("Rewards:")) {
                    datas.add(linha);
                }

                linha = ler_arquivo.readLine();
            }

            arquivo.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
