public class InfixToPrefix {
    private PilhaEncadeada stack = new PilhaEncadeada();
    private String expIn;
    private String expOut = "";
    private int resultado;

    public InfixToPrefix(String expIn) { this.expIn = expIn; }

    public void operate() {
        char c, cPop;

        for(int i = expIn.length() - 1; i >= 0; i--) {
            c = expIn.charAt(i);

            if(ehDigito(c)) { expOut = c + expOut; }
            else if(ehOperador(c)) { 
                try {
                    while(!stack.estaVazia() && prioridade((char)stack.getTop()) > prioridade(c)) {
                        expOut = (char) stack.pop() + expOut;
                    }
                } catch(CountVazioException e) { System.out.println("ERRO"); }
                
                stack.push(c);
            }
            else if(c == ')') { stack.push(c); }
            else if(c == '(') { 
                try {
                    do {
                        cPop = (char) stack.pop();
                        if(cPop != ')') { expOut = cPop + expOut; }
                    } while(cPop != ')');
                } catch(CountVazioException e) { System.out.println("ERRO"); }
            }
            else { }
        }

        while(!stack.estaVazia()) {
            try { expOut = (char) stack.pop() + expOut; } 
            catch (CountVazioException e) { System.out.println("ERRO"); }
        }
    }

    public boolean ehDigito(char c) {
        switch(c) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0': { return true; }
            default: { return false; }
        }
    }

    public boolean ehOperador(char c) {
        switch(c) {
            case '+', '/', '-', '*', '$': { return true; }
            default: { return false; }
        }
    }

    public int prioridade(char c) {
        switch(c) {
            case '+', '-': return 0;
            case '*', '/': return 1;
            case '$': return 2;
            default: return -1;
        }
    }

    public void calcular() {
        String c;

        for(int i = expOut.length() - 1; i >= 0; i--) {
            c = expOut.substring(i, i + 1);     

            if(ehOperador(c)) {
                try {
                    int numero1 = (int) stack.pop();
                    int numero2 = (int) stack.pop();
                    int resultado = operacao(c, numero1, numero2);
                    stack.push(resultado);
                } catch(CountVazioException e) { System.out.println("ERRO"); }
            } else if(ehDigito(c)) {
                int numero = Integer.parseInt(c);
                stack.push(numero);
            }
        }

        try { resultado = (int) stack.pop(); } 
        catch(CountVazioException e) { System.out.println("ERRO"); }
    }

    public int operacao(String operador, int numero1, int numero2) {
        switch(operador) {
            case "+": { return numero1 + numero2; }
            case "-": { return numero1 - numero2; }
            case "*": { return numero1 * numero2; }
            case "$": { return (int) Math.pow(numero1, numero2); }
            default: { return numero1 / numero2; }
        }
    }

    public boolean ehDigito(String c) {
        switch(c) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0": { return true; }
            default: { return false; }
        }
    }

    public boolean ehOperador(String c) {
        switch(c) {
            case "+", "/", "-", "*", "$": { return true; }
            default: { return false; }
        }
    }

    public String getExpIn() { return expIn; }
    public String getExpOut() { return expOut; }
    public int getResultado() { return resultado; }

    @Override
    public String toString() {
        operate();
        calcular();
        return "Expressão inicial: " + getExpIn() +
        "\nExpressão préfixa: " + getExpOut() +
        "\nResultado: " + getResultado();
    }
}
