package fr.m2i.spring.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Getter
@Setter
@ToString(includeFieldNames = false, of = "nom")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "clients", uniqueConstraints = @UniqueConstraint(columnNames = "nom"))
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotEmpty
    private String nom;

    @Column
    @NotEmpty
    private String prenom;
        
    @Column
    private String adresse;
    
    @Column
    private String zip;
   
    @Column
    private String ville;
    
    @Column
    private String tel;
    
    @Column
    private String mail;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Lines> lines = new ArrayList<>();

    public Client(String nom, String prenom, String adresse, String zip, String ville, String tel, String mail, List<Lines> lines) {
        this.nom = nom;
        this.adresse = adresse;
        this.zip = zip;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
        this.lines = lines;
    }
    
    public Client(String nom, String prenom, String adresse, String zip, String ville, String tel, String mail) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.zip = zip;
        this.ville = ville;
        this.tel = tel;
        this.mail = mail;
    }    
    
    public Client(String nom) {
        this.nom = nom;
    }

}
