package org.grupo_e.proyec2_grupoebackend.data.mapper;

import org.grupo_e.proyec2_grupoebackend.data.dto.ProductoDto;
import org.grupo_e.proyec2_grupoebackend.logic.models.Producto;

public class ProductoMapper {

    public static ProductoDto mapToProductoDto(Producto producto) {
        return ProductoDto.builder()
                .idProducto(producto.getIdProducto())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .unidadMedida(producto.getUnidadMedida())
                .actividad(producto.getActividad())
                .emisor(producto.getEmisor())
                .build();
    }

    public static Producto mapToProducto(ProductoDto productoDto) {
        return Producto.builder()
                .idProducto(productoDto.getIdProducto())
                .nombre(productoDto.getNombre())
                .descripcion(productoDto.getDescripcion())
                .precio(productoDto.getPrecio())
                .unidadMedida(productoDto.getUnidadMedida())
                .actividad(productoDto.getActividad())
                .emisor(productoDto.getEmisor())
                .build();
    }
}
