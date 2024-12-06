/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.GradSchoolOrganization;
import Business.Organization.Organization;
import Business.Organization.PermHousingOrganization;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.Student.StudentDirectory;
import Business.WorkQueue.GradSchoolRequest;
import Business.WorkQueue.PhysicalHealthCareRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Shreyas
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    
    JPanel userProcessContainer;
    private FileWriter writer;
    private File file;
    EcoSystem ecosystem;
    StudentDirectory vd;
    UserAccountDirectory user_Dir;
    

    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem ecosystem, StudentDirectory vd, UserAccountDirectory user_Dir) throws IOException {
       
        initComponents();
        
        
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        this.user_Dir = user_Dir;
        this.vd = vd;
        
        
        
        String f = "img/ez_logo.png";
        ImageIcon ficon = new ImageIcon(f.toString());
        Image fimage = ficon.getImage();
        Image fimagescaling = fimage.getScaledInstance(300, 75, Image.SCALE_SMOOTH);
        ImageIcon scaled = new ImageIcon(fimagescaling);
        populateTree();
        genFile();
        genMedicalFile();
        getEduFile();
        
    }

    public void populateTree() {
        
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        ArrayList<Network> networkList = ecosystem.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;

        Network network;
        Enterprise enterprise;
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);

        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;

        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();
            
            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                
                
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(i);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }
    
    
    public void getEduFile() throws IOException {

        String USER_HEADER = "Sender,receiver,requestDate,resolveDate,status,desUni,desProgram,bachGrade,hsGrade,bachProg";
        String LINE_BREAK = "\n";
        String USER_CAT_PATH = "csv/gradStats.csv";

        file = new File(USER_CAT_PATH);
        if (file.exists()) {
            file.delete();
        }

        file.createNewFile();
        System.out.println("New Edu File Created");
        writer = new FileWriter(file);

        writer.append(USER_HEADER);
        writer.append(LINE_BREAK);

        for (Network network
                : ecosystem.getNetworkList()) {
            
            //Step 2.a: check against each enterprise
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {

                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                        
                        if (request instanceof GradSchoolRequest) 
                        {        
                        String column = request.getSender() + "," + request.getReceiver() + "," + request.getRequestDate() + "," + request.getResolveDate() + "," + request.getStatus() + "," +  ((GradSchoolRequest) request).getDesUni() + "," + ((GradSchoolRequest) request).getDesProgram() + "," + ((GradSchoolRequest) request).getBachGrade() + "," + ((GradSchoolRequest) request).getHsGrade() + "," + ((GradSchoolRequest) request).getBachDegree();

                        writer.append(column);
                        writer.append(LINE_BREAK);
                        System.out.println(column);
                        }
                    }
                }
            }
        }
        writer.flush();
        writer.close();
    }
    
    
    public void genMedicalFile() throws IOException {

        String USER_HEADER = "Sender,receiver,requestDate,resolveDate,status,bp,sugarLevel,bodyTemp,diabetic,maxBP,minBP";
        String LINE_BREAK = "\n";
        String USER_CAT_PATH = "csv/physicalStats.csv";

        file = new File(USER_CAT_PATH);
        if (file.exists()) {
            file.delete();
        }

        file.createNewFile();
        System.out.println("New PhysicalHealth File Created");
        writer = new FileWriter(file);

        writer.append(USER_HEADER);
        writer.append(LINE_BREAK);
        
        

        for (Network network
                : ecosystem.getNetworkList()) {
            //Step 2.a: check against each enterprise
            
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {

                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    
                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                        
                        if (request instanceof PhysicalHealthCareRequest) 
                        {        
                        String column = request.getSender() + "," + request.getReceiver() + "," + request.getRequestDate() + "," + request.getResolveDate() + "," + request.getStatus() + "," +  ((PhysicalHealthCareRequest) request).getBloodPressure() + "," + ((PhysicalHealthCareRequest) request).getBloodSugarlevel() + "," + ((PhysicalHealthCareRequest) request).getBodyTemp() + "," + ((PhysicalHealthCareRequest) request).getDiabetic() + "," + ((PhysicalHealthCareRequest) request).getMinBP() + "," + ((PhysicalHealthCareRequest) request).getMaxBP();

                        writer.append(column);
                        writer.append(LINE_BREAK);
                        System.out.println(column);
                        }
                    }
                }
            }
        }
        
        writer.flush();
        writer.close();
    }

    public void genFile() throws IOException {

        String USER_HEADER = "org,sender,receiver,requestDate,resolvedDate,status";
        String LINE_BREAK = "\n";
        String USER_CAT_PATH = "csv/stats.csv";

        file = new File(USER_CAT_PATH);
        if (file.exists()) {
            file.delete();
        }

        file.createNewFile();
        System.out.println("New OverallStats File Created");
        writer = new FileWriter(file);

        writer.append(USER_HEADER);
        writer.append(LINE_BREAK);

        for (Network network
                : ecosystem.getNetworkList()) {
            
            //Step 2.a: check against each enterprise
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {

                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                        String column = organization + "," + request.getSender() + "," + request.getReceiver() + "," + request.getRequestDate() + "," + request.getResolveDate() + "," + request.getStatus();

                        writer.append(column);
                        writer.append(LINE_BREAK);
                        System.out.println(column);

                    }
                }
            }
        }
        
        writer.flush();
        writer.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        btnManageNetwork = new javax.swing.JButton();
        btnManageEnterprise = new javax.swing.JButton();
        btnManageAdmin = new javax.swing.JButton();
        btnRegisterStudent = new javax.swing.JButton();
        btnViewAllStudents = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 161, Short.MAX_VALUE))
        );

        jSplitPane.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(246, 198, 103));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManageNetwork.setBackground(new java.awt.Color(12, 36, 60));
        btnManageNetwork.setForeground(new java.awt.Color(255, 255, 255));
        btnManageNetwork.setText("Manage Region");
        btnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageNetworkActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 250, 50));

        btnManageEnterprise.setBackground(new java.awt.Color(12, 36, 60));
        btnManageEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        btnManageEnterprise.setText("Manage Enterprise");
        btnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterpriseActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 250, 50));

        btnManageAdmin.setBackground(new java.awt.Color(12, 36, 60));
        btnManageAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnManageAdmin.setText("Manage Enterprise User");
        btnManageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 250, 50));

        btnRegisterStudent.setBackground(new java.awt.Color(12, 36, 60));
        btnRegisterStudent.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisterStudent.setText("Register Student");
        btnRegisterStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterStudentActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegisterStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 250, 50));

        btnViewAllStudents.setBackground(new java.awt.Color(12, 36, 60));
        btnViewAllStudents.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAllStudents.setText("View Students");
        btnViewAllStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllStudentsActionPerformed(evt);
            }
        });
        jPanel2.add(btnViewAllStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 250, 50));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Student Services");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 150, -1));

        jButton1.setBackground(new java.awt.Color(12, 36, 60));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 250, 50));

        jSplitPane.setRightComponent(jPanel2);

        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageNetworkActionPerformed
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageNetworkActionPerformed

    private void btnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterpriseActionPerformed
        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEnterpriseActionPerformed

    private void btnManageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdminActionPerformed
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseAdminJPanel", manageEnterpriseAdminJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdminActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged

    }//GEN-LAST:event_jTreeValueChanged

    private void btnRegisterStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterStudentActionPerformed
        // TODO add your handling code here:
        RegisterStudent rg = new RegisterStudent(userProcessContainer, ecosystem, vd, user_Dir);
        userProcessContainer.add("RegisterStudent", rg);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRegisterStudentActionPerformed

    private void btnViewAllStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllStudentsActionPerformed
        // TODO add your handling code here:
        ViewAllStudents rg = new ViewAllStudents(userProcessContainer, ecosystem, vd);
        userProcessContainer.add("ViewAllStudents", rg);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewAllStudentsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ReportingJPanel rjp = new ReportingJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("reportingJPanel", rjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdmin;
    private javax.swing.JButton btnManageEnterprise;
    private javax.swing.JButton btnManageNetwork;
    private javax.swing.JButton btnRegisterStudent;
    private javax.swing.JButton btnViewAllStudents;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
