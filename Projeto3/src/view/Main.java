package view;

import java.awt.HeadlessException;

public class Main {
    public static void main(String[] args) {
        try {
            JanelaPrincipal programa = new JanelaPrincipal();
            programa.inicia();
        } catch (HeadlessException e) {
            imprMsgErroETermina("Programa terminado por uma HeadlessException no metodo main()", e);
        } catch (Exception e) {
            imprMsgErroETermina("Programa terminado por uma Generic Exception no metodo main()", e);
        }
    }

    private static void imprMsgErroETermina(String mensagem, Exception ocorrencia) {
        System.out.println("Mensagem de erro:\t" + mensagem);
        System.out.println("Texto da excecao:\t" + ocorrencia.getMessage());
        System.exit(1);
    }
}
