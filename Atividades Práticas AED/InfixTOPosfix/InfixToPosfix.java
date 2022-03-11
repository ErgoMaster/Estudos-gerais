public class InfixToPosfix {
    private PilhaEncadeada stack = new PilhaEncadeada();
    private String expIn;
    private String expOut = "";

    public InfixToPosfix(String expIn) { this.expIn = expIn; }

    public void operate() {
        char c, cPop;

        for(int i = 0; i < expIn.length(); i++) {
            c = expIn.charAt(i);

            if(ehDigito(c)) { expOut = expOut + c; }
            else if(ehOperador(c)) { 
                try {
                    while(!stack.estaVazia() && prioridade((char)stack.getTop()) >= prioridade(c)) {
                        expOut = expOut + (char) stack.pop();
                    }
                } catch (Exception e) { System.out.println("ERRO"); }
                
                stack.push(c);
            }
            else if(c == '(') { stack.push(c); }
            else if(c == ')') { 
                try {
                    do {
                        cPop = (char) stack.pop();
                        if(cPop != '(') { expOut = expOut + c; }
                    } while(cPop != '(');
                } catch (Exception e) { System.out.println("ERRO"); }
            }
            else { }
        }

        while(!stack.estaVazia()) {
            try { expOut = expOut + (char) stack.pop(); } 
            catch (Exception e) { System.out.println("ERRO"); }
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
    
