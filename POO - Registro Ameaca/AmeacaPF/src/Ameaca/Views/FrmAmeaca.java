package Ameaca.Views;

import Ameaca.Entities.Ameaca;
import Ameaca.Entities.Produtos;
import Ameaca.Entities.Tipos;
import Ameaca.Service.ProdutosService;
import Ameaca.Service.TiposService;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;


public class FrmAmeaca extends JDialog implements ActionListener {
    private JButton btnOk;
    private JButton btnCancel;
    private JTextField tbxCve;
    private JTextField tbxCriticidade;
    private JTextField tbxData;

    private boolean confirmou = false;

    MaskFormatter mascaraData;
    MaskFormatter mascaraCve;
    MaskFormatter mascaraCriti;
    private JComboBox jboxTipo;
    private JComboBox jboxProduto;

    private TiposService ts = new TiposService();
    private ProdutosService ps = new ProdutosService();


    private JComboBox criarBoxField(JPanel pnlPai, String rotulo, int largura, String[] v) {
        Panel pnl = new Panel(new FlowLayout(FlowLayout.LEFT));
        pnl.setPreferredSize(new Dimension(450, 30));
        JLabel lbl = new JLabel(rotulo);
        lbl.setPreferredSize(new Dimension(100, 30));
        JComboBox<String> jbox = new JComboBox<String>();
        jbox.setPreferredSize(new Dimension(largura, 20));
        for (int i = 0; i < v.length; i++) {
            jbox.addItem(v[i]);
        }
        pnl.add(lbl);
        pnl.add(jbox);
        pnlPai.add(pnl);
        return jbox;
    }

    private JTextField criarTextFieldFormat(JPanel pnlPai, String rotulo, int largura, JTextField jpai) {
        Panel pnl = new Panel(new FlowLayout(FlowLayout.LEFT));
        pnl.setPreferredSize(new Dimension(450, 30));
        JLabel lbl = new JLabel(rotulo);
        lbl.setPreferredSize(new Dimension(100, 30));
        jpai.setPreferredSize(new Dimension(largura, 20));
        pnl.add(lbl);
        pnl.add(jpai);
        pnlPai.add(pnl);
        return jpai;
    }

    public String[] tipos(Iterable<Tipos> t) {

        ArrayList<Tipos> tp = new ArrayList<>();
        for (Tipos tipos : t) {
            tp.add(tipos);
        }
        for (Tipos tipos : t) {
            tp.add(tipos);
        }
        String[] v = new String[tp.size()];
        for (int i = 0; tp.size() > i; i++) {
            v[i] = tp.get(i).getTipo();
        }
        return v;
    }

    public String[] produtos(Iterable<Produtos> p) {
        ArrayList<Produtos> pt = new ArrayList<>();
        for (Produtos produtos : p) {
            pt.add(produtos);
        }
        String[] v = new String[pt.size()];
        for (int i = 0; pt.size() > i; i++) {
            String aux = (pt.get(i).getProduto() + "/" + pt.get(i).getVersao());
            v[i] = aux;
        }
        return v;
    }

    public FrmAmeaca() {
        setTitle("Ameaca");
        setSize(new Dimension(500, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        JPanel pnlBotoes, pnlDados;

        pnlBotoes = new JPanel();
        ((FlowLayout) pnlBotoes.getLayout()).setHgap(70);
        pnlDados = new JPanel();

        add(pnlBotoes, BorderLayout.SOUTH);
        add(pnlDados, BorderLayout.CENTER);

        btnOk = new JButton("Ok");
        btnOk.setPreferredSize(new Dimension(100, 25));
        btnOk.addActionListener(this);
        pnlBotoes.add(btnOk);

        btnCancel = new JButton("Cancelar");
        btnCancel.setPreferredSize(new Dimension(100, 25));
        btnCancel.addActionListener(this);
        pnlBotoes.add(btnCancel);

        try {
            mascaraData = new MaskFormatter("##/##/####");
            mascaraCve = new MaskFormatter("CVE" + "-####-#####");
            mascaraCriti = new MaskFormatter("#");
            mascaraCriti.setPlaceholderCharacter('_');
            mascaraCve.setPlaceholderCharacter('_');
            mascaraData.setPlaceholderCharacter('_');
        } catch (ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }
        JFormattedTextField jFormattedTextCve = new JFormattedTextField(mascaraCve);
        JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);
        JFormattedTextField jFormattedTextCriti = new JFormattedTextField(mascaraCriti);


        tbxCve = criarTextFieldFormat(pnlDados, "CVE", 100, jFormattedTextCve);
        jboxProduto = criarBoxField(pnlDados, "Produto", 200, produtos(ps.listar()));
        jboxTipo = criarBoxField(pnlDados, "Tipo", 150, tipos(ts.listar()));
        tbxCriticidade = criarTextFieldFormat(pnlDados, "Criticidade", 20, jFormattedTextCriti);
        tbxData = criarTextFieldFormat(pnlDados, "Data", 65, jFormattedTextData);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOk)
            confirmou = true;
        hide();
    }

    private void atualizarTela(Ameaca d) {
        tbxCve.setText(d.getCve());
        jboxProduto.setSelectedItem(d.getSeparador());
        jboxTipo.setSelectedItem(d.getTipo());
        tbxCriticidade.setText("" + d.getCriticidade());
        tbxData.setText(d.getData());
    }

    private void atualizarObjeto(Ameaca a) {
        a.setSeparador(jboxProduto.getSelectedItem().toString());
        String[] v = a.getSeparador().split("/");
        String aux = v[0];
        String aux2 = v[1];
        a.setCve(tbxCve.getText());
        a.setProduto(aux);
        a.setVersao(aux2);
        a.setTipo(jboxTipo.getSelectedItem().toString());
        a.setCriticidade(Integer.parseInt(tbxCriticidade.getText()));
        a.setData(tbxData.getText());
    }


    public boolean executar(Ameaca d) {
        atualizarTela(d);
        confirmou = false;
        show();
        if (confirmou) {
            atualizarObjeto(d);
            return true;
        }
        return false;
    }
}