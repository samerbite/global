package cl.globallogic.demo.repository;

import cl.globallogic.demo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {}
