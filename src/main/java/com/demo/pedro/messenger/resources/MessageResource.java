package com.demo.pedro.messenger.resources;

import java.util.ArrayList;

import com.demo.pedro.messenger.model.Message;
import com.demo.pedro.messenger.service.MessageService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id );
//		return "get path param : "+messageId;
	}

}
