package Ameaca.Repository;

import Ameaca.Entities.Arquivos;

import java.util.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ArquivosRepository extends AllRepository {

    public void inserir(Arquivos a) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("insert into arquivos (idAmeaca, arquivoTxt, arquivoPdf) values (?,?,?)");
            statement.setInt(1, a.getIdAmeaca());
            statement.setBytes(2, a.getArquivoTxt());
            statement.setBytes(3, a.getArquivoPdf());
            statement.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void remover(int id) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("delete from arquivos where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void alterar(int id, Arquivos a) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("update arquivos set idAmeaca=?, arquivoTxt=?, arquivoPdf=? where idAmeaca=?");
            statement.setInt(1, a.getIdAmeaca());
            statement.setBytes(2, a.getArquivoTxt());
            statement.setBytes(3, a.getArquivoPdf());
            statement.setInt(4, id);
            statement.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public Arquivos get(int id) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("select id, idAmeaca, arquivoTxt, arquivoPdf from arquivos where idAmeaca=?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Arquivos a = null;
            if (rs.next()) {
                a = new Arquivos();
                a.setId(rs.getInt(1));
                a.setIdAmeaca(rs.getInt(2));
                a.setArquivoTxt(rs.getBytes(3));
                a.setArquivoPdf(rs.getBytes(4));
            }
            desconectar();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
}


