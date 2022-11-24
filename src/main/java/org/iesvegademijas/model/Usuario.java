package org.iesvegademijas.model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class Usuario {
	private int codigo;
	private String usuario;
	private String password;
	private String rol;
	
	public Usuario() {
		
	}
	
	public Usuario(int codigo, String usuario, String password, String rol) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo, password, rol, usuario);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return codigo == other.codigo && Objects.equals(password, other.password) && Objects.equals(rol, other.rol)
				&& Objects.equals(usuario, other.usuario);
	}



	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public static String hashPassword(String password ) throws NoSuchAlgorithmException {
        MessageDigest digest;
        
        digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        
        return bytesToHex(encodedhash);                    
        
    }
    
    private static String bytesToHex(byte[] byteHash) {
        
        StringBuilder hexString = new StringBuilder(2 * byteHash.length);          
        for (int i = 0; i < byteHash.length; i++) {
            String hex = Integer.toHexString(0xff & byteHash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        
        return hexString.toString();
        
    }
	
}
