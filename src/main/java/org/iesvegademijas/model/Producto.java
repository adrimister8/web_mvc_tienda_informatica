package org.iesvegademijas.model;

import java.util.Objects;
import java.math.BigDecimal;

public class Producto {
	private int codigo;
	private String nombre;
	private Double precio;
	private int codigoFabricante;
	
	
	public Producto() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", codigoFabricante="
				+ codigoFabricante + "]";
	}



	public Producto(String nombre, Double precio, int codigoFabricante) {
		this.nombre = nombre;
		this.precio = precio;
		this.codigoFabricante = codigoFabricante;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, codigoFabricante, nombre, precio);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return codigo == other.codigo && codigoFabricante == other.codigoFabricante
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCodigoFabricante() {
		return codigoFabricante;
	}
	public void setCodigoFabricante(int codigoFabricante) {
		this.codigoFabricante = codigoFabricante;
	}
	
	
}
