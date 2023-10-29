package com.edu.cibertec.DSW_CL2_GALINDO.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private  String descripcion;
    @Column(name = "cantidad")
    private  Integer cantidad;
    @Column(name = "fechavencimiento")
    private Date fechavencimiento;

}
