package br.com.clinica.controllers;

import java.util.List;

public interface SelectionController<TItem> {
	String getTitle();
	String getLabel();
	String getBtnText();
	List<TItem> getElements();
    void selectedElement(TItem item);
}