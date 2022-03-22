package com.demo.pedro.messenger.resources;

import java.util.List;

import com.demo.pedro.messenger.model.Message;
import com.demo.pedro.messenger.resources.beans.MessageFilterBean;
import com.demo.pedro.messenger.service.MessageService;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean fileterBean) {
		if (fileterBean.getYear() > 0) {
			return messageService.getAllMessageForYear(fileterBean.getYear());
		}
		if (fileterBean.getStart() > 0 && fileterBean.getSize() > 0) {
			return messageService.getAllMessagesPabinated(fileterBean.getStart(), fileterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@POST
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long id) {
		return messageService.getMessage(id);
//		return "get path param : "+messageId;
	}

}
