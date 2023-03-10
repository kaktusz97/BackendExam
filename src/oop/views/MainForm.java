package oop.views;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import oop.entities.DurableProduct;
import oop.entities.DurableProductHandler;
import oop.entities.PerishableProduct;
import oop.entities.PerishableProductHandler;
import oop.entities.Product;
import oop.entities.ProductHandler;
import oop.utils.ProductType;
import oop.views.strategies.InsertProductStrategy;
import oop.views.strategies.UpdateProductStrategy;
import oop.views.tablemodels.DurableProductTableModel;
import oop.views.tablemodels.PerishableProductTableModel;

/**
 *
 * @author --G--
 */
public class MainForm extends javax.swing.JFrame {

    private AbstractTableModel perishableTableModel;
    private AbstractTableModel durableTableModel;
    private ProductHandler handler;
    private List<PerishableProduct> perishableProducts;
    private List<DurableProduct> durableProducts;
    private ProductEditorForm productEditorForm;
    private int tabIndex;
    private ProductEventListener perishableEventListener;
    private ProductEventListener durableEventListener;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        tabIndex = 0;
        setTabIndex();
        setPerishablePage();
        setDurablePage();
        popAlertIfNecessary();
        perishableEventListener = new PerishableProductListener();
        durableEventListener = new DurableProductListener();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNew = new javax.swing.JButton();
        btUpdate = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        paneProducts = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerishableProducts = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDurableProducts = new javax.swing.JTable();
        btIncrQuantity = new javax.swing.JButton();
        btDecrQuantity = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        btSaveLog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TheBestProductHandlerProgramEverMade");
        setLocationByPlatform(true);

