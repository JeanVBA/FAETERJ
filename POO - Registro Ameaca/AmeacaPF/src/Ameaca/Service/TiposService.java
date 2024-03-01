package Ameaca.Service;

import Ameaca.Entities.Tipos;
import Ameaca.Repository.TiposRepository;



public class TiposService {

    private TiposRepository tr = new TiposRepository();

    public void inserir(Tipos t)
    {
        if(t.getTipo() == null || t.getTipo().length() < 2)
            throw new BussinesException("Tipo não aceita esse valor");
        tr.inserir(t);
    }
    public Iterable<Tipos> listar()
    {
        return tr.listar();
    }
    public void criar(){
        Tipos t = new Tipos();
        TiposService ts = new TiposService();
        t.setTipo("Blended Threats");
        ts.inserir(t);
        t.setTipo("Cavalo de Troia");
        ts.inserir(t);
        t.setTipo("Ransomware");
        ts.inserir(t);
        t.setTipo("Autorun");
        ts.inserir(t);
        t.setTipo("Kilim");
        ts.inserir(t);
        t.setTipo("Majava");
        ts.inserir(t);
        t.setTipo("Keylogger");
        ts.inserir(t);
        t.setTipo("Spyware");
        ts.inserir(t);
        t.setTipo("Worms");
        ts.inserir(t);
        t.setTipo("Adware");
        ts.inserir(t);
    }
}
