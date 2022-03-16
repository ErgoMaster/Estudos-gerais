public interface DequeInterface extends FilaInterface {
    public Object getUltimo() throws CountVazioException;
    public void enfileirarInicio(Object item);
    public void enfileirarFim(Object item);
    public Object desenfileirarInicio() throws CountVazioException;
    public Object desenfileirarFim() throws CountVazioException;
}
