public class DescuentoPercentualConTope extends Descuento{
    protected float tope = 100;


    public void setTope(float tope) {
        this.tope = tope;
    }

    @Override
    public float aplicarDescuento(float valorAntesDescuento) {
        float descuentoFijo = valorAntesDescuento - this.tope;
        float descuentoPercentual = valorAntesDescuento - valorAntesDescuento * valor;
        return Math.max(descuentoFijo, descuentoPercentual);
    }
}
