package Ameaca.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import Ameaca.Entities.Ameaca;

public class AmeacaRepository extends AllRepository {
    public void inserir(Ameaca a) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("insert into ameaca(cve,produto,versao,tipo,criticidade,data) values (?,?,?,?,?,?)");
            statement.setString(1, a.getCve());
            statement.setString(2, a.getProduto());
            statement.setString(3, a.getVersao());
            statement.setString(4, a.getTipo());
            statement.setInt(5, a.getCriticidade());
            statement.setString(6, a.getData());
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
            PreparedStatement statement = prepareStatement("delete from ameaca where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void alterar(int id, Ameaca a) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement(
                    "update ameaca set cve=?,produto=?,versao=?,tipo=?,criticidade=?,data=? where id=?");
            statement.setString(1, a.getCve());
            statement.setString(2, a.getProduto());
            statement.setString(3, a.getVersao());
            statement.setString(4, a.getTipo());
            statement.setInt(5, a.getCriticidade());
            statement.setString(6, a.getData());
            statement.setInt(7, id);
            statement.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Ameaca get(int cod) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("select id,cve,produto,versao,tipo,criticidade,data from ameaca where id=?");
            statement.setInt(1, cod);
            ResultSet rs = statement.executeQuery();
            Ameaca a = null;
            if (rs.next()) {
                a = new Ameaca();
                a.setId(rs.getInt(1));
                a.setCve(rs.getString(2));
                a.setProduto(rs.getString(3));
                a.setVersao(rs.getString(4));
                a.setTipo(rs.getString(5));
                a.setCriticidade(rs.getInt(6));
                a.setData(rs.getString(7));
            }
            desconectar();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public Iterable<Ameaca> listar() {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("select id,cve,produto,versao,tipo,criticidade,data from ameaca order by id");
            ResultSet rs = statement.executeQuery();
            List<Ameaca> list = new LinkedList<Ameaca>();
            while (rs.next()) {
                Ameaca a = new Ameaca();
                a.setId(rs.getInt(1));
                a.setCve(rs.getString(2));
                a.setProduto(rs.getString(3));
                a.setVersao(rs.getString(4));
                a.setTipo(rs.getString(5));
                a.setCriticidade(rs.getInt(6));
                a.setData(rs.getString(7));
                list.add(a);
            }
            desconectar();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

}
