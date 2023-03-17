import java.time.LocalDate;

class Carrito implements Cloneable{
    private Persona persona;
    private Producto[] listaDeProductos = new Producto[3];
    private int[] cantidad = new int[3];
    private LocalDate fechaDeCompra;
    private Descuento descuento = new Descuento();

    public Carrito() {}

    public Carrito(Persona persona){
        this.persona = persona;
        this.fechaDeCompra = LocalDate.now();
    }
    public void agregarProducto(Producto producto, int cantidad) {
        int vacio = -1;
        for (int i = 0; i < 3; i++){
            if (listaDeProductos[i] == null) {
                vacio = i;
                break;
            }
        }
        if(vacio != -1) {
            this.listaDeProductos[vacio] = producto;
            this.cantidad[vacio] = cantidad;
            System.out.printf("Producto agregado al carrito: %s, cantidad: %d%n", producto.getNombre(), cantidad);
        } else {
            System.out.println("El carrito esta lleno");
        }
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
    }

    public float precio() {
        float result = 0;
        for (int i = 0; i < 3; i++){
            if (listaDeProductos[i] != null) {
                result += (listaDeProductos[i].getPrecioUnitario() * cantidad[i]);
                break;
            }
        }
        return descuento.aplicarDescuento(result);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
