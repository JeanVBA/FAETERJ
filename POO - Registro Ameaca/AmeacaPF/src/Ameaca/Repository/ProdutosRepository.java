package Ameaca.Repository;

import Ameaca.Entities.Produtos;
import Ameaca.Service.ProdutosService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ProdutosRepository extends AllRepository {
    public void inserir(Produtos p) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("insert into produtos(produto, versao) values (?,?)");
            statement.setString(1, p.getProduto());
            statement.setDouble(2, p.getVersao());
            statement.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public Iterable<Produtos> listar() {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("select id, produto, versao from produtos order by id");
            ResultSet rs = statement.executeQuery();
            List<Produtos> list = new LinkedList<Produtos>();
            while (rs.next()) {
                Produtos p = new Produtos();
                p.setProduto(rs.getString(2));
                p.setVersao(rs.getDouble(3));
                list.add(p);
            }
            desconectar();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public void criar() {
        List<Produtos> list = (List<Produtos>) listar();
        if (list.size() == 0) {
            ProdutosService ps = new ProdutosService();
            ps.criar();
        }
    }


}
