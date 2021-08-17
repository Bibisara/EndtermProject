package controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("users")
public class UserController {
    @GET
    public String sayHello(){
        return "Hello world!";
    }
}
