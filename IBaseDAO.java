/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business.entity;

 import java.util.List;

public interface IBaseDAO<T> {
    
    // Crear
    void create(T entity);
    
    // Leer
    T read(int id);
    
    // Actualizar
    void update(T entity);
    
    // Eliminar
    void delete(int id);
    
    // Listar todos
    List<T> listAll();
    
    
}
