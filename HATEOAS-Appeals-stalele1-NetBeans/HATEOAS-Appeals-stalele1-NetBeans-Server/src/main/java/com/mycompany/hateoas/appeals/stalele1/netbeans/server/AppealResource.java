package com.mycompany.hateoas.appeals.stalele1.netbeans.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("AppealResource")
public class AppealResource {

    //private static final Logger LOG = LoggerFactory.getLogger(AppealResource.class);

    private @Context UriInfo uriInfo;

    public AppealResource() {
        //LOG.info("AppealResource constructor");
    }

    public AppealResource(UriInfo uriInfo) {
        //LOG.info("AppealResource constructor with mock uriInfo {}", uriInfo);
        this.uriInfo = uriInfo;  
    }
    
    @GET
    @Path("GetAppeal/{studentId}")
    @Produces("application/vnd-appeals+xml")
    public Response GetGrade() {
        //LOG.info("Retrieving an Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().retrieveGrade(new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(responseRepresentation).build();
        }  
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists.");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while getting appeal info of student.");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Retrieved the appeal response", response);
        return response;
    }
    
    @POST
    @Path("AddGrade")
    @Produces("application/vnd-appeals+xml")
    @Consumes("application/vnd-appeals+xml")
    public Response AddGrade(String s) {
        //LOG.info("Adding Grade Item in Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().createGrade(AppealRepresentation.fromXmlString(s).getAppeal(),new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.created(responseRepresentation.getAddAppealLink().getUri()).entity(responseRepresentation).build();
        }
        catch (InvalidAppealException iae) {
            //LOG.debug("Invalid grade in the XML representation {}", s);
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while adding the grade");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response {}", response);
       return response;
    }
    
    @PUT
    @Path("UpdateGrade/{studentId}")
    @Produces("application/vnd-appeals+xml")
    @Consumes("application/vnd-appeals+xml")
    public Response UpdateGrade(String s) {
        //LOG.info("Updating grade in Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().updateGrade(AppealRepresentation.fromXmlString(s).getAppeal(),new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(responseRepresentation).build();
        } 
        catch (InvalidAppealException iae) {
            //LOG.debug("Invalid appeal in the XML representation {}", s);
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists.");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch(UpdateAppealException ue) {
            //LOG.debug("Problem updating the appeal resource");
            response = Response.status(Response.Status.CONFLICT).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while updating grades of student.");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response {}", response);
        return response;
    }
    
    @DELETE
    @Path("RemoveAppeal/{studentId}")
    @Produces("application/vnd-appeals+xml")
    public Response RemoveAppeal() {
        //LOG.info("Removing an Appeal");
        Response response = null;
        try {
            AppealRepresentation removedAppeal = new Activity().removeAppeal(new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(removedAppeal).build();
        }
        catch(AppealAbandonException ex){
             //LOG.debug("Problem removing appeal resource");
            response = Response.status(Response.Status.METHOD_NOT_ALLOWED).header("Allow", "GET").build();
        }
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists.");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while removing appeal.");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response for deleting the appeal is {}", response);
        return response;
    }
    
    @PUT
    @Path("AddAppeal/{studentId}")
    @Produces("application/vnd-appeals+xml")
    @Consumes("application/vnd-appeals+xml")
    public Response AddAppeal(String s) {
        //LOG.info("Adding appeal in Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().createAppeal(AppealRepresentation.fromXmlString(s).getAppeal(),new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(responseRepresentation).build();
        } 
        catch (InvalidAppealException iae) {
            //LOG.debug("Invalid appeal in the XML representation {}", s);
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists.");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while adding appeal.");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response {}", response);
       return response;
    }
    
    @PUT
    @Path("SubmitAppeal/{studentId}")
    @Produces("application/vnd-appeals+xml")
    @Consumes("application/vnd-appeals+xml")
    public Response SubmitAppeal(String s) {
        //LOG.info("Submitting an Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().submitAppeal(new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(responseRepresentation).build();
        }  
        catch (InvalidAppealException iae) {
            //LOG.debug("Invalid appeal in the XML representation {}", s);
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }  
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists.");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch(UpdateAppealException ue) {
            //LOG.debug("Problem updating the appeal resource");
            response = Response.status(Response.Status.CONFLICT).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while submitting appeal.");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response {}", response);
       return response;
    }
    
    
    @PUT
    @Path("UpdateAppealRemarks/{studentId}")
    @Produces("application/vnd-appeals+xml")
    @Consumes("application/vnd-appeals+xml")
    public Response UpdateAppealRemarks(String s) {
        //LOG.info("Updating AppealRemarks in Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().updateAppealRemarks(AppealRepresentation.fromXmlString(s).getAppeal(),new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(responseRepresentation).build();
        }  
        catch (InvalidAppealException iae) {
            //LOG.debug("Invalid appeal in the XML representation {}", s);
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists.");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch(UpdateAppealException ue) {
            //LOG.debug("Problem updating the appeal resource");
            response = Response.status(Response.Status.CONFLICT).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while adding AppealRemarks to the appeal");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response {}", response);
        return response;
    }
    
    @PUT
    @Path("FollowUp/{studentId}")
    @Produces("application/vnd-appeals+xml")
    @Consumes("application/vnd-appeals+xml")
    public Response FollowUp(String s) {
        //LOG.info("Updating followUp in Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().updateFollowUp(AppealRepresentation.fromXmlString(s).getAppeal(),new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(responseRepresentation).build();
        } 
        catch (InvalidAppealException iae) {
            //LOG.debug("Invalid appeal in the XML representation {}", s);
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists. ");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch(UpdateAppealException ue) {
            //LOG.debug("Problem updating the appeal resource");
            response = Response.status(Response.Status.CONFLICT).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while adding followup comments to the appeal");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response {}", response);
        return response;
    }
    
    @PUT
    @Path("RemarksByProf/{studentId}")
    @Produces("application/vnd-appeals+xml")
    @Consumes("application/vnd-appeals+xml")
    public Response RemarksByProf(String s) {
        //LOG.info("Updating  RemarksByProf in Appeal Resource");
        Response response;
        try {
            AppealRepresentation responseRepresentation = new Activity().updateRemarksByProf(AppealRepresentation.fromXmlString(s).getAppeal(),new RestAppealUri(uriInfo.getRequestUri()));
            response = Response.status(Response.Status.OK).entity(responseRepresentation).build();
        } 
        catch (InvalidAppealException iae) {
            //LOG.debug("Invalid appeal in the XML representation {}", s);
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch(NoSuchAppealException ex){
            //LOG.debug("No such appeal exists.");
            response = Response.status(Response.Status.NOT_FOUND).build();
        }
        catch(UpdateAppealException ue) {
            //LOG.debug("Problem updating the appeal resource");
            response = Response.status(Response.Status.CONFLICT).build();
        }
        catch (Exception ex) {
            //LOG.debug("Something went wrong while adding remarks by prof to the appeal");
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        //LOG.debug("Resulting response {}", response);
        return response;
    }
}
