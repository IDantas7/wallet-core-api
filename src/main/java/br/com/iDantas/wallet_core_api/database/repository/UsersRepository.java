package br.com.iDantas.wallet_core_api.database.repository;

import br.com.iDantas.wallet_core_api.database.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findById(Long id);
}
