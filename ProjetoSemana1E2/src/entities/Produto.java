package entities;

public class Produto {
    private Integer id;
    private String nome;
    private Double valorUnitario;

    public Produto(Integer id, String nome, Double valorUnitario) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }
public Integer getId() {
        return id;
}
public void setId(Integer id) {
        this.id = id;
}
    public String getNome() {
        return nome;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


}
