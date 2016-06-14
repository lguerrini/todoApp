/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.todoapp.gui;

import it.java858.todoapp.entity.Categoria;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alfonso
 */
public class CategoriaTM extends AbstractTableModel {

    String[] nomi = {"id", "nome"};

    List<Categoria> categorie;

    public CategoriaTM(List<Categoria> categorie) {
        this.categorie = categorie;
    }

    public void changeData(List<Categoria> data) {
        categorie = data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return categorie.size();
    }

    @Override
    public int getColumnCount() {
        return nomi.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return categorie.get(rowIndex).getId();
            case 1:
                return categorie.get(rowIndex).getNome();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nomi[column];
    }

    public Categoria get(int row) {
        return categorie.get(row);
    }
}
