package webAppSpringMvc.service;

import java.util.List;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import webAppSpringMvc.dao.Client;

@Data
@Service
@RequiredArgsConstructor
public class GestionClient 
{
	@Autowired
	private IGestionClient gc;
    public void ajouterClient (Client c)
	{
	   gc.save(c);
	}
	
	
	
	public void supprimerClient (Integer id)
	{
	  
	   gc.deleteById(id);
	      
	}
	
	
	public Page<Client> listerClient(Pageable pageable) {
	    return gc.findAll(pageable);
	}
	
	
	public void modifierClient (Client c)
	{
		gc.save(c);
		
	}
	
	
	public void searchClient (Integer id)
	{
		gc.findById(id);
	}

	public Client getClientById(int id) throws Exception {
			return gc.findById(id).orElseThrow(()->new Exception("Not found"));
	}
}
