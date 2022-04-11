package negocio;

import datos.UsuarioDAO;
import datos.RolDAO;
import entidades.Usuario;
import entidades.Rol;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class UsuarioControl {

    private final UsuarioDAO DATOS;
    private final RolDAO DATOSROL;
    private Usuario obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados = 0;

    public UsuarioControl() {
        this.DATOS = new UsuarioDAO();
        this.DATOSROL = new RolDAO();
        this.obj = new Usuario();
    }

    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Usuario> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));

        String[] titulos = {"Id", "Rol ID", "Rol", "Usuario", "Documento", "# Documento", "Dirección", "Telefono", "Email", "Clave" ,"Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[11];
        this.registrosMostrados = 0;

        for (Usuario item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getRol_id());
            registro[2] = item.getRolNombre();
            registro[3] = item.getNombre();
            registro[4] = item.getTipoDocumento();
            registro[5] = item.getNumDocumento();
            registro[6] = item.getDireccion();
            registro[7] = item.getTelefono();
            registro[8] = item.getEmail();
            registro[9] = item.getClave();
            registro[10] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }
    
    public DefaultComboBoxModel seleccionar(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Rol> lista = new ArrayList();
        lista = DATOSROL.seleccionar();
        for(Rol item : lista){
            items.addElement(new Rol(item.getId(), item.getNombre()));
        }
        return items;
    }
    
    private static String encriptar(String valor){
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        
        byte[] hash = md.digest(valor.getBytes());
        StringBuilder sb = new StringBuilder();
        
        for (byte b : hash){
            sb.append(String.format("%02x", b));
        }
        
        return sb.toString();
    }

    public String insertar(int rolId, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email, String clave) {
        if (DATOS.existe(email)) {
            return "El registro ya existe.";
        } else {
            obj.setRol_id(rolId);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            obj.setClave(encriptar(clave));
            if (DATOS.Insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }
    }

    public String actualizar(int id, int rolId, String nombre, String tipoDocumento, String numDocumento, String direccion, String telefono, String email, String emailAnt, String clave) {
        if (email.equals(emailAnt)) {
            obj.setId(id);
            obj.setRol_id(rolId);
            obj.setNombre(nombre);
            obj.setTipoDocumento(tipoDocumento);
            obj.setNumDocumento(numDocumento);
            obj.setDireccion(direccion);
            obj.setTelefono(telefono);
            obj.setEmail(email);
            
            String encriptado;
            if (clave.length() == 64){
                encriptado = clave;
            } else {
                encriptado = encriptar(clave);
            }
            obj.setClave(encriptado);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización.";
            }
        } else {
            if (DATOS.existe(email)) {
                return "El registro ya existe.";
            } else {
                obj.setRol_id(rolId);
                obj.setNombre(nombre);
                obj.setTipoDocumento(tipoDocumento);
                obj.setNumDocumento(numDocumento);
                obj.setDireccion(direccion);
                obj.setTelefono(telefono);
                obj.setEmail(email);

                String encriptado;
                if (clave.length() == 64) {
                    encriptado = clave;
                } else {
                    encriptado = encriptar(clave);
                }
                obj.setClave(encriptado);
                if (DATOS.actualizar(obj)) {
                    return "OK";
                } else {
                    return "Error en la actualización.";
                }
            }
        }
    }

    public String desactivar(int id) {
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro.";
        }
    }

    public String activar(int id) {
        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No se puede activar el registro.";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return this.registrosMostrados;
    }
}
