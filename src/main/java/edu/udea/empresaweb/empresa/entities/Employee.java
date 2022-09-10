package edu.udea.empresaweb.empresa.entities;

import javax.persistence.*;

import lombok.Data;

import java.time.LocalDate;
//import java.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    //@NotNull(message = "Debe ingresar un email")
    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
    @JoinColumn(name = "Idprofile")
    private Profile profile;
    
    //@NotNull(message = "El rol del empleado puede ser Admin u operario")
    @Column(name = "role")
    private Enum_RoleName role;
    
    @Column(name = "createdAt")
    private LocalDate createdAt;
    
    @Column(name = "updatedAt")
    private LocalDate updateAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;

   

    
}
