/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud.gradebook.stalele1.netbeans.client;

import com.sun.jersey.api.client.ClientResponse;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shreyasrameshtalele
 */
public class CRUD_Client_UI extends javax.swing.JFrame {
    
    private static final Logger LOG = LoggerFactory.getLogger(CRUD_Client_UI.class);
    
    private Gradebook_CRUD_Client gradebook_CRUD_rest_client;
    
    private URI resourceURI;
    
    public CRUD_Client_UI() {
        initComponents();
         LOG.info("Creating a CRUD_Client_UI object");
        gradebook_CRUD_rest_client = new Gradebook_CRUD_Client();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabelStudentId = new javax.swing.JLabel();
        jRadioButtonTeacher = new javax.swing.JRadioButton();
        jRadioButtonStudent = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldStudentId = new javax.swing.JTextField();
        jLabelGradeItemName = new javax.swing.JLabel();
        jRadioButtonCreate = new javax.swing.JRadioButton();
        jRadioButtonRead = new javax.swing.JRadioButton();
        jRadioButtonUpdate = new javax.swing.JRadioButton();
        jRadioButtonDelete = new javax.swing.JRadioButton();
        jTextFieldGradeItemName = new javax.swing.JTextField();
        jLabelGradeItemWtg = new javax.swing.JLabel();
        jTextFieldAppeal = new javax.swing.JTextField();
        jLabelAppeal = new javax.swing.JLabel();
        jTextFieldGradeItemWtg = new javax.swing.JTextField();
        jLabelGradeItemMarks1 = new javax.swing.JLabel();
        jTextFieldGradeItemMarks1 = new javax.swing.JTextField();
        jLabelFeedback = new javax.swing.JLabel();
        jTextFieldFeedback = new javax.swing.JTextField();
        jLabelResponseCode = new javax.swing.JLabel();
        jTextFieldResponseCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelMediaType = new javax.swing.JLabel();
        jTextFieldMediaType = new javax.swing.JTextField();
        jButtonSubmit = new javax.swing.JButton();
        jLabelLocation = new javax.swing.JLabel();
        jTextFieldLocation = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelStar1 = new javax.swing.JLabel();
        jLabelStar2 = new javax.swing.JLabel();
        jLabelStar3 = new javax.swing.JLabel();
        jButtonMakeAppeal = new javax.swing.JButton();
        jLabelAppealMsg = new javax.swing.JLabel();
        jCheckBoxAddGrdForAll = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabelStudentId.setText("Student Id:");

        jRadioButtonTeacher.setText("Teacher");
        jRadioButtonTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonTeacherMouseClicked(evt);
            }
        });
        jRadioButtonTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTeacherActionPerformed(evt);
            }
        });

        jRadioButtonStudent.setText("Student");
        jRadioButtonStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonStudentMouseClicked(evt);
            }
        });
        jRadioButtonStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStudentActionPerformed(evt);
            }
        });

        jTextFieldStudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStudentIdActionPerformed(evt);
            }
        });

        jLabelGradeItemName.setText("GradeItem Name:");

        jRadioButtonCreate.setText("Create");
        jRadioButtonCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonCreateMouseClicked(evt);
            }
        });
        jRadioButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCreateActionPerformed(evt);
            }
        });

        jRadioButtonRead.setText("Read");
        jRadioButtonRead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonReadMouseClicked(evt);
            }
        });
        jRadioButtonRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonReadActionPerformed(evt);
            }
        });

        jRadioButtonUpdate.setText("Update");
        jRadioButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonUpdateMouseClicked(evt);
            }
        });
        jRadioButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUpdateActionPerformed(evt);
            }
        });

        jRadioButtonDelete.setText("Delete");
        jRadioButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonDeleteMouseClicked(evt);
            }
        });
        jRadioButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDeleteActionPerformed(evt);
            }
        });

        jLabelGradeItemWtg.setText("GradeItem Wtg.:");

        jTextFieldAppeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAppealActionPerformed(evt);
            }
        });

        jLabelAppeal.setText("Appeal:");

        jTextFieldGradeItemWtg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGradeItemWtgActionPerformed(evt);
            }
        });

        jLabelGradeItemMarks1.setText("GradeItem Marks:");

        jTextFieldGradeItemMarks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGradeItemMarks1ActionPerformed(evt);
            }
        });

        jLabelFeedback.setText("Feedback:");

        jTextFieldFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFeedbackActionPerformed(evt);
            }
        });

        jLabelResponseCode.setText("Response Code:");

        jLabelMediaType.setText("MediaType:");

        jTextFieldMediaType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMediaTypeActionPerformed(evt);
            }
        });

        jButtonSubmit.setText("Submit");
        jButtonSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSubmitMouseClicked(evt);
            }
        });
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabelLocation.setText("Location:");

        jLabelStar1.setText("*");

        jLabelStar2.setText("*");

        jLabelStar3.setFont(new java.awt.Font("Lucida Grande", 3, 10)); // NOI18N
        jLabelStar3.setText("(Fields marked with * are required)");

        jButtonMakeAppeal.setText("Make Appeal");
        jButtonMakeAppeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMakeAppealActionPerformed(evt);
            }
        });

        jLabelAppealMsg.setForeground(new java.awt.Color(51, 204, 0));
        jLabelAppealMsg.setText("Appealed Successfully..!!");

        jCheckBoxAddGrdForAll.setText("Check if want to do for all students");
        jCheckBoxAddGrdForAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAddGrdForAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jRadioButtonTeacher)
                        .addGap(359, 359, 359)
                        .addComponent(jRadioButtonStudent))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonCreate)
                                .addGap(72, 72, 72)
                                .addComponent(jRadioButtonRead)
                                .addGap(98, 98, 98)
                                .addComponent(jRadioButtonUpdate)
                                .addGap(79, 79, 79)
                                .addComponent(jRadioButtonDelete))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelGradeItemWtg)
                        .addGap(30, 30, 30)
                        .addComponent(jTextFieldGradeItemWtg, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelLocation)
                        .addGap(12, 12, 12)
                        .addComponent(jTextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelGradeItemMarks1)
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldGradeItemMarks1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButtonMakeAppeal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelStudentId)
                                        .addGap(62, 62, 62)
                                        .addComponent(jTextFieldStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelGradeItemName)
                                        .addGap(22, 22, 22)
                                        .addComponent(jTextFieldGradeItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelStar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelStar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelResponseCode)
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldResponseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelMediaType)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAppealMsg)
                                    .addComponent(jTextFieldMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAppeal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldAppeal, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelStar3)
                                .addGap(53, 53, 53)
                                .addComponent(jCheckBoxAddGrdForAll))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonTeacher)
                    .addComponent(jRadioButtonStudent))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonRead)
                    .addComponent(jRadioButtonUpdate)
                    .addComponent(jRadioButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonCreate))
                .addGap(9, 9, 9)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStar3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAddGrdForAll))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelStudentId))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelStar1)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelGradeItemName))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldGradeItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelStar2)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelGradeItemWtg))
                    .addComponent(jTextFieldGradeItemWtg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelGradeItemMarks1))
                    .addComponent(jTextFieldGradeItemMarks1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAppeal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAppeal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMakeAppeal)
                            .addComponent(jLabelAppealMsg))))
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldResponseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelResponseCode)
                            .addComponent(jLabelMediaType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelLocation))
                    .addComponent(jTextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jRadioButtonCreate.getAccessibleContext().setAccessibleName("Create Student with GradeItem");

        setSize(new java.awt.Dimension(650, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTeacherActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jRadioButtonTeacherActionPerformed

    private void jTextFieldStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStudentIdActionPerformed

    private void setOperationRadioBtnVisibility(boolean flag){
        jRadioButtonCreate.setVisible(flag);
        jRadioButtonRead.setVisible(flag);
        jRadioButtonDelete.setVisible(flag);
        jRadioButtonUpdate.setVisible(flag);
    }
    
    private void setOperationRadioBtnSelected(boolean flag){
        jRadioButtonCreate.setSelected(flag);
        jRadioButtonRead.setSelected(flag);
        jRadioButtonDelete.setSelected(flag);
        jRadioButtonUpdate.setSelected(flag);
    }
    
    private void jRadioButtonTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonTeacherMouseClicked
        // TODO add your handling code here:
        jRadioButtonTeacher.setSelected(true);
        jRadioButtonStudent.setSelected(false);
        jLabelStar1.setVisible(false);
        jLabelStar2.setVisible(false);
        jLabelStar3.setVisible(false);
        setOperationRadioBtnVisibility(true);
        setOperationRadioBtnSelected(false);
        setOperationsVisibility(false);
        setResponseVisibility(false);
        jButtonMakeAppeal.setVisible(false);
        jLabelAppealMsg.setVisible(false);
        jCheckBoxAddGrdForAll.setVisible(false);
    }//GEN-LAST:event_jRadioButtonTeacherMouseClicked

    private void jRadioButtonStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStudentActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButtonStudentActionPerformed

    private void jRadioButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCreateActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButtonCreateActionPerformed

    private void jRadioButtonReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonReadActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButtonReadActionPerformed

    private void jRadioButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUpdateActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jRadioButtonUpdateActionPerformed

    private void jRadioButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButtonDeleteActionPerformed
    
    private void clearResponseData() {
        
        jTextFieldResponseCode.setText("");
        jTextFieldMediaType.setText("");
        jTextFieldLocation.setText("");
        jTextFieldStudentId.setText("");
        jTextFieldAppeal.setText("");
        jTextFieldFeedback.setText("");
        jTextFieldGradeItemMarks1.setText("");
        jTextFieldGradeItemName.setText("");
        jTextFieldGradeItemWtg.setText("");
       
    }
    
    private void jRadioButtonStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonStudentMouseClicked
        jRadioButtonTeacher.setSelected(false);
        jRadioButtonStudent.setSelected(true);
        
        jRadioButtonCreate.setVisible(false);
        jRadioButtonRead.setVisible(true);
        jRadioButtonDelete.setVisible(false);
        jRadioButtonUpdate.setVisible(false);
        
        jLabelStar1.setVisible(false);
        jLabelStar2.setVisible(false);
        jLabelStar3.setVisible(false);
        
        jRadioButtonRead.setSelected(false);
        
        setOperationsVisibility(false);
        setResponseVisibility(false);
        
        jButtonMakeAppeal.setVisible(false);
        jLabelAppealMsg.setVisible(false);
        jCheckBoxAddGrdForAll.setVisible(false);
    }//GEN-LAST:event_jRadioButtonStudentMouseClicked

    private void jTextFieldAppealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAppealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAppealActionPerformed

    private void jTextFieldGradeItemWtgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGradeItemWtgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGradeItemWtgActionPerformed

    private void jTextFieldGradeItemMarks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGradeItemMarks1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGradeItemMarks1ActionPerformed

    private void jTextFieldFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFeedbackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFeedbackActionPerformed

    private void jTextFieldMediaTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMediaTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMediaTypeActionPerformed

    private Gradebook CreateRequest(boolean flag){
        LOG.info("Create request to add gradebook");
        Gradebook grdbook = new Gradebook();
        List<Gradebook.Student> studList = new ArrayList<>();
        Gradebook.Student stud = new Gradebook.Student();
        if(flag)
            if (!jTextFieldStudentId.getText().equals("")){
            stud.setId(jTextFieldStudentId.getText());
            }
            else{}
        else
            stud.setId("XXxXxRBsqUqX");
        List<Gradebook.Student.GrdeItem> gradeItemList = new ArrayList<>();
        Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
        gradeItem.setName(jTextFieldGradeItemName.getText());
        gradeItem.setValue(jTextFieldGradeItemMarks1.getText());
        gradeItem.setWeightage(jTextFieldGradeItemWtg.getText());

        gradeItemList.add(gradeItem);
        stud.setGrdeItem(gradeItemList);
        studList.add(stud);
        grdbook.setStudent(studList);
        return grdbook;
    }
    
    private Gradebook UpdateRequest(boolean isStudent){
        LOG.info("Create request to update gradebook");
        Gradebook grdbook = new Gradebook();
        List<Gradebook.Student> studList = new ArrayList<>();
        Gradebook.Student stud = new Gradebook.Student();
        if (!jTextFieldStudentId.getText().equals("")){
            stud.setId(jTextFieldStudentId.getText());
        }
        List<Gradebook.Student.GrdeItem> gradeItemList = new ArrayList<>();
        Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
        gradeItem.setName(jTextFieldGradeItemName.getText());
        gradeItem.setValue(jTextFieldGradeItemMarks1.getText());
        gradeItem.setFeedback(jTextFieldFeedback.getText());
        gradeItem.setWeightage(jTextFieldGradeItemWtg.getText());
        if(isStudent)
        {
            gradeItem.setAppeal(jTextFieldAppeal.getText());
        }
        
        gradeItemList.add(gradeItem);
        stud.setGrdeItem(gradeItemList);
        studList.add(stud);
        grdbook.setStudent(studList);
        return grdbook;
    }
    
    private void populateFormRead(ClientResponse clientResponse,boolean showAppeal){
        LOG.info("Populating the UI with the Appointment info");
        String  entity = clientResponse.getEntity(String.class);
        try{
            if ((clientResponse.getStatus() == Response.Status.OK.getStatusCode()) ||
            (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode())){
            Gradebook gradebook = (Gradebook)Converter.convertFromXmlToObject(entity, Gradebook.class);
            jTextFieldStudentId.setText(gradebook.getStudent().get(0).getId());
            jTextFieldGradeItemName.setText(gradebook.getStudent().get(0).getGrdeItem().get(0).getName());
            jTextFieldGradeItemMarks1.setText(gradebook.getStudent().get(0).getGrdeItem().get(0).getValue());
            jTextFieldGradeItemWtg.setText(gradebook.getStudent().get(0).getGrdeItem().get(0).getWeightage());
            jTextFieldFeedback.setText(gradebook.getStudent().get(0).getGrdeItem().get(0).getFeedback());
            
            jTextFieldAppeal.setText(gradebook.getStudent().get(0).getGrdeItem().get(0).getAppeal());
                    
            jTextFieldAppeal.setVisible(true);
            jLabelAppeal.setVisible(true);
            jTextFieldFeedback.setVisible(true);
            jLabelFeedback.setVisible(true);
            jTextFieldGradeItemMarks1.setVisible(true);
            jLabelGradeItemMarks1.setVisible(true);
            jTextFieldGradeItemWtg.setVisible(true);
            jLabelGradeItemWtg.setVisible(true);
            if(showAppeal)
            {
                jButtonMakeAppeal.setVisible(true);
            }
        } 
        else {
            
        }   
        jTextFieldResponseCode.setText(Integer.toString(clientResponse.getStatus()));
        jTextFieldMediaType.setText(clientResponse.getType().toString());
        if (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode()){
            jTextFieldLocation.setText(clientResponse.getLocation().toString());
        } 
        else {
            jTextFieldLocation.setText("");
        }
        } 
        catch (JAXBException e){
        }
    }
    
    private void populateFormRead1(ClientResponse clientResponse,boolean flag){
        LOG.info("Populating the UI with the Appointment info");
        String  entity = clientResponse.getEntity(String.class);
        try{
            String studentId = jTextFieldStudentId.getText();
            String gradeItemName = jTextFieldGradeItemName.getText();
            if ((clientResponse.getStatus() == Response.Status.OK.getStatusCode()) ||
            (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode())){
            Gradebook gradebook = (Gradebook)Converter.convertFromXmlToObject(entity, Gradebook.class);
            List <Gradebook.Student> slist = gradebook.getStudent();
                for (int i = 0; i < slist.size(); i++) {
                   if(slist.get(i).getId().equalsIgnoreCase(studentId)){
                        List <Gradebook.Student.GrdeItem> itemList = slist.get(i).getGrdeItem();
                        for (int j = 0; j < itemList.size(); j++) {
                            if(itemList.get(j).getName().equalsIgnoreCase(gradeItemName)){
                                jTextFieldGradeItemMarks1.setText(itemList.get(j).getValue());
                                jTextFieldGradeItemWtg.setText(itemList.get(j).getWeightage());
                                jTextFieldFeedback.setText(itemList.get(j).getFeedback());
                                jTextFieldAppeal.setText(itemList.get(j).getAppeal());
                            }
                       }
                   }
                }
            jTextFieldAppeal.setVisible(true);
            jLabelAppeal.setVisible(true);
            jTextFieldFeedback.setVisible(true);
            jLabelFeedback.setVisible(true);
            jTextFieldGradeItemMarks1.setVisible(true);
            jLabelGradeItemMarks1.setVisible(true);
            jTextFieldGradeItemWtg.setVisible(true);
            jLabelGradeItemWtg.setVisible(true);
            jLabelAppealMsg.setVisible(true);
        } 
        else {
            
        }   
        jTextFieldResponseCode.setText(Integer.toString(clientResponse.getStatus()));
        jTextFieldMediaType.setText(clientResponse.getType().toString());
        if (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode()){
            jTextFieldLocation.setText(clientResponse.getLocation().toString());
        } 
        else {
            jTextFieldLocation.setText("");
        }
        } 
        catch (JAXBException e){
        }
    }
    
    private void populateForm(ClientResponse clientResponse){
        LOG.info("Populating the UI with the Appointment info");
        if ((clientResponse.getStatus() == Response.Status.OK.getStatusCode()) ||
            (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode())){
        } 
        else {
        }
        jTextFieldResponseCode.setText(Integer.toString(clientResponse.getStatus()));
        try{
            jTextFieldMediaType.setText(clientResponse.getType().toString());
        }
        catch(Exception ex){
            jTextFieldMediaType.setText("application/xml");
        }
        
        if (clientResponse.getStatus() == Response.Status.CREATED.getStatusCode()){
            jTextFieldLocation.setText(clientResponse.getLocation().toString());
        } 
        else {
            jTextFieldLocation.setText("");
        }
    }
    
    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        // TODO add your handling code here:
        LOG.info("Invoking REST Client based on selection");
        boolean teacher = jRadioButtonTeacher.isSelected();
        boolean student = jRadioButtonStudent.isSelected();
        boolean create = jRadioButtonCreate.isSelected();
        boolean read = jRadioButtonRead.isSelected();
        boolean update = jRadioButtonUpdate.isSelected();
        boolean delete = jRadioButtonDelete.isSelected();
        boolean isChecked = jCheckBoxAddGrdForAll.isSelected();
        if(teacher && !student)
        {
            String studentId = jTextFieldStudentId.getText();
            String gradeItemName = jTextFieldGradeItemName.getText();
            if(create)
            {
                LOG.debug("Invoking Create action");
                if(!isChecked){
                Gradebook grdbook = CreateRequest(true);
                ClientResponse clientResponse = gradebook_CRUD_rest_client.createStudent(grdbook);
                resourceURI = clientResponse.getLocation();
                
                populateForm(clientResponse);
                }
                else{
                Gradebook grdbook = CreateRequest(false);
                ClientResponse clientResponse = gradebook_CRUD_rest_client.createStudent(grdbook);
                resourceURI = clientResponse.getLocation();
                populateForm(clientResponse);
                }
                LOG.debug("Retrieved location {}", resourceURI);
            }
            if(read)
            {
                LOG.debug("Invoking Read action");
                ClientResponse clientResponse = gradebook_CRUD_rest_client.retrieveStudent(ClientResponse.class, studentId,gradeItemName);
                populateFormRead(clientResponse,false);
            }
            if(update)
            {
                LOG.debug("Invoking update action");
                Gradebook grdbook = UpdateRequest(false);
                String xmlString = Converter.convertFromObjectToXml(grdbook, grdbook.getClass());
                ClientResponse clientResponse = gradebook_CRUD_rest_client.updateStudent(xmlString);
                populateForm(clientResponse);
            }
            if(delete)
            {
                LOG.debug("Invoking delete action");
                if(!isChecked)
                {
                    ClientResponse clientResponse = gradebook_CRUD_rest_client.deleteStudent(studentId,gradeItemName);
                    populateForm(clientResponse);
                }
                else
                {
                    ClientResponse clientResponse = gradebook_CRUD_rest_client.deleteStudent("xXxJxWeR",gradeItemName);
                    populateForm(clientResponse);
                }
            }
        }
        else if(!teacher && student)
        {
            jLabelAppealMsg.setVisible(false);
            String studentId = jTextFieldStudentId.getText();
            String gradeItemName = jTextFieldGradeItemName.getText();
            if(read)
            {
                LOG.debug("Invoking Read action");
                ClientResponse clientResponse = gradebook_CRUD_rest_client.retrieveStudent(ClientResponse.class, studentId,gradeItemName);
                populateFormRead(clientResponse,true);
            }
        }
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void jRadioButtonCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonCreateMouseClicked
        // TODO add your handling code here:
        jRadioButtonCreate.setSelected(true);
        jRadioButtonRead.setSelected(false);
        jRadioButtonUpdate.setSelected(false);
        jRadioButtonDelete.setSelected(false);
        
        jTextFieldAppeal.setVisible(false);
        jLabelAppeal.setVisible(false);
        
        jTextFieldFeedback.setVisible(false);
        jLabelFeedback.setVisible(false);
        
        jTextFieldGradeItemMarks1.setVisible(false);
        jLabelGradeItemMarks1.setVisible(false);
        
        jTextFieldGradeItemWtg.setVisible(true);
        jLabelGradeItemWtg.setVisible(true);
        
        jTextFieldStudentId.setVisible(true);
        jLabelStudentId.setVisible(true);
        
        jTextFieldGradeItemName.setVisible(true);
        jLabelGradeItemName.setVisible(true);
        
        jLabelStar1.setVisible(true);
        jLabelStar2.setVisible(true);
        jLabelStar3.setVisible(true);
        
        setResponseVisibility(true);
        clearResponseData();
        jCheckBoxAddGrdForAll.setVisible(true);
        jCheckBoxAddGrdForAll.setSelected(false);
    }//GEN-LAST:event_jRadioButtonCreateMouseClicked

    private void jRadioButtonReadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonReadMouseClicked
        // TODO add your handling code here:
        jRadioButtonCreate.setSelected(false);
        jRadioButtonRead.setSelected(true);
        jRadioButtonUpdate.setSelected(false);
        jRadioButtonDelete.setSelected(false);
        
        jTextFieldAppeal.setVisible(false);
        jLabelAppeal.setVisible(false);
        
        jTextFieldFeedback.setVisible(false);
        jLabelFeedback.setVisible(false);
        
        jTextFieldGradeItemMarks1.setVisible(false);
        jLabelGradeItemMarks1.setVisible(false);
        
        jTextFieldGradeItemWtg.setVisible(false);
        jLabelGradeItemWtg.setVisible(false);
        
        jTextFieldStudentId.setVisible(true);
        jLabelStudentId.setVisible(true);
        
        jTextFieldGradeItemName.setVisible(true);
        jLabelGradeItemName.setVisible(true);
        jLabelStar1.setVisible(true);
        jLabelStar2.setVisible(true);
        jLabelStar3.setVisible(true);
        setResponseVisibility(true);
        clearResponseData();
        jButtonMakeAppeal.setVisible(false);
        jLabelAppealMsg.setVisible(false);
        jCheckBoxAddGrdForAll.setVisible(false);
    }//GEN-LAST:event_jRadioButtonReadMouseClicked

    private void jRadioButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonUpdateMouseClicked
        // TODO add your handling code here:
        jRadioButtonCreate.setSelected(false);
        jRadioButtonRead.setSelected(false);
        jRadioButtonUpdate.setSelected(true);
        jRadioButtonDelete.setSelected(false);
        
        jTextFieldAppeal.setVisible(false);
        jLabelAppeal.setVisible(false);
        
        jTextFieldFeedback.setVisible(true);
        jLabelFeedback.setVisible(true);
        
        jTextFieldGradeItemMarks1.setVisible(true);
        jLabelGradeItemMarks1.setVisible(true);
        
        jTextFieldGradeItemWtg.setVisible(true);
        jLabelGradeItemWtg.setVisible(true);
        
        jTextFieldStudentId.setVisible(true);
        jLabelStudentId.setVisible(true);
        
        jTextFieldGradeItemName.setVisible(true);
        jLabelGradeItemName.setVisible(true);
        
        jLabelStar1.setVisible(true);
        jLabelStar2.setVisible(true);
        jLabelStar3.setVisible(true);
        
        setResponseVisibility(true);
        clearResponseData();
        jCheckBoxAddGrdForAll.setVisible(false);
    }//GEN-LAST:event_jRadioButtonUpdateMouseClicked

    private void jRadioButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonDeleteMouseClicked
        // TODO add your handling code here:
        jRadioButtonCreate.setSelected(false);
        jRadioButtonRead.setSelected(false);
        jRadioButtonUpdate.setSelected(false);
        jRadioButtonDelete.setSelected(true);
        
        jTextFieldAppeal.setVisible(false);
        jLabelAppeal.setVisible(false);
        
        jTextFieldFeedback.setVisible(false);
        jLabelFeedback.setVisible(false);
        
        jTextFieldGradeItemMarks1.setVisible(false);
        jLabelGradeItemMarks1.setVisible(false);
        
        jTextFieldGradeItemWtg.setVisible(false);
        jLabelGradeItemWtg.setVisible(false);
        
        jTextFieldStudentId.setVisible(true);
        jLabelStudentId.setVisible(true);
        
        jTextFieldGradeItemName.setVisible(true);
        jLabelGradeItemName.setVisible(true);
        jLabelStar1.setVisible(true);
        jLabelStar2.setVisible(true);
        jLabelStar3.setVisible(true);
        setResponseVisibility(true);
        clearResponseData();
        jCheckBoxAddGrdForAll.setVisible(true);
        jCheckBoxAddGrdForAll.setSelected(false);
    }//GEN-LAST:event_jRadioButtonDeleteMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         jTextFieldAppeal.setVisible(false);
         jTextFieldFeedback.setVisible(false);
         jTextFieldGradeItemMarks1.setVisible(false);
         jTextFieldGradeItemWtg.setVisible(false);
         jTextFieldStudentId.setVisible(false);
         jTextFieldGradeItemName.setVisible(false);
         jRadioButtonCreate.setVisible(false);
         jRadioButtonRead.setVisible(false);
         jRadioButtonDelete.setVisible(false);
         jRadioButtonUpdate.setVisible(false);
         
         jLabelAppeal.setVisible(false);
         jLabelFeedback.setVisible(false);
         jLabelGradeItemMarks1.setVisible(false);
         jLabelGradeItemWtg.setVisible(false);
         jLabelStudentId.setVisible(false);
         jLabelGradeItemName.setVisible(false);
         jLabelStar1.setVisible(false);
         jLabelStar2.setVisible(false);
         jLabelStar3.setVisible(false);
         setResponseVisibility(false);
         jLabelAppealMsg.setVisible(false);
         jButtonMakeAppeal.setVisible(false);
         jCheckBoxAddGrdForAll.setVisible(false);
         jCheckBoxAddGrdForAll.setSelected(false);
    }//GEN-LAST:event_formWindowOpened

    private void jButtonSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSubmitMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonSubmitMouseClicked

    private void jButtonMakeAppealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMakeAppealActionPerformed
        // TODO add your handling code here:
        boolean teacher = jRadioButtonTeacher.isSelected();
        boolean student = jRadioButtonStudent.isSelected();
        boolean read = jRadioButtonRead.isSelected();
        
        if(!teacher && student)
        {
            if(read)
            {
                Gradebook grdbook = UpdateRequest(true);
                String xmlString = Converter.convertFromObjectToXml(grdbook, grdbook.getClass());
                ClientResponse clientResponse = gradebook_CRUD_rest_client.updateStudent(xmlString);
                populateFormRead1(clientResponse,false);
                
            }
        }
    }//GEN-LAST:event_jButtonMakeAppealActionPerformed

    private void jCheckBoxAddGrdForAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAddGrdForAllActionPerformed
        // TODO add your handling code here:
        boolean checked = jCheckBoxAddGrdForAll.isSelected();
        if(checked){
            jLabelStudentId.setVisible(false);
            jTextFieldStudentId.setVisible(false);
            jLabelStar1.setVisible(false);
        }
        else{
            jLabelStudentId.setVisible(true);
            jTextFieldStudentId.setVisible(true);
            jLabelStar1.setVisible(true);
        }
    }//GEN-LAST:event_jCheckBoxAddGrdForAllActionPerformed
   
    private void setResponseVisibility(boolean flag){
         jButtonSubmit.setVisible(flag);
         jLabelResponseCode.setVisible(flag);
         jTextFieldResponseCode.setVisible(flag);
         jLabelLocation.setVisible(flag);
         jTextFieldLocation.setVisible(flag);
         jLabelMediaType.setVisible(flag);
         jTextFieldMediaType.setVisible(flag);
    }
    
    private void setOperationsVisibility(boolean flag){
        jTextFieldAppeal.setVisible(flag);
        jLabelAppeal.setVisible(flag);
        jTextFieldFeedback.setVisible(flag);
        jLabelFeedback.setVisible(flag);
        jTextFieldGradeItemMarks1.setVisible(flag);
        jLabelGradeItemMarks1.setVisible(flag);
        jTextFieldGradeItemWtg.setVisible(flag);
        jLabelGradeItemWtg.setVisible(flag);
        jTextFieldStudentId.setVisible(flag);
        jLabelStudentId.setVisible(flag);
        jTextFieldGradeItemName.setVisible(flag);
        jLabelGradeItemName.setVisible(flag);
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CRUD_Client_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD_Client_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD_Client_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD_Client_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_Client_UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButtonMakeAppeal;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JCheckBox jCheckBoxAddGrdForAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelAppeal;
    private javax.swing.JLabel jLabelAppealMsg;
    private javax.swing.JLabel jLabelFeedback;
    private javax.swing.JLabel jLabelGradeItemMarks1;
    private javax.swing.JLabel jLabelGradeItemName;
    private javax.swing.JLabel jLabelGradeItemWtg;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JLabel jLabelMediaType;
    private javax.swing.JLabel jLabelResponseCode;
    private javax.swing.JLabel jLabelStar1;
    private javax.swing.JLabel jLabelStar2;
    private javax.swing.JLabel jLabelStar3;
    private javax.swing.JLabel jLabelStudentId;
    private javax.swing.JRadioButton jRadioButtonCreate;
    private javax.swing.JRadioButton jRadioButtonDelete;
    private javax.swing.JRadioButton jRadioButtonRead;
    private javax.swing.JRadioButton jRadioButtonStudent;
    private javax.swing.JRadioButton jRadioButtonTeacher;
    private javax.swing.JRadioButton jRadioButtonUpdate;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldAppeal;
    private javax.swing.JTextField jTextFieldFeedback;
    private javax.swing.JTextField jTextFieldGradeItemMarks1;
    private javax.swing.JTextField jTextFieldGradeItemName;
    private javax.swing.JTextField jTextFieldGradeItemWtg;
    private javax.swing.JTextField jTextFieldLocation;
    private javax.swing.JTextField jTextFieldMediaType;
    private javax.swing.JTextField jTextFieldResponseCode;
    private javax.swing.JTextField jTextFieldStudentId;
    // End of variables declaration//GEN-END:variables

   
}
