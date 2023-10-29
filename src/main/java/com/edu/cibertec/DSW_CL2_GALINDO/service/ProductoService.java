package com.edu.cibertec.DSW_CL2_GALINDO.service;

import com.edu.cibertec.DSW_CL2_GALINDO.model.bd.Producto;
import com.edu.cibertec.DSW_CL2_GALINDO.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoService {

    private ProductoRepository productoRepository;

    public List<Producto> listarProducto(){
        return productoRepository.findAll();
    }
    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }


    public Optional<Producto> obtenerProductoPorId(Integer id){
        Optional<Producto> categoria = productoRepository.findById(id);
        if (categoria.equals(null)){
            return Optional.empty();
        }else
            return categoria;
    }

    public void eliminarProductoPorId(Integer id) {
        // Verificar si el producto existe antes de eliminarlo
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            productoRepository.deleteById(id);
        } else {
            // Manejo si el producto no existe
            throw new RuntimeException("El producto con ID " + id + " no existe.");
        }
    }



}
