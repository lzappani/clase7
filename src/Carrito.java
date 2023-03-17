import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Carrito implements Cloneable{
    private Persona persona;
    private List<Producto> listaDeProductos = new ArrayList<Producto>();
    private List<Integer> cantidad = new ArrayList<Integer>();
    private LocalDate fechaDeCompra;
    private Descuento descuento = new Descuento();
    private Float precioantesDescuento;
    private Float precioFinal;


    public Float getPrecioantesDescuento() {
        return precioantesDescuento;
    }

    public Float getPrecioFinal() {
        return precioFinal;
    }


    public Carrito(Persona persona){
        this.persona = persona;
        this.fechaDeCompra = LocalDate.now();
    }
    public void agregarProducto(Producto producto, int cantidad) {
        this.listaDeProductos.add(producto);
        this.cantidad.add(cantidad);
        System.out.printf("Producto agregado al carrito: %s, cantidad: %d%n", producto.getNombre(), cantidad);
    }

    public void setDescuento(float valor, char tipo) {
        switch (tipo) {
            case 'f':
                this.descuento = new DescuentoFijo();
                this.descuento.setValor(valor);
                break;
            case 'p':
                this.descuento = new DescuentoPercentual();
                this.descuento.setValor(valor);
                break;
            case 't':
                this.descuento = new DescuentoPercentualConTope();
                this.descuento.setValor(valor);
                break;
            default:
                throw new RuntimeException("Tipo de descuento inexistente.");
        }
        this.precio();
    }

    public void precio() {
        float sumOfPrices = 0;
        for (int i = 0; i < listaDeProductos.size(); i++){
            sumOfPrices += (listaDeProductos.get(i).getPrecioUnitario() * cantidad.get(i));
        }
        this.precioantesDescuento = sumOfPrices;
        try{
            this.precioFinal =  descuento.aplicarDescuento(sumOfPrices);
        }
        catch (RuntimeException e) {
            this.precioFinal = sumOfPrices;
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
