public interface CursorInterface {
    Object getDado() throws IndexOutOfBoundsException;
    void inserirDepois (Object o);
    void inserirAntes (Object o) throws CountCheioException, IndexOutOfBoundsException;
    void remover();
}
