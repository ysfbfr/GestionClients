package webAppSpringMvc.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.Data;
import webAppSpringMvc.dao.Client;
import webAppSpringMvc.service.GestionClient;




@Controller
@Data
@RequiredArgsConstructor
public class ClientController
{

	private final GestionClient gc;


	/*@GetMapping("/home")
	public String getHome(Model model , @RequestParam (defaultValue = "0") int numpage) {
		Page<Client> maList = gc.listerClient(PageRequest.of(numpage, 5));
		model.addAttribute("totalpage" , maList.getTotalPages());
		model.addAttribute("currentpage", numpage);
		model.addAttribute("maliste",maList);
		System.out.println(maList);
		return "index";
	}*/
	@GetMapping("/home")
	public String getHome(Model model, @RequestParam(defaultValue = "0") int numpage) {
		Page<Client> maList = gc.listerClient(PageRequest.of(numpage, 5));
		model.addAttribute("totalpage", maList.getTotalPages());
		model.addAttribute("currentpage", numpage);
		model.addAttribute("maliste", maList);
		System.out.println(maList);
		return "index";
	}

	@GetMapping("/add-client")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client()); // Add an empty Client object to the model
        return "add-client"; // Return the name of the Thymeleaf template for add-client page
    }


	@PostMapping("/save-client")
	public String saveClient(@Valid Client  c , BindingResult br)  {
		if(br.hasErrors())
			{
			return "add-client";
			}
		else {
			gc.ajouterClient(c);
			return "redirect:/home";
		}
	}
	/*@GetMapping("/edit-client/{id}")
	public String showEditClientForm(@PathVariable("id") Integer id, Model model) {
		try {
			Client client = gc.getClientById(id);
			model.addAttribute("client", client);
			return "edit-client"; // Le nom du template Thymeleaf pour le formulaire de modification
		} catch (Exception e) {
			// Gérer le cas où le client n'est pas trouvé
			return "redirect:/home";
		}*/

	/*@PostMapping("/update-client")
	public String updateClient(@Valid @ModelAttribute("client") Client client, BindingResult result) {
		if (result.hasErrors()) {
			return "edit-client";
		}
		gc.modifierClient(client);
		return "redirect:/home";
	}

	@PostMapping("/modifier-client")
	public String updateClient(@Valid Client c ,Integer Id, BindingResult br) throws Exception
	{
		if(br.hasErrors())
		{
			return "modifier-client";
		}
		else{
			Client client=gc.getClientById(Id);
			return "index";
		}
	}
*/
	@GetMapping("/delete-client/{id}")
	public String deleteClient(@PathVariable("id") Integer id) {
		gc.supprimerClient(id);
		return "redirect:/home";
	}
	@GetMapping("/edit-client/{id}")
	public String showEditClientForm(@PathVariable("id") Integer id, Model model) {
		try {
			Client client = gc.getClientById(id);
			model.addAttribute("client", client);
			return "modifier-client"; // Le nom du template Thymeleaf pour le formulaire de modification
		} catch (Exception e) {
			// Gérer le cas où le client n'est pas trouvé
			return "redirect:/home";
		}
	}

	@PostMapping("/update-client")
	public String updateClient(@Valid Client client, BindingResult result) {
		if (result.hasErrors()) {
			return "modifier-client"; // Retourne le formulaire avec les erreurs de validation
		}
		gc.modifierClient(client);
		return "redirect:/home"; // Redirige vers la page d'accueil après la modification du client
	}


}