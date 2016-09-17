/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateoas.appeals.stalele1.netbeans.client;
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
