public class DescuentoFijo extends Descuento {
    @Override
    public float aplicarDescuento(float valorAntesDescuento) {
        return valorAntesDescuento - this.valor;
    }
}

