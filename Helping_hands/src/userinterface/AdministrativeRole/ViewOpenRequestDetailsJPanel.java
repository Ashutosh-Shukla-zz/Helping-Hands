/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import userinterface.SystemAdminWorkArea.*;
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
import java.util.Date;

/**
 *
 * @author shukl
 */
public class ViewOpenRequestDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewRequestDetailsJPanel
     */
    private JPanel userProcessContainer;
    private ResourcesWorkRequest request;
    private EcoSystem system;
    private Enterprise enterprise;
    private List<String> s;

    public ViewOpenRequestDetailsJPanel(JPanel userProcessContainer, ResourcesWorkRequest request, EcoSystem system, Enterprise enterprise) {
        initComponents();
        this.request = request;
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        s = new ArrayList<String>();
        numberOfPacketsTestField1.setEditable(false);
        numberOfPacketsTestField1.setEnabled(false);
        moneyTextField1.setEditable(false);
        moneyTextField1.setEnabled(false);
        nameOfMedicineTextField1.setEditable(false);
        nameOfMedicineTextField1.setEnabled(false);
        typeOfMedicineTextField1.setEditable(false);
        typeOfMedicineTextField1.setEnabled(false);
        quantityOfMedicineTextField1.setEditable(false);
        quantityOfMedicineTextField1.setEnabled(false);
        numberOfDoctorTextField1.setEditable(false);
        numberOfDoctorTextField1.setEnabled(false);
        numberOfEducationSuppliesTextField1.setEditable(false);
        numberOfEducationSuppliesTextField1.setEnabled(false);
        numberOfTeacherTextField1.setEditable(false);
        numberOfTeacherTextField1.setEnabled(false);

        boolean isFood = false;
        boolean isHealth = false;
        boolean isEdu = false;
        boolean isMon = false;
        for (Resource reqRes : request.getResourceRequested()) {
            if (reqRes.getName().equalsIgnoreCase("Food")) {
                isFood = true;
            }
            if (reqRes.getName().equalsIgnoreCase("Education")) {
                isEdu = true;
            }
            if (reqRes.getName().equalsIgnoreCase("Health")) {
                isHealth = true;
            }
            if (reqRes.getName().equalsIgnoreCase("Money")) {
                isMon = true;
            }

        }

        for (String s : enterprise.getResourcesOffered().keySet()) {

            if (s.equalsIgnoreCase("Food") && isFood) {
                numberOfPacketsTestField1.setEditable(true);
                numberOfPacketsTestField1.setEnabled(true);
            }
            if (s.equalsIgnoreCase("Education") && isEdu) {
                numberOfEducationSuppliesTextField1.setEditable(true);
                numberOfEducationSuppliesTextField1.setEnabled(true);
                numberOfTeacherTextField1.setEditable(true);
                numberOfTeacherTextField1.setEnabled(true);
            }
            if (s.equalsIgnoreCase("Health") && isHealth) {
                nameOfMedicineTextField1.setEditable(true);
                nameOfMedicineTextField1.setEnabled(true);
                typeOfMedicineTextField1.setEditable(true);
                typeOfMedicineTextField1.setEnabled(true);
                quantityOfMedicineTextField1.setEditable(true);
                quantityOfMedicineTextField1.setEnabled(true);
                numberOfDoctorTextField1.setEditable(true);
                numberOfDoctorTextField1.setEnabled(true);
            }
            if (s.equalsIgnoreCase("Money") && isMon) {
                moneyTextField1.setEditable(true);
                moneyTextField1.setEnabled(true);
            }
        }

        for (Map.Entry<String, Integer> map : request.getResourcesPendingMap().entrySet()) {
            if (map.getKey().equalsIgnoreCase("Food")) {
                if (map.getValue() < 0) {
                    numberOfPacketsTestField1.setEditable(false);
                    numberOfPacketsTestField1.setEnabled(false);
                }
            }
            if (map.getKey().equalsIgnoreCase("Education")) {

                if (map.getValue() < 0) {
                    numberOfEducationSuppliesTextField1.setEditable(false);
                    numberOfEducationSuppliesTextField1.setEnabled(false);
                    numberOfTeacherTextField1.setEditable(false);
                    numberOfTeacherTextField1.setEnabled(false);
                }
            }
            if (map.getKey().equalsIgnoreCase("Health")) {
                if (map.getValue() < 0) {
                    nameOfMedicineTextField1.setEditable(false);
                    nameOfMedicineTextField1.setEnabled(false);
                    typeOfMedicineTextField1.setEditable(false);
                    typeOfMedicineTextField1.setEnabled(false);
                    quantityOfMedicineTextField1.setEditable(false);
                    quantityOfMedicineTextField1.setEnabled(false);
                    numberOfDoctorTextField1.setEditable(false);
                    numberOfDoctorTextField1.setEnabled(false);
                }
            }
            if (map.getKey().equalsIgnoreCase("Money")) {
                if (map.getValue() < 0) {
                    moneyTextField1.setEditable(false);
                    moneyTextField1.setEnabled(false);
                }
            }

        }

        populateRequestData();
    }

    public void populateRequestData() {
        requestIdTextField.setText(String.valueOf(request.getRequsetId()));
        descriptionTextField.setText(request.getRequestDescription());
        requestTypeComboField.setSelectedItem(request.getMessage());
        localityComboField.setText(request.getNetwork());
        requestTypeComboField.setSelectedItem(request.getMessage());
        statusTextField.setText(request.getStatus());
        createdDate.setText(UtitlityMethods.getStringFromDate(request.getRequestDate()));
        for (Resource resource : request.getResourceRequested()) {

            s.add(resource.getName());
        }
        for (String s : s) {
            typeOfResources1.setText(typeOfResources1.getText() + s);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addResourcesForRequests = new javax.swing.JButton();
        numberOfPacketsTestField1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        numberOfEducationSuppliesTextField1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        nameOfMedicineTextField1 = new javax.swing.JTextField();
        quantityOfMedicineTextField1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        typeOfMedicineTextField1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        moneyTextField1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        numberOfDoctorTextField1 = new javax.swing.JTextField();
        numberOfTeacherTextField1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        localityComboField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        createdDate = new javax.swing.JTextField();
        typeOfResources1 = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numberOfEducationSuppliesTextField.setEditable(false);
        numberOfEducationSuppliesTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfEducationSuppliesTextFieldjTextField2ActionPerformed(evt);
            }
        });
        add(numberOfEducationSuppliesTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 264, 131, -1));

        numberOfTeacherTextField.setEditable(false);
        numberOfTeacherTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfTeacherTextFieldjTextField3ActionPerformed(evt);
            }
        });
        add(numberOfTeacherTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 290, 131, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 595, -1, -1));

        requestTypeComboField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Community", "Individual" }));
        add(requestTypeComboField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 141, -1, -1));

        jLabel15.setText("Locality");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 191, -1, -1));

        typeOfMedicineTextField.setEditable(false);
        typeOfMedicineTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeOfMedicineTextFieldjTextField7ActionPerformed(evt);
            }
        });
        add(typeOfMedicineTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 385, 131, -1));

        jLabel27.setText("Type of Medicine required");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 385, -1, -1));

        jLabel26.setText("Quantity");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 350, -1, -1));

        jLabel24.setText("No of doctors required");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 424, -1, -1));

        requestIdTextField.setEditable(false);
        requestIdTextField.setText(" ");
        add(requestIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 43, 131, -1));

        nameOfMedicineTextField.setEditable(false);
        nameOfMedicineTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameOfMedicineTextFieldjTextField5ActionPerformed(evt);
            }
        });
        add(nameOfMedicineTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 347, 131, -1));

        descriptionTextField.setEditable(false);
        descriptionTextField.setColumns(20);
        descriptionTextField.setRows(5);
        jScrollPane3.setViewportView(descriptionTextField);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 69, 184, 50));

        moneyTextField.setEditable(false);
        moneyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyTextFieldjTextField8ActionPerformed(evt);
            }
        });
        add(moneyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 465, 131, -1));

        numberOfDoctorTextField.setEditable(false);
        numberOfDoctorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfDoctorTextFieldjTextField7ActionPerformed(evt);
            }
        });
        add(numberOfDoctorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 421, 131, -1));

        jLabel25.setText("Money Required in USD ");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 468, -1, -1));

        jLabel20.setText("No of education Supplies");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 267, -1, -1));

        jLabel21.setText("No of teacher required");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 293, -1, -1));

        jLabel22.setText("No of Food packets Req");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 324, -1, -1));

        quantityOfMedicineTextField.setEditable(false);
        quantityOfMedicineTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityOfMedicineTextFieldjTextField6ActionPerformed(evt);
            }
        });
        add(quantityOfMedicineTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 347, 58, -1));

        jLabel23.setText("Name of medicine required");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 347, -1, -1));

        jLabel17.setText("Description");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 127, -1, -1));

        jLabel16.setText("On behalf of ");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 141, -1, -1));

        jLabel14.setText("requestId");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 46, -1, -1));

        numberOfPacketsTestField.setEditable(false);
        numberOfPacketsTestField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPacketsTestFieldjTextField4ActionPerformed(evt);
            }
        });
        add(numberOfPacketsTestField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 321, 131, -1));

        jLabel28.setText("Status");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 506, -1, -1));

        statusTextField.setEditable(false);
        statusTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusTextFieldjTextField8ActionPerformed(evt);
            }
        });
        add(statusTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 503, 131, -1));

        jLabel1.setText("Add resources for this Request");

        jLabel3.setText("Food Resources");

        jLabel4.setText("Education Resources");

        jLabel5.setText("Health Resources");

        jLabel6.setText("Money Resources");

        addResourcesForRequests.setText("Add Resources");
        addResourcesForRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addResourcesForRequestsActionPerformed(evt);
            }
        });

        numberOfPacketsTestField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfPacketsTestField1jTextField4ActionPerformed(evt);
            }
        });

        jLabel30.setText("No of Food packets Req");

        jLabel31.setText("No of education Supplies");

        numberOfEducationSuppliesTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfEducationSuppliesTextField1jTextField2ActionPerformed(evt);
            }
        });

        jLabel33.setText("Name of medicine required");

        nameOfMedicineTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameOfMedicineTextField1jTextField5ActionPerformed(evt);
            }
        });

        quantityOfMedicineTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityOfMedicineTextField1jTextField6ActionPerformed(evt);
            }
        });

        jLabel34.setText("Type of Medicine required");

        typeOfMedicineTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeOfMedicineTextField1jTextField7ActionPerformed(evt);
            }
        });

        jLabel36.setText("Money Required in USD ");

        moneyTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyTextField1jTextField8ActionPerformed(evt);
            }
        });

        jLabel37.setText("Quantity");

        jLabel32.setText("No of doctors required");

        numberOfDoctorTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfDoctorTextField1jTextField7ActionPerformed(evt);
            }
        });

        numberOfTeacherTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfTeacherTextField1jTextField3ActionPerformed(evt);
            }
        });

        jLabel35.setText("No of teacher required");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(numberOfTeacherTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(addResourcesForRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel31)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(numberOfEducationSuppliesTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(21, 21, 21)
                        .addComponent(moneyTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(numberOfPacketsTestField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel32))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberOfDoctorTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nameOfMedicineTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel37)
                                .addGap(18, 18, 18)
                                .addComponent(quantityOfMedicineTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(typeOfMedicineTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(numberOfPacketsTestField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(numberOfEducationSuppliesTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(numberOfTeacherTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameOfMedicineTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantityOfMedicineTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel37))
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeOfMedicineTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(numberOfDoctorTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(moneyTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(addResourcesForRequests)
                .addGap(27, 27, 27))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 11, -1, -1));

        jLabel18.setText("Type of Resources Requested");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 229, -1, -1));

        localityComboField.setEditable(false);
        localityComboField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localityComboFieldjTextField2ActionPerformed(evt);
            }
        });
        add(localityComboField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 131, -1));

        jLabel2.setText("Request Details");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 11, -1, -1));

        jLabel29.setText("Created Date");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 537, -1, -1));

        createdDate.setEditable(false);
        createdDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createdDatejTextField8ActionPerformed(evt);
            }
        });
        add(createdDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 534, 131, -1));

        typeOfResources1.setEditable(false);
        typeOfResources1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeOfResources1jTextField2ActionPerformed(evt);
            }
        });
        add(typeOfResources1, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 226, 131, -1));
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

    private void localityComboFieldjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localityComboFieldjTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localityComboFieldjTextField2ActionPerformed

    private void addResourcesForRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addResourcesForRequestsActionPerformed

        if (numberOfPacketsTestField1.isEnabled()) {
            FoodResource resource = new FoodResource(Integer.parseInt(numberOfPacketsTestField1.getText()), "Food", EcoSystem.counter++);
            resource.setIsResourceAvailable(Boolean.FALSE);
            resource.setExpiryDate(new Date());
            request.getResourcesUtillized().add(resource);
            request.getResourcesPendingMap().put("Food", request.getResourcesPendingMap().get("Food") - Integer.parseInt(numberOfPacketsTestField1.getText()));
            enterprise.getResourcesOffered().get("Food").add(resource);
        }

        if (numberOfEducationSuppliesTextField1.isEnabled()) {
            EducationResource resource = new EducationResource(Integer.parseInt(numberOfEducationSuppliesTextField1.getText()), Integer.parseInt(numberOfTeacherTextField1.getText()), "Education", EcoSystem.counter++);
            resource.setIsResourceAvailable(Boolean.FALSE);
            resource.setExpiryDate(new Date());
            request.getResourcesUtillized().add(resource);
            request.getResourcesPendingMap().put("Education", request.getResourcesPendingMap().get("Education") - Integer.parseInt(numberOfEducationSuppliesTextField1.getText()));
            enterprise.getResourcesOffered().get("Education").add(resource);
        }

        if (quantityOfMedicineTextField1.isEnabled()) {
            HealthResource resource = new HealthResource(nameOfMedicineTextField1.getText(), typeOfMedicineTextField1.getText(), Integer.parseInt(quantityOfMedicineTextField1.getText()), Integer.parseInt(numberOfDoctorTextField1.getText()), "Health", EcoSystem.counter++);
            resource.setIsResourceAvailable(Boolean.FALSE);
            resource.setExpiryDate(new Date());
            request.getResourcesUtillized().add(resource);
            request.getResourcesPendingMap().put("Health", request.getResourcesPendingMap().get("Health") - Integer.parseInt(quantityOfMedicineTextField1.getText()));
            enterprise.getResourcesOffered().get("Health").add(resource);

        }

        if (moneyTextField1.isEnabled()) {
            MoneyResource resource = new MoneyResource(Integer.parseInt(moneyTextField1.getText()), "USD", "Money", EcoSystem.counter++);
            resource.setIsResourceAvailable(Boolean.FALSE);
            resource.setExpiryDate(new Date());
            request.getResourcesUtillized().add(resource);
            request.getResourcesPendingMap().put("Money", request.getResourcesPendingMap().get("Money") - Integer.parseInt(moneyTextField1.getText()));
            enterprise.getResourcesOffered().get("Money").add(resource);

        }

        if (request.getResourcesPendingMap().get("Food") + request.getResourcesPendingMap().get("Education") + request.getResourcesPendingMap().get("Money") + request.getResourcesPendingMap().get("Health") > 0) {
            request.setStatus("Partially Completed");
        } else {
            request.setStatus("Completed");
        }

        JOptionPane.showMessageDialog(null, "Added Resources Successfully");
        backJButtonActionPerformed(null);
    }//GEN-LAST:event_addResourcesForRequestsActionPerformed

    private void createdDatejTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createdDatejTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createdDatejTextField8ActionPerformed

    private void numberOfPacketsTestField1jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfPacketsTestField1jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfPacketsTestField1jTextField4ActionPerformed

    private void numberOfEducationSuppliesTextField1jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfEducationSuppliesTextField1jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfEducationSuppliesTextField1jTextField2ActionPerformed

    private void nameOfMedicineTextField1jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameOfMedicineTextField1jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameOfMedicineTextField1jTextField5ActionPerformed

    private void quantityOfMedicineTextField1jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityOfMedicineTextField1jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityOfMedicineTextField1jTextField6ActionPerformed

    private void typeOfMedicineTextField1jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeOfMedicineTextField1jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeOfMedicineTextField1jTextField7ActionPerformed

    private void moneyTextField1jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyTextField1jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyTextField1jTextField8ActionPerformed

    private void numberOfDoctorTextField1jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfDoctorTextField1jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfDoctorTextField1jTextField7ActionPerformed

    private void numberOfTeacherTextField1jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfTeacherTextField1jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfTeacherTextField1jTextField3ActionPerformed

    private void typeOfResources1jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeOfResources1jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeOfResources1jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addResourcesForRequests;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField createdDate;
    private javax.swing.JTextArea descriptionTextField;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField localityComboField;
    private javax.swing.JTextField moneyTextField;
    private javax.swing.JTextField moneyTextField1;
    private javax.swing.JTextField nameOfMedicineTextField;
    private javax.swing.JTextField nameOfMedicineTextField1;
    private javax.swing.JTextField numberOfDoctorTextField;
    private javax.swing.JTextField numberOfDoctorTextField1;
    private javax.swing.JTextField numberOfEducationSuppliesTextField;
    private javax.swing.JTextField numberOfEducationSuppliesTextField1;
    private javax.swing.JTextField numberOfPacketsTestField;
    private javax.swing.JTextField numberOfPacketsTestField1;
    private javax.swing.JTextField numberOfTeacherTextField;
    private javax.swing.JTextField numberOfTeacherTextField1;
    private javax.swing.JTextField quantityOfMedicineTextField;
    private javax.swing.JTextField quantityOfMedicineTextField1;
    private javax.swing.JTextField requestIdTextField;
    private javax.swing.JComboBox requestTypeComboField;
    private javax.swing.JTextField statusTextField;
    private javax.swing.JTextField typeOfMedicineTextField;
    private javax.swing.JTextField typeOfMedicineTextField1;
    private javax.swing.JTextField typeOfResources1;
    // End of variables declaration//GEN-END:variables

}
