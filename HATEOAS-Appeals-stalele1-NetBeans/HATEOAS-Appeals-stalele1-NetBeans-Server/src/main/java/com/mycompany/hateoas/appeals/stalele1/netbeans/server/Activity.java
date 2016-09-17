/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateoas.appeals.stalele1.netbeans.server;

/**
 *
 * @author shreyasrameshtalele
 */
public class Activity {
    
    public AppealRepresentation createAppeal(Appeal appeal1, RestAppealUri requestUri) {
        Identifier identifier = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        appeal.setStatus(AppealStatus.AppealCreatedButNotSubmitted);
        appeal.setAppealRemarks(appeal1.getAppealRemarks());
        AppealRepository.current().store(identifier,appeal);
        RestAppealUri getAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/GetAppeal/"  + identifier.toString());
        RestAppealUri updateAppealUri = new RestAppealUri(requestUri.getBaseUri()+ "/UpdateAppealRemarks/"  + identifier.toString());
        RestAppealUri submitAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/SubmitAppeal/"  + identifier.toString());
        RestAppealUri removeAppealUri = new RestAppealUri(requestUri.getBaseUri()+"/RemoveAppeal/"  + identifier.toString());
        return new AppealRepresentation(appeal, 
                new Link(Representation.RELATIONS_URI + "UpdateAppealRemarks", updateAppealUri),
        new Link(Representation.RELATIONS_URI + "SubmitAppeal", submitAppealUri),
        new Link(Representation.RELATIONS_URI + "RemoveAppeal", removeAppealUri),
        new Link(Representation.SELF_REL_VALUE, getAppealUri));
    }
    
    public AppealRepresentation createGrade(Appeal appeal, RestAppealUri requestUri) {
        appeal.setStatus(AppealStatus.GradedAndNoAppealCreated);
        Identifier identifier = AppealRepository.current().store(appeal);
        RestAppealUri appealUri = new RestAppealUri(requestUri.getBaseUri() +"/AddAppeal/" + identifier.toString());
        return new AppealRepresentation(appeal, 
                new Link(Representation.RELATIONS_URI + "AddAppeal", appealUri),
                new Link(Representation.SELF_REL_VALUE, requestUri));
    }
    
    public AppealRepresentation retrieveGrade(RestAppealUri requestUri) {
        Identifier identifier  = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        return AppealRepresentation.createResponseAppealRepresentation(appeal, requestUri);
    }
    
    public AppealRepresentation removeAppeal(RestAppealUri requestUri) {
        Identifier identifier  = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        if (appeal.getStatus() != AppealStatus.AppealCreatedButNotSubmitted) {
            throw new AppealAbandonException();
        }
        appeal.setStatus(AppealStatus.AppealAbandoned);
        AppealRepository.current().store(identifier,appeal);
        RestAppealUri getAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/GetAppeal/"  + identifier.toString());
        return new AppealRepresentation(appeal,
                new Link(Representation.SELF_REL_VALUE, getAppealUri));
    }
    
    public AppealRepresentation submitAppeal(RestAppealUri requestUri) {
        Identifier identifier  = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        if (appeal.getStatus() != AppealStatus.AppealCreatedButNotSubmitted) {
            throw new UpdateAppealException();
        }
        appeal.setStatus(AppealStatus.AppealSubmittedButNotEvaluated);
        AppealRepository.current().store(identifier,appeal);
        RestAppealUri appealUpdateGradeUri = new RestAppealUri(requestUri.getBaseUri() + "/UpdateGrade/"  + identifier.toString());
        RestAppealUri remarksAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/RemarksByProf/"  + identifier.toString());
        RestAppealUri followUpAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/FollowUp/"  + identifier.toString());
        RestAppealUri getAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/GetAppeal/"  + identifier.toString());
        return new AppealRepresentation(appeal, 
                new Link(Representation.RELATIONS_URI + "UpdateGrade", appealUpdateGradeUri),
                new Link(Representation.RELATIONS_URI + "RemarksByProf", remarksAppealUri),
                new Link(Representation.RELATIONS_URI + "FollowUp", followUpAppealUri),
                new Link(Representation.SELF_REL_VALUE, getAppealUri));
    }
    
    public AppealRepresentation updateAppealRemarks(Appeal newAppeal,RestAppealUri requestUri) {
        Identifier identifier  = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        if (appeal.getStatus() != AppealStatus.AppealCreatedButNotSubmitted) {
            throw new UpdateAppealException();
        }
        appeal.setAppealRemarks(newAppeal.getAppealRemarks());
        AppealRepository.current().store(identifier,appeal);
        RestAppealUri getAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/GetAppeal/"  + identifier.toString());
        return new AppealRepresentation(appeal, 
                new Link(Representation.SELF_REL_VALUE, getAppealUri));
    }
    
    public AppealRepresentation updateFollowUp(Appeal newAppeal, RestAppealUri requestUri) {
        Identifier identifier  = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        if (appeal.getStatus() != AppealStatus.AppealSubmittedButNotEvaluated) {
            throw new UpdateAppealException();
        }
        appeal.setFollowUpComByStudent(newAppeal.getFollowUpComByStudent());
        AppealRepository.current().store(identifier,appeal);
        RestAppealUri getAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/GetAppeal/"  + identifier.toString());
        return new AppealRepresentation(appeal, 
                new Link(Representation.SELF_REL_VALUE, getAppealUri));
    }
    
    public AppealRepresentation updateGrade(Appeal newAppeal,RestAppealUri requestUri) {
        Identifier identifier  = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        if (appeal.getStatus() != AppealStatus.AppealSubmittedButNotEvaluated) {
            throw new UpdateAppealException();
        }
        appeal.setGrades(newAppeal.getGrades());
        appeal.setStatus(AppealStatus.AppealAcknowledgedAndGradesUpdated);
        AppealRepository.current().store(identifier,appeal);
        RestAppealUri getAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/GetAppeal/"  + identifier.toString());
        return new AppealRepresentation(appeal, 
                new Link(Representation.SELF_REL_VALUE, getAppealUri));
    }
    
    public AppealRepresentation updateRemarksByProf(Appeal newAppeal,RestAppealUri requestUri) {
        Identifier identifier  = requestUri.getId();
        Appeal appeal = AppealRepository.current().get(identifier);
        if(appeal == null)
        { 
            throw new NoSuchAppealException();
        }
        if (!(appeal.getStatus() == AppealStatus.AppealSubmittedButNotEvaluated ||
                appeal.getStatus() == AppealStatus.AppealAcknowledgedAndGradesUpdated) ) {
            throw new UpdateAppealException();
        }
        appeal.setRemarksByProf(newAppeal.getRemarksByProf());
        appeal.setStatus(AppealStatus.AppealAcknowledgedAndGradesNotUpdated);
        AppealRepository.current().store(identifier,appeal);
        RestAppealUri getAppealUri = new RestAppealUri(requestUri.getBaseUri() + "/GetAppeal/"  + identifier.toString());
        return new AppealRepresentation(appeal, 
                new Link(Representation.SELF_REL_VALUE, getAppealUri));
    }
}
