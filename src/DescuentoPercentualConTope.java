public class DescuentoPercentualConTope extends Descuento{
    protected float tope = 100;


    public void setTope(float tope) {
        this.tope = tope;
    }

    @Override
    public float aplicarDescuento(float valorAntesDescuento) {
        if (valorAntesDescuento == 0) {
            RuntimeException valorCero;
            valorCero= new RuntimeException("No se pudo aplicar el descuento! el precio del carrito antes del descuento es cero");
            throw valorCero;
        }
        float descuentoFijo = valorAntesDescuento - this.tope;
        float descuentoPercentual = valorAntesDescuento - valorAntesDescuento * valor;

        float result = Math.max(descuentoFijo, descuentoPercentual);
        if (result < 0) {
            RuntimeException precioNegativo;
            precioNegativo= new RuntimeException("No se pudo aplicar el descuento! el precio del carrito con descuento es negativo");
            throw precioNegativo;
        }
        return result;
    }
}
