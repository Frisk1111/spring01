package com.example.javadb.prova;

import com.example.javadb.exceptions.DatabaseOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

import static com.example.javadb.params.Parameters.*;

public class Prova02 {

	private static final Logger log = LogManager.getLogger(Prova02.class);

	public static void main(String[] args)  {

		String sqlQuery = "select id_cliente, nome, cognome from clienti order by cognome, nome";

		// connessione al DB
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(MARIADB_DRIVER_URL);
			log.trace("Dopo apertura connection");
			// preparazione di uno Statement da inviare al DB
			pst = conn.prepareStatement(sqlQuery);
			log.trace("Dopo preparazione statement");
			// eseguiamo la query
			rs = pst.executeQuery();
			log.trace("Dopo esecuzione statement");
			// stampare i risultati della query
			while (rs.next()) {
				String str = String.format("id=%s, cognome=%s, nome=%s", rs.getInt("id_cliente"), rs.getString(3),
						rs.getString("nome"));
				System.out.println(str);
			}
			log.trace("Dopo lettura result set");


		} catch (SQLException e) {
			log.error("Errore intervenuto durante le operazioni di utilizzo RDBMS", e);
			// System.exit(-1); // brutto e sbagliato
			throw new DatabaseOperationException(e); // istanza di RuntimeException
		} finally {
			log.trace("Blocco finally");
			// shutdown del ResultSet
			try {
				rs.close();
				log.trace("Dopo chiusura result set");
			} catch (Exception e) {
			}
			// shutdown dello Statement
			try {
				pst.close();
				log.trace("Dopo chiusura statement");
			} catch (Exception e) {
			}
			// PIU IMPORTANTE va sempre fatta
			// close della connessione
			try {
				conn.close();
				log.trace("Dopo chiusura connection");
			} catch (Exception e) {
			}
		}

	}

}
