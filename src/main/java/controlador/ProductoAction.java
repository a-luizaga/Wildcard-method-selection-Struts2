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
		
	private String codArtActual;
		
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
		
		proDao.delete(codArtActual);
		
		log.info("El producto:" +productoBean.getCodArt()+ " fue eliminado de la BD correctamente");
		
		return "insertadoOK";
	}
	
	public String actualizar() {
		ProductoDao proDao = new ProductoDaoImpl();
		
		productoBean = proDao.read(codArtActual);
		
		
		return "actualizarProd";
	}
		
	
	public String updateAndSave() {
		
		ProductoDao prodDao = new ProductoDaoImpl();
		
		prodDao.update(productoBean);
		
		log.info("Se actualizo el producto: "+ codArtActual+" correctamente.");
		
		return "insertadoOK";
	}
	
	public String getCodArtActual() {
		return codArtActual;
	}


	public void setCodArtActual(String codArtActual) {
		this.codArtActual = codArtActual;
	}


	public Producto getProductoBean() {
		return productoBean;
	}


	public void setProductoBean(Producto productoBean) {
		this.productoBean = productoBean;
	}
	
	
}
