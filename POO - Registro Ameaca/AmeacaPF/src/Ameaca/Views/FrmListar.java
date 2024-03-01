package Ameaca.Views;

import Ameaca.Entities.Ameaca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrmListar extends JDialog implements ActionListener {
    private JButton btnOk;
    private CtrlListar ctrlListar;

    public FrmListar() {
        setTitle("Lista de Ameacas");
        setSize(new Dimension(500, 270));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        JPanel pnlBotoes, pnlDados;

        pnlBotoes = new JPanel();
        pnlDados = new JPanel();
        pnlDados.setLayout(new BorderLayout());

        add(pnlBotoes, BorderLayout.SOUTH);
        add(pnlDados, BorderLayout.CENTER);

        btnOk = new JButton("Ok");
        btnOk.setPreferredSize(new Dimension(100, 25));
        btnOk.addActionListener(this);
        pnlBotoes.add(btnOk);

        ctrlListar = new CtrlListar();
        pnlDados.add(ctrlListar, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        hide();
    }

    private void atualizarTela(Iterable<Ameaca> colecao) {
        ctrlListar.update(colecao);
    }

    public void executar(Iterable<Ameaca> colecao) {
        atualizarTela(colecao);
        show();
    }
}