package br.com.clinica.controllers;

public interface PaymentController<TItem> {
	String getTitle();
	void paymentFinished(boolean status, TItem item);
}