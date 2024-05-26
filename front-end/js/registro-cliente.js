document.addEventListener('DOMContentLoaded', () => {
    const registerClientForm = document.getElementById('register-client-form');

    registerClientForm.addEventListener('submit', async (event) => {
        event.preventDefault();

        const client = {
            nombre: document.getElementById('client-name').value,
            email: document.getElementById('client-email').value,
            telefono: document.getElementById('client-phone').value
        };

        try {
            const response = await fetch('/api/clientes', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(client)
            });

            if (response.ok) {
                alert('Cliente registrado exitosamente');
                registerClientForm.reset();
            } else {
                alert('Error al registrar el cliente');
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Error al registrar el cliente');
        }
    });
});
