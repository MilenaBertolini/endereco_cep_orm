package iftm.orm.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iftm.orm.endereco.model.EnderecoEspecifico;

@Repository
public interface EnderecoEspecificoRepository extends JpaRepository<EnderecoEspecifico, Long>{
    
}
