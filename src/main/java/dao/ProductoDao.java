package dao;

import java.util.List;

import modelo.Producto;

// Interfaz que contiene la acciones CRUD (create, read, update y delete)
public interface ProductoDao {
	public List<Producto> listar();
	public void insert(Producto producto);
	public Producto read(String codArt);
	public void update(Producto producto);
	public void delete(String codArt);
	
}

