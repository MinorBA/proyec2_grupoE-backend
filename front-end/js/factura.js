document.addEventListener('DOMContentLoaded', () => {
    const facturaForm = document.getElementById('factura-form');

    facturaForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        const factura = {
            proveedor: document.getElementById('factura-provider').value,
            cliente: document.getElementById('factura-client').value,
            fecha: document.getElementById('factura-date').value,
            total: parseFloat(document.getElementById('factura-total').value)
        };

        try {
            const response = await fetch('/api/facturas', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(factura)
            });

            if (response.ok) {
                alert('Factura generada exitosamente');
                facturaForm.reset();
            } else {
                alert('Error al generar la factura');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Error al generar la factura');
        }
    });
});
