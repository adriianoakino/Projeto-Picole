package Helper;

import android.app.DialogFragment;
import android.util.Base64;

/**
 * Created by Adriano on 16/09/2017.
 */

public class Base64Custom extends DialogFragment {
    public static String codificarBase64(String texto) {
        return Base64.encodeToString(texto.getBytes(), Base64.DEFAULT).replaceAll("(\\n|\\r)","");
    }

    public static String decodificadorBase64(String textoCodificado){
        return new String(Base64.decode(textoCodificado.getBytes(), Base64.DEFAULT));
    }

    
}
