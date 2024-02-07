package uz.asadbek.money.manager.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.asadbek.money.manager.DTO.UserRegisterDTO;
import uz.asadbek.money.manager.models.User;
import uz.asadbek.money.manager.service.UserRegisterService;
import uz.asadbek.money.manager.util.UserNotCreatedExeption;

import java.util.List;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	private final ModelMapper modelMapper;
	private final UserRegisterService userRegisterService;

	@Autowired
	public AuthController(ModelMapper modelMapper, UserRegisterService userRegisterService) {
		this.modelMapper = modelMapper;
		this.userRegisterService = userRegisterService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegisterDTO userRegisterDTO,
	                                           BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuilder stringBuilder = new StringBuilder();
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				stringBuilder.append(fieldError.getField())
						.append("-")
						.append(fieldError.getDefaultMessage())
						.append(";");
			}
			throw new UserNotCreatedExeption(stringBuilder.toString());
		}
		userRegisterService.save(convertToUser(userRegisterDTO));
		return new ResponseEntity<>("Muaffaqiyatli qo'shildi", HttpStatus.CREATED);
	}

	private User convertToUser(UserRegisterDTO userRegisterDTO) {
		return modelMapper.map(userRegisterDTO, User.class);
	}
}
