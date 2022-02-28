package implementaçãolistaencadeada;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testes da lista encadeada ---");

        ListaEncadeada lista = new ListaEncadeada();

        lista.inserirInicio(5);
        lista.inserirInicio(10);
        lista.inserirInicio(9);

        lista.imprimirLista();
    }
}
