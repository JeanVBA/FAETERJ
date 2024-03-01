package Ameaca.Views;

import Ameaca.Entities.Ameaca;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;


class DataModelAmeaca extends AbstractTableModel {
    private java.util.List<Ameaca> lst = new ArrayList<Ameaca>();

    public DataModelAmeaca() {
    }

    public void update(Iterable<Ameaca> ams) {
        lst.clear();
        for (Ameaca am : ams)
            lst.add(am);
        fireTableDataChanged();
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "id";
            case 1:
                return "CVE";
            case 2:
                return "PRODUTO";
            case 3:
                return "VERSAO";
            case 4:
                return "TIPO";
            case 5:
                return "CRITICIDADE";
            case 6:
                return "DATA";
            default:
                return "desconhecido";
        }
    }

    public Ameaca getAt(int row) {
        if (row < 0 || row >= lst.size())
            return null;
        else
            return lst.get(row);
    }

    public int getColumnCount() {
        return 7;
    }

    public int getRowCount() {
        return lst.size();
    }

    public Object getValueAt(int row, int col) {
        Ameaca d = lst.get(row);
        switch (col) {
            case 0:
                return d.getId();
            case 1:
                return d.getCve();
            case 2:
                return d.getProduto();
            case 3:
                return d.getVersao();
            case 4:
                return d.getTipo();
            case 5:
                return d.getCriticidade();
            case 6:
                return d.getData();
            default:
                return "error";
        }
    }
}


public class CtrlListar extends JPanel {
    private JTable tbl;
    private DataModelAmeaca mdl;

    public CtrlListar() {
        mdl = new DataModelAmeaca();
        tbl = new JTable(mdl);
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(10);
        JScrollPane scrollpane = new JScrollPane(tbl);
        this.setLayout(new BorderLayout());
        add(scrollpane, BorderLayout.CENTER);
    }

    public void update(Iterable<Ameaca> ams) {
        mdl.update(ams);
    }

    public Ameaca getSelected() {
        if (tbl.getSelectedRows().length != 1)
            return null;
        else {
            int row = tbl.getSelectedRow();
            return mdl.getAt(row);
        }
    }
}