package Ameaca.Service;

import Ameaca.Entities.Produtos;
import Ameaca.Repository.ProdutosRepository;

public class ProdutosService {



        private ProdutosRepository pr = new ProdutosRepository();
        public void inserir(Produtos p)
        {
            if(p.getProduto() == null || p.getProduto().length() < 2)
                throw new BussinesException("Produto não aceita esse valor");
            if(p.getVersao() == 0.0)
                throw new BussinesException("Versao não aceita");
            pr.inserir(p);
        }
        public Iterable<Produtos> listar()
        {
            return pr.listar();
        }
        public void criar(){
            Produtos t = new Produtos();
            Ameaca.Service.ProdutosService ts = new Ameaca.Service.ProdutosService();
            t.setProduto("macOS Ventura");
            t.setVersao(13.4);
            ts.inserir(t);
            t.setProduto("macOS Montery");
            t.setVersao(12.6);
            ts.inserir(t);
            t.setProduto("macOS Big Sur");
            t.setVersao(11.7);
            ts.inserir(t);
            t.setProduto("macOS Catalina");
            t.setVersao(10.15);
            ts.inserir(t);
            t.setProduto("macOS Mojave");
            t.setVersao(10.14);
            ts.inserir(t);
            t.setProduto("macOS Sierra");
            t.setVersao(10.12);
            ts.inserir(t);
            t.setProduto("OS Yosemite");
            t.setVersao(10.10);
            ts.inserir(t);
            t.setProduto("OS Mavericks");
            t.setVersao(10.9);
            ts.inserir(t);
            t.setProduto("Windows XP");
            t.setVersao(1.0);
            ts.inserir(t);
            t.setProduto("Windows Vista");
            t.setVersao(1.0);
            ts.inserir(t);
            t.setProduto("Windows");
            t.setVersao(7.0);
            ts.inserir(t);
            t.setProduto("Windows");
            t.setVersao(8.0);
            ts.inserir(t);
            t.setProduto("Windows");
            t.setVersao(8.1);
            ts.inserir(t);
            t.setProduto("Windows");
            t.setVersao(10.0);
            ts.inserir(t);
            t.setProduto("Windows");
            t.setVersao(11.0);
            ts.inserir(t);
        }
}
