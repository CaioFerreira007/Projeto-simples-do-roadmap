package entities;

public class Cliente {
    private Integer id;
    private String nome;
    private String numeroTelefone;
    private String cidade;


    public Cliente(Integer id, String nome, String numeroTelefone, String cidade) {
        this.id = id;
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.cidade = cidade;
    }
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getNumeroTelefone() {
        return numeroTelefone;
    }
    public String getCidade() {
        return cidade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "'nome='" + nome + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}