/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Store;

import Business.Enterprise.Enterprise;
import Business.Organization.StoreInventoryOrganization;
import Business.Product.Product;
import Business.StoreInventory.StoreProduct;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class StoreInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form StoreInventoryJPanel
     */
    private JPanel rightJPanel;
    private StoreInventoryOrganization storeInvntryOrg;
    private Enterprise enterprise;
    private UserAccount userAccount;
    
    public StoreInventoryJPanel(JPanel rightJPanel,UserAccount userAccount,StoreInventoryOrganization storeInvntryOrg,Enterprise enterprise) {
        initComponents();
        this.rightJPanel=rightJPanel;
        this.enterprise=enterprise;
        this.storeInvntryOrg= storeInvntryOrg;
        this.userAccount= userAccount;
        populateProdTable();
    }

    private void populateProdTable()
    {
        DefaultTableModel model = (DefaultTableModel) productJTable.getModel();
        
        model.setRowCount(0);
        
        System.out.println("enterprise.getProdDir().getProductList(): "+enterprise.getProdDir().getProductList());
        for (Product prod : enterprise.getProdDir().getProductList()){
            System.out.println("inside for of StoreInventoryJPanel");
            Object[] row = new Object[3];
            //System.out.println("supplier.getSupplierId(): "+supplier.getSupplierId());
            row[0] = prod;
            //System.out.println("supplier.getSupplierName(): "+supplier.getSupplierName());
            row[1] = prod.getProductId();
            row[2]= prod.getQuantity();
            model.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productJTable = new javax.swing.JTable();
        submitRequestJBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(232, 104, 80));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Store Inventory");

        productJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Name", "Product ID", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productJTable);

        submitRequestJBtn.setText("Make Requests");
        submitRequestJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitRequestJBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(submitRequestJBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(submitRequestJBtn)
                .addGap(214, 214, 214))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitRequestJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitRequestJBtnActionPerformed
        // TODO add your handling code here:
        
        StoreInventoryMakeRequestJPanel storeInvntryRequestJPanel= new StoreInventoryMakeRequestJPanel(rightJPanel,userAccount,enterprise);
        rightJPanel.add("Store Inventory Request Panel", storeInvntryRequestJPanel);
        CardLayout layout = (CardLayout) rightJPanel.getLayout();
        layout.next(rightJPanel);
    }//GEN-LAST:event_submitRequestJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productJTable;
    private javax.swing.JButton submitRequestJBtn;
    // End of variables declaration//GEN-END:variables
}
