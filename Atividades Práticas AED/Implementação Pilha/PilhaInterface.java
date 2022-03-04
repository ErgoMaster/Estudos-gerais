public interface PilhaInterface  {
    void fazVazia();
    boolean estaVazia();
    void push(Object item);
    Object pop() throws CountVazioException;
    Object getTop() throws CountVazioException;
    void imprimirPilha();
}
