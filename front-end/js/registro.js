document.addEventListener('DOMContentLoaded', () => {
    const registerProviderForm = document.getElementById('register-provider-form');

    registerProviderForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        const provider = {
            nombre: document.getElementById('provider-name').value,
            email: document.getElementById('provider-email').value,
            telefono: document.getElementById('provider-phone').value
        };

        try {
            const response = await fetch('/api/proveedores', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(provider)
            });

            if (response.ok) {
                alert('Proveedor registrado exitosamente');
                registerProviderForm.reset();
            } else {
                alert('Error al registrar el proveedor');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Error al registrar el proveedor');
        }
    });
});
