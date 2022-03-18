public interface ListaClassificadaInterface {
    int get (int i) throws IndexOutOfBoundsException;
    Cursor procurarPosicao (int item) throws ObjetoNaoEncontradoException;
    boolean eMembro(int item);
    void inserir (int item) throws CountCheioException;
    void remover (int item) throws ObjetoNaoEncontradoException, CountVazioException;
    int procurar (int item) throws ObjetoNaoEncontradoException;
}