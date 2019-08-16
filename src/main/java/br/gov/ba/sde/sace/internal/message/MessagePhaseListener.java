package br.gov.ba.sde.sace.internal.message;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.gov.ba.sde.sace.internal.util.Beans;
import br.gov.ba.sde.sace.internal.util.Faces;

public class MessagePhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	
	public void beforePhase(PhaseEvent e) {
		transferMessages(e);
	}

	public void afterPhase(PhaseEvent e) {
		
	}

	private void transferMessages(PhaseEvent e) {
		MessageContext messageContext = Beans.getReference(MessageContext.class);
		Faces.addMessages(messageContext.getMessages());
		messageContext.clear();
	}

	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
