package uz.asadbek.money.manager.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class UserLoginDTO {
	@NotEmpty(message = "Login kiritilmadi!")
	private String login;
	@NotEmpty(message = "Parol kiritilmadi!")
	private String password;

	public UserLoginDTO(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public UserLoginDTO() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
