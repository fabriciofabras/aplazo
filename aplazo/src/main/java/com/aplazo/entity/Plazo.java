package com.aplazo.entity;

import java.util.Date;

public class Plazo {

	public Integer getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(Integer paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}



	private Integer paymentNumber;
	private double amount;
	private Date payDate;
}
