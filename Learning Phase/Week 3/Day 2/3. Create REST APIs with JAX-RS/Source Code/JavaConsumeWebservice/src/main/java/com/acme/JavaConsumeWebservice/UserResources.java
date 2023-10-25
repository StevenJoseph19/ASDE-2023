package com.acme.JavaConsumeWebservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("users")
public class UserResources 
{
	UserRepository urr = new UserRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser()
	{
		return urr.displayUser();
	}
	
	@POST
	@Path("createuser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces( MediaType.APPLICATION_JSON)
	public User create(User u)
	{
		System.out.println("here...");
		urr.createUser(u);
		return u;
	}
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getSpecificUser(@PathParam("id") int id)
	{
		return urr.getUserId(id);
	}
	
	@PUT
	@Path("updateuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public User update(User u)
	{
		urr.updateUser(u);
		return u;
	}
	
	@DELETE
	@Path("user/{id}")
	public User kill(@PathParam("id") int id)
	{
		User user = urr.getUserId(id);
		
		urr.deleteUser(id);
		
		return user;
	}
}
