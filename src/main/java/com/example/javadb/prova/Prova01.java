package com.example.javadb.prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.javadb.params.Parameters.*;

public class Prova01 {

	public static void main(String[] args) throws Exception {

		String sqlQuery = "select id_cliente, nome, cognome from clienti order by cognome, nome";

		// connessione al DB
		Connection conn = DriverManager.getConnection(MARIADB_DRIVER_URL);

		// preparazione di uno Statement da inviare al DB
		PreparedStatement pst = conn.prepareStatement(sqlQuery);

		// eseguiamo la query
		ResultSet rs = pst.executeQuery();

		// stampare i risultati della query
		while( rs.next() ) {
			String str = String.format("id=%s, cognome=%s, nome=%s", rs.getInt("id_cliente"), rs.getString(3), rs.getString("nome"));
			System.out.println(str);
		}

		// shutdown del ResultSet
		rs.close();

		// shutdown dello Statement
		pst.close();

		// PIU IMPORTANTE va sempre fatta
		// close della connessione
		conn.close();
	}

}
