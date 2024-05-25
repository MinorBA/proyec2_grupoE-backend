package org.grupo_e.proyec2_grupoebackend.presentation;
import jakarta.validation.Valid;
import org.grupo_e.proyec2_grupoebackend.data.dto.ProductoDto;
import org.grupo_e.proyec2_grupoebackend.logic.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDto>> listProductos() {
        List<ProductoDto> productoDtos = productoService.findAllProductos();
        return ResponseEntity.ok(productoDtos);
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable int productoId) {
        ProductoDto productoDto = productoService.findProductoById(productoId);
        if (productoDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoDto);
    }

    @PostMapping("/actividad/{idActividad}")
    public ResponseEntity<ProductoDto> createProducto(@PathVariable String idActividad, @Valid @RequestBody ProductoDto productoDto) {
        ProductoDto savedProducto = productoService.saveProducto(idActividad, productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<ProductoDto> updateProducto(@PathVariable int productoId, @Valid @RequestBody ProductoDto productoDto) {
        ProductoDto existingProducto = productoService.findProductoById(productoId);
        if (existingProducto == null) {
            return ResponseEntity.notFound().build();
        }
        productoDto.setIdProducto(productoId);
        ProductoDto updatedProducto = productoService.updateProducto(productoDto);
        return ResponseEntity.ok(updatedProducto);
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int productoId) {
        ProductoDto productoDto = productoService.findProductoById(productoId);
        if (productoDto == null) {
            return ResponseEntity.notFound().build();
        }
        productoService.deleteProducto(productoId);
        return ResponseEntity.noContent().build();
    }
}
