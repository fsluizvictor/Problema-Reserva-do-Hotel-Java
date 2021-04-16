public class Hotel {
    private String nome;
    private int soma, classificacao;
    private int taxa_semana_normal, taxa_semana_fidelidade;
    private int taxa_fds_normal, taxa_fds_fidelidade;

    Hotel() {
    }

    public Hotel(String nome, int taxa_semana_normal, int taxa_semana_fidelidade, int taxa_fds_normal,
            int taxa_fds_fidelidade, int classificacao) {
        this.nome = nome;
        this.taxa_semana_normal = taxa_semana_normal;
        this.taxa_semana_fidelidade = taxa_semana_fidelidade;
        this.taxa_fds_normal = taxa_fds_normal;
        this.taxa_fds_fidelidade = taxa_fds_fidelidade;
        this.classificacao = classificacao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setSoma(int soma) {
        this.soma = soma;
    }

    public int getSoma() {
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public int getTaxa_fds_fidelidade() {
        return taxa_fds_fidelidade;
    }

    public int getTaxa_fds_normal() {
        return taxa_fds_normal;
    }

    public int getTaxa_semana_fidelidade() {
        return taxa_semana_fidelidade;
    }

    public int getTaxa_semana_normal() {
        return taxa_semana_normal;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getNome();
    }
}