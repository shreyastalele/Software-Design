package com.mycompany.hateoas.appeals.stalele1.netbeans.server;

/**
 * @author shreyasrameshtalele
 */
import javax.xml.bind.annotation.XmlEnumValue;

public enum AppealStatus {
    
    @XmlEnumValue(value="UnGraded")
    UnGraded,
    
    @XmlEnumValue(value="GradedAndNoAppealCreated")
    GradedAndNoAppealCreated,
    
    @XmlEnumValue(value="AppealCreatedButNotSubmitted")
    AppealCreatedButNotSubmitted, 
        
    @XmlEnumValue(value="AppealSubmittedButNotEvaluated")
    AppealSubmittedButNotEvaluated, 
    
    @XmlEnumValue(value="AppealAcknowledgedAndGradesUpdated")
    AppealAcknowledgedAndGradesUpdated, 
    
    @XmlEnumValue(value="AppealAcknowledgedAndGradesNotUpdated")
    AppealAcknowledgedAndGradesNotUpdated, 
    
    @XmlEnumValue(value="AppealAbandoned")
    AppealAbandoned 
}

