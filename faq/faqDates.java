package faq;

public class faqDates {
	public int requests;
	public int solvedRequests;
	
	public int getSatisfactionIndicator() { 
		return requests/solvedRequests;
	}
	
}
