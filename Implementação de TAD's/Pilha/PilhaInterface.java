public interface PilhaInterface {
    public void fazVazia();
    public boolean estaVazia();
    public void push(Object item);
    public Object pop() throws CountVazioException;
    public Object getTop() throws CountVazioException; 
}
