package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;

public class ProductoDaoImpl implements ProductoDao {

	private static String url = "jdbc:mysql://localhost:3306/pildoras_informaticas";
	private static String username = "root";
	private static String password = "";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";

	@Override
	public void insert(Producto producto) {
		Connection miConexion = null;
		PreparedStatement ps = null;

		try {
			Class.forName(driverClassName);
			// Establecemos la conexion a traves del pool de conexion y su metodo
			// getConnection
			miConexion = DriverManager.getConnection(url, username, password);

			String query2 = "insert into productos (CodArt, Seccion, NombreArt, Precio, Fecha, Importado, Pais) values (?, ?, ?, ?, ?, ?, ?)";
			ps = miConexion.prepareStatement(query2);
			ps.setString(1, producto.getCodArt());
			ps.setString(2, producto.getSeccion());
			ps.setString(3, producto.getNombreArt());
			ps.setDouble(4, producto.getPrecio());
			ps.setDate(5, producto.getFecha());
			ps.setString(6, producto.getImportado());
			ps.setString(7, producto.getPais());

			ps.executeUpdate();

			ps.close();
			ps = null;
			miConexion.close(); // Return to connection pool
			miConexion = null; // Make sure we don't close it twice
		} catch (SQLException e) {
			// ... deal with errors ...
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Always make sure result sets and statements are closed,
			// and the connection is returned to the pool
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null;
			}
			if (miConexion != null) {
				try {
					miConexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				miConexion = null;
			}
		}

	}

	@Override
	public Producto read(String codArt) {
		Producto producto = null;
		Connection miConexion = null;
		// parece q esta bie, falta cerrar las conexiones
		try {
			Class.forName(driverClassName);
			miConexion = DriverManager.getConnection(url, username, password);
			String query = "select * from productos where CodArt=?";
			PreparedStatement miPrepStat = miConexion.prepareStatement(query);

			miPrepStat.setString(1, codArt);

			ResultSet miRes = miPrepStat.executeQuery();

			if (miRes.next()) {
				producto = new Producto(miRes.getString("CodArt"), miRes.getString("Seccion"),
						miRes.getString("NombreArt"), miRes.getFloat("Precio"), miRes.getDate("Fecha"),
						miRes.getString("Importado"), miRes.getString("Pais"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return producto;
	}

	@Override
	public void update(Producto producto) {
		Connection miConexion = null;
		PreparedStatement ps = null;

		try {
			Class.forName(driverClassName);
			miConexion = DriverManager.getConnection(url, username, password);

			String query = "update productos set seccion = ?, nombreArt = ?, precio = ?, fecha = ?,"
					+ " importado = ?, pais = ? where codArt = ? ";

			ps = miConexion.prepareStatement(query);

			// Seteamos las variables '?'

			ps.setString(1, producto.getSeccion());
			ps.setString(2, producto.getNombreArt());
			ps.setDouble(3, producto.getPrecio());
			ps.setDate(4, producto.getFecha());
			ps.setString(5, producto.getImportado());
			ps.setString(6, producto.getPais());

			ps.setString(7, producto.getCodArt());
			ps.executeUpdate();

			// Cerramos la conexion
			ps.close();
			ps = null;
			miConexion.close(); // Return to connection pool
			miConexion = null; // Make sure we don't close it twice

		} catch (SQLException e) {
			// ... deal with errors ...
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Always make sure result sets and statements are closed,
			// and the connection is returned to the pool
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null;
			}
			if (miConexion != null) {
				try {
					miConexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				miConexion = null;
			}
		}

	}

	@Override
	public void delete(String codArt) {
		Connection miConexion = null;

		try {
			Class.forName(driverClassName);
			miConexion = DriverManager.getConnection(url, username, password);

			String query = "delete from productos where CodArt = ?";
			PreparedStatement miPrep = miConexion.prepareStatement(query);

			miPrep.setString(1, codArt);

			miPrep.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Producto> listar() {
		ArrayList<Producto> lista = new ArrayList<>();
		Connection miConexion = null;
		Statement miSt = null;
		ResultSet miRes = null;
		
		try {
			Class.forName(driverClassName);
			miConexion = DriverManager.getConnection(url, username, password);

			// Crear la sentencia SQL
			String query = "select * from productos";

			miSt = miConexion.createStatement();

			// Ejecutar la sentencia SQL
			miRes = miSt.executeQuery(query);

			// Recorrer el ResultSet obtenido
			String codArt, seccion, nombre, importado, pais;
			double precio;
			Date fecha;
			while (miRes.next()) {
				codArt = miRes.getString(1);
				seccion = miRes.getString(2);
				nombre = miRes.getString(3);
				precio = miRes.getDouble(4);
				fecha = miRes.getDate(5);
				importado = miRes.getString(6);
				pais = miRes.getString(7);

				lista.add(new Producto(codArt, seccion, nombre, precio, fecha, importado, pais));
			}

			miRes.close();
			miRes = null;
			miSt.close();
			miSt = null;
			miConexion.close(); // Return to connection pool
			miConexion = null; // Make sure we don't close it twice

		} catch (SQLException e) {
//		    ... deal with errors ...
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Always make sure result sets and statements are closed,
			// and the connection is returned to the pool
			if (miRes != null) {
				try {
					miRes.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				miRes = null;
			}
			if (miSt != null) {
				try {
					miSt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				miSt = null;
			}
			if (miConexion != null) {
				try {
					miConexion.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				miConexion = null;
			}
		}

		return lista;
	}

}
