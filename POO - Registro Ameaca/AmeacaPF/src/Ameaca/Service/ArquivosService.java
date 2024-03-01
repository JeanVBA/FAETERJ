package Ameaca.Service;

import Ameaca.Entities.Arquivos;
import Ameaca.Entities.Ameaca;
import Ameaca.Repository.ArquivosRepository;
import Ameaca.Packges.SolucaoPackge;

public class ArquivosService {

    private ArquivosRepository rep = new ArquivosRepository();
    private SolucaoPackge sp = new SolucaoPackge();

    public void criar(Ameaca a){
        Arquivos ar = new Arquivos();
        try{
        ar.setIdAmeaca(a.getId());
        ar.setArquivoTxt(sp.txtEmBites());
        ar.setArquivoPdf(sp.pdfEmBites(ar, a));
        inserir(ar);
        }catch (Exception e){
             throw new BussinesException("Erro ao passar informacoes para arquivos");
        }
    }
    public void baixar(Ameaca a){
        Arquivos ar;
        try{
             ar = rep.get(a.getId());
             sp.Zip(ar);
        }catch(Exception e){
            throw new BussinesException("Erro ao baixar arquivos");
        }
    }
    public void alterarArquivo(Ameaca a){
        Arquivos ar = new Arquivos();
        try{
            ar.setIdAmeaca(a.getId());
            ar.setArquivoTxt(sp.txtEmBites());
            ar.setArquivoPdf(sp.pdfEmBites(ar, a));
            alterar(a.getId(), ar);
        }catch (Exception e){
            throw new BussinesException("Erro ao passar informacoes para arquivos");
        }
    }
    public void inserir(Arquivos a)
    {
        var aux = rep.get(a.getIdAmeaca());
        if(aux != null)
            throw new BussinesException("Já existe Arquivos pra essa ameaca");
        if (a.getArquivoTxt() == null || a.getArquivoTxt().length==0 )
            throw new BussinesException("Arquivo TXT vazio!");
        if (a.getArquivoPdf() == null || a.getArquivoPdf().length==0 )
            throw new BussinesException("Arquivo PDF vazio!");
        rep.inserir(a);
    }
    public void alterar(int id, Arquivos a)
    {
        if (a.getArquivoTxt() == null || a.getArquivoTxt().length==0 )
            throw new BussinesException("Arquivo TXT vazio!");
        if (a.getArquivoPdf() == null || a.getArquivoPdf().length==0 )
            throw new BussinesException("Arquivo PDF vazio!");
        rep.alterar(id, a);
    }
    public void remover(int id)
    {
        var media = rep.get(id);
        if (media == null)
            throw new BussinesException("Arquivos não encontrado para remoção");
        rep.remover(id);
    }

    public Arquivos obterPeloId(int id)
    {
        return rep.get(id);
    }
}
