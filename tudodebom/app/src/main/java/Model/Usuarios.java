package Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

import DAO.FirebaseConfiguration;

/**
 * Created by Adriano on 16/09/2017.
 */

public class Usuarios {

    private String Id;
    private String email;
    private String password;
    private String nome;
    private String Rua;
    private String Numero;
    private String Bairro;
    private String CEP;
    private String Cidade;
    private String Estado;
    private String Telefone;
    private String Celular;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public void salvarUsuario(){
        DatabaseReference reference = FirebaseConfiguration.getFireBase();
        reference.child("usuario").child(String.valueOf(getId())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> hashMapUsuario = new HashMap<>();

        hashMapUsuario.put("id", getId());
        hashMapUsuario.put("nome", getNome());
        hashMapUsuario.put("email", getEmail());
        hashMapUsuario.put("password", getPassword());
        hashMapUsuario.put("Rua", getRua());
        hashMapUsuario.put("Numero", getNumero());
        hashMapUsuario.put("Bairro", getBairro());
        hashMapUsuario.put("CEP", getCEP());
        hashMapUsuario.put("Cidade", getCidade());
        hashMapUsuario.put("Estado", getEstado());
        hashMapUsuario.put("Telefone", getTelefone());
        hashMapUsuario.put("Celular", getCelular());

        return hashMapUsuario;
    }
}


