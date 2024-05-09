package com.prueba.capitole.infrastructure.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prueba.capitole.infrastructure.entity.PriceEntity;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
	
	@Query("SELECT p.idBrand, p.idproduct, p.startdate, p.enddate, MAX(p.priority), p.price, p.curr FROM prices p WHERE p.idBrand = :brandId AND p.idproduct = :idProduct AND p.startdate <= :fechaApp AND p.enddate >= :fechaApp GROUP BY p.priority")
	Optional<PriceEntity> findPrice(@Param("brandId") String idcadena, @Param("idProduct") String idProducto, @Param("fechaApp") LocalDateTime fechaApp);
}
