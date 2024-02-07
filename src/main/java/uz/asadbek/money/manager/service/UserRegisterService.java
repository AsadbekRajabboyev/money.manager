package uz.asadbek.money.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.asadbek.money.manager.models.User;
import uz.asadbek.money.manager.repositories.UserRepo;

@Service
@Transactional(readOnly = true)
public class UserRegisterService {
	private final UserRepo userRepo;
	@Autowired
	public UserRegisterService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	@Transactional
	public void save(User user){
		 userRepo.save(user);
	}


}
