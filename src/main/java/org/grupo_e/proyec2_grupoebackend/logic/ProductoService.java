package org.grupo_e.proyec2_grupoebackend.logic;

import org.grupo_e.proyec2_grupoebackend.data.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    ProductoDto findProductoById(int id);
    ProductoDto saveProducto(String idActividad, ProductoDto productoDto);
    ProductoDto updateProducto(ProductoDto productoDto);
    void deleteProducto(int id);
    List<ProductoDto> findAllProductos();
}
