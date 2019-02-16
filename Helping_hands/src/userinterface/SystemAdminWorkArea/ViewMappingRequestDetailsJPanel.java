/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Resources.EducationResource;
import Business.Resources.FoodResource;
import Business.Resources.HealthResource;
import Business.Resources.MoneyResource;
import Business.Resources.Resource;
import Business.WorkQueue.ResourcesWorkRequest;
import java.awt.CardLayout;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Utility.*;
import java.util.ArrayList;

/**
 *
 * @author shukl
 */
public class ViewMappingRequestDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewRequestDetailsJPanel
     */
    private JPanel userProcessContainer;
    private ResourcesWorkRequest request;
    private EcoSystem system;
    private List<String> s;

    public ViewMappingRequestDetailsJPanel(JPanel userProcessContainer, ResourcesWorkRequest request, EcoSystem system) {
        initComponents();
        this.request = request;
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        s = new ArrayList<String>();
        populateRequestData();
        populateResourceData();
    }

    public void populateRequestData() {
        requestIdTextField.setText(String.valueOf(request.getRequsetId()));
        descriptionTextField.setText(request.getRequestDescription());
        requestTypeComboField.setSelectedItem(request.getMessage());
        localityField.setText(request.getNetwork());
        requestTypeComboField.setSelectedItem(request.getMessage());
        statusTextField.setText(request.getStatus());
        createdDate.setText(UtitlityMethods.getStringFromDate(request.getRequestDate()));
        for (Resource resource : request.getResourceRequested()) {

            s.add(resource.getName());
        }
        for (String s : s) {
            localityField.setText(localityField.getText() + s);
        }
        statusTextField.setText(request.getStatus());
        for (Resource res : request.getResourceRequested()) {
            if (res instanceof FoodResource) {
                FoodResource f = (FoodResource) res;
                numberOfPacketsTestField.setText(String.valueOf(f.getNumberOfFoodPackets()));
            }
            if (res instanceof HealthResource) {
                HealthResource f = (HealthResource) res;
                nameOfMedicineTextField.setText(f.getMedicineName());
                typeOfMedicineTextField.setText(f.getMedicineType());
                quantityOfMedicineTextField.setText(String.valueOf(f.getNumberOfPackets()));
                numberOfDoctorTextField.setText(String.valueOf(f.getNumberOfDoctors()));
            }
            if (res instanceof EducationResource) {
                EducationResource f = (EducationResource) res;
                numberOfEducationSuppliesTextField.setText(String.valueOf(f.getNumberOfSupplyMaterial()));
                numberOfTeacherTextField.setText(String.valueOf(f.getNumberOfTeachers()));
            }
            if (res instanceof MoneyResource) {
                MoneyResource f = (MoneyResource) res;
                moneyTextField.setText(String.valueOf(f.getAmount()));
            }
        }

        for (Map.Entry<String, Integer> map : request.getResourcesPendingMap().entrySet()) {
            if (map.getKey().equalsIgnoreCase("Food")) {
                numberOfPacketsTestField.setText(String.valueOf(map.getValue()));
            }
            if (map.getKey().equalsIgnoreCase("Education")) {
                numberOfEducationSuppliesTextField.setText(String.valueOf(map.getValue()));
            }
            if (map.getKey().equalsIgnoreCase("Health")) {
                quantityOfMedicineTextField.setText(String.valueOf(map.getValue()));
            }
            if (map.getKey().equalsIgnoreCase("Money")) {
                moneyTextField.setText(String.valueOf(map.getValue()));
            }
        }
    }

    private void populateResourceData() {
        for (Network network : system.getNetworkList()) {
            if (network.getName().equalsIgnoreCase(request.getNetwork())) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Map.Entry<String, List<Resource>> map : enterprise.getResourcesOffered().entrySet()) {
                        if (s.contains("Food")) {
                            if (map.getKey().equalsIgnoreCase("Food")) {

                                DefaultTableModel model = (DefaultTableModel) foodResourceJTable.getModel();

                                FoodResource fres;
                                for (Resource res : map.getValue()) {
                                    if (res.getIsResourceAvailable()) {
                                        fres = (FoodResource) res;
                                        Object[] row = new Object[3];
                                        row[0] = enterprise.getName();
                                        row[1] = fres.getNumberOfFoodPackets();
                                        row[2] = fres;
                                        model.addRow(row);
                                    }
                                }
                                //ResourcesWorkRequest res = (ResourcesWorkRequest) request;

                            }
                        }
                        if (s.contains("Education")) {
                            if (map.getKey().equalsIgnoreCase("Education")) {

                                DefaultTableModel model = (DefaultTableModel) educationResourceJTable.getModel();

                                EducationResource eres;
                                for (Resource res : map.getValue()) {
                                    if (res.getIsResourceAvailable()) {
                                        eres = (EducationResource) res;
                                        Object[] row = new Object[4];
                                        row[0] = enterprise.getName();
                                        row[1] = eres.getNumberOfSupplyMaterial();
                                        row[2] = eres.getNumberOfTeachers();
                                        row[3] = eres;
                                        model.addRow(row);
                                    }
                                }
                                //ResourcesWorkRequest res = (ResourcesWorkRequest) request;
                            }
                        }

                        if (s.contains("Health")) {
                            if (map.getKey().equalsIgnoreCase("Health")) {

                                DefaultTableModel model = (DefaultTableModel) healthResourceJTable.getModel();

                                HealthResource hres;
                                for (Resource res : map.getValue()) {
                                    if (res.getIsResourceAvailable()) {
                                        hres = (HealthResource) res;
                                        Object[] row = new Object[5];
                                        row[0] = enterprise.getName();
                                        row[1] = hres.getMedicineName();
                                        row[2] = hres.getNumberOfPackets();
                                        row[3] = hres.getNumberOfDoctors();
                                        row[4] = hres;
                                        model.addRow(row);
                                    }
                                }
                                //ResourcesWorkRequest res = (ResourcesWorkRequest) request;

                            }
                        }
                        if (s.contains("Money")) {
                            if (map.getKey().equalsIgnoreCase("Money")) {

                                DefaultTableModel model = (DefaultTableModel) moneyResurceJTable.getModel();

                                MoneyResource mres;
                                for (Resource res : map.getValue()) {
                                    if (res.getIsResourceAvailable()) {
                                        mres = (MoneyResource) res;
                                        Object[] row = new Object[3];
                                        row[0] = enterprise.getName();
                                        row[1] = mres.getAmount();
                                        row[2] = mres;
                                        model.addRow(row);
                                    }
                                }
                                //ResourcesWorkRequest res = (ResourcesWorkRequest) request;

                            }
                        }
                    }

                }
            }
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

        numberOfEducationSuppliesTextField = new javax.swing.JTextField();
        numberOfTeacherTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        requestTypeComboField = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        typeOfMedicineTextField = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        requestIdTextField = new javax.swing.JTextField();
        nameOfMedicineTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionTextField = new javax.swing.JTextArea();
        moneyTextField = new javax.swing.JTextField();
        numberOfDoctorTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        quantityOfMedicineTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        numberOfPacketsTestField = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        statusTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodResourceJTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        educationResourceJTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        healthResourceJTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        moneyResurceJTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        matchRequestResouce = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        localityField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        createdDate = new javax.swing.JTextField();
        typeOfResources1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numberOfEducationSuppliesTextField.setEditable(false);
        numberOfEducationSuppliesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfEducationSuppliesTextFieldjTextField2ActionPerformed(evt);
            }
        });
        add(numberOfEducationSuppliesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 284, 131, -1));

        numberOfTeacherTextField.setEditable(false);
        numberOfTeacherTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfTeacherTextFieldjTextField3ActionPerformed(evt);
            }
        });
        add(numberOfTeacherTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 313, 131, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 640, -1, -1));

        requestTypeComboField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Community", "Individual" }));
        add(requestTypeComboField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 155, -1, -1));

        jLabel15.setText("Locality");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 207, -1, -1));

        typeOfMedicineTextField.setEditable(false);
        typeOfMedicineTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeOfMedicineTextFieldjTextField7ActionPerformed(evt);
            }
        });
        add(typeOfMedicineTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 417, 131, -1));

        jLabel27.setText("Type of Medicine required");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 417, -1, -1));

        jLabel26.setText("Quantity");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, -1));

        jLabel24.setText("No of doctors required");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 458, -1, -1));

        requestIdTextField.setEditable(false);
        requestIdTextField.setText(" ");
        add(requestIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 53, 131, -1));

        nameOfMedicineTextField.setEditable(false);
        nameOfMedicineTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameOfMedicineTextFieldjTextField5ActionPerformed(evt);
            }
        });
        add(nameOfMedicineTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 377, 131, -1));

        descriptionTextField.setEditable(false);
        descriptionTextField.setColumns(20);
        descriptionTextField.setRows(5);
        jScrollPane3.setViewportView(descriptionTextField);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 83, 184, 50));

        moneyTextField.setEditable(false);
        moneyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyTextFieldjTextField8ActionPerformed(evt);
            }
        });
        add(moneyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 501, 131, -1));

        numberOfDoctorTextField.setEditable(false);
        numberOfDoctorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfDoctorTextFieldjTextField7ActionPerformed(evt);
            }
        });
        add(numberOfDoctorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 455, 131, -1));

        jLabel25.setText("Money Required in USD ");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 504, -1, -1));

        jLabel20.setText("No of education Supplies");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 287, -1, -1));

        jLabel21.setText("No of teacher required");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 316, -1, -1));

        jLabel22.setText("No of Food packets Req");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 351, -1, -1));

        quantityOfMedicineTextField.setEditable(false);
        quantityOfMedicineTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityOfMedicineTextFieldjTextField6ActionPerformed(evt);
            }
        });
        add(quantityOfMedicineTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 377, 58, -1));

        jLabel23.setText("Name of medicine required");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 377, -1, -1));

        jLabel17.setText("Description");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 139, -1, -1));

        jLabel16.setText("On behalf of ");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 155, -1, -1));

        jLabel14.setText("requestId");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 56, -1, -1));

        numberOfPacketsTestField.setEditable(false);
        numberOfPacketsTestField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPacketsTestFieldjTextField4ActionPerformed(evt);
            }
        });
        add(numberOfPacketsTestField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 348, 131, -1));

        jLabel28.setText("Status");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 544, -1, -1));

        statusTextField.setEditable(false);
        statusTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusTextFieldjTextField8ActionPerformed(evt);
            }
        });
        add(statusTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 541, 131, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Top Matched Resources for this Request");

        foodResourceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Resource Enterprise", "Number Of food Packets", "Type"
            }
        ));
        foodResourceJTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(foodResourceJTable);
        foodResourceJTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel3.setText("Food Resources");

        educationResourceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Resource Enterprise", "Number of Education supplies", "Number of teachers offered", "Type"
            }
        ));
        educationResourceJTable.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(educationResourceJTable);
        educationResourceJTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel4.setText("Education Resources");

        healthResourceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Resource Enterprise", "Medicine Name", "Medicine Quantity", "Number of Doctor", "Type"
            }
        ));
        healthResourceJTable.setColumnSelectionAllowed(true);
        jScrollPane4.setViewportView(healthResourceJTable);
        healthResourceJTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel5.setText("Health Resources");

        moneyResurceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Resource Enterprise", "Number Of food Packets", "Type"
            }
        ));
        moneyResurceJTable.setColumnSelectionAllowed(true);
        jScrollPane5.setViewportView(moneyResurceJTable);
        moneyResurceJTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLabel6.setText("Money Resources");

        matchRequestResouce.setText("Match Selected with Request");
        matchRequestResouce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matchRequestResouceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(matchRequestResouce, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(88, 88, 88)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(matchRequestResouce)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 19, -1, -1));

        jLabel18.setText("Type of Resources Requested");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 247, -1, -1));

        localityField.setEditable(false);
        localityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localityFieldjTextField2ActionPerformed(evt);
            }
        });
        add(localityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 131, -1));

        jLabel2.setText("Request Details");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 19, -1, -1));

        jLabel29.setText("Created Date");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 579, -1, -1));

        createdDate.setEditable(false);
        createdDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createdDatejTextField8ActionPerformed(evt);
            }
        });
        add(createdDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 576, 131, -1));

        typeOfResources1.setEditable(false);
        typeOfResources1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeOfResources1jTextField2ActionPerformed(evt);
            }
        });
        add(typeOfResources1, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 244, 131, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void numberOfEducationSuppliesTextFieldjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfEducationSuppliesTextFieldjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfEducationSuppliesTextFieldjTextField2ActionPerformed

    private void numberOfTeacherTextFieldjTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfTeacherTextFieldjTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfTeacherTextFieldjTextField3ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void typeOfMedicineTextFieldjTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeOfMedicineTextFieldjTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeOfMedicineTextFieldjTextField7ActionPerformed

    private void nameOfMedicineTextFieldjTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameOfMedicineTextFieldjTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameOfMedicineTextFieldjTextField5ActionPerformed

    private void moneyTextFieldjTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyTextFieldjTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyTextFieldjTextField8ActionPerformed

    private void numberOfDoctorTextFieldjTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfDoctorTextFieldjTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfDoctorTextFieldjTextField7ActionPerformed

    private void quantityOfMedicineTextFieldjTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityOfMedicineTextFieldjTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityOfMedicineTextFieldjTextField6ActionPerformed

    private void numberOfPacketsTestFieldjTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfPacketsTestFieldjTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfPacketsTestFieldjTextField4ActionPerformed

    private void statusTextFieldjTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusTextFieldjTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusTextFieldjTextField8ActionPerformed

    private void localityFieldjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localityFieldjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localityFieldjTextField2ActionPerformed

    private void matchRequestResouceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matchRequestResouceActionPerformed
        int selectedRowFood;
        if (s.contains("Food")) {
            if (foodResourceJTable.getRowCount() != 0) {
            selectedRowFood = foodResourceJTable.getSelectedRow();
            
                FoodResource resource = (FoodResource) foodResourceJTable.getValueAt(selectedRowFood, 2);
                resource.setIsResourceAvailable(Boolean.FALSE);
                request.getResourcesUtillized().add(resource);
                request.getResourcesPendingMap().put("Food", request.getResourcesPendingMap().get("Food") - resource.getNumberOfFoodPackets());
            }
        }

        int selectedRowEducation;
        if (educationResourceJTable.getRowCount() != 0) {
        if (s.contains("Education")) {
            selectedRowEducation = educationResourceJTable.getSelectedRow();

            EducationResource resource = (EducationResource) educationResourceJTable.getValueAt(selectedRowEducation, 3);
            resource.setIsResourceAvailable(Boolean.FALSE);
            request.getResourcesUtillized().add(resource);
            request.getResourcesPendingMap().put("Education", request.getResourcesPendingMap().get("Education") - resource.getNumberOfSupplyMaterial());
        }
        }
        int selectedRowHealth;
        if (healthResourceJTable.getRowCount() != 0) {
        if (s.contains("Health")) {
            selectedRowHealth = healthResourceJTable.getSelectedRow();

            HealthResource resource = (HealthResource) healthResourceJTable.getValueAt(selectedRowHealth, 4);
            resource.setIsResourceAvailable(Boolean.FALSE);
            request.getResourcesUtillized().add(resource);
            request.getResourcesPendingMap().put("Health", request.getResourcesPendingMap().get("Health") - resource.getNumberOfPackets());

        }
        }
        int selectedRowMoney;
        if (moneyResurceJTable.getRowCount() != 0) {
        if (s.contains("Money")) {
            selectedRowMoney = moneyResurceJTable.getSelectedRow();

            MoneyResource resource = (MoneyResource) moneyResurceJTable.getValueAt(selectedRowMoney, 2);
            resource.setIsResourceAvailable(Boolean.FALSE);
            request.getResourcesUtillized().add(resource);
            request.getResourcesPendingMap().put("Money", request.getResourcesPendingMap().get("Money") - resource.getAmount());

        }
        }
        if (request.getResourcesPendingMap().get("Food") + request.getResourcesPendingMap().get("Education") + request.getResourcesPendingMap().get("Money") + request.getResourcesPendingMap().get("Health") > 0) {
            request.setStatus("Partially Completed");
        } else {
            request.setStatus("Completed");
        }
        JOptionPane.showMessageDialog(null, "Resources selected matched with request. !");

    //        ResourcesWorkRequest request = (ResourcesWorkRequest) workRequestJTable.getValueAt(selectedRow, 1);

    }//GEN-LAST:event_matchRequestResouceActionPerformed

    private void createdDatejTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createdDatejTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createdDatejTextField8ActionPerformed

    private void typeOfResources1jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeOfResources1jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeOfResources1jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField createdDate;
    private javax.swing.JTextArea descriptionTextField;
    private javax.swing.JTable educationResourceJTable;
    private javax.swing.JTable foodResourceJTable;
    private javax.swing.JTable healthResourceJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField localityField;
    private javax.swing.JButton matchRequestResouce;
    private javax.swing.JTable moneyResurceJTable;
    private javax.swing.JTextField moneyTextField;
    private javax.swing.JTextField nameOfMedicineTextField;
    private javax.swing.JTextField numberOfDoctorTextField;
    private javax.swing.JTextField numberOfEducationSuppliesTextField;
    private javax.swing.JTextField numberOfPacketsTestField;
    private javax.swing.JTextField numberOfTeacherTextField;
    private javax.swing.JTextField quantityOfMedicineTextField;
    private javax.swing.JTextField requestIdTextField;
    private javax.swing.JComboBox requestTypeComboField;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JTextField typeOfMedicineTextField;
    private javax.swing.JTextField typeOfResources1;
    // End of variables declaration//GEN-END:variables

}
