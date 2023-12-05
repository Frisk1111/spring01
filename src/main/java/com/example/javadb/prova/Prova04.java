package com.example.javadb.prova;

import com.example.javadb.exceptions.DatabaseOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.example.javadb.params.Parameters.*;

public class Prova04 {

	private static final Logger log = LogManager.getLogger(Prova04.class);

	public static void main(String[] args) {

		String sqlQuery = "select id_cliente, nome, cognome from clienti where id_cliente = ?";

		/**
		 * TRY With Resources
		 */
		ResultSet rs = null;
		try ( // risorse autocloseable
				Connection conn = DriverManager.getConnection(MARIADB_DRIVER_URL);
				PreparedStatement pst = conn.prepareStatement(sqlQuery);) {
			pst.setInt(1, 3);
			rs = pst.executeQuery();
			log.trace("Dopo esecuzione statement");
			if (rs.next()) {
				String str = String.format("id=%s, cognome=%s, nome=%s", rs.getInt("id_cliente"), rs.getString(3),
						rs.getString("nome"));
				System.out.println(str);
			}
			log.trace("Dopo lettura result set");

		} catch (SQLException e) {
			log.error("Errore intervenuto durante le operazioni di utilizzo RDBMS", e);
			throw new DatabaseOperationException(e);
		} finally {
			log.trace("Blocco finally");
			try {
				rs.close();
			} catch (Exception e) {
			}
		}
	}

}
