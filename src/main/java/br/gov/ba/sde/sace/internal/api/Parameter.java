package br.gov.ba.sde.sace.internal.api;

import javax.faces.convert.Converter;

public interface Parameter<T> {

	void setValue(T value);

	String getKey();

	T getValue();

	Converter getConverter();
}
