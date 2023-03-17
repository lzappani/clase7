public class DescuentoFijo extends Descuento {
    @Override
    public float aplicarDescuento(float valorAntesDescuento) {
        if (valorAntesDescuento == 0) {
            RuntimeException valorCero;
            valorCero= new RuntimeException("ERROR! el precio del carrito antes del descuento es cero");
            throw valorCero;
        }
        float result = valorAntesDescuento - this.valor;
        if (result < 0) {
            RuntimeException precioNegativo;
            precioNegativo= new RuntimeException("ERROR! el precio del carrito luego del descuento es negativo");
            throw precioNegativo;
        }
        return result;
    }
}

