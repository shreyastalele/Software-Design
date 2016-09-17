/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud.gradebook.stalele1.netbeans.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author shreyasrameshtalele
 */
public class Gradebook_CRUD_Client {
    private static final Logger LOG = LoggerFactory.getLogger(Gradebook_CRUD_Client.class);
    
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/CRUD-GradeBook-stalele1-NetBeans-Server/CSE-564/Gradebook";
    
    public Gradebook_CRUD_Client(){
        LOG.info("Creating a Gradebook_CRUD_Client object");
        ClientConfig config = new DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI);
        LOG.debug("webResource = {}", webResource.getURI());
    }
    
    public ClientResponse createStudent(Object requestEntity) throws UniformInterfaceException {
        LOG.info("Initiating a Create request");
        return webResource.type(MediaType.APPLICATION_XML).post(ClientResponse.class, requestEntity);
    }
    
    public ClientResponse deleteStudent( String id, String gradeItemName) throws UniformInterfaceException {
        LOG.info("Initiating a Delete request");
        LOG.debug("Id = {} and gradeItemName = {}", id,gradeItemName);
        return webResource.path(id).path(gradeItemName).delete(ClientResponse.class);
    }

    public ClientResponse updateStudent(Object requestEntity) throws UniformInterfaceException {
        LOG.info("Initiating an Update request");
        return webResource.type(MediaType.APPLICATION_XML).put(ClientResponse.class, requestEntity);
    }

    public <T> T retrieveStudent(Class<T> responseType, String id, String gradeItemName) throws UniformInterfaceException {
        LOG.info("Initiating a Retrieve request");
        LOG.debug("responseType = {}", responseType.getClass());
        LOG.debug("Id = {} and gradeItemName = {}", id, gradeItemName);
        return webResource.path(id).path(gradeItemName).accept(MediaType.APPLICATION_XML).get(responseType);
    }

    public void close() {
        LOG.info("Closing the REST Client");
        client.destroy();
    }
}
