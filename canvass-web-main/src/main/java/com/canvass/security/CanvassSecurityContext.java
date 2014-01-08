package com.canvass.security;

import com.canvass.data.model.Account;
import com.canvass.data.model.WebSession;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;


public class CanvassSecurityContext implements SecurityContext {
    private final Account account;
    private final WebSession session;
 
    public CanvassSecurityContext(Account account, WebSession session) {
        this.session = session;
        this.account = account;
    }
    
	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

	@Override
	public Principal getUserPrincipal() {
		return account;
	}

	@Override
	public boolean isSecure() {
		return (null != session) ? session.isSecure() : false;
	}

	@Override
	public boolean isUserInRole(String role) {
        if (null == session || !session.isActive()) {
            // Forbidden
            Response denied = Response.status(Response.Status.FORBIDDEN).entity("Permission Denied").build();
            throw new WebApplicationException(denied);
        }
 
        try {
            // this user has this role?
            return account.getRole().equals(Account.Role.valueOf(role));
        } catch (Exception e) {
        }
         
        return false;
	}

}
