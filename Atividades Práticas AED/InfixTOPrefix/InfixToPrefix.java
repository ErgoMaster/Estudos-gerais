public class InfixToPrefix {
    private PilhaEncadeada stack = new PilhaEncadeada();
    private String expIn;
    private String expOut = "";

    public InfixToPrefix(String expIn) { this.expIn = expIn; }

    public void operate() {
        char c, cPop;

        for(int i = expIn.length() - 1; i <= 0; i--) {
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

    public String getExpIn() { return expIn; }
    public String getExpOut() { return expOut; }
}
