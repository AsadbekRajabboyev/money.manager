package uz.asadbek.money.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.asadbek.money.manager.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
