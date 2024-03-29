/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class ListaTrianguloJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ListaTrianguloJPanel
     */
      public ListaTrianguloJPanel(List<Document> areasTriangulos) {
        initComponents();
        cargarTabla(areasTriangulos);
    }

    private void cargarTabla(List<Document> areasTriangulos) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("#");
        modeloTabla.addColumn("Base");
        modeloTabla.addColumn("Altura");
        modeloTabla.addColumn("Área");

        for (int i = 0; i < areasTriangulos.size(); i++) {
            Document area = areasTriangulos.get(i);
            modeloTabla.addRow(new Object[]{i + 1, area.getDouble("base"), area.getDouble("altura"), area.getDouble("area")});
        }

        jTableTriangulo.setModel(modeloTabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTriangulo = new javax.swing.JTable();

        jTableTriangulo.setForeground(new java.awt.Color(52, 162, 240));
        jTableTriangulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Base", "Altura", "Área"
            }
        ));
        jScrollPane1.setViewportView(jTableTriangulo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTriangulo;
    // End of variables declaration//GEN-END:variables
}
