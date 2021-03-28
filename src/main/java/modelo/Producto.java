package modelo;

import java.sql.Date;

public class Producto {
	private String codArt;
	private String seccion;
	private String nombreArt;
	private float precio;
	private Date fecha;
	private String importado;
	private String pais;

	public Producto() {

	}

	public Producto(String codArt, String seccion, String nombreArt, float precio, Date fecha, String importado,
			String pais) {

		this.codArt = codArt;
		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais = pais;
	}

	public Producto(String seccion, String nombreArt, float precio, Date fecha, String importado, String pais) {

		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pais = pais;
	}

	public String getCodArt() {
		return codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombreArt() {
		return nombreArt;
	}

	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getImportado() {
		return importado;
	}

	public void setImportado(String importado) {
		this.importado = importado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Producto [codArt=" + codArt + ", seccion=" + seccion + ", nombreArt=" + nombreArt + ", precio=" + precio
				+ ", fecha=" + fecha + ", importado=" + importado + ", pais=" + pais + "]";
	}

}
