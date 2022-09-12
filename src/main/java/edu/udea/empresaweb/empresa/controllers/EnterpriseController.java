package edu.udea.empresaweb.empresa.controllers;

import edu.udea.empresaweb.empresa.entities.Enterprise;
import edu.udea.empresaweb.empresa.services.enterpriseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
    public class EnterpriseController {
    @Autowired
    enterpriseServices service;

    public EnterpriseController( enterpriseServices service){
        this.service = service;
    }

    @GetMapping("/enterprises")
    public List<Enterprise> getEnterprise(){
        return this.service.getEnterprises();
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise getEnterprise(@PathVariable("id") long id){
        return this.service.getEnterprise(id);
    }

    @PostMapping("/enterprises")
    public Enterprise createEnterprise(@RequestBody Enterprise enterprise){
        return this.service.createEnterprise(enterprise);
    }

    @PutMapping("/enterprises/{id}")
    @ExceptionHandler
    public Enterprise updateEnterprise(@PathVariable("id") long id, @RequestBody Enterprise enterprise){
        return this.service.updateEnterprise(id, enterprise);
    }


    @PatchMapping("/enterprises/{id}")
    public Enterprise patchEnterprise(@PathVariable("id") Long id, @RequestBody Map<Object, Object> objectMap){
        return this.service.patchEnterprise(id, objectMap);
    }



    @DeleteMapping("/enterprises/{id}")
    public Boolean deleteEnterprise(@PathVariable("id") long id) {
        return this.service.deleteEnterprise(id);
    }

}























