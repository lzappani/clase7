public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Persona leandro = new Persona("Leandro", "Zappani", "9/3/1991");
        Producto producto1 = new Producto("Jabon en Polvo", "101", 10);
        Producto producto2 = new Producto("Esponja", "102", 10);
        Producto producto3 = new Producto("Chocolate", "103", 10);

        Carrito carrito1 = new Carrito(leandro);
        Carrito carrito3 = new Carrito(leandro);

        carrito1.agregarProducto(producto1, 1);
        carrito1.agregarProducto(producto2, 1);
        carrito1.agregarProducto(producto3, 1);
        carrito1.agregarProducto(producto1, 1);

        Carrito carrito2 = (Carrito) carrito1.clone();

        carrito2.precio();
        System.out.printf("%nPrecio final sin descuento: %.2f%n%n", carrito2.getPrecioFinal());

        carrito1.setDescuento(0.15f, 'p');
        System.out.printf("Precio final con descuento percentual: %.2f%n%n", carrito1.getPrecioFinal());

        carrito1.setDescuento(50, 'f');
        System.out.printf("Precio final con descuento fijo: %.2f%n%n", carrito1.getPrecioFinal());

        carrito1.setDescuento(0.15f, 't');
        System.out.printf("Precio final con descuento perc con tope: %.2f%n%n", carrito1.getPrecioFinal());

        carrito3.setDescuento(0.15f, 'p');
        System.out.printf("Precio final con descuento percentual: %.2f%n%n", carrito3.getPrecioFinal());
    }

}

