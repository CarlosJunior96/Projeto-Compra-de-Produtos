package entidades;

public class OrdemItem {
    private Integer quantidade;
    private Double preco;
    private Produto produto;

    public OrdemItem(){

    }

    public  OrdemItem(Integer quantidade, Produto produto){
        this.quantidade = quantidade;
        this.produto = produto;
        this.preco = precoProduto(preco);

    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    public Integer getQuantidade(){
        return quantidade;
    }

    public Double getPreco(){
        return preco;
    }

    public Double precoProduto(Double preco){
        return this.preco = produto.getPreco();
    }

    public Produto getProduto(){
        return produto;
    }

    public Double subTotal(){
        return preco * quantidade;
    }
}
