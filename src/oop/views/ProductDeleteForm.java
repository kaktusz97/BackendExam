package oop.views;

import java.util.ArrayList;
import java.util.List;
import oop.entities.DurableProductHandler;
import oop.entities.PerishableProductHandler;
import oop.entities.Product;
import oop.entities.ProductHandler;
import oop.utils.ProductType;
import oop.views.strategies.DeleteProductStrategy;

/**
 *
 * @author Marci
 */
public class ProductDeleteForm extends javax.swing.JDialog {

    private Product p;
    private List<ProductEventListener> listeners;
    private ProductHandlingStrategy strategy;
    private ProductType type;
    private ProductHandler handler;

    /**
     * Creates new form ProductDeleteForm
     *
     * @param parent
     * @param type
     * @param p
     */
    public ProductDeleteForm(java.awt.Frame parent, ProductType type, Product p) {
        super(parent, false);
        initComponents();
        setLocationRelativeTo(null);
        this.p = p;
        this.type = type;
        setHandler();
        listeners = new ArrayList();
        strategy = new DeleteProductStrategy();
    }

    private void setHandler() {
        switch (type) {
            case DURABLE_PRODUCT:
                handler = new DurableProductHandler();
                break;
            case PERISHABLE_PRODUCT:
                handler = new PerishableProductHandler();
                break;
        }
    }

    public void addProductEventListener(ProductEventListener l) {
        listeners.add(l);
    }

    public void removeProductEventListener(ProductEventListener l) {
        listeners.remove(l);
    }

    private void notifyListeners() {
        for (ProductEventListener listener : listeners) {
            strategy.notify(p, listener);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btYes = new javax.swing.JButton();
        btNo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btYes.setText("Yes");
        btYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btYesActionPerformed(evt);
            }
        });

        btNo.setText("No");
        btNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNoActionPerformed(evt);
            }
        });

        jLabel1.setText("Are you sure your want to delete this product?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btYes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btNo)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btYes)
                    .addComponent(btNo))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btYesActionPerformed
        // TODO add your handling code here:
        strategy.save(handler, p);
        notifyListeners();
        dispose();
    }//GEN-LAST:event_btYesActionPerformed

    private void btNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNo;
    private javax.swing.JButton btYes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
