/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm2
 */
public class Conexao {
        
    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/CRUD";
    final private String usuario = "root";
    final private String senha = "";

    private Connection conexao;
    private Statement statement;
    
    public boolean conectar() {
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return true;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado: " + e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão com o banco de dados: " + e);
        }
        return false;
    }
    
     public void desconectar() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível fechar o banco de dados: " + e);
        }
    }

     

    public void executeSQL(String sql) {
        // Abre a conexão com o banco de dados
        if (conectar()) {
            try {
                statement = conexao.createStatement();
                statement.executeUpdate(sql);
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Erro ao executar SQL: " + sqle.getMessage());
            } finally {
                desconectar(); // Certifique-se de sempre desconectar
            }
        }
    }
    
    public ResultSet RetornarResultset(String sql) {
        ResultSet resultSet = null;
        // Abre a conexão com o banco de dados
        if (conectar()) {
            try {
                statement = conexao.createStatement();
                resultSet = statement.executeQuery(sql);
                resultSet.next();
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Erro ao retornar ResultSet: " + sqle.getMessage());
            }
        }
        return resultSet;
    }
}
