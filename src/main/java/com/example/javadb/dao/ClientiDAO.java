package com.example.javadb.dao;

import com.example.javadb.entities.Cliente;
import com.example.javadb.params.Parameters;
import com.example.javadb.exceptions.DatabaseOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientiDAO implements DAO<Cliente, Integer> {

	private static final Logger log = LogManager.getLogger(ClientiDAO.class);

	private static final String findAllQuery = "select id_cliente, nome, cognome, email, indirizzo, citta, provincia, cap from clienti";
	private static final String findByIdQuery = "select id_cliente, nome, cognome, email, indirizzo, citta, provincia, cap from where id_cliente = ?";
	private static final String removeByIdQuery = "delete from clienti where id_cliente = ?";
	private static final String insertQuery = "insert into clienti (id_cliente, nome, cognome, email, indirizzo, citta, provincia, cap) values(?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String updateQuery = "update clienti set " +
			" nome = ?,"+
			" cognome = ?,"+
			" email = ?,"+
			" indirizzo = ?,"+
			" citta = ?,"+
			" provincia = ?,"+
			" cap = ?"+
			" where id_cliente = ?";
	@Override
	public Cliente findById(Integer key) {
		Cliente cliente = null;

		try ( // risorse autocloseable
			  Connection conn = DriverManager.getConnection(Parameters.MARIADB_DRIVER_URL);
			  PreparedStatement pst = conn.prepareStatement(findByIdQuery);
				) {
			pst.setInt(1, key);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				cliente = generateCliente(rs);
			}
		} catch (SQLException e) {
			log.error("Errore intervenuto durante le operazioni di utilizzo RDBMS", e);
			throw new DatabaseOperationException(e);
		}

		return cliente;
	}

	// prende i dati da result set e li incapsula nel cliente
	private Cliente generateCliente(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(rs.getInt("id_cliente"));
		cliente.setNome(rs.getString("nome"));
		cliente.setCognome(rs.getString("cognome"));
		cliente.setEmail(rs.getString("email"));
		cliente.setIndirizzo(rs.getString("indirizzo"));
		cliente.setCitta(rs.getString("citta"));
		cliente.setProvincia(rs.getString("provincia"));
		cliente.setCap(rs.getString("cap"));
		log.debug("Cliente {}", cliente);
		return cliente;
	}

	@Override
	public List<Cliente> findAll() {
		List<Cliente> clienti = new ArrayList<>();

		try ( // risorse autocloseable
			  Connection conn = DriverManager.getConnection(Parameters.MARIADB_DRIVER_URL);
			  PreparedStatement pst = conn.prepareStatement(findAllQuery);
			  ResultSet rs = pst.executeQuery();) {
			while (rs.next()) {
				clienti.add(generateCliente(rs));
			}
		} catch (SQLException e) {
			log.error("Errore intervenuto durante le operazioni di utilizzo RDBMS", e);
			throw new DatabaseOperationException(e);
		}
		return clienti;
	}

	@Override
	public Cliente create(Cliente entity) {
		int numeroRecord = 0;
		log.debug("Tentativo di creazione cliente {}", entity); // id_cliente=null
		try (Connection conn = DriverManager.getConnection(Parameters.MARIADB_DRIVER_URL);
			 PreparedStatement pst = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);) {
			setClienteToStatement(pst, entity);
			numeroRecord = pst.executeUpdate();
			// id_cliente è stato valorizzato e devo comunicarlo al client
			ResultSet rs = pst.getGeneratedKeys();
			if( rs.next() ) {
				entity.setIdCliente(rs.getInt(1)); // id_cliente valorizzato da DB
				log.debug("Creato cliente {}", entity);
			}
		} catch (Exception e) {
			log.error("Errore durante la create ", e);
			throw new DatabaseOperationException(e);
		}
		return entity;
	}

	private void setClienteToStatement(PreparedStatement pst, Cliente cliente) throws SQLException {
		if(cliente.getIdCliente()!= null) {
			pst.setInt(1, cliente.getIdCliente());
		} else {
			pst.setNull(1, Types.INTEGER);
		}

		pst.setString(2, cliente.getNome());
		pst.setString(3, cliente.getCognome());
		pst.setString(4, cliente.getEmail());
		pst.setString(5, cliente.getIndirizzo());
		pst.setString(6, cliente.getCitta());
		pst.setString(7, cliente.getProvincia());
		pst.setString(8, cliente.getCap());
	}
	@Override
	public Integer update(Cliente entity) {
		int numeroRecord = 0;
		try (Connection conn = DriverManager.getConnection(Parameters.MARIADB_DRIVER_URL);
			 PreparedStatement pst = conn.prepareStatement(updateQuery);) {
			// prendere l'id e leggere il dbper verificare che entity esista
			Cliente cliente = findById(entity.getIdCliente());

			// se esite prosegui se no ... ritorna 0
			if(cliente != null) {
				setClienteToStatementForUpdate(pst, entity);
				numeroRecord = pst.executeUpdate();
			}
		} catch (Exception e) {
			log.error("Errore durante la merge ", e);
			throw new DatabaseOperationException(e);
		}
		return numeroRecord;
	}

	private void setClienteToStatementForUpdate(PreparedStatement pst, Cliente cliente) throws SQLException {
		pst.setString(1, cliente.getNome());
		pst.setString(2, cliente.getCognome());
		pst.setString(3, cliente.getEmail());
		pst.setString(4, cliente.getIndirizzo());
		pst.setString(5, cliente.getCitta());
		pst.setString(6, cliente.getProvincia());
		pst.setString(7, cliente.getCap());
		pst.setInt(8, cliente.getIdCliente());
	}

	@Override
	public Integer delete(Integer key) {
		int numeroRecord = 0;
		try (Connection conn = DriverManager.getConnection(Parameters.MARIADB_DRIVER_URL);
			 PreparedStatement pst = conn.prepareStatement(removeByIdQuery);) {
			pst.setInt(1, key);
			numeroRecord = pst.executeUpdate();
		} catch (Exception e) {
			log.error("Errore durante la removeById ", e);
			throw new DatabaseOperationException(e);
		}
		return numeroRecord;
	}

}
