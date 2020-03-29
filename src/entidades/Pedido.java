package entidades;

import entidades.enums.OrdemStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date momento;
    private OrdemStatus status;

    private Cliente cliente;
    private List<OrdemItem> listaItens = new ArrayList<>();

    public Pedido(){

    }

    public Pedido(Date momento, OrdemStatus status, Cliente cliente){
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public OrdemStatus getStatus() {
        return status;
    }

    public void setStatus(OrdemStatus status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<OrdemItem> getListaItens() {
        return listaItens;
    }

    public void addItem (OrdemItem item){
        listaItens.add(item);
    }

    public void removerItem(OrdemItem item){
        listaItens.remove(item);
    }

    public void mostrarItens(){
        for(OrdemItem o : listaItens){
            System.out.println(o.getProduto().getNome() + ", " + "R$ " + o.getPreco() +", Quantidade: " + o.getQuantidade() +", Subtotal: R$" + o.subTotal());
        }
    }

    public Double valorTotal(){
        double total = 0.0;
        for(OrdemItem l : listaItens){
            total += l.subTotal();
        }
        return  total;
    }
}
