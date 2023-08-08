package com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.ec.pau3p4mp.ejercicio_pa_u3_p4_mp.repository.model.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

    @Autowired
    EntityManager entityManager;

    @Override
    public void crear(Producto producto) {
        this.entityManager.persist(producto);
    }

    @Override
    public Producto leer(String codigoBarras) {

        String jpql = "select p from Producto p where p.codigoBarras = :datoCodigo";
        TypedQuery<Producto> query = entityManager.createQuery(jpql, Producto.class);

        query.setParameter("datoCodigo", codigoBarras);

        return query.getSingleResult();
    }

    @Override
    public void actualizar(Producto producto) {
        entityManager.merge(producto);
    }
    
}
