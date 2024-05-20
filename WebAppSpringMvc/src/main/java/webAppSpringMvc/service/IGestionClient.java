package webAppSpringMvc.service;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import webAppSpringMvc.dao.Client;


@Repository
public interface IGestionClient extends JpaRepository<Client, Integer>
{
	
}
