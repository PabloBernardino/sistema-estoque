import java.util.Scanner;
import java.util.Locale;

public class SistemaEstoque {

    public static void titulo(String texto){

        System.out.println("\n================================");
        System.out.println(texto);
        System.out.println("================================");

    }

    public static void limparTela(){

        for (int i = 0; i < 50;  i++){
            System.out.println();
        }

    }

    public static void menuPrincipal(){

        System.out.println("1 - Cadastro de produtos");
        System.out.println("2 - Entrada de estoque");
        System.out.println("3 - Saída de estoque");
        System.out.println("4 - Consulta de produtos");
        System.out.println("5 - Alerta de estoque baixo");
        System.out.println("0 - Sair");

    }

    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);

        final int LIMITE = 100;

        String produtos[] = new String[LIMITE];
        int quantidades[] = new int[LIMITE];
        double precos[] = new double[LIMITE];
        String categorias[] = new String[LIMITE];

        int opcao;

        do {
            titulo("SISTEMA DE ESTOQUE");

            System.out.println();

            menuPrincipal();

            System.out.println();

            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();

            scanner.nextLine();

            switch (opcao) {
                case 1:
                    limparTela();
                    titulo("CADASTRO DE PRODUTOS");

                    // Encontrar posição livre
                    int posicaoLivre = -1;

                    for (int indiceProdutos = 0; indiceProdutos < produtos.length; indiceProdutos++){

                        if(produtos[indiceProdutos] == null){

                            posicaoLivre = indiceProdutos;
                            break;
                        }
                    }

                    // Verificar se existe espaço
                    if (posicaoLivre == -1){
                        System.out.println("Limite de produtos atingido!");
                        break;
                    }

                    // Solicitar dados
                    System.out.print("Nome do produto: ");
                    produtos[posicaoLivre] = scanner.nextLine();

                    System.out.print("Preço: ");
                    precos[posicaoLivre] = scanner.nextDouble();

                    scanner.nextLine(); // Limpar buffer

                    System.out.print("Quantidade em estoque: ");
                    quantidades[posicaoLivre] = scanner.nextInt();

                    scanner.nextLine(); // Limpar buffer

                    System.out.print("Digite a categoria: ");
                    categorias[posicaoLivre] = scanner.nextLine();

                    // Confirmar cadastro
                    System.out.print("Produto cadastrado com sucesso! ");
                    break;

                case 2:
                    limparTela();
                    titulo("ENTRADA DE ESTOQUE");

                    // Pedir o nome do produto
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    // Procurar o produto no vetor
                    int indiceEncontrado = -1;

                    for(int indiceProduto = 0; indiceProduto < produtos.length; indiceProduto++){

                        if(produtos[indiceProduto] != null && produtos[indiceProduto].equalsIgnoreCase(nomeProduto)){

                            indiceEncontrado = indiceProduto;
                            break;
                        }
                    }

                    // Verificar se o produto foi encontrado
                    if (indiceEncontrado == -1){
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    // Pedir a quantidade de entrada
                    System.out.println("Quantidade em estoque de produto: " + "[" + quantidades[indiceEncontrado] + "]");
                    System.out.print("Digite a quantidade para entrada: ");
                    int quantidadeEntrada = scanner.nextInt();

                    scanner.nextLine();

                    // Atualizar o estoque
                    if (quantidadeEntrada <= 0) {
                        System.out.println("Quantidade inválida!");
                        break;
                    }

                    // Somar ao estoque atual
                    quantidades[indiceEncontrado] += quantidadeEntrada;

                    // Mostrar confirmação
                    System.out.println("Entrada de produtos realizado com sucesso!");
                    System.out.println("Estoque atual: " + quantidades[indiceEncontrado]);
                    break;

                case 3:
                    limparTela();
                    titulo("SAÍDA DE ESTOQUE");

                    // Pedir o nome do produto
                    System.out.println("Digite o nome do produto: ");
                    nomeProduto = scanner.nextLine();

                    // Procurar o produto no vetor
                    indiceEncontrado = -1;

                    for(int indiceProduto = 0; indiceProduto < produtos.length; indiceProduto++){

                        if(produtos[indiceProduto] != null && produtos[indiceProduto].equalsIgnoreCase(nomeProduto)){

                            indiceEncontrado = indiceProduto;
                            break;
                        }
                    }

                    // Verificar se o produto foi encontrado
                    if (indiceEncontrado == -1){
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    // Pedir a quantidade de entrada
                    System.out.println("Quantidade em estoque de produto: " + quantidades[indiceEncontrado]);
                    System.out.print("Digite a quantidade para saída: ");
                    int quantidadeSaida = scanner.nextInt();

                    scanner.nextLine();

                    // Atualizar o estoque
                    if (quantidadeSaida <= 0) {
                        System.out.println("Quantidade inválida!");
                        break;
                    }

                    if (quantidadeSaida > quantidades[indiceEncontrado]) {
                        System.out.println("Estoque insuficiente!");
                        break;
                    }

                    // Somar ao estoque atual
                    quantidades[indiceEncontrado] -= quantidadeSaida;

                    // Mostrar confirmação
                    System.out.println("Sída de produtos realizada com sucesso!");
                    System.out.println("Estoque atual: " + quantidades[indiceEncontrado]);
                    break;
                case 4:
                    limparTela();
                    titulo("CONSULTA DE PRODUTOS");

                    // Pedir o nome do produto
                    System.out.println("Digite o nome do produto: ");
                    nomeProduto = scanner.nextLine();

                    // Procurar o produto no vetor
                    indiceEncontrado = -1;

                    for(int indiceProduto = 0; indiceProduto < produtos.length; indiceProduto++){

                        if(produtos[indiceProduto] != null && produtos[indiceProduto].equalsIgnoreCase(nomeProduto)){

                            indiceEncontrado = indiceProduto;
                            break;
                        }
                    }

                    // Verificar se o produto foi encontrado
                    if (indiceEncontrado == -1){
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    titulo("PRODUTOS EM ESTOQUE");

                    System.out.println("Nome: " + produtos[indiceEncontrado]);
                    System.out.println("Categoria: " + categorias[indiceEncontrado]);
                    System.out.println("Preço: R$ " + precos[indiceEncontrado]);
                    System.out.println("Quantidade: " + quantidades[indiceEncontrado]);

                    break;

                case 5:
                    limparTela();
                    titulo("ALERTA DE ESTOQUE BAIXO");

                    int estoqueBaixo = 5;
                    boolean encontrou = false;

                    for(int indiceProduto = 0; indiceProduto < produtos.length; indiceProduto++){

                        if(produtos[indiceProduto] != null && quantidades[indiceProduto] <= estoqueBaixo){

                            System.out.println("Nome: " + produtos[indiceProduto] +
                                    " | Estoque: " + quantidades[indiceProduto]);

                            encontrou = true;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Nenhum produto com estoque baixo.");
                    }
            }

        }while(opcao != 0);


    }
}
