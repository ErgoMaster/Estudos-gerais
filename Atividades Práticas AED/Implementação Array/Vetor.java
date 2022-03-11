public class Vetor {
    private Object[] data;
    private int base;

    public Vetor(int tamanho, int limite) {
        data = new Object[tamanho];
        base = limite;
    }
    public Vetor() { this(0,0); }
    public Vetor(int tamanho) { this(tamanho, 0); }

    public Object getData() { return data; }
    public int getBase() { return base; }
    public int getlength() { return data.length; }

    public void assing(Vetor a) {
        if(a != this) {
            if(data.length != a.data.length) {
                data = new Object[a.data.length];
            }

            for(int i = 0; i < data.length; i++) {
                data[i] = a.data[i];
            }

            base = a.base;
        }
    }

    public Object getElemento(int index) { return data[index - base]; }
    public void setElemento(int index, Object object) { data[index - base] = object; }

    public void setBase(int newBase) { base = newBase; }
    public void setLength(int newLen) {
        if(data.length != newLen) {
            Vetor newData = new Vetor(newLen);

            int min = data.length < newLen ? data.length: newLen;

            for(int i = 0 ; i < min; i++) {
                newData.data[i] = data[i];
            }

            data = newData.data;
        }
    }

    public void imprimirArray() throws VetorVazioException {
        if(data.length == 0) { throw new VetorVazioException(); }

        for(int i = 0; i < data.length; i++) {
            System.out.println(this.getElemento(i));
        }
    }
}
