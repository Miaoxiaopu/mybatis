package com.soft863.www.bean;

public class StudentCard {
	private int cardId;
	private String cardInfo;

	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getCardInfo() {
		return cardInfo;
	}
	public void setCardInfo(String cardInfo) {
		this.cardInfo = cardInfo;
	}
	@Override
	public String toString() {
		return "StudentCard [cardId=" + cardId + ", cardInfo=" + cardInfo + "]";
	}
	
	
}
