package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Enterprise")
public class Enterprise {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "document")
    private String document;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "address")
    private String address;
    
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> users;
    
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List <Transaction> transactions;
    
    @Column(name = "createdAt")
    private LocalDate createdAt;
    
    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    

    
}
