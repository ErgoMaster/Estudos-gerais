public interface ListaClassificadaInterface {
    Object get (int i);
    Cursor procurarPosicao (Object item);
    boolean eMembro(Object item);
    void inserir (Object item) throws CountCheioException;
    void remover (Object item) throws ObjetoNaoEncontradoException;
    Object procurar (Object item);
}