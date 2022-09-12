package edu.udea.empresaweb.empresa.controllers;



import edu.udea.empresaweb.empresa.entities.Transaction;
import edu.udea.empresaweb.empresa.services.transactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController

    public class TransactionController {
    @Autowired
    transactionServices service;
    
    public TransactionController( transactionServices service){
        this.service = service;
    }

    @GetMapping("/enterprises/{id}/movements")
    public List<Transaction> getAllTransaction(@PathVariable("id") long id){
        return this.service.getAllTransaction(id);
    }

    @GetMapping("/enterprises/{id}/movements/{idM}")
    public Transaction getTransaction(@PathVariable("idM") long idM){
        return (Transaction) this.service.getTransaction(idM);
    }

    @PostMapping("/enterprises/{id}/movements")
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return this.service.createTransaction(transaction);
    }

    @PutMapping
    @ExceptionHandler
    public Transaction updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction){
        return this.service.updateTransaction(id, transaction);
    }


    @PatchMapping("/enterprises/{id}/movements")
    public Transaction patchTransaction(@PathVariable("id") Long id, @RequestBody Map<Object, Object> objectMap){
        return this.service.patchTransaction(id, objectMap);
    }



    @DeleteMapping("/enterprises/{id}/movements")
    public Boolean deleteEnterprise(@PathVariable("id") long id) {
        return this.service.deleteEnterprise(id);
    }

}





