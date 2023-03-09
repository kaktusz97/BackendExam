package oop.views;

import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lists.ObservableArrayList;
import oop.entities.DurableProduct;
import oop.entities.DurableProductHandler;
import oop.entities.PerishableProduct;
import oop.entities.PerishableProductHandler;
import oop.entities.Product;
import oop.entities.ProductHandler;
import oop.exceptions.VerificationException;
import oop.utils.ProductType;

/**
 *
 * @author Marci
 */
public class ProductEditorForm extends javax.swing.JDialog {

    private ProductHandler handler;
    private ProductType type;
    private List<ProductEventListener> listeners;
    private ProductHandlingStrategy strategy;

    /**
     * Creates new form ProductEditorForm
     *
     * @param parent
     * @param type
     */
    public ProductEditorForm(java.awt.Frame parent, ProductType type) {
        super(parent, false);
        initComponents();
        this.type = type;
        setHandler();
        listeners = new ObservableArrayList();
        setTextFields();
    }

    public ProductEditorForm(java.awt.Frame parent, ProductType type, Product p) {
        super(parent, false);
        initComponents();
        this.type = type;
        setHandler();
        listeners = new ObservableArrayList();
        setTextFields();
        fillFormWithData(p);
    }

    public void setProductHandlingStrategy(ProductHandlingStrategy s) {
        this.strategy = s;
    }

    public void addProductEventListener(ProductEventListener l) {
        listeners.add(l);
    }

    public void removeProductEventListener(ProductEventListener l) {
        listeners.remove(l);
    }

