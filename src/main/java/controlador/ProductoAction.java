package controlador;

import org.apache.logging.log4j.*;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductoDao;
import dao.ProductoDaoImpl;
import modelo.Producto;

public class ProductoAction extends ActionSupport{

	private static final long serialVersionUID = -5194841497095129222L;
	private Producto productoBean;
		
	private String codArtAEliminar;
		
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
		
		ProductoDao proDao = new ProductoDaoImpl();
		
		proDao.insert(getProductoBean());		
		
		
		return "insertadoOK";
	}
	
	public String eliminar() {
		
		ProductoDao proDao = new ProductoDaoImpl();
		
		proDao.delete(codArtAEliminar);
		
		log.info("El producto:" +codArtAEliminar+ " fue eliminado de la BD correctamente");
		
		return "insertadoOK";
	}
	
	public String getCodigo() {
		return codArtAEliminar;
	}


	public void setCodigo(String codigo) {
		this.codArtAEliminar = codigo;
	}

	
	public Producto getProductoBean() {
		return productoBean;
	}


	public void setProductoBean(Producto productoBean) {
		this.productoBean = productoBean;
	}
	
	
}
