package userinterface.AdministrativeRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.NGOEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.WorkQueue.CSRActivityWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import userinterface.MainPanel;

/**
 *
 * @author raunak
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {

    int foodCount = 0;
    int moneyCount = 0;
    int HealthCount = 0;
    JPanel userProcessContainer;
    Enterprise enterprise;
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    public AdminWorkAreaJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        if (enterprise.getEnterpriseType().equals(NGOEnterprise.EnterpriseType.NGO)) {
            ngoFunctionLabel.setText("Start a Fund Raiser");
            windowLabel.setText("NGO WORK AREA");
        }
        populateCorporate();
//valueLabel.setText(enterprise.getName());
    }
    
    public void populateCorporate() {        
        try {
            
            final String raised = "Request Raised";
            final String pending = "Request Pending";
            final String completed = "Request Completed";
            final String speed = "Raised";
            final String popular = "Pending";
            
            final String userrating = "Completed";
            
            final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            VolunteerOrganization vorg;
            int active = 0;
            int completedcount = 0;
            int csrrequestraisedCount = 0;
            for (Network network : system.getNetworkList()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                        if (org instanceof VolunteerOrganization) {
                            vorg = (VolunteerOrganization) org;
                            for (WorkRequest request : vorg.getWorkQueue().getWorkRequestList()) {
                                if (request instanceof CSRActivityWorkRequest) {
                                    csrrequestraisedCount++;
                                    if (request.getStatus().equalsIgnoreCase("pending")) {
                                        active++;
                                    }
                                    if (request.getStatus().equalsIgnoreCase("completed")) {
                                        completedcount++;
                                    }                                    
                                }
                            }
                            
                        }
                    }
                }
            }
            
            if (!(csrrequestraisedCount == 0)) {
                dataset.addValue(csrrequestraisedCount, raised, raised);
                dataset.addValue(active, pending, popular);
                dataset.addValue(completedcount, completed, userrating);
            } else {
                dataset.addValue(1, raised, raised);
                dataset.addValue(1, pending, popular);
                dataset.addValue(0, completed, userrating);
            }
            
            JFreeChart barChart = ChartFactory.createBarChart3D(
                    "CSR Resource Status",
                    "Status",
                    "",
                    dataset,
                    PlotOrientation.VERTICAL,
                    true, true, false);
            
            int width = 640; /* Width of the image */

            int height = 480; /* Height of the image */

            File barChart3D = new File("barChart3D.jpeg");
            ChartUtilities.saveChartAsJPEG(barChart3D, barChart, width, height);
            ChartPanel cpanel = new ChartPanel(barChart);
            cpanel.setSize(500, 500);            
            cpanel.setVisible(true);
            jPanel2.add(cpanel);
        } catch (IOException ex) {
            Logger.getLogger(AdminWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonDashboard = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        raiseCSRRequestButton = new javax.swing.JPanel();
        ngoFunctionLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        manageUserAccount = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        manageResourceButton = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        viewRequestsButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        manageEmployeeButton = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        manageReport = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        logoutJButton = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        viewResourceRequestsButton = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        windowLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 752, 72, -1));

        jPanel4.setBackground(new java.awt.Color(22, 16, 16));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(102, 102, 102));
        jLabel26.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setText("Helping");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 13, 170, 70));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Hands");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 13, 140, 70));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 430, 13));

        buttonDashboard.setBackground(new java.awt.Color(204, 204, 204));
        buttonDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDashboardMouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Dashboard");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pen-tablet.png"))); // NOI18N

        javax.swing.GroupLayout buttonDashboardLayout = new javax.swing.GroupLayout(buttonDashboard);
        buttonDashboard.setLayout(buttonDashboardLayout);
        buttonDashboardLayout.setHorizontalGroup(
            buttonDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonDashboardLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
        );
        buttonDashboardLayout.setVerticalGroup(
            buttonDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonDashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(36, 36, 36))
            .addGroup(buttonDashboardLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.add(buttonDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 116, 430, 55));

        raiseCSRRequestButton.setBackground(new java.awt.Color(22, 16, 16));
        raiseCSRRequestButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                raiseCSRRequestButtonMouseClicked(evt);
            }
        });
        raiseCSRRequestButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ngoFunctionLabel.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        ngoFunctionLabel.setForeground(new java.awt.Color(204, 204, 204));
        ngoFunctionLabel.setText("Raise CSR Request");
        raiseCSRRequestButton.add(ngoFunctionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));
        raiseCSRRequestButton.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 0, -1, 38));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coin-stack-1.png"))); // NOI18N
        raiseCSRRequestButton.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 30));

        jPanel4.add(raiseCSRRequestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 173, 430, 56));

        manageUserAccount.setBackground(new java.awt.Color(22, 16, 16));
        manageUserAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageUserAccountMouseClicked(evt);
            }
        });
        manageUserAccount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Manage User Account");
        manageUserAccount.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 22, -1, -1));
        manageUserAccount.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 0, -1, 90));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/id-card-1.png"))); // NOI18N
        manageUserAccount.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 30));

        jPanel4.add(manageUserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 303, 430, 61));

        manageResourceButton.setBackground(new java.awt.Color(22, 16, 16));
        manageResourceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageResourceButtonMouseClicked(evt);
            }
        });
        manageResourceButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Manage Resource ");
        manageResourceButton.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));
        manageResourceButton.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, 90));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user-add.png"))); // NOI18N
        manageResourceButton.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 30));

        jPanel4.add(manageResourceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 366, 430, 64));

        viewRequestsButton.setBackground(new java.awt.Color(22, 16, 16));
        viewRequestsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewRequestsButtonMouseClicked(evt);
            }
        });
        viewRequestsButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("View open request");
        viewRequestsButton.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/email-outbox.png"))); // NOI18N
        viewRequestsButton.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 30));

        jPanel4.add(viewRequestsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 437, 430, 63));

        manageEmployeeButton.setBackground(new java.awt.Color(22, 16, 16));
        manageEmployeeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageEmployeeButtonMouseClicked(evt);
            }
        });
        manageEmployeeButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Manage Organization and Employee");
        manageEmployeeButton.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));
        manageEmployeeButton.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, 90));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/building-6.png"))); // NOI18N
        manageEmployeeButton.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 30));

        jPanel4.add(manageEmployeeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 236, 430, 60));

        manageReport.setBackground(new java.awt.Color(22, 16, 16));
        manageReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageReportMouseClicked(evt);
            }
        });
        manageReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Manage Reports");
        manageReport.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/file-notes-document.png"))); // NOI18N
        manageReport.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 30));

        jPanel4.add(manageReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 507, 430, 63));

        logoutJButton.setBackground(new java.awt.Color(22, 16, 16));
        logoutJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutJButtonMouseClicked(evt);
            }
        });
        logoutJButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Logout");
        logoutJButton.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 199, -1));
        logoutJButton.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 23, 39, -1));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lock-unlock-1.png"))); // NOI18N
        logoutJButton.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 30));

        jPanel4.add(logoutJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 647, 430, -1));

        viewResourceRequestsButton.setBackground(new java.awt.Color(22, 16, 16));
        viewResourceRequestsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewResourceRequestsButtonMouseClicked(evt);
            }
        });
        viewResourceRequestsButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("View Resource requests");
        viewResourceRequestsButton.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/email-outbox.png"))); // NOI18N
        viewResourceRequestsButton.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 40, 30));

        jPanel4.add(viewResourceRequestsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 577, 406, 63));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 990));

        windowLabel.setBackground(new java.awt.Color(22, 16, 16));
        windowLabel.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        windowLabel.setForeground(new java.awt.Color(22, 16, 16));
        windowLabel.setText("CORPORATE WORK AREA");
        jPanel1.add(windowLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 500, 70));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 2320, 13));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 13, -1, -1));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel21.setText("a corporate social responsiblity request");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 320, -1));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel23.setText("Click on \"Raise CSR request\"  to raise ");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 320, 26));

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel28.setText("Click on \"Manage user account\"  to view and");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 340, 30));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel29.setText("  and update the user information.");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 320, 20));
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 130, -1, 100));

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel31.setText("Click on \"Manage organization and employee\" ");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 350, 26));

        jLabel32.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel32.setText(" to add organization or employee");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 320, -1));

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel34.setText("Click on \"Manage resource\"  to manage");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, 320, 26));

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel35.setText("the resource of corporate");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 320, -1));

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel41.setText("Click on \"Manage user account\"  to view and");
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 340, 30));

        jLabel42.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel42.setText("  and update the user information.");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, 320, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-admin-settings-male-24.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 40, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-coins-filled-50.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 60, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-plus-filled-50.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 60, 50));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-unicast-filled-50.png"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 60, 50));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-user-groups-filled-50.png"))); // NOI18N
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 60, 50));

        jLabel44.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel44.setText("Click on \"Manage Reports\"  to view and");
        jPanel3.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 150, 340, 30));

        jLabel45.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel45.setText("  and update the user information.");
        jPanel3.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 180, 320, 20));
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 150, 60, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 740, 2290, 250));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 500, 500));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2440, 1010));
    }// </editor-fold>//GEN-END:initComponents

    private void raiseCSRRequestButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raiseCSRRequestButtonMouseClicked
        if (enterprise.getEnterpriseType().equals(NGOEnterprise.EnterpriseType.NGO)) {
            StartFundRaiser startFundRaiser = new StartFundRaiser(userProcessContainer, enterprise, system);
            userProcessContainer.add("startFundRaiser", startFundRaiser);
            
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            RaiseCSRActivityJPanel raiseCsrActivityJPanel = new RaiseCSRActivityJPanel(userProcessContainer, enterprise, system);
            userProcessContainer.add("raiseCsrActivityJPanel", raiseCsrActivityJPanel);
            
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_raiseCSRRequestButtonMouseClicked

    private void manageEmployeeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageEmployeeButtonMouseClicked
        ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageEmployeeButtonMouseClicked

    private void manageResourceButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageResourceButtonMouseClicked
        ManageResourcesJPanel manageResourcesJPanel = new ManageResourcesJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("manageResourcesJPanel", manageResourcesJPanel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageResourceButtonMouseClicked

    private void manageUserAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageUserAccountMouseClicked
        ManageUserAccountJPanel manageUserAccountJPanel = new ManageUserAccountJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("manageUserAccountJPanel", manageUserAccountJPanel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageUserAccountMouseClicked

	private void manageReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageReportActionPerformed
            // TODO add your handling code here:
            ManageReports report = new ManageReports(userProcessContainer, enterprise, system);
            userProcessContainer.add("ManageReports", report);
            
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
    }//GEN-LAST:event_manageReportActionPerformed

    private void buttonDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDashboardMouseClicked
        AdminWorkAreaJPanel systemAdminWorkAreaJPanel = new AdminWorkAreaJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("systemAdminWorkAreaJPanel", systemAdminWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_buttonDashboardMouseClicked

    private void viewRequestsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewRequestsButtonMouseClicked
        if (enterprise.getEnterpriseType().equals(NGOEnterprise.EnterpriseType.NGO)) {
            ViewFundRaiserRequestsJPanel viewRequestsJPanel = new ViewFundRaiserRequestsJPanel(userProcessContainer, enterprise, system);
            userProcessContainer.add("viewRequestsJPanel", viewRequestsJPanel);
            
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            ViewCSRRequestsJPanel viewRequestsJPanel = new ViewCSRRequestsJPanel(userProcessContainer, enterprise, system);
            userProcessContainer.add("viewRequestsJPanel", viewRequestsJPanel);
            
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_viewRequestsButtonMouseClicked

    private void manageReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageReportMouseClicked
        // TODO add your handling code here:
        ManageReports manageReports = new ManageReports(userProcessContainer, enterprise, system);
        userProcessContainer.add("manageReports", manageReports);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_manageReportMouseClicked

    private void logoutJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutJButtonMouseClicked
        userProcessContainer.removeAll();
        dB4OUtil.storeSystem(system);
        MainPanel mainJPanel = new MainPanel();
        userProcessContainer.add("mainJPanel", mainJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        

    }//GEN-LAST:event_logoutJButtonMouseClicked

    private void viewResourceRequestsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewResourceRequestsButtonMouseClicked
        
        ViewOpenResourceRequestsJPanel viewOpenResourceRequestsJPanel = new ViewOpenResourceRequestsJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("viewOpenResourceRequestsJPanel", viewOpenResourceRequestsJPanel);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewResourceRequestsButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonDashboard;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel logoutJButton;
    private javax.swing.JPanel manageEmployeeButton;
    private javax.swing.JPanel manageReport;
    private javax.swing.JPanel manageResourceButton;
    private javax.swing.JPanel manageUserAccount;
    private javax.swing.JLabel ngoFunctionLabel;
    private javax.swing.JPanel raiseCSRRequestButton;
    private javax.swing.JPanel viewRequestsButton;
    private javax.swing.JPanel viewResourceRequestsButton;
    private javax.swing.JLabel windowLabel;
    // End of variables declaration//GEN-END:variables

}
