package Ameaca.Repository;



import Ameaca.Entities.Tipos;
import Ameaca.Service.TiposService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class TiposRepository extends AllRepository{
    public void inserir(Tipos t) {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("insert into tipos(tipo) values (?)");
            statement.setString(1, t.getTipo());
            statement.executeUpdate();
            desconectar();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public Iterable<Tipos> listar() {
        try {
            conectar();
            PreparedStatement statement = prepareStatement("select id, tipo from tipos order by id");
            ResultSet rs = statement.executeQuery();
            List<Tipos> list = new LinkedList<Tipos>();
            while (rs.next()) {
                Tipos t = new Tipos();
                t.setTipo(rs.getString(2));
                list.add(t);
            }
            desconectar();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }
    public void criar(){
        List<Tipos> list = (List<Tipos>) listar();
        if(list.size() ==0){
            TiposService ts = new TiposService();
            ts.criar();
        }
    }
}
