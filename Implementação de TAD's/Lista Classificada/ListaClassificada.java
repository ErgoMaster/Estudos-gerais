public class ListaClassificada implements ListaClassificadaInterface {
    protected Object[] array;
    protected int count;

    public ListaClassificada(int tamanho) {
        array = new Object[tamanho];
        count = 0;
    }

    @Override
    public Object get(int i) {
        return null;
    }

    @Override
    public Cursor procurarPosicao(Object item) {
        return null;
    }

    @Override
    public boolean eMembro(Object item) {
        for(int i = 0; i < array.length; i++) {
            if(item == array[i]) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void inserir(Object item) throws CountCheioException {
        if(count == array.length) { throw new CountCheioException(); } 
        else {
            array[count] = item;
            count++;
        }
    }

    @Override
    public void remover(Object item) throws ObjetoNaoEncontradoException {
        int aux = 0;

        while(aux <= count && array[aux] != item) {
            aux++;
        }

        if(aux == count) { throw new ObjetoNaoEncontradoException(); }
        else {
            int i; 

            for(i = aux; i < count - 1; i++) {
                array[i] = array[i + 1];
            }

            array[i] = null;
            count--;
        } 
    }

    @Override
    public Object procurar(Object item) {
        for(int i = 0; i < array.length; i++) {
            if(item == array[i]) {
                return array[i];
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String texto = "";
        texto += "[";

        if(array[0] == null) { return "[ ]"; }

        for(int i = 0; i < array.length; i++) {
            if(i != array.length) { texto += array[i] + ", "; } 
            else { texto += array[i] + "]"; }
        }

        return texto;
    }
}
