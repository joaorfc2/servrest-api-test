package util;

import java.util.Random;

public class GeradorDados {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random random = new Random();

    public static String gerarEmailUnico() {
        String prefixo = gerarStringAleatoria(8);
        String sufixo = gerarStringAleatoria(4);
        return prefixo + "@" + sufixo + ".com";
    }

    public static String gerarSenha10Digitos() {
        return gerarStringAleatoria(10);
    }

    private static String gerarStringAleatoria(int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
