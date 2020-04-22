package pro;

public class proRequest {
	private String cpf;
	private String paymentMethod;
	private String name;
	private String lastName;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void newProRequest(String cpf,String paymentMethod,String name,String lastName) {
		setCpf(cpf);
		setPaymentMethod(paymentMethod);
		setName(name);
		setLastName(lastName);
		proUsers.newProUser();
	}
}
