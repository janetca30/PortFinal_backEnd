
package com.janetca.portfinal.Repository;

import com.janetca.portfinal.Entity.Redes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RRedes extends JpaRepository<Redes, Integer>{
    Optional<Redes> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
