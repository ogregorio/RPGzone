package com.rpgzonewebrest.dto;

public class InviteReqNewSessionDTO extends InviteDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SessionDTO session;
	public InviteReqNewSessionDTO(Long roomID, SessionDTO session) {
		super(roomID);
		this.session = session;
	}
	
	@Override
	public SessionDTO getSession() {
		return session;
	}

	public void setSession(SessionDTO session) {
		this.session = session;
	}

	
	
	
	
}
