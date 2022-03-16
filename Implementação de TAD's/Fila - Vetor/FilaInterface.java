public interface FilaInterface {
    public void fazVazia();
    public boolean estaVazia();
    public Object getPrimeiro();
    public void enfileirar(Object item) throws CountCheioException;
    public Object desenfileirar();
}
