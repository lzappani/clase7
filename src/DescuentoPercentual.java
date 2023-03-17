public class DescuentoPercentual extends Descuento {
    @Override
    public float aplicarDescuento(float valorAntesDescuento) {
        return valorAntesDescuento - valorAntesDescuento * this.valor;
    }

}
