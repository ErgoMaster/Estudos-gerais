public class Expressoes {
    public static String infixtoprefix(String strIn) {
        PilhaEncadeada stack = new PilhaEncadeada();
        String strOut = "";
        char c, cPop;

        for(int i = strIn.length() - 1; i >= 0; i--) {
            c = strIn.charAt(i);

            if(ehDigito(c)) { strOut = c + strOut; }
            else if(ehOperador(c)) { 
                try {
                    while(!stack.estaVazia() && prioridade((char)stack.getTop()) > prioridade(c)) {
                        strOut = (char) stack.pop() + strOut;
                    }
                } catch(Exception e) { System.out.println("ERRO"); }
                
                stack.push(c);
            }
            else if(c == ')') { stack.push(c); }
            else if(c == '(') { 
                try {
                    do {
                        cPop = (char) stack.pop();
                        if(cPop != ')') { strOut = cPop + strOut; }
                    } while(cPop != ')');
                } catch(Exception e) { System.out.println("ERRO"); }
            }
            else { }
        }

        try {
            while(!stack.estaVazia()) {
                strOut = (char) stack.pop() + strOut;
            }
        } catch (Exception e) { System.out.println("ERRO"); }

        return strOut;
    }

    static public boolean ehDigito(char c) {
        switch(c) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0': { return true; }
            default: { return false; }
        }
    }

    static public boolean ehOperador(char c) {
        switch(c) {
            case '+', '/', '-', '*', '$': { return true; }
            default: { return false; }
        }
    }

    static public int prioridade(char c) {
        switch(c) {
            case '+', '-': return 0;
            case '*', '/': return 1;
            case '$': return 2;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(infixtoprefix("(7+2)*1"));
    }
}