    private void notifyListeners(Product product) {
        for (ProductEventListener listener : listeners) {
            strategy.notify(product, listener);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfArticleNumber = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfFamily = new javax.swing.JTextField();
        tfBrand = new javax.swing.JTextField();
        tfNettoPrice = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        tfTaxId = new javax.swing.JTextField();
        tfAmountUnits = new javax.swing.JTextField();
        tfCriticalQuantity = new javax.swing.JTextField();
        tfVariable2 = new javax.swing.JTextField();
        tfVariable1 = new javax.swing.JTextField();
        lbArticleNumber = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        lbFamily = new javax.swing.JLabel();
        lbNettoPrice = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbAmountUnits = new javax.swing.JLabel();
        lbCriticalQuantity = new javax.swing.JLabel();
        lbTaxId = new javax.swing.JLabel();
        lbQuantity = new javax.swing.JLabel();
        lbVariable2 = new javax.swing.JLabel();
        lbVariable1 = new javax.swing.JLabel();
        btCancel = new javax.swing.JButton();
        btSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lbArticleNumber.setText("ArticleNumber");

        lbName.setText("Name");

        lbBrand.setText("Brand");

        lbFamily.setText("Family");

        lbNettoPrice.setText("NettoPrice");

        lbAmountUnits.setText("AmountUnits");

        lbCriticalQuantity.setText("CriticalQuantity");

        lbTaxId.setText("TaxId");

        lbQuantity.setText("Quantity");

        lbVariable2.setText("-");

        lbVariable1.setText("-");

        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbArticleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfArticleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbFamily, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfFamily, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNettoPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfNettoPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTaxId, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfTaxId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbAmountUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfAmountUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbCriticalQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfCriticalQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tfVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbVariable2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfVariable2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfArticleNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbArticleNumber))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFamily, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFamily, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNettoPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNettoPrice))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTaxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTaxId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbQuantity))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAmountUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAmountUnits))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCriticalQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCriticalQuantity))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVariable1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(lbVariable1))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfVariable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVariable2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            // TODOadd your handling code here:
            Product p = createProductWithFormData();
            strategy.save(handler, p);
            notifyListeners(p);
            dispose();
        } catch (VerificationException ex) {
            Logger.getLogger(ProductEditorForm.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbAmountUnits;
    private javax.swing.JLabel lbArticleNumber;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbCriticalQuantity;
    private javax.swing.JLabel lbFamily;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNettoPrice;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JLabel lbTaxId;
    private javax.swing.JLabel lbVariable1;
    private javax.swing.JLabel lbVariable2;
    private javax.swing.JTextField tfAmountUnits;
    private javax.swing.JTextField tfArticleNumber;
    private javax.swing.JTextField tfBrand;
    private javax.swing.JTextField tfCriticalQuantity;
    private javax.swing.JTextField tfFamily;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNettoPrice;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfTaxId;
    private javax.swing.JTextField tfVariable1;
    private javax.swing.JTextField tfVariable2;
    // End of variables declaration//GEN-END:variables

    private void setTextFields() {
        switch (type) {
            case DURABLE_PRODUCT:
                lbVariable1.setText("WarrantyPeriod");
                lbVariable2.setText("GrossWeight");
                break;
            case PERISHABLE_PRODUCT:
                lbVariable1.setText("ExpirationDate");
                lbVariable2.setText("ProductionDate");
                break;
        }
    }

    private Product createProductWithFormData() throws VerificationException {
        Product result = switch (type) {
            case DURABLE_PRODUCT ->
                createDurableProduct();
            case PERISHABLE_PRODUCT ->
                createPerishableProduct();
        };
        return result;
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

    private DurableProduct createDurableProduct() throws VerificationException {
        return new DurableProduct(
                tfArticleNumber.getText(),
                tfName.getText(),
                tfBrand.getText(),
                tfFamily.getText(),
                Integer.parseInt(tfNettoPrice.getText()),
                Integer.parseInt(tfTaxId.getText()),
                Integer.parseInt(tfQuantity.getText()),
                tfAmountUnits.getText(),
                Integer.parseInt(tfCriticalQuantity.getText()),
                Integer.parseInt(tfVariable1.getText()),
                Double.parseDouble(tfVariable2.getText()));
    }

    private PerishableProduct createPerishableProduct() throws VerificationException {
        return new PerishableProduct(
                tfArticleNumber.getText(),
                tfName.getText(),
                tfBrand.getText(),
                tfFamily.getText(),
                Integer.parseInt(tfNettoPrice.getText()),
                Integer.parseInt(tfTaxId.getText()),
                Integer.parseInt(tfQuantity.getText()),
                tfAmountUnits.getText(),
                Integer.parseInt(tfCriticalQuantity.getText()),
                Date.valueOf(tfVariable1.getText()),
                Date.valueOf(tfVariable2.getText()));
    }

    private void fillFormWithData(Product p) {
        switch (type) {
            case DURABLE_PRODUCT:
                fillFromDurableProduct((DurableProduct) p);
                break;
            case PERISHABLE_PRODUCT:
                fillFromPerishableProduct((PerishableProduct) p);
                break;
        }
    }

    private void fillFromDurableProduct(DurableProduct p) {
        tfArticleNumber.setText(p.getArticleNumber());
        tfName.setText(p.getName());
        tfBrand.setText(p.getBrand());
        tfFamily.setText(p.getFamily());
        tfNettoPrice.setText(String.valueOf(p.getNettoPrice()));
        tfTaxId.setText(String.valueOf(p.getTaxId()));
        tfQuantity.setText(String.valueOf(p.getQuantity()));
        tfAmountUnits.setText(p.getAmountUnits());
        tfCriticalQuantity.setText(String.valueOf(p.getCriticalQuantity()));
        tfVariable1.setText((String.valueOf(p.getWarrantyPeriod())));
        tfVariable2.setText(String.valueOf(p.getGrossWeight()));
    }

    private void fillFromPerishableProduct(PerishableProduct p) {
        tfArticleNumber.setText(p.getArticleNumber());
        tfName.setText(p.getName());
        tfBrand.setText(p.getBrand());
        tfFamily.setText(p.getFamily());
        tfNettoPrice.setText(String.valueOf(p.getNettoPrice()));
        tfTaxId.setText(String.valueOf(p.getTaxId()));
        tfQuantity.setText(String.valueOf(p.getQuantity()));
        tfAmountUnits.setText(p.getAmountUnits());
        tfCriticalQuantity.setText(String.valueOf(p.getCriticalQuantity()));
        tfVariable1.setText((String.valueOf(p.getExpirationDate())));
        tfVariable2.setText(String.valueOf(p.getProductionDate()));
    }
}
