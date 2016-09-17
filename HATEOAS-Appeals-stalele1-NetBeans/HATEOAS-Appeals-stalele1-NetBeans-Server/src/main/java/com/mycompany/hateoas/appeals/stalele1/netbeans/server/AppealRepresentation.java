/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateoas.appeals.stalele1.netbeans.server;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shreyasrameshtalele
 */
@XmlRootElement(name = "appeal", namespace = Representation.RESTAPPEAL_NAMESPACE)
public class AppealRepresentation extends Representation {
    
    //private static final Logger LOG = LoggerFactory.getLogger(AppealRepresentation.class);

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
    
    AppealRepresentation() {
        //LOG.debug("In AppealRepresentation Constructor");
    }
    
    public static AppealRepresentation fromXmlString(String xmlRepresentation) {
        //LOG.info("Creating an Appeal object from the XML = {}", xmlRepresentation);
                
        AppealRepresentation appealRepresentation = null;     
        try {
            JAXBContext context = JAXBContext.newInstance(AppealRepresentation.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            appealRepresentation = (AppealRepresentation) unmarshaller.unmarshal(new ByteArrayInputStream(xmlRepresentation.getBytes()));
        } catch (Exception e) {
            //throw new InvalidOrderException(e);
        }
        //LOG.debug("Generated the object {}", appealRepresentation);
        return appealRepresentation;
    }
    
    public AppealRepresentation(Appeal appeal, Link... links) {
       // //LOG.info("Creating an Appeal Representation for appeal = {} and links = {}", appeal.toString(), Arrays.toString(links));
        
        try {
            this.studentName = appeal.getStudentName();
            this.appealStatus = appeal.getStatus();
            this.remarksByProf = appeal.getRemarksByProf();
            this.grades = appeal.getGrades();
            this.appealRemarks = appeal.getAppealRemarks();
            this.subjectName = appeal.getSubjectName();
            this.followUpCommentByStudent = appeal.getFollowUpComByStudent();
            this.links = java.util.Arrays.asList(links);
        } catch (Exception ex) {
            throw new InvalidAppealException(ex);
        }
        //LOG.info("Created the AppealRepresentation ");
    }
    
    public AppealStatus getStatus() {
        //LOG.info("Retrieving the Appeal status {}", this.appealStatus);
        return appealStatus;
    }

    @Override
    public String toString() {
        //LOG.info("Converting Appeal Representation object to string");
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

    public Appeal getAppeal() {
        //LOG.info("Retrieving the Appeal Representation");
        //LOG.debug("subjectName = {}", subjectName);
        //LOG.debug("remarksByProf = {}", remarksByProf);
        //LOG.debug("grades = {}", grades);
        //LOG.debug("studentName = {}", studentName);
        //LOG.debug("appealRemarks = {}", appealRemarks);
        //LOG.debug("appealStatus = {}", appealStatus);
        //LOG.debug("followUpComment = {}", followUpCommentByStudent);
        Appeal appeal = new Appeal(appealStatus,studentName,subjectName,remarksByProf,appealRemarks,grades,followUpCommentByStudent);
        //LOG.debug("Retrieving the Appeal Representation {}", appeal);
        return appeal;
    }
    
     public Link getAddAppealLink() {
        //LOG.info("Retrieving the AddAppeal link ");
        return getLinkByName(RELATIONS_URI + "AddAppeal");
    }
    
    public Link getSelfLink() {
        return getLinkByName("self");
    }
    
    public Link getRemoveAppealLink() {
        return getLinkByName(RELATIONS_URI + "RemoveAppeal");
    }
    
    public Link getUpdateAppealLink() {
        return getLinkByName(RELATIONS_URI + "UpdateAppealRemarks");
    }
     
    public Link getSubmitAppealLink() {
        return getLinkByName(RELATIONS_URI + "SubmitAppeal");
    }
    
    public Link getGetAppealLink() {
        return getLinkByName(RELATIONS_URI + "GetAppeal");
    }
    
    public Link getFollowUpLink() {
        return getLinkByName(RELATIONS_URI + "FollowUp");
    }
     
    public Link getRemarksByProfLink() {
        return getLinkByName(RELATIONS_URI + "RemarksByProf");
    }
    
    public Link getUpdateGradeLink() {
        return getLinkByName(RELATIONS_URI + "UpdateGrade");
    }
          
    
    public static AppealRepresentation createResponseAppealRepresentation(Appeal appeal, RestAppealUri appealUri) {
        ////LOG.info("Creating a Response Appeal for appeal = {} and appealUri = {}", appeal.toString(), appealUri.toString());
        AppealRepresentation appealRepresentation;     

        if(appeal.getStatus() == AppealStatus.UnGraded) {
            //LOG.debug("The appeal status is {}", AppealStatus.UnGraded);
            appealRepresentation = new AppealRepresentation(appeal, 
                    new Link(RELATIONS_URI + "AddGrade", appealUri));
        } 
        else if(appeal.getStatus() == AppealStatus.GradedAndNoAppealCreated) {
            //LOG.debug("The appeal status is {}", AppealStatus.GradedAndNoAppealCreated);
            appealRepresentation = new AppealRepresentation(appeal, 
                    new Link(RELATIONS_URI + "AddAppeal", appealUri));
        } 
        else if(appeal.getStatus() == AppealStatus.AppealCreatedButNotSubmitted) {
            RestAppealUri removeAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/RemoveAppeal/"  + appealUri.getId().toString());
            RestAppealUri submitAppeal = new RestAppealUri(appealUri.getBaseUri() + "/SubmitAppeal/"  + appealUri.getId().toString());
            RestAppealUri updateAppeal = new RestAppealUri(appealUri.getBaseUri() + "/UpdateAppeal/"  + appealUri.getId().toString());
            RestAppealUri getAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/GetAppeal/"  + appealUri.getId().toString());
            //LOG.debug("The appeal status is {}", AppealStatus.AppealCreatedButNotSubmitted);
            appealRepresentation = new AppealRepresentation(appeal, 
                    new Link(Representation.RELATIONS_URI + "RemoveAppeal", removeAppealUri),
                    new Link(Representation.RELATIONS_URI + "SubmitAppeal", submitAppeal),
                    new Link(Representation.RELATIONS_URI + "UpdateAppeal", updateAppeal),
                    new Link(Representation.SELF_REL_VALUE, getAppealUri));
        }
        else if(appeal.getStatus() == AppealStatus.AppealSubmittedButNotEvaluated) {
            RestAppealUri appealUpdateGradeUri = new RestAppealUri(appealUri.getBaseUri() + "/UpdateGrade/"  + appealUri.getId().toString());
            RestAppealUri remarksAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/RemarksByProf/"  + appealUri.getId().toString());
            RestAppealUri followUpAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/FollowUp/"  + appealUri.getId().toString());
            RestAppealUri getAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/GetAppeal/"  + appealUri.getId().toString());
            //LOG.debug("The appeal status is {}", AppealStatus.AppealSubmittedButNotEvaluated);
            appealRepresentation = new AppealRepresentation(appeal, 
                    new Link(Representation.RELATIONS_URI + "UpdateGrade", appealUpdateGradeUri),
                    new Link(Representation.RELATIONS_URI + "RemarksByProf", remarksAppealUri),
                    new Link(Representation.RELATIONS_URI + "FollowUp", followUpAppealUri),
                    new Link(Representation.SELF_REL_VALUE, getAppealUri));           
        }
        else if(appeal.getStatus() == AppealStatus.AppealAcknowledgedAndGradesUpdated) {
            //LOG.debug("The appeal status is {}", AppealStatus.AppealAcknowledgedAndGradesUpdated);
            RestAppealUri getAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/GetAppeal/"  + appealUri.getId().toString());
            appealRepresentation = new AppealRepresentation(appeal,
                new Link(Representation.SELF_REL_VALUE, getAppealUri));              
        }
        else if(appeal.getStatus() == AppealStatus.AppealAcknowledgedAndGradesNotUpdated) {
            //LOG.debug("The appeal status is {}", AppealStatus.AppealAcknowledgedAndGradesNotUpdated);
            RestAppealUri getAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/GetAppeal/"  + appealUri.getId().toString());
            appealRepresentation = new AppealRepresentation(appeal,
                new Link(Representation.SELF_REL_VALUE, getAppealUri));              
        }
        else if(appeal.getStatus() == AppealStatus.AppealAbandoned) {
            //LOG.debug("The appeal status is {}", AppealStatus.AppealAbandoned);
            RestAppealUri getAppealUri = new RestAppealUri(appealUri.getBaseUri() + "/GetAppeal/"  + appealUri.getId().toString());
            appealRepresentation = new AppealRepresentation(appeal,
                new Link(Representation.SELF_REL_VALUE, getAppealUri));
        }
        else {
            //LOG.debug("The appeal status is in an unknown status");
            throw new RuntimeException("Unknown Appeal Status");
        }
        //LOG.debug("The appeal representation created for the Create Response Appeal Representation is {}", appealRepresentation);
        return appealRepresentation;
    }
}
