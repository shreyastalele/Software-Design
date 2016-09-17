/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud.gradebook.stalele1.netbeans.client;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author shreyasrameshtalele
 */
public class Converter {
    
    public static Object convertFromXmlToObject(Object xmlString, Class... type) throws JAXBException{
        Object result;
        StringReader sr = null;
        if (xmlString instanceof String){
            sr = new StringReader((String)xmlString);
        }
        JAXBContext context         = JAXBContext.newInstance(type);
        Unmarshaller unmarshaller   = context.createUnmarshaller();
        result = unmarshaller.unmarshal(sr);
        return result;
    }
    public static String convertFromObjectToXml(Object source, Class... type) {
        String result;
        StringWriter sw = new StringWriter();
        try {
            JAXBContext context     = JAXBContext.newInstance(type);
            Marshaller  marshaller  = context.createMarshaller();
            marshaller.marshal(source, sw);
            result = sw.toString();
        } 
        catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
