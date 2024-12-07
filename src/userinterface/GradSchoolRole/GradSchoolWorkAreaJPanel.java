/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.GradSchoolRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.GradSchoolOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Student.StudentDirectory;
import Business.WorkQueue.GradSchoolRequest;
import Business.WorkQueue.PartTimeRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.SystemAdminWorkArea.ViewAllStudents;

/**
 *
 * @author vandanarangaswamy
 */

public class GradSchoolWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GradSchoolWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private final Organization gradSchoolOrganization;
    private StudentDirectory vd;
    private Enterprise enterprise;
//    private EcoSystem business;

    public GradSchoolWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization gradSchoolOrganization, Enterprise enterprise, StudentDirectory vd, EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.enterprise = enterprise;
        this.vd = vd;
        this.gradSchoolOrganization = (GradSchoolOrganization) gradSchoolOrganization;
        this.business = business;
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblStudentDisp.getModel();

        model.setRowCount(0);
        int totalRequests = 0;
        int acceptedRequests = 0;
        int acceptedRequestsUser = 0;
        int rejectedRequestsUser = 0;
        int rejectedRequests = 0;
        int pendingRequests = 0;
        int totalRequestsUser = 0;
        int pendingRequestsUser = 0;
        int unassignedReq = 0;

        for (WorkRequest request : gradSchoolOrganization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof GradSchoolRequest) {
                totalRequests = totalRequests + 1;
                Object[] row = new Object[8];
                row[0] = request;
                row[1] = request.getSender();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getStatus();
                row[4] = ((GradSchoolRequest) request).getDesUni();
                row[5] = ((GradSchoolRequest) request).getDesProgram();
                row[6] = ((GradSchoolRequest) request).getBachUni();
                row[7] = ((GradSchoolRequest) request).getBachGrade();

            if (request.getReceiver() == null) {
                unassignedReq = unassignedReq + 1;
            } else if (request.getReceiver().getEmployee().equals(userAccount.getEmployee())) {
                totalRequestsUser = totalRequestsUser + 1;
                if (request.getStatus().equals("Accepted")) {
                    acceptedRequestsUser = acceptedRequestsUser + 1;
                } else if (request.getStatus().equals("Rejected")) {
                    rejectedRequestsUser = rejectedRequestsUser + 1;
                } else {
                    pendingRequestsUser = pendingRequestsUser + 1;
                }

            }

                if (request.getStatus().equals("Accepted")) {
                    acceptedRequests = acceptedRequests + 1;
                } else if (request.getStatus().equals("Rejected")) {
                    rejectedRequests = rejectedRequests + 1;
                } else {
                    pendingRequests = pendingRequests + 1;
                }

                model.addRow(row);
            }

            txtTotalRequests1.setText(Integer.toString(totalRequests));
            txtRej.setText(Integer.toString(rejectedRequests));
            txtPend.setText(Integer.toString(pendingRequests));
            txtAcc.setText(Integer.toString(acceptedRequests));
            
            txtTotalRequests2.setText(Integer.toString(totalRequestsUser));
            txtAcc1.setText(Integer.toString(acceptedRequestsUser));
            txtRej1.setText(Integer.toString(rejectedRequestsUser));
            txtPend1.setText(Integer.toString(pendingRequestsUser));

            txtWelcome.setText("Welcome back, " + userAccount.getEmployee().getName() + ". There are " + (Integer.toString(unassignedReq)) + " unassigned request(s) for review & " + (Integer.toString(pendingRequests)) + " in your queue.");

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

        txtAcc = new javax.swing.JLabel();
        txtWelcome = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalRequests1 = new javax.swing.JLabel();
        txtRej = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalRequests2 = new javax.swing.JLabel();
        txtAcc1 = new javax.swing.JLabel();
        txtRej1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPend = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPend1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentDisp = new javax.swing.JTable();
        btnrefresh = new javax.swing.JButton();
        btnAsgnMe = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        btnViewAllStudents = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 198, 103));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAcc.setBackground(new java.awt.Color(12, 36, 60));
        txtAcc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtAcc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAcc.setFocusable(false);
        txtAcc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 88, 34));

        txtWelcome.setBackground(new java.awt.Color(204, 204, 255));
        txtWelcome.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        txtWelcome.setFocusable(false);
        add(txtWelcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 580, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel3.setText("Total Requests");
        jLabel3.setFocusable(false);
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txtTotalRequests1.setBackground(new java.awt.Color(246, 198, 103));
        txtTotalRequests1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTotalRequests1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalRequests1.setFocusable(false);
        txtTotalRequests1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtTotalRequests1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 88, 34));

        txtRej.setBackground(new java.awt.Color(12, 36, 60));
        txtRej.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtRej.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRej.setFocusable(false);
        txtRej.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtRej, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 88, 34));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Overall - Across Organization");
        jLabel4.setFocusable(false);
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel5.setText("Total Accepted");
        jLabel5.setFocusable(false);
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel6.setText("Total Rejected");
        jLabel6.setFocusable(false);
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, -1));

        txtTotalRequests2.setBackground(new java.awt.Color(12, 36, 60));
        txtTotalRequests2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtTotalRequests2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTotalRequests2.setFocusable(false);
        txtTotalRequests2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtTotalRequests2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 88, 34));

        txtAcc1.setBackground(new java.awt.Color(12, 36, 60));
        txtAcc1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtAcc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAcc1.setFocusable(false);
        txtAcc1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtAcc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 88, 34));

        txtRej1.setBackground(new java.awt.Color(12, 36, 60));
        txtRej1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtRej1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRej1.setFocusable(false);
        txtRej1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtRej1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 88, 34));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel7.setText("Total Rejected");
        jLabel7.setFocusable(false);
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel8.setText("Total Accepted");
        jLabel8.setFocusable(false);
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel9.setText("Total Requests");
        jLabel9.setFocusable(false);
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("My Requests");
        jLabel10.setFocusable(false);
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        txtPend.setBackground(new java.awt.Color(12, 36, 60));
        txtPend.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPend.setFocusable(false);
        txtPend.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtPend, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 88, 34));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel11.setText("Total Pending");
        jLabel11.setFocusable(false);
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        txtPend1.setBackground(new java.awt.Color(12, 36, 60));
        txtPend1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPend1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPend1.setFocusable(false);
        txtPend1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(txtPend1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 88, 34));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel12.setText("Total Pending");
        jLabel12.setFocusable(false);
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("Education");
        jLabel13.setFocusable(false);
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        tblStudentDisp.setBackground(new java.awt.Color(12, 36, 60));
        tblStudentDisp.setForeground(new java.awt.Color(255, 255, 255));
        tblStudentDisp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Bachelor's University", "Sender", "Receiver", "Status", "University", "Program", "Bachelor's University", "GPA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStudentDisp);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 690, 132));

        btnrefresh.setBackground(new java.awt.Color(12, 36, 60));
        btnrefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });
        add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 120, 40));

        btnAsgnMe.setBackground(new java.awt.Color(12, 36, 60));
        btnAsgnMe.setForeground(new java.awt.Color(255, 255, 255));
        btnAsgnMe.setText("Assign to me");
        btnAsgnMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsgnMeActionPerformed(evt);
            }
        });
        add(btnAsgnMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 162, 40));

        btnProcess.setBackground(new java.awt.Color(12, 36, 60));
        btnProcess.setForeground(new java.awt.Color(255, 255, 255));
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, 150, 40));

        btnViewAllStudents.setBackground(new java.awt.Color(12, 36, 60));
        btnViewAllStudents.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAllStudents.setText("View Students");
        btnViewAllStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllStudentsActionPerformed(evt);
            }
        });
        add(btnViewAllStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 120, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        populateTable();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void btnAsgnMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsgnMeActionPerformed

        int selectedRow = tblStudentDisp.getSelectedRow();

        if (selectedRow < 0) {

            JOptionPane.showMessageDialog(null, "Please select a record to proceed", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        WorkRequest request = (WorkRequest) tblStudentDisp.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateTable();
    }//GEN-LAST:event_btnAsgnMeActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed

        int selectedRow = tblStudentDisp.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a record to Process", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        GradSchoolRequest request = (GradSchoolRequest) tblStudentDisp.getValueAt(selectedRow, 0);
        if (request.getStatus().equalsIgnoreCase("Pending") || request.getStatus().equals(null)) {
            request.setStatus("Processing");
        }
        ProcessGradReqJPanel processGradReqJPanel = new ProcessGradReqJPanel(userProcessContainer, request, vd, business);
        userProcessContainer.add("processGradReqJPanel", processGradReqJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnProcessActionPerformed

    private void btnViewAllStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllStudentsActionPerformed
        // TODO add your handling code here:
        ViewAllStudents rg = new ViewAllStudents(userProcessContainer, business, vd);
        userProcessContainer.add("ViewAllStudents", rg);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewAllStudentsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsgnMe;
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnViewAllStudents;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudentDisp;
    private javax.swing.JLabel txtAcc;
    private javax.swing.JLabel txtAcc1;
    private javax.swing.JLabel txtPend;
    private javax.swing.JLabel txtPend1;
    private javax.swing.JLabel txtRej;
    private javax.swing.JLabel txtRej1;
    private javax.swing.JLabel txtTotalRequests1;
    private javax.swing.JLabel txtTotalRequests2;
    private javax.swing.JLabel txtWelcome;
    // End of variables declaration//GEN-END:variables
}
