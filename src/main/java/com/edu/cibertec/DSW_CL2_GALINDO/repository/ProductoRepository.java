package com.edu.cibertec.DSW_CL2_GALINDO.repository;

import com.edu.cibertec.DSW_CL2_GALINDO.model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {





}
