
class Producto {
    private String nombre;
    private String codigo;
    private float precioUnitario;

    public Producto(String nombre, String codigo, float precioUnitario) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public float getPrecioUnitario() {
        return this.precioUnitario;
    }
}