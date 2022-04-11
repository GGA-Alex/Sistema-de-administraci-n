package entidades;

public class Usuario {
    private int id;
    private int rol_id;
    private String rolNombre;
    private String nombre;
    private String tipoDocumento;
    private String numDocumento;
    private String direccion;
    private String telefono;
    private String email;
    private String clave;
    private boolean activo;
    
    // Constructores

    public Usuario() {
    }

    public Usuario(int id, int rol_id, String rolNombre, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email, String clave, boolean activo) {
        this.id = id;
        this.rol_id = rol_id;
        this.rolNombre = rolNombre;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        this.activo = activo;
    }
    
    // Setter y getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