        btNew.setText("New Product");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btUpdate.setText("Update Product");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        btDelete.setText("Delete Product");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btExit.setText("Exit");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });

        tblPerishableProducts.setAutoCreateRowSorter(true);
        tblPerishableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPerishableProducts.setName(""); // NOI18N
        jScrollPane1.setViewportView(tblPerishableProducts);

        paneProducts.addTab("Perishable Products", jScrollPane1);

        tblDurableProducts.setAutoCreateRowSorter(true);
        tblDurableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblDurableProducts);

        paneProducts.addTab("Durable Products", jScrollPane2);

        btIncrQuantity.setText("Deposit");

        btDecrQuantity.setText("Withdraw");

        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        btSaveLog.setText("SaveLog");
        btSaveLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paneProducts)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNew)
                        .addGap(18, 18, 18)
                        .addComponent(btUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btDelete)
                        .addGap(26, 26, 26)
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btIncrQuantity)
                        .addGap(18, 18, 18)
                        .addComponent(btDecrQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addComponent(btSaveLog)
                        .addGap(127, 127, 127)
                        .addComponent(btExit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNew)
                    .addComponent(btUpdate)
                    .addComponent(btDelete)
                    .addComponent(btExit)
                    .addComponent(btIncrQuantity)
                    .addComponent(btDecrQuantity)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSaveLog))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void popAlertIfNecessary() {
        List<Product> result = new ArrayList<>();
        for (PerishableProduct perishableProduct : perishableProducts) {
            if (perishableProduct.getQuantity() < perishableProduct.getCriticalQuantity()) {
                result.add(perishableProduct);
            }
        }
        for (DurableProduct durableProduct : durableProducts) {
            if (durableProduct.getQuantity() < durableProduct.getCriticalQuantity()) {
                result.add(durableProduct);
            }
        }
        if (!result.isEmpty()) {
            popAlertWindow(result);
        }
    }

    private void popAlertWindow(List<Product> list) {
        CriticalQuantityAlert alert = new CriticalQuantityAlert(this, list);
        alert.setVisible(true);
    }

    private void searchPerishableProduct(String scan) {
    }

    private void searchDurableProduct(String scan) {
    }

    private void initPerishableInsert() {
        productEditorForm = new ProductEditorForm(this, ProductType.PERISHABLE_PRODUCT);
        productEditorForm.addProductEventListener(perishableEventListener);
        productEditorForm.setProductHandlingStrategy(new InsertProductStrategy());
    }

    private void initDurableInsert() {
        productEditorForm = new ProductEditorForm(this, ProductType.DURABLE_PRODUCT);
        productEditorForm.addProductEventListener(durableEventListener);
        productEditorForm.setProductHandlingStrategy(new InsertProductStrategy());
    }

    private void initDurableDelete() {
        int i = tblDurableProducts.getSelectedRow();
        ProductDeleteForm form = new ProductDeleteForm(this, ProductType.DURABLE_PRODUCT, durableProducts.get(i));
        form.addProductEventListener(durableEventListener);
        form.setVisible(true);
    }

    private void initPerishableDelete() {
        int i = tblPerishableProducts.getSelectedRow();
        ProductDeleteForm form = new ProductDeleteForm(this, ProductType.PERISHABLE_PRODUCT, perishableProducts.get(i));
        form.addProductEventListener(perishableEventListener);
        form.setVisible(true);
    }

    private class PerishableProductListener implements ProductEventListener<PerishableProduct> {

        @Override
        public void productCreated(PerishableProduct p) {
            perishableProducts.add(p);
            drawTable();
        }

        @Override
        public void productUpdated(PerishableProduct p) {
            drawTable();
        }

        @Override
        public void productDeleted(PerishableProduct p) {
            perishableProducts.remove(p);
            drawTable();
        }

        private void drawTable() {
            perishableTableModel.fireTableDataChanged();
        }
    }

    private class DurableProductListener implements ProductEventListener<DurableProduct> {

        @Override
        public void productCreated(DurableProduct p) {
            durableProducts.add(p);
            drawTable();
        }

        @Override
        public void productUpdated(DurableProduct p) {
            drawTable();
        }

        @Override
        public void productDeleted(DurableProduct p) {
            durableProducts.remove(p);
            drawTable();
        }

        private void drawTable() {
            durableTableModel.fireTableDataChanged();
        }
    }
    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        switch (tabIndex) {
            case 0:
                initPerishableInsert();
                break;
            case 1:
                initDurableInsert();
                break;
        }
        productEditorForm.setVisible(true);
    }//GEN-LAST:event_btNewActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        dispose();
    }//GEN-LAST:event_btExitActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        switch (tabIndex) {
            case 0:
                if (tblPerishableProducts.getSelectedRow() > -1 && !perishableProducts.isEmpty()) {
                    initPerishableUpdate();
                }
                break;
            case 1:
                if (tblDurableProducts.getSelectedRow() > -1 && !durableProducts.isEmpty()) {
                    initDurableUpdate();
                }
                break;
        }
    }//GEN-LAST:event_btUpdateActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        // TODO add your handling code here:
        Scanner scanner = new Scanner(tfSearch.getText());
        String scan = scanner.nextLine();
        switch (tabIndex) {
            case 0:
                searchPerishableProduct(scan);
                break;
            case 1:
                searchDurableProduct(scan);
                break;
        }

    }//GEN-LAST:event_tfSearchKeyReleased

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed

        switch (tabIndex) {
            case 0:
                if (tblPerishableProducts.getSelectedRow() > -1 && !perishableProducts.isEmpty()) {

                    initPerishableDelete();
                }
                break;
            case 1:
                if (tblDurableProducts.getSelectedRow() > -1 && !durableProducts.isEmpty()) {
                    initDurableDelete();
                }
                break;
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btSaveLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveLogActionPerformed
        File logFile = new File("savedtransactions.log");
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();
            try {
                Files.copy(logFile.toPath(), saveFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                try ( FileWriter writer = new FileWriter(logFile)) {
                    writer.write("");
                }
                JOptionPane.showMessageDialog(this, "File saved successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error while saving the file: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btSaveLogActionPerformed

    private void initPerishableUpdate() {
        int index = tblPerishableProducts.getSelectedRow();
        productEditorForm = new ProductEditorForm(this, ProductType.PERISHABLE_PRODUCT, perishableProducts.get(index));
        productEditorForm.addProductEventListener(perishableEventListener);
        productEditorForm.setProductHandlingStrategy(new UpdateProductStrategy());
        productEditorForm.setVisible(true);

    }

    private void initDurableUpdate() {
        int index = tblDurableProducts.getSelectedRow();
        productEditorForm = new ProductEditorForm(this, ProductType.DURABLE_PRODUCT, durableProducts.get(index));
        productEditorForm.addProductEventListener(durableEventListener);
        productEditorForm.setProductHandlingStrategy(new UpdateProductStrategy());
        productEditorForm.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.
                            getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class
                    .getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDecrQuantity;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btIncrQuantity;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSaveLog;
    private javax.swing.JButton btUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane paneProducts;
    private javax.swing.JTable tblDurableProducts;
    private javax.swing.JTable tblPerishableProducts;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

    private void setPerishablePage() {
        handler = new PerishableProductHandler();
        perishableProducts = handler.getAllProducts();
        perishableTableModel = new PerishableProductTableModel(perishableProducts);
        tblPerishableProducts.setModel(perishableTableModel);

    }

    private void setDurablePage() {
        handler = new DurableProductHandler();
        durableProducts = handler.getAllProducts();
        durableTableModel = new DurableProductTableModel(durableProducts);
        tblDurableProducts.setModel(durableTableModel);

    }

    private void setTabIndex() {
        paneProducts.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tabIndex = paneProducts.getSelectedIndex();
            }
        });
    }

}
