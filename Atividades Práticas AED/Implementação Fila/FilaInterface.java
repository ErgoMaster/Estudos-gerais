public interface FilaInterface {
    public void fazVazia();
    public boolean estaVazia();
    public Object getPrimeiro() throws CountVazioException;
    public void enfileirar(Object item);
    public Object desenfileirar() throws CountVazioException;
}
