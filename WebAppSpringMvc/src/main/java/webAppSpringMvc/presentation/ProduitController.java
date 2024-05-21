package webAppSpringMvc.presentation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.Data;
import webAppSpringMvc.dao.Client;
import webAppSpringMvc.dao.Produit;
import webAppSpringMvc.service.GestionProduit;




@Controller
@Data
@RequiredArgsConstructor
public class ProduitController {

    private final GestionProduit gp;

    @GetMapping("/ProduitList")
    public String getProduitList(Model model , @RequestParam (defaultValue = "0") int numpage) {
        Page<Produit> maList = gp.listerProduit(PageRequest.of(numpage, 5));
        model.addAttribute("totalpage" , maList.getTotalPages());
        model.addAttribute("currentpage", numpage);
        model.addAttribute("maliste",maList);
        System.out.println(maList);
        return "ProduitList";
    }


    @GetMapping("/Add_Produit")
    public String showAddProduitForm(Model model) {
        model.addAttribute("produit", new Produit()); // Add an empty Client object to the model
        return "Add_Produit"; // Return the name of the Thymeleaf template for add-client page
    }

    @PostMapping("/save-produit")
    public String saveProduit(@Valid Produit p, BindingResult br) {
        if (br.hasErrors()) {
            return "Add_Produit";
        } else {
            gp.ajouterProduit(p);
            return "redirect:/ProduitList";
        }

    }

    @GetMapping("/delete-produit/{id_produit}")
    public String deleteProduit(@PathVariable("id_produit") int id_produit) {
        gp.supprimerProduit(id_produit);
        return "redirect:/ProduitList";
    }



    @GetMapping("/edit-produit/{id_produit}")
    public String showEditProduitForm(@PathVariable("id_produit") Integer id_produit, Model model) {
        try {
          Produit produit = gp.getProduitById(id_produit);
        model.addAttribute("produit", produit);
            return "modifier-produit"; // Le nom du template Thymeleaf pour le formulaire de modification
        } catch (Exception e) {
            // Gérer le cas où le client n'est pas trouvé
            return "redirect:/ProduitList";
        }
    }

    @PostMapping("/update-produit")
    public String updateProduit(@Valid Produit produit, BindingResult result) {
        if (result.hasErrors()) {
            return "modifier-produit"; // Retourne le formulaire avec les erreurs de validation
        }
        gp.modifierClient(produit);
        return "redirect:/ProduitList"; // Redirige vers la page d'accueil après la modification du client
    }


}
