package iftm.orm.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iftm.orm.endereco.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String>{

    
} 
