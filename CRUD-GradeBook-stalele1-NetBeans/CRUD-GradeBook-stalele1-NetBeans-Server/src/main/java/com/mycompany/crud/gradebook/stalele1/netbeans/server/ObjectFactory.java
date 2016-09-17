package com.mycompany.crud.gradebook.stalele1.netbeans.server;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Gradebook createGradebook() {
        return new Gradebook();
    }

    public Gradebook.Student createGradebookStudent() {
        return new Gradebook.Student();
    }

    public Gradebook.Student.GrdeItem createGradebookStudentGrdeItem() {
        return new Gradebook.Student.GrdeItem();
    }

}

