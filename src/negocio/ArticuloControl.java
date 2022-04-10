package negocio;

import datos.ArticuloDAO;
import entidades.Articulo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ArticuloControl {

    private final ArticuloDAO DATOS;
    private Articulo obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados = 0;

    public ArticuloControl() {
        this.DATOS = new ArticuloDAO();
        this.obj = new Articulo();
    }

    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina) {
        List<Articulo> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));

        String[] titulos = {"Id", "Categoria ID", "Categoria", "Nombre", "Código", "Precio de venta", "Stock", "Descripcion", "Imagen", "Estado"};
        this.modeloTabla = new DefaultTableModel(null, titulos);

        String estado;
        String[] registro = new String[10];
        this.registrosMostrados = 0;

        for (Articulo item : lista) {
            if (item.isActivo()) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            registro[0] = Integer.toString(item.getId());
            registro[1] = Integer.toString(item.getCategoria_id());
            registro[2] = item.getCategoriaNombre();
            registro[3] = item.getNombre();
            registro[4] = item.getCodigo();
            registro[5] = Double.toString(item.getPrecio_venta());
            registro[6] = Integer.toString(item.getStock());
            registro[7] = item.getDescripcion();
            registro[8] = item.getImagen();
            registro[9] = estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados + 1;
        }
        return this.modeloTabla;
    }

    public String insertar(int categoriaId, String codigo, String nombre, double precio_venta, int stock, String descripcion, String imagen) {
        if (DATOS.existe(nombre)) {
            return "El registro ya existe.";
        } else {
            obj.setCategoria_id(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecio_venta(precio_venta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);
            if (DATOS.Insertar(obj)) {
                return "OK";
            } else {
                return "Error en el registro.";
            }
        }
    }

    public String actualizar(int id, int categoriaId, String codigo, String nombre, String nombreAnt, double precio_venta, int stock, String descripcion, String imagen) {
        if (nombre.equals(nombreAnt)) {
            obj.setId(id);
            obj.setCategoria_id(categoriaId);
            obj.setCodigo(codigo);
            obj.setNombre(nombre);
            obj.setPrecio_venta(precio_venta);
            obj.setStock(stock);
            obj.setDescripcion(descripcion);
            obj.setImagen(imagen);
            if (DATOS.actualizar(obj)) {
                return "OK";
            } else {
                return "Error en la actualización.";
            }
        } else {
            if (DATOS.existe(nombre)) {
                return "El registro ya existe.";
            } else {
                obj.setId(id);
                obj.setCategoria_id(categoriaId);
                obj.setCodigo(codigo);
                obj.setNombre(nombre);
                obj.setPrecio_venta(precio_venta);
                obj.setStock(stock);
                obj.setDescripcion(descripcion);
                obj.setImagen(imagen);
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