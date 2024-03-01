package Ameaca.Repository;

import java.sql.*;
import java.util.*;
import java.io.*;


public class AllRepository {

    private static final String _NOME_BANCO_ = "banco_de_dados.db";


    private Connection _con;


    public AllRepository() {
        try {
            Class.forName("org.sqlite.JDBC");
            File f = new File(_NOME_BANCO_);
            if (!f.exists())
                criarBanco();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void criarBanco() {
        try {
            conectar();
            Statement statement = _con.createStatement();
            statement.executeUpdate(
                    "create table ameaca (id INTEGER PRIMARY KEY AUTOINCREMENT, cve VARCHAR(20), produto VARCHAR(50), versao VARCHAR(20), tipo VARCHAR(50), criticidade int, data VARCHAR(10))");
            statement.executeUpdate("create table arquivos ( id integer primary key autoincrement, idAmeaca int not null, arquivoTxt blob, arquivoPdf blob,   FOREIGN KEY(idAmeaca) REFERENCES ameaca(id) ON delete CASCADE ON UPDATE CASCADE );");
            statement.executeUpdate("create table tipos ( id integer primary key autoincrement, tipo varchar(50));");
            statement.executeUpdate("create table produtos ( id integer primary key autoincrement, produto varchar(50), versao DOUBLE);");
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    protected Connection conectar() {
        try {
            if (_con == null)
                _con = DriverManager.getConnection("jdbc:sqlite:" + _NOME_BANCO_);
            return _con;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    protected void desconectar() {
        try {
            _con.close();
            _con = null;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    protected PreparedStatement prepareStatement(String sql) {
        try {
            return _con.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }


}
