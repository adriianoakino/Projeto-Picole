package Helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Adriano on 16/09/2017.
 */

public class Preferencias {

    private Context contex;
    private SharedPreferences sharedPreferences;
    private String NOME_ARQUIVO="tudodebomFirebase.preferences";
    private int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String CHAVE_IDENTIFICADOR = "identificadorUsuarioLogado";
    private final String CHAVE_NOME = "nomeUsuarioLogado";

    public Preferencias(Context contex){
        this.contex = contex;
        sharedPreferences = contex.getSharedPreferences(NOME_ARQUIVO, MODE);
        editor = sharedPreferences.edit();
    }

    public void salvarUsuarioPreferencias(String identificadorUsuario, String nomeUsuario){
        editor.putString(CHAVE_IDENTIFICADOR,identificadorUsuario);
        editor.putString(CHAVE_NOME, nomeUsuario);
        editor.commit();
    }

    public String getIdentificador(){
        return sharedPreferences.getString(CHAVE_IDENTIFICADOR, null);
    }

    public String getNome(){
        return sharedPreferences.getString(CHAVE_NOME, null);
    }


}
