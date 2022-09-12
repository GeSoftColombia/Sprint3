package edu.udea.empresaweb.empresa.services;

import edu.udea.empresaweb.empresa.entities.Enterprise;
import edu.udea.empresaweb.empresa.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class enterpriseServices {
    private EnterpriseRepository enterpriseRepository;

    public enterpriseServices(EnterpriseRepository enterpriseRepository){
        this.enterpriseRepository = enterpriseRepository;
    }

    public List<Enterprise> getEnterprises(){
        return this.enterpriseRepository.findAll();
    }

    public Enterprise getEnterprise(Long id){
        Optional<Enterprise> enterprise = this.enterpriseRepository.findById(id);
        return enterprise.orElse(null);
    }

    public Enterprise createEnterprise(Enterprise enterprise){
        return this.enterpriseRepository.save(enterprise);
    }


    public Enterprise updateEnterprise(Long id, Enterprise enterprise){
        Optional<Enterprise> dbData = this.enterpriseRepository.findAllById(id);

        if(dbData.isPresent()){
            Enterprise e = dbData.get();
            e.setName(enterprise.getName());
            e.setDocument(enterprise.getDocument());
            e.setPhone(enterprise.getPhone());
            e.setAddress(enterprise.getAddress());
            e.setCreatedAt(enterprise.getCreatedAt());
            e.setUpdatedAt(enterprise.getUpdatedAt());
            this.enterpriseRepository.save(e);
            return e;
        }
        return null;
    }


    public Enterprise patchEnterprise(Long id, Map<Object, Object> objectMap) {
        Enterprise enterprise = enterpriseRepository.findById(id).get();
        objectMap.forEach((key, value)->{
            Field field = ReflectionUtils.findField(Enterprise.class, (String) key);;
            field.setAccessible(true);
            ReflectionUtils.setField(field, enterprise, value);
        });
        return enterpriseRepository.save(enterprise);
    }







    public Boolean deleteEnterprise(Long id){
        try{
            this.enterpriseRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
