
package business.entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements IBaseDAO<Producto> {
    
    private final Connection connection;

    // Constructor que recibe la conexión a la base de datos
    public ProductoDAO(Connection connection) {
        this.connection = connection;
    }

    // Crear un nuevo producto
    @Override
    public void create(Producto producto) {
        String query = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Leer un producto por ID
    @Override
    public Producto read(int id) {
        Producto producto = null;
        String query = "SELECT * FROM productos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
            }
        } catch (SQLException e) {
        }
        return producto;
    }

    // Actualizar un producto existente
    @Override
    public void update(Producto producto) {
        String query = "UPDATE productos SET nombre = ?, precio = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setInt(3, producto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Eliminar un producto

    /**
     *
     * @param id
     */
    @Override
    public void delete(int id) {
        String query = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // Listar todos los productos
    @Override
    public List<Producto> listAll() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM productos";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Producto producto = new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
                productos.add(producto);
            }
        } catch (SQLException e) {
        }
        return productos;
    }
}