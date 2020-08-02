package com.app.commons.prueba.compra.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.commons.alquiler.models.entity.Cliente;
import com.app.commons.alquiler.models.entity.Juego;

@Entity
@Table(name="prueba_compra")
public class PruebaCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	private String estadoOrd;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Cliente> clientes;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	private List<Juego> juegos;
	 
	public PruebaCompra() {
		
		this.clientes=new ArrayList<>();
		this.juegos = new ArrayList<>();
	}
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getEstadoOrd() {
		return estadoOrd;
	}

	public void setEstadoOrd(String estadoOrd) {
		this.estadoOrd = estadoOrd;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void removeAlumno(Cliente cliente) {		
		this.clientes.remove(cliente);
	}
	
	public void addJuegos(Juego juego) {
		this.juegos.add(juego);	
	}
	
	public void removeJuego(Juego juego) {		
		this.juegos.remove(juego);			
	}

	public List<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(List<Juego> juegos) {
		this.juegos = juegos;
	}
	
	

}
