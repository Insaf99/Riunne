package com.example.Riunne.Servicio;

import com.example.Riunne.Dominio.Articulo;
import com.example.Riunne.Repository.ArticuloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService{

    /* transactional es para iniciar una nueva transaccion
    * si es que no existe alguna con la base de datos
    * ponerle el readOnly solo hace un select en la base de datos*/

    @Autowired
    private ArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        return (List<Articulo>) articuloDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void eliminar(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo encontrarArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getId_articulo()).orElse(null);
    }

}
