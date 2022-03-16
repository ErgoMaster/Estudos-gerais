public class DequeEncadeado extends FilaEncadeada implements DequeInterface {
    public DequeEncadeado() {
        super();
    }

    public void fazVazia() { this.fazVazia(); }

    public boolean estaVazia() { return this.estaVazia(); }

    public Object getPrimeiro() { return this.getPrimeiro(); }

    @Override
    public Object getUltimo() throws CountVazioException {
        try { return this.list.getUltimo(); }
        catch(Exception e) { throw new CountVazioException(); }
    }

    @Override
    public void enfileirarInicio(Object item) { this.list.inserirInicio(item); }

    @Override
    public void enfileirarFim(Object item) { this.enfileirar(item); }

    @Override
    public Object desenfileirarInicio() throws CountVazioException { return this.desenfileirar(); }

    @Override
    public Object desenfileirarFim() throws CountVazioException {
        try {
            Object temp = this.list.getUltimo();
            this.list.extrair(temp);
            return temp;
        } catch (Exception e) { throw new CountVazioException(); }
    }

    @Override
    public String toString() { return this.toString(); }
}