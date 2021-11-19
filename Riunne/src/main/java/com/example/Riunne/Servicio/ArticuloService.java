package com.example.Riunne.Servicio;

import com.example.Riunne.Dominio.Articulo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ArticuloService {

    public List<Articulo> listarArticulos();

    public void guardar(Articulo articulo);

    public void eliminar(Articulo articulo);

    public Articulo encontrarArticulo(Articulo articulo);

}
