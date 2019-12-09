package cl.globallogic.demo.repository;

import cl.globallogic.demo.model.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface findUsuarios extends JpaRepository<usuarios, String> {
    usuarios findByEmail(final String email);
}
