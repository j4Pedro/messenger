package com.demo.pedro.messenger.exception;

import com.demo.pedro.messenger.model.ErrorMessage;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),500,"GenericException-https://www.google.com.tw/");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}

}