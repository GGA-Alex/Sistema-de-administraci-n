package entidades;

public class Articulo {
    private int id;
    private int categoria_id;
    private String categoriaNombre;
    private String codigo;
    private String nombre;
    private double precio_venta;
    private int stock;
    private String descripcion;
    private String imagen;
    private boolean activo;
    
    // Constructores

    public Articulo() {
    }

    public Articulo(int id, int categoria_id, String categoriaNombre, String codigo, String nombre, double precio_venta, int stock, String descripcion, String imagen, boolean activo) {
        this.id = id;
        this.categoria_id = categoria_id;
        this.categoriaNombre = categoriaNombre;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }
    
    // Getter y setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    // toString

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", categoria_id=" + categoria_id + ", categoriaNombre=" + categoriaNombre + ", codigo=" + codigo + ", nombre=" + nombre + ", precio_venta=" + precio_venta + ", stock=" + stock + ", descripcion=" + descripcion + ", imagen=" + imagen + ", activo=" + activo + '}';
    }
}
