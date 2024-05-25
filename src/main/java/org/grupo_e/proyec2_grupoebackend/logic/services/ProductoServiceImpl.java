package org.grupo_e.proyec2_grupoebackend.logic.services;

import org.grupo_e.proyec2_grupoebackend.data.dto.ProductoDto;
import org.grupo_e.proyec2_grupoebackend.data.mapper.ProductoMapper;
import org.grupo_e.proyec2_grupoebackend.data.repository.ActividadRepository;
import org.grupo_e.proyec2_grupoebackend.data.repository.ProductoRepository;
import org.grupo_e.proyec2_grupoebackend.logic.ProductoService;
import org.grupo_e.proyec2_grupoebackend.logic.models.Actividad;
import org.grupo_e.proyec2_grupoebackend.logic.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {
    private ProductoRepository productoRepository;
    private ActividadRepository actividadRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository, ActividadRepository actividadRepository) {
        this.productoRepository = productoRepository;
        this.actividadRepository = actividadRepository;
    }

    @Override
    public ProductoDto findProductoById(int id) {
        Producto producto = productoRepository.findById(id).get();
        return mapToProductoDto(producto);
    }

    @Override
    public ProductoDto saveProducto(String idActividad,ProductoDto productoDto) {
        Producto producto = mapToProducto(productoDto);
        Producto savedProducto = productoRepository.save(producto);
        return mapToProductoDto(savedProducto);
    }

    @Override
    public ProductoDto updateProducto(ProductoDto productoDto) {
        Producto producto = mapToProducto(productoDto);
        Producto updatedProducto = productoRepository.save(producto);
        return mapToProductoDto(updatedProducto);
    }

    @Override
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<ProductoDto> findAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(this::mapToProductoDto).collect(Collectors.toList());
    }

    private ProductoDto mapToProductoDto(Producto producto) {
        return ProductoMapper.mapToProductoDto(producto);
    }

    private Producto mapToProducto(ProductoDto productoDto) {
        return ProductoMapper.mapToProducto(productoDto);
    }
}

