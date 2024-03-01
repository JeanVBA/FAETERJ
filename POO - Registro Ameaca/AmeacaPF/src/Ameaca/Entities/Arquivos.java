package Ameaca.Entities;

public class Arquivos {
    private int id;
    private int idAmeaca;
    private byte[] arquivoTxt;
    private byte[] arquivoPdf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAmeaca() {
        return idAmeaca;
    }

    public void setIdAmeaca(int idAmeaca) {
        this.idAmeaca = idAmeaca;
    }

    public byte[] getArquivoTxt() {
        return arquivoTxt;
    }

    public void setArquivoTxt(byte[] arquivoTxt) {
        this.arquivoTxt = arquivoTxt;
    }

    public byte[] getArquivoPdf() {
        return arquivoPdf;
    }

    public void setArquivoPdf(byte[] arquivoPdf) {
        this.arquivoPdf = arquivoPdf;
    }
}
