package view;

class ConstantesGlobais {
    public static final String autor = "Diego Ferreira Rapaci 198854\n"
            + "Marx Maciel Xavier 184878\n"
            + "Natalia Emboava 173709\n"
            + "Ulisses Dos Santos Cardoso Da Silva 244902\n"
            + "Victor Valentim Bergamasco 174213";
    public static final String campus = "FT - Faculdade de Tecnologia";
    public static final String universidade = "Unicamp - Universidade Estadual de Campinas";
    public static final String nome = "Chat Online - Grupo4";
    public static final String versao = "Ver. 1.0.0";
    public static final String arqLogo = "arqLogo.jpg";
    public static final String status = "Status da conexão: ";

    static String getTextoSobre() {
        final StringBuffer text = new StringBuffer();

        text.append("\n");
        text.append(universidade);
        text.append("\n\n");
        text.append(campus);
        text.append("\n\n");
        text.append(autor);
        text.append("\n\n");
        text.append(nome);
        text.append("\n\n");
        text.append(versao);
        text.append("\n");

        return (text.toString());
    }

    static String getTextoAjuda() {
        StringBuilder text = new StringBuilder();

        text.append("\n");
        text.append("Este programa é um exemplo de aplicação Java com interface gráfia para a "
                + "disciplina SI400.\n");

        return (text.toString());
    }

    static String getNomeVersao() {
        return (nome + " - " + versao);
    }
}
