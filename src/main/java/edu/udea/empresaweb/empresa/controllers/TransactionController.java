package edu.udea.empresaweb.empresa.controllers;



import edu.udea.empresaweb.empresa.entities.Transaction;
import edu.udea.empresaweb.empresa.services.transactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/enterprises/{id}/movements")

    public class TransactionController {
    @Autowired
    transactionServices service;
    
    public TransactionController( transactionServices service){
        this.service = service;
    }

    @GetMapping
    public List<Transaction> getAllTransaction(@PathVariable("idM") long id){
        return this.service.getAllTransaction(id);
    }

    @GetMapping(value = "/{idM}")
    public Transaction getTransaction(@PathVariable("idM") long idM){
        return (Transaction) this.service.getTransaction(idM);
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return this.service.createTransaction(transaction);
    }

    @PutMapping
    @ExceptionHandler
    public Transaction updateTransaction(@PathVariable("idM") long id, @RequestBody Transaction transaction){
        return this.service.updateTransaction(id, transaction);
    }


    @PatchMapping(value = "/{idM}")
    public Transaction patchTransaction(@PathVariable("idM") Long id, @RequestBody Map<Object, Object> objectMap){
        return this.service.patchTransaction(id, objectMap);
    }



    @DeleteMapping(value = "/{idM}")
    public Boolean deleteTransaction(@PathVariable("idM") long id) {
        return this.service.deleteTransaction(id);
    }

}





