package org.grupo_e.proyec2_grupoebackend.presentation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.grupo_e.proyec2_grupoebackend.data.dto.FacturaDto;
import org.grupo_e.proyec2_grupoebackend.logic.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
    private final FacturaService facturaService;;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public ResponseEntity<List<FacturaDto>> listFacturas() {
        List<FacturaDto> facturaDtos = facturaService.findAllFacturas();
        return ResponseEntity.ok(facturaDtos);
    }

    @GetMapping("/{facturaId}")
    public ResponseEntity<FacturaDto> getFacturaById(@PathVariable long facturaId) {
        FacturaDto facturaDto = facturaService.findFacturaById(facturaId);
        if (facturaDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facturaDto);
    }

    @PostMapping("/emisor/{emisorId}/cliente/{clienteId}")
    public ResponseEntity<FacturaDto> createFactura(@PathVariable int emisorId, @PathVariable int clienteId, @Valid @RequestBody FacturaDto facturaDto) {
        FacturaDto savedFactura = facturaService.saveFactura(emisorId, clienteId, facturaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFactura);
    }

    @PutMapping("/{facturaId}")
    public ResponseEntity<FacturaDto> updateFactura(@PathVariable long facturaId, @Valid @RequestBody FacturaDto facturaDto) {
        FacturaDto existingFactura = facturaService.findFacturaById(facturaId);
        if (existingFactura == null) {
            return ResponseEntity.notFound().build();
        }
        facturaDto.setIdFactura(facturaId);
        FacturaDto updatedFactura = facturaService.updateFactura(facturaDto);
        return ResponseEntity.ok(updatedFactura);
    }

    @DeleteMapping("/{facturaId}")
    public ResponseEntity<Void> deleteFactura(@PathVariable long facturaId) {
        FacturaDto facturaDto = facturaService.findFacturaById(facturaId);
        if (facturaDto == null) {
            return ResponseEntity.notFound().build();
        }
        facturaService.deleteFactura(facturaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{facturaId}/pdf")
    public void crearPdf(@PathVariable int idFactura, HttpServletResponse response)  {
        try{
            response.addHeader("Content-type","application/pdf");
            FacturaDto factura = facturaService.findFacturaById(idFactura);
            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf,PageSize.A4);

            Paragraph title = new Paragraph("FACTURA");
            title.setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.BLACK,1.0f).setFontSize(16);
            document.add(title);

            Paragraph name = new Paragraph("Sebastian Fuentes Jimenez / Andres Ureña Guido / Marypaz Soler Herrera");
            name.setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.BLACK,0.5f);
            document.add(name);
            document.add(new Paragraph("\n"));

            Paragraph title2 = new Paragraph("Lista de productos");
            title2.setTextAlignment(TextAlignment.CENTER).setFontColor(com.itextpdf.kernel.colors.ColorConstants.BLACK,0.5f);
            document.add(title2);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("\n"));

            float[] floats = {2, 2, 2, 2, 2, 2};
            Table table = new Table(floats);
            table.setWidth(UnitValue.createPercentValue(100)); // Ajusta el ancho de la tabla al 100% del ancho del documento
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);

            Paragraph paragraph1 = new Paragraph("Codigo").setTextAlignment(TextAlignment.CENTER);
            Paragraph paragraph2 = new Paragraph("Cantidad").setTextAlignment(TextAlignment.CENTER);
            Paragraph paragraph3 = new Paragraph("Precio").setTextAlignment(TextAlignment.CENTER);
            Paragraph paragraph4 = new Paragraph("Codigo de producto").setTextAlignment(TextAlignment.CENTER);
            Paragraph paragraph5 = new Paragraph("Nombre").setTextAlignment(TextAlignment.CENTER);
            Paragraph paragraph6 = new Paragraph("Subtotal").setTextAlignment(TextAlignment.CENTER);



            Cell headerCell1 = new Cell().add(paragraph1).setVerticalAlignment(VerticalAlignment.MIDDLE);
            Cell headerCell2 = new Cell().add(paragraph2).setVerticalAlignment(VerticalAlignment.MIDDLE);
            Cell headerCell3 = new Cell().add(paragraph3).setVerticalAlignment(VerticalAlignment.MIDDLE);
            Cell headerCell4 = new Cell().add(paragraph4).setVerticalAlignment(VerticalAlignment.MIDDLE);
            Cell headerCell5 = new Cell().add(paragraph5).setVerticalAlignment(VerticalAlignment.MIDDLE);
            Cell headerCell6 = new Cell().add(paragraph6).setVerticalAlignment(VerticalAlignment.MIDDLE);



            headerCell1.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            headerCell2.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            headerCell3.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            headerCell4.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            headerCell5.setBackgroundColor(ColorConstants.LIGHT_GRAY);
            headerCell6.setBackgroundColor(ColorConstants.LIGHT_GRAY);



            table.addCell(headerCell1);
            table.addCell(headerCell2);
            table.addCell(headerCell3);
            table.addCell(headerCell4);
            table.addCell(headerCell5);
            table.addCell(headerCell6);

            Double subtotal;

            for (Detalle obj : factura.getDetallesByCodigo()) {
                table.addCell(String.valueOf(obj.getCodigo())).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(String.valueOf(obj.getCantidad())).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(String.valueOf(obj.getProductoByProductoiddet().getPrecio())).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(String.valueOf(obj.getProductoByProductoiddet().getCodigo())).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                table.addCell(String.valueOf(obj.getProductoByProductoiddet().getNombre())).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);

                subtotal = obj.getProductoByProductoiddet().getPrecio()*obj.getCantidad();
                table.addCell(String.valueOf(subtotal)).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
            }
            document.add(table);
            Paragraph name1 = new Paragraph("Total: " + String.valueOf(factura.getTotal()));
            name1.setTextAlignment(TextAlignment.RIGHT);
            document.add(name1);
            document.close();

        }
        catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }
}
