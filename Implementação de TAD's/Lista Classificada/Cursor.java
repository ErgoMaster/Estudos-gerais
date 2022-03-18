public class Cursor extends ListaClassificada  implements CursorInterface {
    int offset; 

    public Cursor(int offset, int tamanho) {
        super(tamanho);
        this.offset = offset;
    }

    @Override
    public int getDado() throws IndexOutOfBoundsException {
        if(offset < 0 || offset >= this.count) { throw new IndexOutOfBoundsException(); }

        return this.array[offset];
    }

    @Override
    public void inserirDepois(int item) throws CountCheioException, IndexOutOfBoundsException {
        if(offset < 0 || offset >= this.count) { throw new IndexOutOfBoundsException(); }

        if(count ==  array.length) { throw new CountCheioException(); }

        for(int i = count; i > offset + 1; i--) {
            array[i] = array[i - 1];
        }

        array[offset + 1] = item;
        count++;
    }

    @Override
    public void inserirAntes(int item) throws CountCheioException, IndexOutOfBoundsException {
        if(offset < 0 || offset >= this.count) { throw new IndexOutOfBoundsException(); }

        if(count == array.length) { throw new CountCheioException(); }

        for(int i = count; i > offset; i--) {
            array[i] = array[i - 1];
        }

        array[offset] = item;
        count++;
    }

    @Override
    public void remover() throws CountVazioException, IndexOutOfBoundsException {
        if(offset < 0 || offset >= this.count) { throw new IndexOutOfBoundsException(); }

        if(count ==  0) { throw new CountVazioException(); }

        for(int i = offset; i < count - 1; i++) {
            array[i] = array[i + 1];
        }

        array[count - 1] = 0;
        count--;
    }

    public void setOffset(int offset) { this.offset = offset; }
    public int[] getLista() { return this.array; }
}
