package br.gov.ba.sde.sace.internal.message;

import java.io.Serializable;

public interface Message extends Serializable {

	String getText();
	SeverityType getSeverity();
	
}
