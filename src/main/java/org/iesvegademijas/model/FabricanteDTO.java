package org.iesvegademijas.model;

public class FabricanteDTO extends Fabricante{
	
	private int productos;
	
	public FabricanteDTO(Fabricante f) {
		this.setCodigo(f.getCodigo());
		this.setNombre(f.getNombre());
	}
	
	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}
	
}
