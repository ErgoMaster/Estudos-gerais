public class FilaVetor implements FilaInterface {
    private Vetor vetor;
    private int count;

    public FilaVetor(int tamanho) {
        vetor = new Vetor(tamanho);
    }

    @Override
    public void fazVazia() { vetor.fazVazia(); }

    @Override
    public boolean estaVazia() { return vetor.estaVazia(); }

    @Override
    public Object getPrimeiro() { return vetor.getElemento(0); }

    @Override
    public void enfileirar(Object item) throws CountCheioException {
        int index = 0;

        if(count == vetor.getlength()) { throw new CountCheioException(); } 
        else {
            while(vetor.getElemento(index) != null) {
                index++;
            }

            vetor.setElemento(index, item);
            count++;
        }
    }

    @Override
    public Object desenfileirar() {
        Object elemento = vetor.getElemento(0);
        
        for(int i = 0; i < vetor.getlength(); i++) {
            if(i == vetor.getlength() - 1) { vetor.setElemento(i, null); }
            else { vetor.setElemento(i, vetor.getElemento(i + 1)); }
        }

        count--;
        return elemento;
    }

    @Override 
    public String toString() { return vetor.toString(); }
}
