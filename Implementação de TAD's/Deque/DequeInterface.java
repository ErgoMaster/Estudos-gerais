public interface DequeInterface extends FilaInterface {
    public Object getUltimo();
    public void enfileirarInicio(Object item);
    public void enfileirarFim(Object item);
    public Object desenfileirarInicio();
    public Object desenfileirarFim();
}
