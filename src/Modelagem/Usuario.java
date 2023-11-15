/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Usuario {
    private int codigo;
    private String data1;
    private String resultado;
    private int peso;
    private int altura;
    
    Conexao con = new Conexao();
    
        public Usuario() {
        this(0,"","",0,0);
    }

    public Usuario(int codigo, String data1, String resultado, int peso, int altura) {
        this.codigo = codigo;
        this.data1 = data1;
        this.resultado = resultado;
        this.peso = peso;
        this.altura = altura;

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void cadastrarUsuario() {
        if (con.conectar()) {
            String sql = "INSERT INTO usuarios (data1, resultado, peso, altura) VALUES ('" + data1 + "', '" + resultado + "', " + peso + ", " + altura + ")";
            con.executeSQL(sql);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            con.desconectar();
        }
    }

     public ResultSet consultar(){
        ResultSet tabela;
        tabela = null;
        
        String sql= "Select * from usuarios";
        tabela = con.RetornarResultset(sql);
     return tabela;   
    }

    public void alterar() {
        if (con.conectar()) {
            String sql = "UPDATE usuarios SET data1 = '" + data1 + "', resultado = '" + resultado + "', peso = " + peso + ", altura = " + altura + " WHERE codigo = " + codigo;
            con.executeSQL(sql);
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
            con.desconectar();
        }
    }

    public void excluir() {
        if (con.conectar()) {
            String sql = "DELETE FROM usuarios WHERE codigo = " + codigo;
            con.executeSQL(sql);
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
            con.desconectar();
        }
    }
}