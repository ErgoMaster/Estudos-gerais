public interface CursorInterface {
    int getDado() throws IndexOutOfBoundsException;
    void inserirDepois (int o) throws CountCheioException, IndexOutOfBoundsException;
    void inserirAntes (int o) throws CountCheioException, IndexOutOfBoundsException;
    void remover() throws CountVazioException, IndexOutOfBoundsException;
}
