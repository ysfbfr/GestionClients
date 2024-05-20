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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.Data;
import webAppSpringMvc.dao.Produit;
import webAppSpringMvc.service.GestionProduit;




@Controller
@Data
@RequiredArgsConstructor
public class ProduitController {

    private final GestionProduit gp;

    @GetMapping("/ProduitList")
    public String getHome(Model model , @RequestParam (defaultValue = "0") int numpage) {
        Page<Produit> maList = gp.listerProduit(PageRequest.of(numpage, 5));
        model.addAttribute("totalpage" , maList.getTotalPages());
        model.addAttribute("currentpage", numpage);
        model.addAttribute("maliste",maList);
        System.out.println(maList);
        return "ProduitList";
    }


    @GetMapping("/ajouterProduit")
    public String showAddProduitForm(Model model) {
        model.addAttribute("produit", new Produit()); // Add an empty Client object to the model
        return "Add_Produit"; // Return the name of the Thymeleaf template for add-client page
    }

    @PostMapping("/save-produit")
    public String saveProduit(@Valid Produit p, BindingResult br) {
        if (br.hasErrors()) {
            return "ajouterProduit";
        } else {
            gp.ajouterProduit(p);
            return "ProduitList";
        }

    }

    @PostMapping("/delete-produit")
    public String deleteProduit(@RequestParam("id_produit") Integer id_produit) {
        gp.supprimerProduit(id_produit);

        // Redirect back to the home page after deleting the client
         return "redirect:/ProduitList";
    }

}
