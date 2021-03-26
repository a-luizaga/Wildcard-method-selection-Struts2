package controlador;

import org.apache.logging.log4j.*;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductoDao;
import dao.ProductoDaoImpl;
import modelo.Producto;

public class ProductoAction extends ActionSupport{

	private static final long serialVersionUID = -5194841497095129222L;
	private Producto productoBean;
	private Date fechaAux;
	

	List<Producto> lista;
	Logger log = LogManager.getLogger(ProductoAction.class);
	
	
	public String execute() {
		
		ProductoDao proDao = new ProductoDaoImpl();
		
		lista = proDao.listar();
		
		
		return SUCCESS;
	}


	public List<Producto> getLista() {
		return lista;
	}
	
	public String insert() {
		
//		ProductoDao proDao = new ProductoDaoImpl();
		
		productoBean.setFecha(new java.sql.Date(fechaAux.getTime()));
		log.info(fechaAux+"\n");
		log.info(productoBean);		
		
		
		return INPUT;
	}
	
	public Date getFechaAux() {
		return fechaAux;
	}


	public void setFechaAux(Date fechaAux) {
		this.fechaAux = fechaAux;
	}
	
	public Producto getProductoBean() {
		return productoBean;
	}


	public void setProductoBean(Producto productoBean) {
		this.productoBean = productoBean;
	}
	
	
}
