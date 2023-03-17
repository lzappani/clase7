import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Persona leandro = new Persona("Leandro", "Zappani", "9/3/1991");
        Producto producto1 = new Producto("Jabon en Polvo", "101", 40);
        Producto producto2 = new Producto("Esponja", "102", 10);
        Producto producto3 = new Producto("Chocolate", "103", 100);
        Carrito carrito1 = new Carrito(leandro);
        carrito1.agregarProducto(producto1, 20);
        carrito1.agregarProducto(producto2, 50);
        carrito1.agregarProducto(producto3, 10);
        carrito1.agregarProducto(producto1, 20);
        Carrito carrito2 = (Carrito) carrito1.clone();
        System.out.printf("Precio total sin descuento: %.2f%n", carrito2.precio());
        carrito1.setDescuento(0.15f, 'p');
        System.out.printf("Precio total con descuento percentual: %.2f%n", carrito1.precio());
        carrito1.setDescuento(10, 'f');
        System.out.printf("Precio total con descuento fijo: %.2f%n", carrito1.precio());
        carrito1.setDescuento(0.15f, 't');
        System.out.printf("Precio total con descuento perc con tope: %.2f%n", carrito1.precio());

    }

}

