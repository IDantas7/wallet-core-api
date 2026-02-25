package br.com.iDantas.wallet_core_api.database.repository;

import br.com.iDantas.wallet_core_api.dto.UsersRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersRequest,Integer> {
    Optional<UsersRequest> findById(Long id);
}
