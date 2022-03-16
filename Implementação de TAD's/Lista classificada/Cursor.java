public class Cursor extends ListaClassificada implements CursorInterface {
    int offset; 

    public Cursor(int tamanho) {
        super(tamanho);
    }

    @Override
    public Object getDado() throws IndexOutOfBoundsException {
        if(offset < 0 || offset >= this.count) {
            throw new IndexOutOfBoundsException();
        }

        return this.array[offset];
    }

    @Override
    public void inserirDepois(Object item) {
        
    }

    @Override
    public void inserirAntes(Object item) throws CountCheioException, IndexOutOfBoundsException {
        if(offset < 0 || offset >= this.count) { throw new IndexOutOfBoundsException(); }

        if(count ==  array.length) { throw new CountCheioException(); }

        else {
            for(int i = count; i > offset; i--) {
                array[i] = array[i - 1];
            }

            array[offset] = item;
            count++;
        }
    }

    @Override
    public void remover() {
        
    }
    
}
