package Ameaca.Packges;

import Ameaca.Entities.Ameaca;

import java.awt.*;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import Ameaca.Entities.Arquivos;
import Ameaca.Service.BussinesException;
import Ameaca.Views.FrmPrincipal;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfWriter;


public class SolucaoPackge {

    private String _nomeArqTxt = "arquivo.txt";
    private String _nomeArqPdf = "arquivos.dpf";
    private String _nomeArqZip = "arquivo";
    private String _pastaOrigem = "Arquivos/";

    public SolucaoPackge() {

    }

    private static byte[] lerBytes(FileInputStream inputStream) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteStream.write(buffer, 0, bytesRead);
        }
        return byteStream.toByteArray();
    }

    public FileWriter solucaoTxt() {
        String conteudo = " 1- Utilize um software antivírus atualizado: Um software antivírus confiável e atualizado é uma ferramenta essencial para a detecção e remoção de vírus. Certifique-se de ter um software antivírus instalado em seu sistema e mantenha-o atualizado com as últimas definições de vírus. Realize verificações completas e regulares em seu sistema para identificar e remover quaisquer ameaças.\n" +
                " 2- Execute uma varredura completa do sistema: Inicie uma varredura completa em seu sistema para examinar todos os arquivos, pastas, programas e processos em busca de sinais de infecção. Se o seu software antivírus identificar algum arquivo infectado, siga as instruções para removê-lo ou colocá-lo em quarentena.\n" +
                " 3- Reinicie em modo de segurança: Reiniciar o computador em modo de segurança permite que você inicie o sistema com um conjunto mínimo de drivers e processos, o que pode facilitar a remoção de vírus. No modo de segurança, execute novamente uma varredura completa do sistema usando o seu software antivírus.\n" +
                " 4- Utilize ferramentas de remoção específicas: Além do software antivírus convencional, existem ferramentas de remoção especializadas disponíveis para lidar com ameaças específicas. Alguns vírus podem exigir a utilização de ferramentas de remoção específicas fornecidas pelos fabricantes de antivírus ou outras empresas de segurança. Verifique se há informações específicas sobre a ameaça que você enfrenta e use ferramentas apropriadas, se disponíveis.\n" +
                " 5- Mantenha seu sistema operacional e software atualizados: Manter seu sistema operacional, navegadores da web, plug-ins e outros softwares atualizados é essencial para fechar brechas de segurança conhecidas e proteger contra vulnerabilidades exploradas por vírus. Certifique-se de aplicar regularmente as atualizações e correções mais recentes fornecidas pelos fabricantes.\n" +
                " 6- Remova extensões e programas suspeitos: Verifique se há extensões de navegador, plugins ou programas suspeitos instalados em seu sistema. Desinstale qualquer software indesejado ou desconhecido por meio do painel de controle do sistema operacional ou das configurações do navegador.\n" +
                " 7- Limpe o registro do sistema: Alguns vírus podem deixar rastros no registro do sistema. Se você tem conhecimento avançado, pode limpar manualmente o registro usando o Editor de Registro do Windows ou uma ferramenta confiável de limpeza do registro.\n" +
                " 8- Faça backup e formate, se necessário: Se todos os esforços para remover o vírus falharem ou se você suspeitar de uma infecção grave, pode ser necessário fazer backup dos seus arquivos importantes e formatar completamente o sistema. Isso removerá todas as infecções, mas também apagará todos os dados do disco. Certifique-se de ter backups atualizados e seguros antes de prosseguir com essa opção.";
        try {
            FileWriter fw = new FileWriter(_nomeArqTxt);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write(conteudo);
            bufferedWriter.close();
            fw.close();
            return fw;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Document solucaoPDF(Arquivos arq, Ameaca am) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(_nomeArqPdf));
            document.open();
            Paragraph p = new Paragraph();
            p.setAlignment(Element.ALIGN_CENTER);
            p.add(new Chunk("Consequencias", new Font(Font.FontFamily.HELVETICA, 24)));
            document.add(p);
            document.add(new Paragraph(""));
            p =new Paragraph();
            p.setAlignment(Element.ALIGN_LEFT);
            p.add( new Paragraph("Relação Ameaca: Id "+arq.getIdAmeaca(), new Font(Font.FontFamily.COURIER, 20)));
            p.add( new Paragraph("Registro: "+am.getCve(), new Font(Font.FontFamily.COURIER, 20)));
            p.add( new Paragraph("Produto: "+am.getProduto(), new Font(Font.FontFamily.COURIER, 20)));
            p.add( new Paragraph("Versao: "+am.getVersao(), new Font(Font.FontFamily.COURIER, 20)));
            p.add( new Paragraph("Data: "+am.getData(), new Font(Font.FontFamily.COURIER, 20)));
            document.add(p);
            document.add(new Paragraph("* Ao não seguir os passos obtidos dentro do arquivo.txt, as consequencias podem ser altissimas", new Font(Font.FontFamily.TIMES_ROMAN, 15)));
            document.add(new Paragraph("* Uma ameaça do tipo "+am.getTipo()+" pode causar:\n"+"-Corrupção do seu sistema operacional;\n"+"-Corrupção de arquivos;\n"+"-Vazamentos de informações pessoais;\n"+"-Acesso direto as suas informações financeiras;",new Font(Font.FontFamily.TIMES_ROMAN, 15)));
            document.add(new Paragraph("* Em casos empresarias, a não eliminação de um malware pode causar um colapso da empresa de dentro para fora, impactanto na confiabilidade dos clientes perante aquela empresa",new Font(Font.FontFamily.TIMES_ROMAN, 15)));
            document.add(new Paragraph("* Siga os passos no arquivo.txt e apague o registro da ameaça sabendo que seu PC está mais seguro :)",new Font(Font.FontFamily.TIMES_ROMAN, 15)));

            p = new Paragraph();
            p.setAlignment(Element.ALIGN_BOTTOM);
            p.setAlignment(Element.ALIGN_CENTER);
            p.add(new Paragraph("Registro de Ameacas ltda.", new Font(Font.FontFamily.HELVETICA, 10)));
            p.add(new Paragraph("Para tirar duvidas entr em contato:", new Font(Font.FontFamily.HELVETICA, 10)));
            p.add(new Paragraph("email: jvabreu@faeterj-petropolis.edu.br", new Font(Font.FontFamily.HELVETICA, 10)));
            p.add(new Paragraph("Tel: (+55) 2498882-6439", new Font(Font.FontFamily.HELVETICA, 10)));
            document.add(p);
            document.close();
            return document;
        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] txtEmBites() {
        try {
            solucaoTxt();
            FileInputStream txtStream = new FileInputStream(_nomeArqTxt);
            byte[] txtBytes = lerBytes(txtStream);
            txtStream.close();
            File arquivo = new File(_nomeArqTxt);
            arquivo.delete();
            return txtBytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] pdfEmBites(Arquivos arq, Ameaca a) {
        try {
            solucaoPDF(arq, a);
            FileInputStream pdfStream = new FileInputStream(_nomeArqPdf);
            byte[] pdfBytes = lerBytes(pdfStream);
            pdfStream.close();
            File arquivo = new File(_nomeArqPdf);
            arquivo.delete();
            return pdfBytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FileOutputStream bitesEmTxt(Arquivos a) {
        try {
            FileOutputStream txtOutput = new FileOutputStream("Arquivos/" + "solucao.txt");
            txtOutput.write(a.getArquivoTxt());
            txtOutput.close();
            return txtOutput;
        } catch (Exception e) {
            throw new BussinesException("Não foi possivel recuperar arquivo txt");
        }
    }

    public FileOutputStream bitesEmPdf(Arquivos a) {
        try {
            FileOutputStream pdfOutput = new FileOutputStream("Arquivos/" + "consequencias.pdf");
            pdfOutput.write(a.getArquivoPdf());
            pdfOutput.close();
            return pdfOutput;
        } catch (Exception e) {
            throw new BussinesException("Não foi possivel recuperar arquivo pdf");
        }
    }

    public void ziparArquivos(String pastaOrigem, String arquivoZip) throws IOException {
        FileOutputStream fos = new FileOutputStream(arquivoZip);
        ZipOutputStream zos = new ZipOutputStream(fos);
        File diretorio = new File(pastaOrigem);
        adicionaArquivosAoZip(diretorio, pastaOrigem, zos);
        zos.close();
        fos.close();
    }

    public void adicionaArquivosAoZip(File arquivo, String nomeEntrada, ZipOutputStream zos) throws IOException {
        if (arquivo.isDirectory()) {
            for (File arquivoFilho : arquivo.listFiles()) {
                adicionaArquivosAoZip(arquivoFilho, nomeEntrada + "/" + arquivoFilho.getName(), zos);
            }
        } else {
            FileInputStream fis = new FileInputStream(arquivo);
            ZipEntry entrada = new ZipEntry(nomeEntrada);
            zos.putNextEntry(entrada);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                zos.write(buffer, 0, bytesRead);
            }
            fis.close();
        }
    }

    public void Zip(Arquivos a) {
        try {
            bitesEmTxt(a);
            bitesEmPdf(a);
            ziparArquivos(_pastaOrigem, _nomeArqZip+"AmeacaId_"+a.getIdAmeaca()+".zip");
            File dir = new File(_pastaOrigem);
            if (dir.exists() && dir.isDirectory()) {
                File[] arquivos = dir.listFiles();
                if (arquivos != null)
                    for (File arquivo : arquivos)
                        if (arquivo.isFile())
                            arquivo.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
