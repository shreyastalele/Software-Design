/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud.gradebook.stalele1.netbeans.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "student"
})
@XmlRootElement(name = "Gradebook")
public class Gradebook {

    protected List<Gradebook.Student> student;

    public List<Gradebook.Student> getStudent() {
        if (student == null) {
            student = new ArrayList<Gradebook.Student>();
        }
        return this.student;
    }

    public void setStudent(List<Gradebook.Student> student) {
        this.student = student;
    }       
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "grdeItem"
    })
    public static class Student {

        @XmlElement(name = "GrdeItem")
        protected List<Gradebook.Student.GrdeItem> grdeItem;
        @XmlAttribute(name = "id")
        protected String id;
        public List<Gradebook.Student.GrdeItem> getGrdeItem() {
            if (grdeItem == null) {
                grdeItem = new ArrayList<Gradebook.Student.GrdeItem>();
            }
            return this.grdeItem;
        }
        public void setGrdeItem(List<Gradebook.Student.GrdeItem> item) {
                this.grdeItem = item;
        }
        public String getId() {
            return id;
        }
        public void setId(String value) {
            this.id = value;
        }
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class GrdeItem {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "Name")
            protected String name;
            @XmlAttribute(name = "Weightage")
            protected String weightage;
            @XmlAttribute(name = "Feedback")
            protected String feedback;
            @XmlAttribute(name = "Appeal")
            protected String appeal;

            public String getValue() {
                return value;
            }
            public void setValue(String value) {
                this.value = value;
            }
            public String getAppeal() {
                return appeal;
            }
            public void setAppeal(String value) {
                this.appeal = value;
            }
            public String getName() {
                return name;
            }
            public void setName(String value) {
                this.name = value;
            }
            public void setWeightage(String value) {
                this.weightage = value;
            }
            public void setFeedback(String value) {
                this.feedback = value;
            }
            public String getWeightage() {
                return weightage;
            }
            public String getFeedback() {
                return feedback ;
            }
        }

    }

}
