package Ameaca.Views;

import Ameaca.Entities.Ameaca;
import Ameaca.Service.AmeacaService;
import Ameaca.Service.ArquivosService;
import Ameaca.Service.BussinesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmPrincipal extends JFrame {

    private FrmAmeaca guiAm = new FrmAmeaca();
    private AmeacaService srvAm = new AmeacaService();


    private JButton btnInserir;
    private JButton btnRemover;
    private JButton btnAlterar;
    private JButton btnFiltrar;
    private JButton btnSair;
    private JButton btnArquivos;
    private JButton btnImport;
    private JTextField tbxFiltro;
    private CtrlListar ctrlListar;
    private JPanel pnlBotoes;
    private JPanel pnlBotoesArq;

    private JButton criarBotao(JPanel pnlPai, Action act, int width, int height) {
        JButton btn = new JButton(act);
        btn.setPreferredSize(new Dimension(width, height));
        pnlPai.add(btn);
        return btn;
    }

    private JTextField criarCaixaTexto(JPanel pnlPai, int largura) {
        JTextField txt = new JTextField(largura);
        pnlPai.add(txt);
        return txt;
    }

    private void update() {
        String txt = tbxFiltro.getText();
        ctrlListar.update(srvAm.listar(txt));
    }

    public FrmPrincipal() {
        setTitle("Registro de Ameacas");
        setSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(400, 300));

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Action actInserir = new AbstractAction() {
            {
                putValue(Action.SHORT_DESCRIPTION, "Inserir");
                putValue(Action.SMALL_ICON, new ImageIcon("src/Resource/inserir.png"));
            }

            public void actionPerformed(ActionEvent e) {
                try {
                    Ameaca am = new Ameaca();
                    guiAm.executar(am);
                    srvAm.inserir(am);
                    tbxFiltro.setText("");
                    update();
                } catch (BussinesException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        Action actRemover = new AbstractAction() {
            {
                putValue(Action.SHORT_DESCRIPTION, "Remover");
                putValue(Action.SMALL_ICON, new ImageIcon("src/Resource/remover.png"));
            }

            public void actionPerformed(ActionEvent e) {
                try {
                    Ameaca a = ctrlListar.getSelected();
                    if (null == a)
                        JOptionPane.showMessageDialog(null, "Um e Somente somente um item deve estar selecionado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    else if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Voce tem certeza que deseja remover ameaca " + a.getCve() + "?", "Warning", JOptionPane.YES_NO_OPTION)) {
                        srvAm.remover(a.getId());
                        JOptionPane.showMessageDialog(null, "ameaca removida com sucesso!");
                        update();
                    }
                } catch (BussinesException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        Action actAlterar = new AbstractAction() {
            {
                putValue(Action.SHORT_DESCRIPTION, "Alterar");
                putValue(Action.SMALL_ICON, new ImageIcon("src/Resource/alterar.png"));
            }

            public void actionPerformed(ActionEvent e) {
                try {
                    Ameaca am = ctrlListar.getSelected();
                    if (am == null)
                        JOptionPane.showMessageDialog(null, "Um e Somente somente um item deve estar selecionado para editar!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    else {
                        int aux = am.getId();
                        if (guiAm.executar(am)) {
                            srvAm.alterar(aux, am);
                            JOptionPane.showMessageDialog(null, "Ameaca atualizada com sucesso!");
                            update();
                        }
                    }
                } catch (BussinesException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        Action actCriarArquivos = new AbstractAction() {
            {
                putValue(Action.SHORT_DESCRIPTION, "Criar Arquivos");
                putValue(Action.SMALL_ICON, new ImageIcon("src/Resource/criarDocumento.png"));
            }

            public void actionPerformed(ActionEvent e) {
                try {
                    Ameaca am = ctrlListar.getSelected();
                    if (am == null)
                        JOptionPane.showMessageDialog(null, "Um e Somente somente um item deve estar selecionado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    else {
                        ArquivosService as = new ArquivosService();
                        as.criar(am);
                    }

                } catch (BussinesException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        Action actBaixarArquivos = new AbstractAction() {
            {
                putValue(Action.SHORT_DESCRIPTION, "Baixar Arquivos");
                putValue(Action.SMALL_ICON, new ImageIcon("src/Resource/baixarDocumento.png"));
            }

            public void actionPerformed(ActionEvent e) {
                try {
                    Ameaca am = ctrlListar.getSelected();
                    if (am == null)
                        JOptionPane.showMessageDialog(null, "Um e Somente somente um item deve estar selecionado!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    else {
                        ArquivosService as = new ArquivosService();
                        as.baixar(am);
                    }

                } catch (BussinesException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        Action actFiltrar = new AbstractAction() {
            {
                putValue(Action.SHORT_DESCRIPTION, "Ativar os filtros");
                putValue(Action.SMALL_ICON, new ImageIcon("src/Resource/filtro.png"));
            }

            public void actionPerformed(ActionEvent e) {
                try {
                    tbxFiltro.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                tbxFiltro.getText();
                            }
                            update();
                        }
                    });
                } catch (BussinesException err) {
                    JOptionPane.showMessageDialog(null, err.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Erro não esperado! entre em contato com os desenvolvedores\n\n" + err.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        Action actSair = new AbstractAction() {
            {
                putValue(Action.SHORT_DESCRIPTION, "Sair");
                putValue(Action.SMALL_ICON, new ImageIcon("src/Resource/sair.png"));
            }

            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        };
        pnlBotoes = new JPanel();
        add(pnlBotoes, BorderLayout.NORTH);
        pnlBotoesArq = new JPanel();
        add(pnlBotoesArq, BorderLayout.SOUTH);
        btnInserir = criarBotao(pnlBotoes, actInserir, 50, 50);
        btnRemover = criarBotao(pnlBotoes, actRemover, 50, 50);
        btnAlterar = criarBotao(pnlBotoes, actAlterar, 50, 50);
        btnFiltrar = criarBotao(pnlBotoes, actFiltrar, 50, 50);
        tbxFiltro = criarCaixaTexto(pnlBotoes, 30);
        btnSair = criarBotao(pnlBotoes, actSair, 50, 50);
        btnArquivos = criarBotao(pnlBotoesArq, actCriarArquivos, 100, 50);
        btnImport = criarBotao(pnlBotoesArq, actBaixarArquivos, 100, 50);
        ctrlListar = new CtrlListar();
        add(ctrlListar, BorderLayout.CENTER);
    }

    public void executar() {
        ctrlListar.update(srvAm.listar());
        show();
    }
}