
package com.janetca.portfinal.Security.Repository;

import com.janetca.portfinal.Security.Entity.Rol;
import com.janetca.portfinal.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
