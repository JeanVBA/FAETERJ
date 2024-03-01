package Ameaca;


import Ameaca.Repository.ProdutosRepository;
import Ameaca.Repository.TiposRepository;

import Ameaca.Views.FrmPrincipal;
import Ameaca.Views.FrmSplash;


public class Principal {
    public static void main (String[] args) {
       FrmSplash.executar(5000);
        TiposRepository tr = new TiposRepository();
        ProdutosRepository pr = new ProdutosRepository();
        tr.criar();
        pr.criar();
        FrmPrincipal p = new FrmPrincipal();
        p.executar();
        //System.exit(0);
   }
}