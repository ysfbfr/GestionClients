package webAppSpringMvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import webAppSpringMvc.dao.Client;
import webAppSpringMvc.dao.Produit;
import webAppSpringMvc.service.GestionClient;
import webAppSpringMvc.service.IGestionClient;
import webAppSpringMvc.service.GestionProduit;
import webAppSpringMvc.service.IGestionProduit;

@SpringBootApplication
public class WebAppSpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(WebAppSpringMvcApplication.class, args);
		
		GestionClient gc = ctx.getBean(GestionClient.class);
		Client c1 = new Client (null , "saad" , "garmes" ,"654 saadrnd kjhzefigz kjjzgekj","0658290472","yboufar6@gmail.com");
		Client c2 = new Client (null , "sadfgad" , "garmes" ,"654 saadrnd kjhzefigz kjjzgekj","0658290472","yboufar6@gmail.com");
		Client c3 = new Client (null , "saad" , "garmes" ,"654 saadrnd kjhzefigz kjjzgekj","0658290472","yboufar6@gmail.com");

		Client c4= new Client (null , "saad" , "garmes" ,"654 saadrnd kjhzefigz kjjzgekj","0658290472","yboufar6@gmail.com");
		Client c5 = new Client (null , "sadfgad" , "garmes" ,"654 saadrnd kjhzefigz kjjzgekj","0658290472","yboufar6@gmail.com");
		Client c6 = new Client (null , "saad" , "garmes" ,"654 saadrnd kjhzefigz kjjzgekj","0658290472","yboufar6@gmail.com");
		gc.ajouterClient (c1);
		gc.ajouterClient (c2);
		gc.ajouterClient (c3);
		gc.ajouterClient (c4);
		gc.ajouterClient (c5);
		gc.ajouterClient(c6);
		GestionProduit gp = ctx.getBean(GestionProduit.class);
		Produit p = new Produit();
		Produit p1 = new Produit (1 , "stylo" , "bic" ,"bleu",2);
		gp.ajouterProduit (p1);
		
		
	}

}
