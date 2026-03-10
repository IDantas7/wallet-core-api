package br.com.iDantas.wallet_core_api.database.repository;

import br.com.iDantas.wallet_core_api.database.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findById(Integer id);



    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);

}
