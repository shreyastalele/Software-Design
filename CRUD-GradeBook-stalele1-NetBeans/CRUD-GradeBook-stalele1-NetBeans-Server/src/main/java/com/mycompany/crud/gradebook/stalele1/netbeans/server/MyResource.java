package com.mycompany.crud.gradebook.stalele1.netbeans.server;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("Gradebook")
public class MyResource {
    private static final Logger LOG = LoggerFactory.getLogger(MyResource.class);
    
    File fileName = null;
    
    @Context
    private UriInfo context;
    
    public MyResource(){
       LOG.info("Creating an Gradebook Resource");
       ClassLoader classLoader = getClass().getClassLoader();
       fileName = new File(classLoader.getResource("Gradebook.xml").getFile());
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response GetId() throws JAXBException{
        LOG.info("Retrieving the Complete gradebook");
        LOG.debug("GET request");
        Response response;
        Gradebook gradeBookObj = new Gradebook();
        try{
        gradeBookObj = ReadDataFromXml();
        if(gradeBookObj.getStudent().isEmpty())
        {
            LOG.info("Creating a {} {} Status Response", Response.Status.GONE.getStatusCode(), Response.Status.GONE .getReasonPhrase());
            return Response.status(Response.Status.GONE).entity(gradeBookObj).build();
        }
        LOG.info("Creating a {} {} Status Response", Response.Status.OK.getStatusCode(), Response.Status.OK .getReasonPhrase());
        response = Response.status(Response.Status.OK).entity(gradeBookObj).build();
        }
        catch (JAXBException e) {
        LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
        LOG.debug("XML is incompatible with Student Resource");
        response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        } 
        catch (RuntimeException e) {
        LOG.debug("Catch All exception");
        LOG.info("Creating a {} {} Status Response", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        }
        LOG.debug("Returning the value {}", response);
        return response;
    }
    
    @GET
    @Path("{sId}/{gradeItem}")
    @Produces(MediaType.APPLICATION_XML)
    public Response GetId(@PathParam("sId") String sId, @PathParam("gradeItem") String gradeItem) throws JAXBException{
        LOG.info("Retrieving the Student Info");
        LOG.debug("GET request");
        LOG.debug("PathParam id = {} and gradeItem = {}", sId,gradeItem);
        Response response;
        Gradebook gradeBookObj = new Gradebook();
        ReturnGradebook grdbook = new ReturnGradebook();
        try{
            if( null == sId || "".equalsIgnoreCase(sId)
            || null == gradeItem || gradeItem.equalsIgnoreCase("")){
            LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            LOG.debug("No Student Resource to return");
            response = Response.status(Response.Status.BAD_REQUEST).location(null).entity(null).build();
            return response;
        }
        gradeBookObj = ReadDataFromXml();
        if(gradeBookObj.getStudent().isEmpty())
        {
            LOG.info("Creating a {} {} Status Response", Response.Status.GONE.getStatusCode(), Response.Status.GONE .getReasonPhrase());
            return Response.status(Response.Status.GONE).entity(gradeBookObj).build();
        }
        grdbook = GetStudentInfo(gradeBookObj, sId, gradeItem);
        if(grdbook.returnValue == -1){
            LOG.info("Creating a {} {} Status Response", Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase());
            response = Response.status(Response.Status.NOT_FOUND).entity(null).build();
            return response;
        }
        LOG.info("Creating a {} {} Status Response", Response.Status.OK.getStatusCode(), Response.Status.OK .getReasonPhrase());
        response = Response.status(Response.Status.OK).entity(grdbook.gradebook).build();
        }
        catch (JAXBException e) {
        LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
        LOG.debug("XML is incompatible with Student Resource");
        response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        } 
        catch (RuntimeException e) {
        LOG.debug("Catch All exception");
        LOG.info("Creating a {} {} Status Response", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        }
        LOG.debug("Returning the value {}", response);
        return response;
    }
    
    @GET
    @Path("{sId}")
    @Produces(MediaType.APPLICATION_XML)
    public Response GetId(@PathParam("sId") String sId) throws JAXBException{
        LOG.info("Retrieving the Student Info");
        LOG.debug("GET request");
        LOG.debug("PathParam id = {}", sId);
        Response response;
        Gradebook gradeBookObj = new Gradebook();
        ReturnGradebook grdbook = new ReturnGradebook();
        try{
            if( null == sId || "".equalsIgnoreCase(sId)){
            LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            LOG.debug("No Student Resource to return");
            response = Response.status(Response.Status.BAD_REQUEST).location(null).entity(null).build();
            return response;
        }
        gradeBookObj = ReadDataFromXml();
        if(gradeBookObj.getStudent().isEmpty())
        {
            LOG.info("Creating a {} {} Status Response", Response.Status.GONE.getStatusCode(), Response.Status.GONE .getReasonPhrase());
            return Response.status(Response.Status.GONE).entity(gradeBookObj).build();
        }
        grdbook = GetStudentInfo(gradeBookObj, sId, "");
        if(grdbook.returnValue == -1){
            LOG.info("Creating a {} {} Status Response", Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase());
            response = Response.status(Response.Status.NOT_FOUND).entity(null).build();
            return response;
        }
        LOG.info("Creating a {} {} Status Response", Response.Status.OK.getStatusCode(), Response.Status.OK .getReasonPhrase());
        response = Response.status(Response.Status.OK).entity(grdbook.gradebook).build();
        }
        catch (JAXBException e) {
        LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
        LOG.debug("XML is incompatible with Student Resource");
        response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        } 
        catch (RuntimeException e) {
        LOG.debug("Catch All exception");
        LOG.info("Creating a {} {} Status Response", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        }
        LOG.debug("Returning the value {}", response);
        return response;
    }
    
    private Gradebook ReadDataFromXml() throws JAXBException {
        Source source = new StreamSource(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        JAXBElement<Gradebook> unmarshalledObject = (JAXBElement<Gradebook>) unmarshaller.unmarshal(source,Gradebook.class);
        Gradebook gradeBookObj = unmarshalledObject.getValue();
        return gradeBookObj;
    }
     
    private ReturnGradebook GetStudentInfo(Gradebook gradeBookObj, String id, String sGradeItem) {
        ReturnGradebook grdbook = new ReturnGradebook();
        grdbook.returnValue = -1;
        Gradebook objStudinfo = new Gradebook();
        List<Gradebook.Student> sList = new ArrayList<>();
        List<Gradebook.Student> studList = gradeBookObj.getStudent();
        List<Gradebook.Student.GrdeItem> gradeItemList = new ArrayList<>();
        for (int i = 0; i < studList.size(); i++) {
            if(studList.get(i).id.equalsIgnoreCase(id))
            {
                Gradebook.Student stud = new Gradebook.Student();
                stud.setId(id);
                List<Gradebook.Student.GrdeItem> gradeItemList1 = studList.get(i).getGrdeItem();
                for (int j = 0; j <gradeItemList1.size() ; j++) {
                    Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                    gradeItem.setFeedback(gradeItemList1.get(j).getFeedback());
                    gradeItem.setName(gradeItemList1.get(j).getName());
                    gradeItem.setValue(gradeItemList1.get(j).getValue());
                    gradeItem.setAppeal(gradeItemList1.get(j).getAppeal());
                    gradeItem.setWeightage(gradeItemList1.get(j).getWeightage());
                    if("".equals(sGradeItem))
                    {
                        gradeItemList.add(gradeItem);
                        grdbook.returnValue = 1;
                    }
                    else if(sGradeItem.equalsIgnoreCase(gradeItem.getName())){
                        gradeItemList.add(gradeItem);
                        grdbook.returnValue = 1;
                    }
                }
                stud.setGrdeItem(gradeItemList);
                sList.add(stud);
            }
        }
        objStudinfo.setStudent(sList);
        grdbook.gradebook = objStudinfo;
        return grdbook;
    }

    @DELETE
    @Path("{sId}/{gradeItem}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response DeleteGradeItem(@PathParam("sId") String sId, @PathParam("gradeItem") String gradeItem) throws JAXBException{
        LOG.info("Removing the Student Resource {}");
        LOG.debug("DELETE request");
        LOG.debug("PathParam id = {} and gradeItem ={}", sId,gradeItem);
        Response response;
        Gradebook gradeBookObj = new Gradebook();
        ReturnGradebook grdbook = new ReturnGradebook();
        try{
            if( null == sId || "".equalsIgnoreCase(sId)
            || null == gradeItem || gradeItem.equalsIgnoreCase("")){
            LOG.debug("Empty Name or Student id provided");
            LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            response = Response.status(Response.Status.BAD_REQUEST).location(null).entity(null).build();
            return response;
        }
        gradeBookObj = ReadDataFromXml();
        grdbook = DeleteGradeItem(gradeBookObj, sId, gradeItem);
        if(grdbook.returnValue == -1){
            LOG.info("Creating a {} {} Status Response", Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase());
            response = Response.status(Response.Status.NOT_FOUND).entity(null).build();
            return response;
        }
        if(grdbook.returnValue == -2){
            LOG.info("Creating a {} {} Status Response", Response.Status.GONE.getStatusCode(), Response.Status.GONE.getReasonPhrase());
            response = Response.status(Response.Status.GONE).entity(null).build();
            return response;
        }
        SaveToXml(grdbook.gradebook);
        LOG.info("Creating a {} {} Status Response", Response.Status.NO_CONTENT.getStatusCode(), Response.Status.NO_CONTENT.getReasonPhrase());
        LOG.debug("Deleting the Student Resource");
        response = Response.status(Response.Status.NO_CONTENT).entity(grdbook.gradebook).build();
        }
        catch (JAXBException e) {
        LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
        LOG.debug("XML is incompatible with Student Resource");
        response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
        } 
        catch (RuntimeException e) {
        LOG.debug("Catch All exception");
        LOG.info("Creating a {} {} Status Response", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        }
        LOG.debug("Generated response {}", response);
        return response;
    }
    
    private void SaveToXml(Gradebook obj) throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        Marshaller m = jaxbContext.createMarshaller();
        m.marshal(obj,  fileName);
    }
    
    private ReturnGradebook DeleteGradeItem(Gradebook gradeBookObj, String id, String Name) throws JAXBException {
        ReturnGradebook grdbook = new ReturnGradebook();
        grdbook.returnValue = -1;
        Gradebook objGradeBook = new Gradebook();
        List<Gradebook.Student> sList = new ArrayList<>();
        List<Gradebook.Student> studList = gradeBookObj.getStudent();
        if(studList.isEmpty())
        {
            grdbook.returnValue = -2;
        }
        for (int i = 0; i < studList.size(); i++) {
            List<Gradebook.Student.GrdeItem> gradeItemList = new ArrayList<>();
            Gradebook.Student stud = new Gradebook.Student();
            stud.setId(studList.get(i).id);
            List<Gradebook.Student.GrdeItem> gradeItemList1 = studList.get(i).getGrdeItem();
            for (int j = 0; j <gradeItemList1.size() ; j++) {
                if(!id.equals("xXxJxWeR")){
                    if((gradeItemList1.get(j).getName().equalsIgnoreCase(Name) && studList.get(i).id.equalsIgnoreCase(id))){
                        grdbook.returnValue = 0;
                    }
                    else {
                        Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                        gradeItem.setFeedback(gradeItemList1.get(j).getFeedback());
                        gradeItem.setName(gradeItemList1.get(j).getName());
                        gradeItem.setValue(gradeItemList1.get(j).getValue());
                        gradeItem.setAppeal(gradeItemList1.get(j).getAppeal());
                        gradeItem.setWeightage(gradeItemList1.get(j).getWeightage());
                        gradeItemList.add(gradeItem);
                    }
                }
                else{
                    if((gradeItemList1.get(j).getName().equalsIgnoreCase(Name))){
                        grdbook.returnValue = 0;
                    }
                    else {
                        Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                        gradeItem.setFeedback(gradeItemList1.get(j).getFeedback());
                        gradeItem.setName(gradeItemList1.get(j).getName());
                        gradeItem.setValue(gradeItemList1.get(j).getValue());
                        gradeItem.setAppeal(gradeItemList1.get(j).getAppeal());
                        gradeItem.setWeightage(gradeItemList1.get(j).getWeightage());
                        gradeItemList.add(gradeItem);
                    }
                }
            }
            stud.setGrdeItem(gradeItemList);
            sList.add(stud);   
        }
        objGradeBook.setStudent(sList);
        grdbook.gradebook = objGradeBook;
        return grdbook;  
       
    }

    @POST
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response AddStudent(Gradebook grdBook) throws JAXBException{
       
       LOG.info("Creating the instance AddStudent");
       LOG.debug("POST request");
       Gradebook.Student newStud = grdBook.getStudent().get(0);
       Response response;
       Gradebook gradeBookObj = new Gradebook();
       ReturnGradebook grdbook = new ReturnGradebook();
       grdbook.returnValue = -1;
       try{
        if( null == newStud.getGrdeItem().get(0).name || "".equals(newStud.getGrdeItem().get(0).name)
                || null == newStud.getId() || newStud.getId().equalsIgnoreCase("")){
            LOG.debug("Empty Name or Student id provided");
            LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            response = Response.status(Response.Status.BAD_REQUEST).location(null).entity(null).build();
            return response;
        }
        gradeBookObj = ReadDataFromXml();
        grdbook = AddStudentInfo(gradeBookObj, newStud);
        if(grdbook.returnValue == -1)
        {
            LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
            return response;
        }
        if(grdbook.returnValue == -2)
        {
            LOG.info("Creating a {} {} Status Response", Response.Status.CONFLICT.getStatusCode(), Response.Status.CONFLICT.getReasonPhrase());
            response = Response.status(Response.Status.CONFLICT).entity(null).build();
            return response;
        }
        SaveToXml(grdbook.gradebook);
        //gradeBookObj = ReadDataFromXml();
        URI locationURI = null;
        if(grdbook.returnValue == 2)
        {
            locationURI = URI.create(context.getAbsolutePath().toString());
        }
        else{
            locationURI = URI.create(context.getAbsolutePath() + "/" + newStud.getId());
        }
        LOG.info("Creating a {} {} Status Response", Response.Status.CREATED.getStatusCode(), Response.Status.CREATED.getReasonPhrase());
        response = Response.status(Response.Status.CREATED).location(locationURI).entity(grdbook.gradebook).build();
       }
       catch (JAXBException e) {
            LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            LOG.debug("XML is incompatible with Student Resource");
            response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
       } 
       catch (RuntimeException e) {
           LOG.debug("Catch All exception");
           LOG.info("Creating a {} {} Status Response", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
           response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
       }
       LOG.debug("Generated response {}", response);
       return response;
    }
    
    public class ReturnGradebook{
        Gradebook gradebook;
        int returnValue;
    }
    
    private ReturnGradebook AddStudentInfo(Gradebook gradeBookObj, Gradebook.Student newStud) {
        ReturnGradebook returnObj = new ReturnGradebook();
        returnObj.returnValue = -1;
        Gradebook objGradeBook = new Gradebook();
        boolean exist1 = false;
        List<String> idList = new ArrayList<>();
        List<Gradebook.Student> sList = new ArrayList<>();
        List<Gradebook.Student> studList = gradeBookObj.getStudent();
        if(newStud.getId().equals("XXxXxRBsqUqX")){
            if(studList.isEmpty())
            {
                returnObj.returnValue = -2;
            }
            for (int i = 0; i < studList.size(); i++) {
                exist1 = false;
                List<Gradebook.Student.GrdeItem> gradeItemList = new ArrayList<>();
                Gradebook.Student stud = new Gradebook.Student();
                stud.setId(studList.get(i).id);
                List<Gradebook.Student.GrdeItem> gradeItemList1 = studList.get(i).getGrdeItem();
                for (int j = 0; j <gradeItemList1.size() ; j++) {
                    Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                    gradeItem.setFeedback(gradeItemList1.get(j).getFeedback());
                    gradeItem.setName(gradeItemList1.get(j).getName());
                    if(gradeItemList1.get(j).getName().equalsIgnoreCase(newStud.getGrdeItem().get(0).getName())){
                        exist1 = true;
                    }
                    gradeItem.setValue(gradeItemList1.get(j).getValue());
                    gradeItem.setAppeal(gradeItemList1.get(j).getAppeal());
                    gradeItem.setWeightage(gradeItemList1.get(j).getWeightage());
                    gradeItemList.add(gradeItem);
                }
                if(!exist1){
                    Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                    gradeItem.setName(newStud.getGrdeItem().get(0).getName());
                    gradeItem.setWeightage(newStud.getGrdeItem().get(0).getWeightage());
                    gradeItemList.add(gradeItem);
                }
                stud.setGrdeItem(gradeItemList);
                sList.add(stud);
                returnObj.returnValue = 2;
            }
            objGradeBook.setStudent(sList);
            returnObj.gradebook  = objGradeBook;
            return returnObj;
        }
        else{
            for (int i = 0; i < studList.size(); i++) {
                List<Gradebook.Student.GrdeItem> gradeItemList = new ArrayList<>();
                Gradebook.Student stud = new Gradebook.Student();
                stud.setId(studList.get(i).id);
                idList.add(studList.get(i).id.toLowerCase());
                List<Gradebook.Student.GrdeItem> gradeItemList1 = studList.get(i).getGrdeItem();
                boolean exist = false;
                for (int j = 0; j <gradeItemList1.size() ; j++) {
                    Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                    gradeItem.setFeedback(gradeItemList1.get(j).getFeedback());
                    gradeItem.setName(gradeItemList1.get(j).getName());
                    if(gradeItemList1.get(j).getName().equalsIgnoreCase(newStud.getGrdeItem().get(0).getName()))
                        exist = true;
                    gradeItem.setValue(gradeItemList1.get(j).getValue());
                    gradeItem.setAppeal(gradeItemList1.get(j).getAppeal());
                    gradeItem.setWeightage(gradeItemList1.get(j).getWeightage());
                    gradeItemList.add(gradeItem);
                }
                if(stud.getId().equalsIgnoreCase(newStud.getId()))
                {
                    if(!exist){
                        Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                        gradeItem.setName(newStud.getGrdeItem().get(0).getName());
                        gradeItem.setWeightage(newStud.getGrdeItem().get(0).getWeightage());
                        gradeItem.setFeedback(newStud.getGrdeItem().get(0).getFeedback());
                        gradeItem.setValue(newStud.getGrdeItem().get(0).getValue());
                        gradeItem.setAppeal(newStud.getGrdeItem().get(0).getAppeal());
                        gradeItemList.add(gradeItem);
                        returnObj.returnValue = 1;
                    }
                    else{
                        returnObj.returnValue = -2;
                    }
                }
                stud.setGrdeItem(gradeItemList);
                sList.add(stud);   
            }
            if(!(idList.contains(newStud.id.toLowerCase()))){
                sList.add(newStud);
                returnObj.returnValue = 1;
            }
            objGradeBook.setStudent(sList);
            returnObj.gradebook  = objGradeBook;
            return returnObj;  
        }
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response UpdateStudent(Gradebook grdBook) throws JAXBException{
       Gradebook.Student upStud = grdBook.getStudent().get(0);
       Response response;
       Gradebook gradeBookObj = new Gradebook();
       ReturnGradebook grdbook = new ReturnGradebook();
       grdbook.returnValue = -1;
       try{
           if( null == upStud.getGrdeItem().get(0).name || "".equals(upStud.getGrdeItem().get(0).name)
                || null == upStud.getId() || upStud.getId().equalsIgnoreCase("")){
            response = Response.status(Response.Status.BAD_REQUEST).location(null).entity(null).build();
            LOG.debug("Empty Name or Student id provided");
            LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
            return response;
           }
           gradeBookObj = ReadDataFromXml();
           grdbook = UpdateStudentInfo(gradeBookObj, upStud);
           if(grdbook.returnValue == -1)
           {
               LOG.info("Creating a {} {} Status Response", Response.Status.NOT_FOUND.getStatusCode(), Response.Status.NOT_FOUND.getReasonPhrase());
               response = Response.status(Response.Status.NOT_FOUND).entity(null).build();
               return response;
           }
           if(grdbook.returnValue == -2)
           {
               LOG.info("Creating a {} {} Status Response", Response.Status.CONFLICT.getStatusCode(), Response.Status.CONFLICT.getReasonPhrase());
               response = Response.status(Response.Status.CONFLICT).entity(null).build();
               return response;
           }
           SaveToXml(grdbook.gradebook);
           URI locationURI = URI.create(context.getAbsolutePath() + "/" + upStud.getId());
           LOG.info("Creating a {} {} Status Response", Response.Status.OK.getStatusCode(), Response.Status.OK.getReasonPhrase());
           response = Response.status(Response.Status.OK).location(locationURI).entity(grdbook.gradebook).build();
       }
       catch (JAXBException e) {
           LOG.info("Creating a {} {} Status Response", Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
           LOG.debug("XML is incompatible with Student Resource");
           response = Response.status(Response.Status.BAD_REQUEST).entity(null).build();
       } 
       catch (RuntimeException e) {
           LOG.debug("Catch All exception");
           LOG.info("Creating a {} {} Status Response", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
           response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
       }
       LOG.debug("Generated response {}", response);
       return response;
    }

    private ReturnGradebook UpdateStudentInfo(Gradebook gradeBookObj, Gradebook.Student upStud) {
        ReturnGradebook grdBook = new ReturnGradebook();
        grdBook.returnValue = -1;
        Gradebook objGradeBook = new Gradebook();
        List<Gradebook.Student> sList = new ArrayList<>();
        List<Gradebook.Student> studList = gradeBookObj.getStudent();
        if(studList.isEmpty())
            grdBook.returnValue = -2;
        for (int i = 0; i < studList.size(); i++) {
            List<Gradebook.Student.GrdeItem> gradeItemList = new ArrayList<>();
            Gradebook.Student stud = new Gradebook.Student();
            stud.setId(studList.get(i).id);
            List<Gradebook.Student.GrdeItem> gradeItemList1 = studList.get(i).getGrdeItem();
            for (int j = 0; j <gradeItemList1.size() ; j++) {
                if(stud.getId().equalsIgnoreCase(upStud.id))
                {
                    List<Gradebook.Student.GrdeItem> gradeItemList2 = upStud.getGrdeItem();
                    Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                    if(gradeItemList2.get(0).name.equalsIgnoreCase(gradeItemList1.get(j).name))
                    {
                        grdBook.returnValue = 0;
                        gradeItem.setValue(gradeItemList2.get(0).getValue());
                        gradeItem.setWeightage(gradeItemList2.get(0).getWeightage());
                        gradeItem.setFeedback(gradeItemList2.get(0).getFeedback());
                        gradeItem.setAppeal(gradeItemList2.get(0).getAppeal());
                        gradeItem.setName(gradeItemList2.get(0).getName());
                    }
                    else
                    {
                        gradeItem.setValue(gradeItemList1.get(j).getValue());
                        gradeItem.setWeightage(gradeItemList1.get(j).getWeightage());
                        gradeItem.setFeedback(gradeItemList1.get(j).getFeedback());
                        gradeItem.setName(gradeItemList1.get(j).getName());
                        gradeItem.setAppeal(gradeItemList1.get(j).getAppeal());
                    }
                    gradeItemList.add(gradeItem);
                }
                else
                {
                    Gradebook.Student.GrdeItem gradeItem = new Gradebook.Student.GrdeItem();
                    gradeItem.setFeedback(gradeItemList1.get(j).getFeedback());
                    gradeItem.setName(gradeItemList1.get(j).getName());
                    gradeItem.setValue(gradeItemList1.get(j).getValue());
                    gradeItem.setWeightage(gradeItemList1.get(j).getWeightage());
                    gradeItem.setAppeal(gradeItemList1.get(j).getAppeal());
                    gradeItemList.add(gradeItem);
                }
            }
            stud.setGrdeItem(gradeItemList);
            sList.add(stud);   
        }
        objGradeBook.setStudent(sList);
        grdBook.gradebook = objGradeBook;
        return grdBook;
    }
}
