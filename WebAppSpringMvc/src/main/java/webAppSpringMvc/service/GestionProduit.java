package webAppSpringMvc.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import webAppSpringMvc.dao.Produit;
@Data
@Service
@RequiredArgsConstructor

public class GestionProduit {


    @Autowired
    private IGestionProduit gp;

    public void ajouterProduit(Produit p) {
        gp.save(p);
    }


    public void supprimerProduit(Integer id_produit) {

        gp.deleteById(id_produit);

    }


    public Page<Produit> listerProduit(Pageable pageable) {
        return gp.findAll(pageable);
    }


    public void modifierClient(Produit p) {
        gp.save(p);

    }
}