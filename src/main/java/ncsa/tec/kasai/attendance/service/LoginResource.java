/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncsa.tec.kasai.attendance.service;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import ncsa.tec.kasai.attendance.bean.UserFacade;

/**
 * REST Web Service
 *
 * @author kasai
 */
@Path("login")
public class LoginResource {

    @EJB
    UserFacade userFacade;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    @POST
    @Produces("application/json")
    public String postJson(@FormParam("username") String username, 
            @FormParam("password") String password) {
//        try {
//            request.login(userId, password);
//        } catch (ServletException ex) {
//            Logger.getLogger(LoginResource.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        if (userFacade.isAuth(username, password)) {
            return "ログインしました";
        }
        return "ログインに失敗しました" ;
    }


    /**
     * Retrieves representation of an instance of ncsa.tec.kasai.attendance.service.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
