package com.tcg.huespedes.repository;

import com.tcg.huespedes.model.Huesped;
import com.tcg.commons.enums.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface HuespedRepository extends JpaRepository<Huesped, Long> {

    Optional<Huesped> findByNumeroDocumento(String numeroDocumento);

    List<Huesped> findByTipoDocumento(TipoDocumento tipoDocumento);

    Optional<Huesped> findByNumeroDocumentoAndTipoDocumento(String numeroDocumento, TipoDocumento tipoDocumento);

    boolean existsByNumeroDocumento(String numeroDocumento);
}
