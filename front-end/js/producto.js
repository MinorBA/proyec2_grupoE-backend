document.addEventListener('DOMContentLoaded', () => {
    const productList = document.getElementById('product-list');
    const newProductNameInput = document.getElementById('new-product-name');
    const newProductPriceInput = document.getElementById('new-product-price');
    const addProductButton = document.getElementById('add-product');

    const fetchProducts = async () => {
        try {
            const response = await fetch('/api/productos');
            const products = await response.json();
            productList.innerHTML = '';
            products.forEach(product => {
                const li = document.createElement('li');
                li.textContent = `${product.nombre} - $${product.precio}`;
                productList.appendChild(li);
            });
        } catch (error) {
            console.error('Error al obtener los productos:', error);
        }
    };

    const postProduct = async (product) => {
        try {
            await fetch('/api/productos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(product)
            });
            fetchProducts();
        } catch (error) {
            console.error('Error al enviar el producto:', error);
        }
    };

    addProductButton.addEventListener('click', () => {
        const newProductName = newProductNameInput.value.trim();
        const newProductPrice = parseFloat(newProductPriceInput.value.trim());
        if (newProductName && !isNaN(newProductPrice)) {
            const newProduct = { nombre: newProductName, precio: newProductPrice };
            postProduct(newProduct);
            newProductNameInput.value = '';
            newProductPriceInput.value = '';
        }
    });

    fetchProducts();
});
