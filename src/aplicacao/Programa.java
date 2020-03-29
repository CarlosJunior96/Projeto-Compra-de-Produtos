package aplicacao;

import entidades.Cliente;
import entidades.OrdemItem;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.OrdemStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        //  COLETANDO DADOS DO CLIENTE
        System.out.println("Dados do cliente: ");
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Data de Aniversário (DD/MM/AAAA): ");
        Date aniversario = sdf.parse(ler.next());
        // FINALIZANDO DADOS CLIENTE

        // INICIALIZANDO O OBJETO CLIENTE COM OS DADOS FORNECIDOS
        Cliente cliente = new Cliente(nome, email, aniversario);

        // COLETANDO DADOS DO PEDIDO
        System.out.println("Dados do Pedido: ");
        System.out.print("Status: ");
        String status  = ler.next();

        Date momento = new Date();
        //INICIALIZANDO O OBJETO CLIENTE COM OS DADOS
        Pedido pedido = new Pedido(momento, OrdemStatus.valueOf(status), cliente);

        ler.nextLine();
        System.out.print("Informa a quantidade de Itens a ser pedidos: ");
        int n_pedidos = ler.nextInt();

        for(int i = 1; i <= n_pedidos; i++){
            ler.nextLine();
            System.out.print("Nome do Produto: ");
            String nomeP = ler.nextLine();
            System.out.print("Preço do Produto: ");
            double precoP = ler.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = ler.nextInt();

            //INICIALIZANDO OBJETO PRODUTO
            Produto produto = new Produto(nomeP, precoP);

            //INICIALIZANDO OBJETO ORDEM DE ITENS
            OrdemItem ordemItem = new OrdemItem(quantidade, produto);
            pedido.addItem(ordemItem);
        }

        System.out.println("RESUMO DO PEDIDO");
        System.out.println("Dia do pedido: " + pedido.getMomento());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("Cliente: " + cliente.toString());
        pedido.mostrarItens();
        System.out.print("Preco Total: " + pedido.valorTotal());

        ler.close();
    }
}