import Cardapio.*;
import Pedido.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    public static void main(String[] args) {

        // Leitura do cardápio
        ArrayList<Cardapio> cardapio = CardapioLoader.carregarCardapio("Cardápio/Cardapio.txt");

        // Criação do ArrayList itensEscolhidos para ser preenchido de acordo com as escolhas do cliente.
        Scanner scanner = new Scanner(System.in);
        ArrayList<ItemMenu> itensEscolhidos = new ArrayList<ItemMenu>();

        System.out.println("Bem-vindo. Você deseja pedir um prato principal?");
        String respostaPrato = scanner.nextLine();
        PratoPrincipal pratoEscolhido = null;

        while (!respostaPrato.equalsIgnoreCase("sim") && !respostaPrato.equalsIgnoreCase("não")) {
            System.out.println("Resposta inválida. Tente novamente.");
            respostaPrato = scanner.nextLine();
        }

        // Criação do ArrayList pratos para armazenar somente os pratos principais.
        if (respostaPrato.equalsIgnoreCase("sim")) {
            System.out.println("Qual prato deseja pedir?");
            ArrayList<PratoPrincipal> pratos = new ArrayList<PratoPrincipal>();
            for (int i = 0; i < cardapio.size(); i++) {
                String elemento = cardapio.get(i).getClass().getName();
                if (elemento.equals("Cardapio.PratoPrincipal")) {
                    PratoPrincipal prato = (PratoPrincipal) cardapio.get(i);
                    pratos.add(prato);
                    prato.mostrarInfo();
                }
            }
            String pedidoPrato = scanner.nextLine();
            int index = -1;
            while (index == -1) {
                for (int i = 0; i < pratos.size(); i++) {
                    if (pedidoPrato.equalsIgnoreCase(pratos.get(i).getNome())) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Escolha um prato válido.");
                    pedidoPrato = scanner.nextLine();
                }
            }
            pratoEscolhido = pratos.get(index);
        }
        if (pratoEscolhido != null) {
            itensEscolhidos.add(pratoEscolhido);
        }

        System.out.println("Você deseja pedir algo para beber?");
        String respostaBebida = scanner.nextLine();
        Bebida bebidaEscolhida = null;

        while (!respostaBebida.equalsIgnoreCase("sim") && !respostaBebida.equalsIgnoreCase("não")) {
            System.out.println("Resposta inválida. Tente novamente.");
            respostaBebida = scanner.nextLine();
        }

        if (respostaBebida.equalsIgnoreCase("sim")) {
            System.out.println("Qual bebida deseja pedir?");
            ArrayList<Bebida> bebidas = new ArrayList<Bebida>();
            for (int i = 0; i < cardapio.size(); i++) {
                String elemento = cardapio.get(i).getClass().getName();
                if (elemento.equals("Cardapio.Bebida")) {
                    Bebida bebida = (Bebida) cardapio.get(i);
                    bebidas.add(bebida);
                    bebida.mostrarInfo();
                }
            }
            String pedidoBebida = scanner.nextLine();
            int index = -1;
            while (index == -1) {
                for (int i = 0; i < bebidas.size(); i++) {
                    if (pedidoBebida.equalsIgnoreCase(bebidas.get(i).getNome())) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Escolha uma bebida válida.");
                    pedidoBebida = scanner.nextLine();
                }
            }
            bebidaEscolhida = bebidas.get(index);
        }
        if (bebidaEscolhida != null) {
            itensEscolhidos.add(bebidaEscolhida);
        }

        System.out.println("Você deseja pedir uma sobremesa?");
        String respostaSobremesa = scanner.nextLine();
        Sobremesa sobremesaEscolhida = null;

        while (!respostaSobremesa.equalsIgnoreCase("sim") && !respostaSobremesa.equalsIgnoreCase("não")) {
            System.out.println("Resposta inválida. Tente novamente.");
            respostaSobremesa = scanner.nextLine();
        }

        if (respostaSobremesa.equalsIgnoreCase("sim")) {
            System.out.println("Qual sobremesa deseja pedir?");
            ArrayList<Sobremesa> sobremesas = new ArrayList<Sobremesa>();
            for (int i = 0; i < cardapio.size(); i++) {
                String elemento = cardapio.get(i).getClass().getName();
                if (elemento.equals("Cardapio.Sobremesa")) {
                    Sobremesa sobremesa = (Sobremesa) cardapio.get(i);
                    sobremesas.add(sobremesa);
                    sobremesa.mostrarInfo();
                }
            }
            String pedidoSobremesa = scanner.nextLine();
            int index = -1;
            while (index == -1) {
                for (int i = 0; i < sobremesas.size(); i++) {
                    if (pedidoSobremesa.equalsIgnoreCase(sobremesas.get(i).getNome())) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Escolha uma sobremesa válida.");
                    pedidoSobremesa = scanner.nextLine();
                }
            }
            sobremesaEscolhida = sobremesas.get(index);
        }
        if (sobremesaEscolhida != null) {
            itensEscolhidos.add(sobremesaEscolhida);
        }

        // Montagem do pedido para ir noo arquivo Pedidos.txt
        if (itensEscolhidos.isEmpty()) {
            System.out.println("Obrigado.");
        } else {
            System.out.println("Por favor insira seu nome, telefone e endereço: ");
            String nome = scanner.nextLine();
            String telefone = scanner.nextLine();
            String endereco = scanner.nextLine();

            PedidoManager.criarPedido(nome, telefone, endereco, itensEscolhidos);
        }

        scanner.close();
    }
}