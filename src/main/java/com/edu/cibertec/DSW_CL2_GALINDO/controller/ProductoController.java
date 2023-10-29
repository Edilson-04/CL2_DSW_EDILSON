package com.edu.cibertec.DSW_CL2_GALINDO.controller;


import com.edu.cibertec.DSW_CL2_GALINDO.exception.ResourceNotFoundException;
import com.edu.cibertec.DSW_CL2_GALINDO.model.bd.Producto;
import com.edu.cibertec.DSW_CL2_GALINDO.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/cl2/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping("")
    public ResponseEntity<List<Producto>> listarProducto(){
        List<Producto> categoriaList = new ArrayList<>();
        //obtener lo de categorias para ponerlo en el arreglo
        productoService.listarProducto().forEach(categoriaList::add);
        if (categoriaList.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(categoriaList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Producto> obtenerProducto(@PathVariable("id") Integer id){
        Producto categoria = productoService.obtenerProductoPorId(id)
                .orElseThrow(() ->new ResourceNotFoundException("El producto  " + id + "No existe"));

        return  new ResponseEntity<>(categoria,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto categoria){
        return  new ResponseEntity<>(productoService.guardarProducto(categoria),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable("id") Integer id,
            @RequestBody Producto producto) {

        Producto oldProducto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() ->new ResourceNotFoundException("El producto   " + id + "No existe"));

        oldProducto.setNombre(producto.getNombre());
        oldProducto.setDescripcion(producto.getDescripcion());

        return new ResponseEntity<>(productoService.guardarProducto(oldProducto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(
            @PathVariable("id") Integer id) {
        try {
            productoService.eliminarProductoPorId(id);
            return new ResponseEntity<>("Producto eliminado con ID: " + id, HttpStatus.OK);
        } catch (ResourceNotFoundException exception) {
            return new ResponseEntity<>("Producto no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>("Error al eliminar el producto con ID: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }








}
