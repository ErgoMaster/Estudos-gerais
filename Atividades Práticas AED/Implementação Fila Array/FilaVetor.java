public class FilaVetor implements FilaInterface {
    Vetor vetor;

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
    public void enfileirar(Object item) {
        int index = 0;

        while(vetor.getElemento(index) != null) {
            index++;
        }

        vetor.setElemento(index, item);
    }

    @Override
    public Object desenfileirar() {
        Object elemento = vetor.getElemento(0);
        
        for(int i = 0; i < vetor.getlength(); i++) {
            if(i == vetor.getlength() - 1) { vetor.setElemento(i, null); }
            else { vetor.setElemento(i, vetor.getElemento(i + 1)); }
        }

        return elemento;
    }

    @Override 
    public String toString() { return vetor.toString(); }
}
