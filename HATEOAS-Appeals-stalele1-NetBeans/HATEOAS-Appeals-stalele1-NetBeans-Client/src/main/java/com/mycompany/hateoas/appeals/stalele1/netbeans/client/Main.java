/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateoas.appeals.stalele1.netbeans.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import java.net.URI;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shreyasrameshtalele
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    
    private static final String RESTAPPEAL_MEDIA_TYPE = "application/vnd-appeals+xml";;
    
    private static final String ENTRY_POINT_URI = "http://localhost:8080/HATEOAS-Appeals-stalele1-NetBeans-Server/AppealResource";

    public static void main(String[] args) throws Exception {
        LOG.info("Assignment 3 - Software Design");
        URI serviceUri = new URI(ENTRY_POINT_URI);
        //BasicConfigurator.configure();
        HappyPathTestCase1(serviceUri);
        HappyPathTestCase2(serviceUri);
        BadStartTestCase(serviceUri);
        AbandonTestCase(serviceUri);
        ForgottenTestCase(serviceUri);
        BadIDTestCase(serviceUri);
    }

    private static void HappyPathTestCase1(URI serviceUri) throws Exception{
        System.out.println(String.format("\t\t**********\tHappyPathTest1 Started.\t**********"));
        System.out.println(String.format("Starting Happy Path Test1 with Service URI [%s]", serviceUri));
        Client client = Client.create();
        System.out.println(String.format("Created client [%s]", client));
        
        Appeal appeal = new Appeal();
        appeal.setAppealRemarks("");
        appeal.setGrades("");
        appeal.setFollowUpComByStudent("");
        appeal.setRemarksByProf("");
        appeal.setSubjectName("CSE-545");
        appeal.setStudentName("Shreyas Talele");
        appeal.setStatus(AppealStatus.UnGraded);
        
        System.out.println(String.format("Step 1 - Add grade"));
        System.out.println(String.format("About to start happy path test1. Adding Grade at [%s] via POST", (serviceUri+"/AddGrade")));
        appeal.setGrades("50");
        AppealRepresentation appealRepresentation = client.resource(serviceUri+"/AddGrade").accept(RESTAPPEAL_MEDIA_TYPE).type(RESTAPPEAL_MEDIA_TYPE).post(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created appealRepresentation [%s] denoted by the URI [%s]", appealRepresentation, appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println(String.format("Grade Item created at [%s]", appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println("Step 2 - Create appeal in above created Grade Item");
        Link addAppealLink = appealRepresentation.getAddAppealLink();
        System.out.println(String.format("About to add appeal at [%s] via PUT", addAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.GradedAndNoAppealCreated);
        appeal.setAppealRemarks("I deserve more marks.");
        System.out.println(String.format("Created addAppealLink [%s] for appeal representation [%s]", addAppealLink, appealRepresentation));
        AppealRepresentation addAppealRepresentation = client.resource(addAppealLink.getUri()).accept(addAppealLink.getMediaType()).type(addAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Added appeal in  AppealRepresentation [%s]", addAppealRepresentation));
        System.out.println(String.format("Appeal created at [%s]", addAppealRepresentation.getSelfLink().getUri().toString()));
        Link getAppealLink = addAppealRepresentation.getSelfLink();
        Link updateAppealLink = addAppealRepresentation.getUpdateAppealLink();
        Link submitAppealLink = addAppealRepresentation.getSubmitAppealLink();
        Link removeAppealLink = addAppealRepresentation.getRemoveAppealLink();
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateAppeal link [%s]", updateAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the SubmitAppeal link [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemoveAppeal link [%s]", removeAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println("Step 3 - Submit above Created Appeal in created Grade Item");
        System.out.println(String.format("About to submit appeal at [%s] via PUT", submitAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.AppealSubmittedButNotEvaluated);
        AppealRepresentation submitAppealRepresentation = client.resource(submitAppealLink.getUri()).accept(submitAppealLink.getMediaType()).type(submitAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", submitAppealRepresentation));
        getAppealLink = submitAppealRepresentation.getSelfLink();
        Link remarksByProfLink = submitAppealRepresentation.getRemarksByProfLink();
        Link updateGradeLink = submitAppealRepresentation.getUpdateGradeLink();
        Link followUpLink = submitAppealRepresentation.getFollowUpLink();
        System.out.println(String.format("Appeal submitted at [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemarksByProf link [%s]", remarksByProfLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateGrade link [%s]", updateGradeLink.getUri().toString()));
        System.out.println(String.format("Retrieved the FollowUp link [%s]", followUpLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println("Step 4 - Professor reviewed appeal and Updated the grades of student.");
        System.out.println(String.format("About to update grades of student at [%s] via PUT", updateGradeLink.getUri().toString()));
        appeal.setStatus(AppealStatus.AppealAcknowledgedAndGradesUpdated);
        appeal.setGrades("100");
        AppealRepresentation updateGradeAppealRepresentation = client.resource(updateGradeLink.getUri()).accept(updateGradeLink.getMediaType()).type(updateGradeLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", updateGradeAppealRepresentation));
        getAppealLink = updateGradeAppealRepresentation.getSelfLink();
        System.out.println(String.format("Appeal reviewed and grades updated at [%s]", updateGradeLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s] for appeal represntation [%s]", getAppealLink, updateGradeAppealRepresentation));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        System.out.println(String.format("\t\t**********\tHappyPathTest1 finished.\t**********"));
        
    }
    
    private static void HappyPathTestCase2(URI serviceUri) throws Exception{
        System.out.println(String.format("\t\t**********\tHappyPathTest2 Started.\t\t**********"));
        System.out.println(String.format("Starting Happy Path Test2 with Service URI [%s]", serviceUri));
        Client client = Client.create();
        System.out.println(String.format("Created client [%s]", client));
        
        Appeal appeal = new Appeal();
        appeal.setAppealRemarks("");
        appeal.setGrades("");
        appeal.setFollowUpComByStudent("");
        appeal.setRemarksByProf("");
        appeal.setSubjectName("CSE-545");
        appeal.setStudentName("Shreyas Talele");
        appeal.setStatus(AppealStatus.UnGraded);
        
        System.out.println(String.format("Step 1 - Add grade"));
        System.out.println(String.format("About to start happy path test2. Adding Grade at [%s] via POST", (serviceUri+"/AddGrade")));
        appeal.setGrades("50");
        AppealRepresentation appealRepresentation = client.resource(serviceUri+"/AddGrade").accept(RESTAPPEAL_MEDIA_TYPE).type(RESTAPPEAL_MEDIA_TYPE).post(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created appealRepresentation [%s] denoted by the URI [%s]", appealRepresentation, appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println(String.format("Grade Item created at [%s]", appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 2 - Create appeal in above created Grade Item"));
        Link addAppealLink = appealRepresentation.getAddAppealLink();
        System.out.println(String.format("About to add appeal at [%s] via PUT", addAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.GradedAndNoAppealCreated);
        appeal.setAppealRemarks("I deserve more marks.");
        System.out.println(String.format("Created addAppealLink [%s] for appeal representation [%s]", addAppealLink, appealRepresentation));
        AppealRepresentation addAppealRepresentation = client.resource(addAppealLink.getUri()).accept(addAppealLink.getMediaType()).type(addAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Added appeal in  AppealRepresentation link [%s]", addAppealRepresentation));
        System.out.println(String.format("Appeal created at [%s]", addAppealRepresentation.getSelfLink().getUri().toString()));
        Link getAppealLink = addAppealRepresentation.getSelfLink();
        Link updateAppealLink = addAppealRepresentation.getUpdateAppealLink();
        Link submitAppealLink = addAppealRepresentation.getSubmitAppealLink();
        Link removeAppealLink = addAppealRepresentation.getRemoveAppealLink();
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateAppeal link [%s]", updateAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the SubmitAppeal link [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemoveAppeal link [%s]", removeAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 3 - Submit above Created Appeal in created Grade Item"));
        System.out.println(String.format("About to submit appeal at [%s] via PUT", submitAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.AppealSubmittedButNotEvaluated);
        AppealRepresentation submitAppealRepresentation = client.resource(submitAppealLink.getUri()).accept(submitAppealLink.getMediaType()).type(submitAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", submitAppealRepresentation));
        getAppealLink = submitAppealRepresentation.getSelfLink();
        Link remarksByProfLink = submitAppealRepresentation.getRemarksByProfLink();
        Link updateGradeLink = submitAppealRepresentation.getUpdateGradeLink();
        Link followUpLink = submitAppealRepresentation.getFollowUpLink();
        System.out.println(String.format("Appeal submitted at [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemarksByProf link [%s]", remarksByProfLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateGrade link [%s]", updateGradeLink.getUri().toString()));
        System.out.println(String.format("Retrieved the FollowUp link [%s]", followUpLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 4 - Professor reviewed appeal, did not update the grades of student and gave him some remarks."));
        System.out.println(String.format("About to post remarks to the student's appeal at [%s] via PUT", updateGradeLink.getUri().toString()));
        appeal.setStatus(AppealStatus.AppealAcknowledgedAndGradesNotUpdated);
        appeal.setRemarksByProf("You can do better");
        AppealRepresentation updateGradeAppealRepresentation = client.resource(updateGradeLink.getUri()).accept(updateGradeLink.getMediaType()).type(updateGradeLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", updateGradeAppealRepresentation));
        
        AppealRepresentation remarksByProfAppealRepresentation = client.resource(remarksByProfLink.getUri()).accept(remarksByProfLink.getMediaType()).type(remarksByProfLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", remarksByProfAppealRepresentation));
        
        getAppealLink = remarksByProfAppealRepresentation.getSelfLink();
        System.out.println(String.format("Appeal reviewed and remarks by professor posted at [%s]", updateGradeLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s] for appeal represntation [%s]", getAppealLink, updateGradeAppealRepresentation));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        System.out.println(String.format("\t\t**********\tHappyPathTest2 finished.\t\t**********"));
    }
    
    private static void BadStartTestCase(URI serviceUri) throws Exception{
        System.out.println(String.format("\t\t**********\tBadStartTestCase Started.\t\t**********"));
        System.out.println(String.format("Starting BadStartTestCase with Service URI [%s]", serviceUri));
        Client client = Client.create();
        System.out.println(String.format("Created client [%s]", client));
        
        Appeal appeal = new Appeal();
        appeal.setAppealRemarks("");
        appeal.setGrades("");
        appeal.setFollowUpComByStudent("");
        appeal.setRemarksByProf("");
        appeal.setSubjectName("CSE-545");
        appeal.setStudentName("Shreyas Talele");
        appeal.setStatus(AppealStatus.UnGraded);
        
        System.out.println(String.format("Step 1 - Add grade"));
        System.out.println(String.format("About to start BadStartTestCase. Adding Grade at [%s] via POST", (serviceUri+"/AddGrade")));
        appeal.setGrades("50");
        AppealRepresentation appealRepresentation = client.resource(serviceUri+"/AddGrade").accept(RESTAPPEAL_MEDIA_TYPE).type(RESTAPPEAL_MEDIA_TYPE).post(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created appealRepresentation [%s] denoted by the URI [%s]", appealRepresentation, appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println(String.format("Grade Item created at [%s]", appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        System.out.println(String.format("Step 2 - Create appeal in above created Grade Item"));
        Link badLink = new Link("bad", new RestAppealUri(appealRepresentation.getSelfLink().getUri().toString() + "/bad-uri"), RESTAPPEAL_MEDIA_TYPE);
        System.out.println(String.format("Create bad link [%s]", badLink));
        System.out.println(String.format("About to add appeal at with bad URI [%s] via PUT", badLink.getUri().toString()));
        System.out.println(String.format("Created bad Link [%s] for appeal representation [%s]", badLink, appealRepresentation));
        ClientResponse badUpdateResponse = client.resource(badLink.getUri()).accept(badLink.getMediaType()).type(badLink.getMediaType()).put(ClientResponse.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created Bad Update Response [%s]", badUpdateResponse));
        System.out.println(String.format("Tried to add appeal with bad URI at [%s] via PUT, outcome [%d]", badLink.getUri().toString(), badUpdateResponse.getStatus()));
        System.out.println(String.format("\t\t**********\tBadStartTestCase Finished.\t\t**********"));
    }
    
    private static void AbandonTestCase(URI serviceUri) throws Exception{
        System.out.println(String.format("\t\t**********\tAbandonTestCase Started.\t**********"));
        System.out.println(String.format("Starting AbandonTestCase with Service URI [%s]", serviceUri));
        Client client = Client.create();
        System.out.println(String.format("Created client [%s]", client));
        
        Appeal appeal = new Appeal();
        appeal.setAppealRemarks("");
        appeal.setGrades("");
        appeal.setFollowUpComByStudent("");
        appeal.setRemarksByProf("");
        appeal.setSubjectName("CSE-545");
        appeal.setStudentName("Shreyas Talele");
        appeal.setStatus(AppealStatus.UnGraded);
        
        System.out.println(String.format("Step 1 - Add grade"));
        System.out.println(String.format("About to start AbandonTestCase. Adding Grade at [%s] via POST", (serviceUri+"/AddGrade")));
        appeal.setGrades("50");
        AppealRepresentation appealRepresentation = client.resource(serviceUri+"/AddGrade").accept(RESTAPPEAL_MEDIA_TYPE).type(RESTAPPEAL_MEDIA_TYPE).post(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created appealRepresentation [%s] denoted by the URI [%s]", appealRepresentation, appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println(String.format("Grade Item created at [%s]", appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 2 - Create appeal in above created Grade Item"));
        Link addAppealLink = appealRepresentation.getAddAppealLink();
        System.out.println(String.format("About to add appeal at [%s] via PUT", addAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.GradedAndNoAppealCreated);
        appeal.setAppealRemarks("I deserve more marks.");
        System.out.println(String.format("Created addAppealLink [%s] for appeal representation [%s]", addAppealLink, appealRepresentation));
        AppealRepresentation addAppealRepresentation = client.resource(addAppealLink.getUri()).accept(addAppealLink.getMediaType()).type(addAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Added appeal in  AppealRepresentation link [%s]", addAppealRepresentation));
        System.out.println(String.format("Appeal created at [%s]", addAppealRepresentation.getSelfLink().getUri().toString()));
        Link getAppealLink = addAppealRepresentation.getSelfLink();
        Link updateAppealLink = addAppealRepresentation.getUpdateAppealLink();
        Link submitAppealLink = addAppealRepresentation.getSubmitAppealLink();
        Link removeAppealLink = addAppealRepresentation.getRemoveAppealLink();
        System.out.println(String.format("Retrieved the Self link [%s] for appeal represntation [%s]", getAppealLink, addAppealRepresentation));
        System.out.println(String.format("Retrieved the UpdateAppeal link [%s] for appeal represntation [%s]", updateAppealLink, addAppealRepresentation));
        System.out.println(String.format("Retrieved the SubmitAppeal link [%s] for appeal represntation [%s]", submitAppealLink, addAppealRepresentation));
        System.out.println(String.format("Retrieved the RemoveAppeal link [%s] for appeal represntation [%s]", removeAppealLink, addAppealRepresentation));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 3 - Abandon(Remove) above Created Appeal in created Grade Item"));
        System.out.println(String.format("About to abandon appeal at [%s] via DELETE", removeAppealLink.getUri().toString()));
        AppealRepresentation abandonAppealRepresentation = client.resource(removeAppealLink.getUri()).accept(removeAppealLink.getMediaType()).delete(AppealRepresentation.class);
        System.out.println(String.format("Appeal abandoned in  AppealRepresentation link [%s]", abandonAppealRepresentation));
        getAppealLink = abandonAppealRepresentation.getSelfLink();
        
        System.out.println(String.format("Appeal abandoned at [%s]", removeAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s] for appeal represntation [%s]", getAppealLink, addAppealRepresentation));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        System.out.println(String.format("\t\t**********\tAbandonTestCase finished.\t**********"));
    }

    private static void ForgottenTestCase(URI serviceUri) throws Exception{
    System.out.println(String.format("\t\t**********\tForgottenTestCase Started.\t**********"));
        System.out.println(String.format("Starting ForgottenTestCase with Service URI [%s]", serviceUri));
        Client client = Client.create();
        System.out.println(String.format("Created client [%s]", client));
        
        Appeal appeal = new Appeal();
        appeal.setAppealRemarks("");
        appeal.setGrades("");
        appeal.setFollowUpComByStudent("");
        appeal.setRemarksByProf("");
        appeal.setSubjectName("CSE-545");
        appeal.setStudentName("Shreyas Talele");
        appeal.setStatus(AppealStatus.UnGraded);
        
        System.out.println(String.format("Step 1 - Add grade"));
        System.out.println(String.format("About to start ForgottenTestCase. Adding Grade at [%s] via POST", (serviceUri+"/AddGrade")));
        appeal.setGrades("50");
        AppealRepresentation appealRepresentation = client.resource(serviceUri+"/AddGrade").accept(RESTAPPEAL_MEDIA_TYPE).type(RESTAPPEAL_MEDIA_TYPE).post(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created appealRepresentation [%s] denoted by the URI [%s]", appealRepresentation, appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println(String.format("Grade Item created at [%s]", appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 2 - Create appeal in above created Grade Item"));
        Link addAppealLink = appealRepresentation.getAddAppealLink();
        System.out.println(String.format("About to add appeal at [%s] via PUT", addAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.GradedAndNoAppealCreated);
        appeal.setAppealRemarks("I deserve more marks.");
        System.out.println(String.format("Created addAppealLink [%s] for appeal representation [%s]", addAppealLink, appealRepresentation));
        AppealRepresentation addAppealRepresentation = client.resource(addAppealLink.getUri()).accept(addAppealLink.getMediaType()).type(addAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Added appeal in  AppealRepresentation link [%s]", addAppealRepresentation));
        System.out.println(String.format("Appeal created at [%s]", addAppealRepresentation.getSelfLink().getUri().toString()));
        Link getAppealLink = addAppealRepresentation.getSelfLink();
        Link updateAppealLink = addAppealRepresentation.getUpdateAppealLink();
        Link submitAppealLink = addAppealRepresentation.getSubmitAppealLink();
        Link removeAppealLink = addAppealRepresentation.getRemoveAppealLink();
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateAppeal link [%s]", updateAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the SubmitAppeal link [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemoveAppeal link [%s]", removeAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 3 - Submit above Created Appeal in created Grade Item"));
        System.out.println(String.format("About to submit appeal at [%s] via PUT", submitAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.AppealSubmittedButNotEvaluated);
        AppealRepresentation submitAppealRepresentation = client.resource(submitAppealLink.getUri()).accept(submitAppealLink.getMediaType()).type(submitAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", submitAppealRepresentation));
        getAppealLink = submitAppealRepresentation.getSelfLink();
        Link remarksByProfLink = submitAppealRepresentation.getRemarksByProfLink();
        Link updateGradeLink = submitAppealRepresentation.getUpdateGradeLink();
        Link followUpLink = submitAppealRepresentation.getFollowUpLink();
        System.out.println(String.format("Appeal submitted at [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemarksByProf link [%s]", remarksByProfLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateGrade link [%s]", updateGradeLink.getUri().toString()));
        System.out.println(String.format("Retrieved the FollowUp link [%s]", followUpLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 4 - Take follow up with professor."));
        appeal.setFollowUpComByStudent("Prof., please review my appeal.");
        System.out.println(String.format("About to follow up with prof. at [%s] via PUT", followUpLink.getUri().toString()));
        AppealRepresentation followUpAppealRepresentation = client.resource(followUpLink.getUri()).accept(followUpLink.getMediaType()).type(followUpLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", submitAppealRepresentation));
        getAppealLink = followUpAppealRepresentation.getSelfLink();
        System.out.println(String.format("Appeal reviewed and grades updated at [%s]", followUpLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s] for appeal represntation [%s]", getAppealLink, followUpAppealRepresentation));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        System.out.println(String.format("\t\t**********\tForgottenTestCase finished.\t**********"));
    }
    
    private static void BadIDTestCase(URI serviceUri) throws Exception{
    System.out.println(String.format("\t\t**********\tBadIDTestCase Started.\t**********"));
        System.out.println(String.format("Starting Happy Path Test1 with Service URI [%s]", serviceUri));
        Client client = Client.create();
        System.out.println(String.format("Created client [%s]", client));
        
        Appeal appeal = new Appeal();
        appeal.setAppealRemarks("");
        appeal.setGrades("");
        appeal.setFollowUpComByStudent("");
        appeal.setRemarksByProf("");
        appeal.setSubjectName("CSE-545");
        appeal.setStudentName("Shreyas Talele");
        appeal.setStatus(AppealStatus.UnGraded);
        
        System.out.println(String.format("Step 1 - Add grade"));
        System.out.println(String.format("About to start BadIDTestCase. Adding Grade at [%s] via POST", (serviceUri+"/AddGrade")));
        appeal.setGrades("50");
        AppealRepresentation appealRepresentation = client.resource(serviceUri+"/AddGrade").accept(RESTAPPEAL_MEDIA_TYPE).type(RESTAPPEAL_MEDIA_TYPE).post(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created appealRepresentation [%s] denoted by the URI [%s]", appealRepresentation, appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println(String.format("Grade Item created at [%s]", appealRepresentation.getSelfLink().getUri().toString()));
        System.out.println("Current Appeal Status - " + appeal.getStatus());
        
        System.out.println(String.format("Step 2 - Create appeal in above created Grade Item"));
        Link addAppealLink = appealRepresentation.getAddAppealLink();
        System.out.println(String.format("About to add appeal at [%s] via PUT", addAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.GradedAndNoAppealCreated);
        appeal.setAppealRemarks("I deserve more marks.");
        System.out.println(String.format("Created addAppealLink [%s] for appeal representation [%s]", addAppealLink, appealRepresentation));
        AppealRepresentation addAppealRepresentation = client.resource(addAppealLink.getUri()).accept(addAppealLink.getMediaType()).type(addAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Added appeal in  AppealRepresentation link [%s]", addAppealRepresentation));
        System.out.println(String.format("Appeal created at [%s]", addAppealRepresentation.getSelfLink().getUri().toString()));
        Link getAppealLink = addAppealRepresentation.getSelfLink();
        Link updateAppealLink = addAppealRepresentation.getUpdateAppealLink();
        Link submitAppealLink = addAppealRepresentation.getSubmitAppealLink();
        Link removeAppealLink = addAppealRepresentation.getRemoveAppealLink();
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateAppeal link [%s]", updateAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the SubmitAppeal link [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemoveAppeal link [%s]", removeAppealLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        System.out.println(String.format("Step 3 - Submit above Created Appeal in created Grade Item"));
        System.out.println(String.format("About to submit appeal at [%s] via PUT", submitAppealLink.getUri().toString()));
        appeal.setStatus(AppealStatus.AppealSubmittedButNotEvaluated);
        AppealRepresentation submitAppealRepresentation = client.resource(submitAppealLink.getUri()).accept(submitAppealLink.getMediaType()).type(submitAppealLink.getMediaType()).put(AppealRepresentation.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Appeal submitted in  AppealRepresentation link [%s]", submitAppealRepresentation));
        getAppealLink = submitAppealRepresentation.getSelfLink();
        Link remarksByProfLink = submitAppealRepresentation.getRemarksByProfLink();
        Link updateGradeLink = submitAppealRepresentation.getUpdateGradeLink();
        Link followUpLink = submitAppealRepresentation.getFollowUpLink();
        System.out.println(String.format("Appeal submitted at [%s]", submitAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the Self link [%s]", getAppealLink.getUri().toString()));
        System.out.println(String.format("Retrieved the RemarksByProf link [%s]", remarksByProfLink.getUri().toString()));
        System.out.println(String.format("Retrieved the UpdateGrade link [%s]", updateGradeLink.getUri().toString()));
        System.out.println(String.format("Retrieved the FollowUp link [%s]", followUpLink.getUri().toString()));
        System.out.println("Current Appeal Status - " +appeal.getStatus());
        
        RestAppealUri uri = new RestAppealUri(RestAppealUri.getURIWithoutId(followUpLink.getUri())+"/BadId");
        URI uri1 = uri.getFullUri();
        
        System.out.println(String.format("Step 4 - Follow up with professor with BAD ID."));
        System.out.println(String.format("About to follow up with professor with BAD ID at [%s] via PUT", uri1.toString()));
        appeal.setStatus(AppealStatus.AppealAcknowledgedAndGradesUpdated);
        appeal.setGrades("100");
        ClientResponse badIdResponse = client.resource(uri1).accept(followUpLink.getMediaType()).type(followUpLink.getMediaType()).put(ClientResponse.class, new AppealRepresentation(appeal));
        System.out.println(String.format("Created Bad Update Response [%s]", badIdResponse));
        System.out.println(String.format("Tried to follow up with professor with BAD ID at [%s] via PUT, outcome [%d]", uri.toString(), badIdResponse.getStatus()));
        System.out.println(String.format("\t\t**********\tBadIDTestCase finished.\t**********"));
    }
}
