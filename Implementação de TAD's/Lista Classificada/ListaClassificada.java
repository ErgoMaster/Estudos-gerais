public class ListaClassificada implements ListaClassificadaInterface {
    protected int[] array;
    protected int count;

    public ListaClassificada(int tamanho) {
        array = new int[tamanho];
        count = 0;
    }

    @Override
    public int get(int i) throws IndexOutOfBoundsException {
        if(i >= count || i < 0) { throw new IndexOutOfBoundsException(); }

        return array[i];
    }

    @Override
    public Cursor procurarPosicao(int item) throws ObjetoNaoEncontradoException {
        int index = 0;

        while(index < count && array[index] < item) {
            index++;
        }

        if(index == count - 1) { throw new ObjetoNaoEncontradoException(); }

        return new Cursor(index, array.length);
    }

    @Override
    public boolean eMembro(int item) {
        int inicio = 0;
        int fim = count - 1;
        int meio;

        while(inicio <= fim) {
            meio = ((inicio + fim) / 2);

            if(array[meio] > item) { fim = meio - 1; } 
            else if(array[meio] < item) { inicio = meio + 1; } 
            else { return true; }
        }

        return false;
    }

    @Override
    public void inserir(int item) throws CountCheioException {
        int index = 0;

        if(count == array.length) { throw new CountCheioException(); } 

        while(array[index] != 0 && array[index] < item) {
            index++;
        }
 
        for(int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        
        array[index] = item;
        count++;
    }

    @Override
    public void remover(int item) throws ObjetoNaoEncontradoException, CountVazioException {
        int index = 0;

        if(count == 0) { throw new CountVazioException(); }

        while(array[index] != 0 && array[index] < item) {
            index++;
        }

        for(int i = index; i < count - 1; i ++) {
            array[i] = array[i + 1];
        }

        array[count - 1] = 0;
        count--;
    }

    @Override
    public int procurar(int item) throws ObjetoNaoEncontradoException {
        int inicio = 0;
        int fim = count - 1;
        int meio;

        while(inicio <= fim) {
            meio = ((inicio + fim) / 2);

            if(array[meio] > item) {
                fim = meio - 1;
            } else if(array[meio] < item) {
                inicio = meio + 1;
            } else {
                return meio;
            }
        }

        throw new ObjetoNaoEncontradoException();
    }

    @Override
    public String toString() {
        String texto = "";
        texto += "[";

        if(count == 0) { return "[ ]"; }

        for(int i = 0; i < array.length; i++) {
            if(i != array.length - 1) { texto += array[i] + ", "; } 
            else { texto += array[i]; }
        }

        return texto + "]";
    }
}
