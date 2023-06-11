import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] codigos = {10, 11, 12, 13, 14};
        String[] nomes = {"Pastel", "Pizza", "Pão", "Café", "Suco"};
        float[] precos = {6.00f, 4.50f, 0.15f, 4.00f, 3.00f};
        int[] comanda = new int[5];
        int indice = 5; // Próxima posição disponível nos arrays

        char opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("(c) - cadastrar um novo produto");
            System.out.println("(a) - alterar um produto");
            System.out.println("(i) - incluir um item no pedido");
            System.out.println("(f) - finalizar o pedido e mostrar o total");
            System.out.println("(s) - sair");
            opcao = ler.next().charAt(0);

            switch (opcao) {
                case 'c' ->
                {
                    System.out.println("Digite o código do novo produto:");
                    int codigo = ler.nextInt();
                    
                    if (codigo >= 10 && codigo <=100)
                    {
                        System.out.println("Digite o nome do novo produto:");
                        String nome = ler.next();
                        
                        System.out.println("Digite o preço do novo produto:");
String precoStr = ler.next().replace(',', '.');
double preco;
try {
    preco = Double.parseDouble(precoStr);
} catch (NumberFormatException e) {
    System.out.println("Valor inválido. Tente novamente.");
    return;
}

 
                        codigos[4] = codigo;

                        nomes[4] = nome;
                        
                        precos[4] = (float) preco;

                        
                        System.out.println("Cadastrado com sucesso!");
                    } 
                    else
                    {
                        System.out.println("Código inválido!");
                    }  
                      break;
                }

                case 'a' -> {
                    System.out.println("Digite o código do produto a ser alterado:");
                    int codigo = ler.nextInt();

                    if (codigo >= 10 && codigo <= 14) {
                        System.out.println("Digite o novo preço do produto:");
                        float preco = ler.nextFloat();

                        precos[codigo - 10] = preco;

                        System.out.println("Preço do produto alterado com sucesso!");
                    } else {
                        System.out.println("Código inválido!");
                    }
                    break;
                }

                case 'i' -> {
                    System.out.println("Código\tNome\t\tPreço");
                    for (int i = 0; i < indice; i++) {
                        System.out.println(codigos[i] + "\t" + nomes[i] + "\t" + "R$ " + precos[i]);
                    }

                    System.out.println("Digite o código do produto:");
                    int codigo = ler.nextInt();

                    System.out.println("Digite a quantidade:");
                    int quantidade = ler.nextInt();

                    if (codigo >= 10 && codigo <= 14 && quantidade > 0) {
                        comanda[codigo - 10] += quantidade;
                        System.out.println("Produto adicionado à comanda!");
                    } else {
                        System.out.println("Código ou quantidade inválidos!");
                    }
                    break;
                }

                case 'f' -> {
                    int quantidadeTotal = 0;
                    float valorFinal = 0;

                    System.out.println("Itens do pedido:");

                    for (int i = 0; i < indice; i++) {
                        if (comanda[i] > 0) {
                            System.out.printf("%s\tR$%.2f\tQuantidade: %d\tTotal: R$%.2f\n",
                                    nomes[i], precos[i], comanda[i], precos[i] * comanda[i]);
                            quantidadeTotal += comanda[i];
                            valorFinal += comanda[i] * precos[i];
                        }
                    }
                    System.out.printf("Total de itens: %d\n", quantidadeTotal);
                    System.out.printf("Total a pagar: R$%.2f\n", valorFinal);
                    break;
                }

                case 's' -> {
                    System.out.println("Obrigado pela preferência!");
                    break;
                }

                default -> System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 's');
    }
}
