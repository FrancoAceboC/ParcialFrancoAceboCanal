package ar.edu.utn.parcial.futbolmanager.repository;

import ar.edu.utn.parcial.futbolmanager.models.MarketValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketValueRepository extends JpaRepository<MarketValue, Long>, JpaSpecificationExecutor<MarketValue> {

}
