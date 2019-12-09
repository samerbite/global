package cl.globallogic.demo.repository;

import cl.globallogic.demo.model.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface usuariosRepository extends JpaRepository<usuarios, String> {}
