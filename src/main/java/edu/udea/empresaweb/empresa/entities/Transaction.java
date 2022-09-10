package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "Transaction")
public class Transaction {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "concept")
    private String concept;
    
    @Column(name = "account")
    private Long account;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;
    //@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    //private List<Employee> user;

    @ManyToOne
    @JoinColumn(name = "id_enterprise")
    private Enterprise enterprise;
    
    @Column(name = "createdAt")
    private LocalDate createdAt;
    
    @Column(name = "updatedAt")
    private LocalDate updatedAt;

    

    
}
