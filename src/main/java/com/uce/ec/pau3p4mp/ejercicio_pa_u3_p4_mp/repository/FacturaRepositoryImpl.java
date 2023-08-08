package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.Factura;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Transactional 
@Repository
public class FacturaRepositoryImpl implements IFacturaRepository{

    @Autowired 
    EntityManager entityManager;



    @Override
    public void crear(Factura factura) {
       entityManager.persist(factura);
    }
    
}
