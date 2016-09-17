/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateoas.appeals.stalele1.netbeans.server;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shreyasrameshtalele
 */
@XmlRootElement
public class Appeal {
    
    @XmlElement(name = "studentName",namespace = Representation.RESTAPPEAL_NAMESPACE)
    private String studentName = new String();
    
    @XmlElement(name = "grades",namespace = Representation.RESTAPPEAL_NAMESPACE)
    private String grades = new String();
    
    @XmlElement(name = "subjectName",namespace = Representation.RESTAPPEAL_NAMESPACE)
    private String subjectName = new String();
    
    @XmlElement(name = "remarksByProf",namespace = Representation.RESTAPPEAL_NAMESPACE)
    private String remarksByProf = new String();
    
    @XmlElement(name = "appealRemarks",namespace = Representation.RESTAPPEAL_NAMESPACE)
    private String appealRemarks = new String();
    
    @XmlElement(name = "followUpCommentByStudent",namespace = Representation.RESTAPPEAL_NAMESPACE)
    private String followUpCommentByStudent = new String();
    
    @XmlElement(name = "appealStatus",namespace = Representation.RESTAPPEAL_NAMESPACE)
    private AppealStatus appealStatus = AppealStatus.UnGraded;

    public Appeal() {
      //this(AppealStatus.APPEALEXPECTED, student);
    }

    public Appeal(AppealStatus appealStatus, String studentName, String subjectName, String remarksByProf, String appealRemarks, String grades, String followUpComment) {
        this.studentName = studentName;
        this.appealStatus = appealStatus;
        this.subjectName = subjectName;
        this.remarksByProf = remarksByProf;
        this.appealRemarks = appealRemarks;
        this.grades = grades;
        this.followUpCommentByStudent= followUpComment;
    }

    public void setStatus(AppealStatus appealStatus) {
        this.appealStatus = appealStatus;
    }
    public AppealStatus getStatus() {
        return appealStatus;
    }
    
    public void setGrades(String grades) {
        this.grades = grades;
    }
    public String getGrades() {
        return grades;
    }
    
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
    public String getFollowUpComByStudent() {
        return followUpCommentByStudent;
    }
    public void setFollowUpComByStudent(String comment) {
        this.followUpCommentByStudent = comment;
    }
    
    public String getRemarksByProf() {
        return remarksByProf;
    }
    public void setRemarksByProf(String remarksByProf) {
        this.remarksByProf = remarksByProf;
    }
    
    public String getAppealRemarks() {
        return appealRemarks;
    }
    public void setAppealRemarks(String appealRemarks) {
        this.appealRemarks = appealRemarks;
    }

    @Override
    public String toString() {
        try {
            JAXBContext context = JAXBContext.newInstance(AppealRepresentation.class);
            Marshaller marshaller = context.createMarshaller();

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(this, stringWriter);

            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
