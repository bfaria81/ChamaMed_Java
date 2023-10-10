package ChamadasLeitos.chamadas.Service;

import org.springframework.stereotype.Service;

@Service
public class S_Generico {

    public static String limparNumero(String numero){
        //Remove caracteres não numéricos
        return numero.replaceAll("[^0-9]", "");
    }

    public static boolean campoVazio(String texto){
        return texto == null || texto.trim().equals("");
    }

}
