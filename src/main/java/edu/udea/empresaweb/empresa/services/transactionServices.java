package edu.udea.empresaweb.empresa.services;



import edu.udea.empresaweb.empresa.entities.Transaction;
import edu.udea.empresaweb.empresa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
    public class transactionServices {
    private TransactionRepository transactionRepository;

    public transactionServices(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransaction(long id){
        return this.transactionRepository.findAll();
    }

    public Transaction getTransaction(Long id){
        Optional<Transaction> transaction = this.transactionRepository.findById(id);
        return transaction.orElse(null);
    }

    public Transaction createTransaction(Transaction transaction){
        return this.transactionRepository.save(transaction);
    }


    public Transaction updateTransaction(Long id, Transaction transaction){
        Optional<Transaction> dbData = this.transactionRepository.findAllById(id);

        if(dbData.isPresent()){
            Transaction e = dbData.get();
            e.setConcept(transaction.getConcept());
            e.setAccount(transaction.getAccount());
            e.setEmployee(transaction.getEmployee());
            e.setEnterprise(transaction.getEnterprise());
            e.setCreatedAt(transaction.getCreatedAt());
            e.setUpdatedAt(transaction.getUpdatedAt());
            this.transactionRepository.save(e);
            return e;
        }
        return null;
    }


    public Transaction patchTransaction(Long id, Map<Object, Object> objectMap) {
        Transaction transaction = transactionRepository.findById(id).get();
        objectMap.forEach((key, value)->{
            Field field = ReflectionUtils.findField(Transaction.class, (String) key);;
            field.setAccessible(true);
            ReflectionUtils.setField(field, transaction, value);
        });
        return transactionRepository.save(transaction);
    }

    public Boolean deleteTransaction(Long id){
        try{
            this.transactionRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}



