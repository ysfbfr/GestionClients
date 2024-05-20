package webAppSpringMvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import webAppSpringMvc.dao.Produit;


@Repository
public interface IGestionProduit extends JpaRepository<Produit, Integer>
{

}
