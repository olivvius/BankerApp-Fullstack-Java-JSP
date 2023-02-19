package fr.m2i.spring.controller;

import fr.m2i.spring.Service.ClientService;
import fr.m2i.spring.Service.LinesService;
import fr.m2i.spring.model.Client;
import java.util.List;
import fr.m2i.spring.model.Lines;
import fr.m2i.spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.validation.BindingResult;
import fr.m2i.spring.repository.LinesRepository;

@Controller
public class LinesController {

    //Attribut de la classe
    private LinesRepository linesRepository;
    private LinesService linesService;
    private ClientService clientService;
    private ClientRepository clientRepository;

    //Injection des dépendences
    @Autowired
    public LinesController(LinesRepository linesRepository, LinesService linesService, ClientRepository clientRepository, ClientService clientService) {
        this.linesRepository = linesRepository;
        this.linesService = linesService;
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    // routage pour l'affichage de l'index
    @GetMapping("/")
    public String root() {
        return "index";
    }
    
        // routage pour l'affichage de l'index
    @GetMapping("/index")
    public String root2() {
        return "index";
    }

    // routage pour l'affichage de la liste des prestations
    @GetMapping("/list-lines")
    public String getLinesList(ModelMap model) {
        return "list-lines";
    }


    
    //recuperation de liste des prestations et injection dans un attribut de model
    @ModelAttribute("listLines")
    public List<Lines> listlines() {
        List<Lines> lignes = linesService.findAll();
       // System.out.println(lignes.getClass().getSimpleName());
        return lignes;
    }
       
      // liste des lignes par client 
        @GetMapping("/list-lines-client")
    public String getLinesListClient(@RequestParam("id") int id, ModelMap model) {
        Client client = clientService.findById(id);
        String nom = client.getNom()+ " " + client.getPrenom() ;
        model.addAttribute("nom", nom); 
        List<Lines> lignes = linesRepository.findByClient(client);
        Double solde = 0.00;
        for(int i=0;i<lignes.size();i++){
            solde += lignes.get(i).getMontant();
        }
        model.addAttribute("solde", solde);
        model.addAttribute("listLinesClient", lignes);
       // System.out.println(lignes.getClass().getSimpleName());
        return "list-lines-client";
    }
    /*
    @ModelAttribute("listLinesClient")
    public List<Lines> listlinesClient(Client client) {
        return linesRepository.findByClient(client);
    }
    */
    
        //recuperation de liste des clients et injection dans un attribut de model
    @ModelAttribute("listClients")
    public List<Client> listClients() {
        return clientService.findAll();
    }

    //creation d'une instance de prestation en tant qu'attribut de modele
    @ModelAttribute("delete")
    public Lines delete() {
        return new Lines();
    }

    //routage en POST pour suppression d'une ligne avec redirection vers la liste des lignes actualisée
    @PostMapping("/delete-prestation")
    public String deleteLine(@ModelAttribute("delete") Lines line) {
        linesService.delete(line.getId());
        return "redirect:list-lines";
    }

    //creation d'une instance de prestation en tant qu'attribut de modele
    @ModelAttribute("modify")
    public Lines modify() {
        return new Lines();
    }

    //ajout d'un attribut au modele, la prestation recupérée par son id
    @GetMapping("/modify-line")
    public String modify(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("modify", linesService.findById(id));
        return "modify-line";
    }

    //routage POST, recup  prestation et inejction en BDD, renvoi vers liste prestations reactualisée
    @PostMapping("/modify-line")
    public String modifyLine(@ModelAttribute("modify") @Valid Lines line) {
        /*
        Prestation presta = new Prestation();
        presta.setDescription(prestation.getDescription());
        presta.setEtat(presta.getEtat());
        prestation.setPrix((int) presta.getPrix());
        prestation.setDuree((int) presta.getDuree());
         */
        linesService.create(line);
        return "list-lines";
    }

    //routage GET vers la page d'ajout de prestation et ajout d'une prstation en tant qu'attribut du model
    @GetMapping("/add-line")
    public String addLine(ModelMap model) {
        model.addAttribute("add-line", new Lines());
        
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
    
        return "add-line";
    }

    //routage POST pour recuperer la prstation créée et injection dans la BDD via le service
    @PostMapping("/add-line")
    public String createLine(@ModelAttribute("add-line") @Valid Lines line, BindingResult result) {
        if (result.hasErrors()) {
            return "add-line";
        }
        this.linesService.create(line);

        return "redirect:list-lines";
    }
}
