package uz.asadbek.money.manager.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class UserRegisterDTO {
	@NotEmpty(message = "Ism bo'sh kiritildi!")
	@Size(min = 2, max = 30,message = "Ism 2dan 30gacha harfdan iborat bo'lishi kerak!")
	private String name;
	@NotEmpty(message = "Familiya bo'sh kiritildi!")
	@Size(min = 2, max = 30,message = "Ism 2dan 30gacha harfdan iborat bo'lishi kerak!")
	private String surname;

	@NotEmpty(message = "Login bo'sh kiritildi!")
	@Size(min = 2, max = 30,message = "Login 2dan 30gacha harfdan iborat bo'lishi kerak!")
	private String login;
	@NotEmpty(message = "Parol bo'sh kiritildi!")
	@Size(min = 5, max = 15,message = "Parol 5dan 15gacha belgidan iborat bo'lishi kerak!")
	private String password;
	@NotEmpty(message = "Parol bo'sh kiritildi!")
	@Size(min = 5, max = 15,message = "Parol 5dan 15gacha belgidan iborat bo'lishi kerak!")
	private String confirmPassword;

	public boolean isValid() {
		return password != null && password.equals(confirmPassword);
	}
}
