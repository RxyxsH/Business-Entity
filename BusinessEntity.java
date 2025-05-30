
package business.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Reyes
 */
public class BusinessEntity {

    public static void main(String[] args) {
         try (Connection connection = ConnectionManager.getConnection()) {
            ProductoDAO productoDAO = new ProductoDAO(connection);

            // Crea un nuevo producto
            Producto nuevoProducto = new Producto(0, "Producto A", 25.50);
            productoDAO.create(nuevoProducto);

            // Leer un producto
            Producto producto = productoDAO.read(1);
            System.out.println("Producto leído: " + producto);

            // Actualiz un producto
            producto.setPrecio(30.00);
            productoDAO.update(producto);

            // Producto
            productoDAO.delete(2);

            // Lista de todos los productos
            List<Producto> productos = productoDAO.listAll();
            productos.forEach(System.out::println);

        } catch (SQLException e) {
            
        }
    }
        
    }
    

