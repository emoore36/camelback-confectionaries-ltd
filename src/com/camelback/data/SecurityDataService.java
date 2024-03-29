/**
 * 
 */
package com.camelback.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.camelback.beans.CredentialSet;
import com.camelback.util.DatabaseException;

/**
 * @author Owner
 *
 */
public class SecurityDataService implements SecurityDataInterface<CredentialSet> {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	/**
	 * Find if the database contains the user's credentials.
	 * 
	 * @param cred
	 *            The user credentials.
	 * @return 1 if found, 0 if not.
	 */
	public int find(CredentialSet cred) {

		// create SQL String
		String sql = "SELECT * FROM USER_TABLE WHERE USERNAME = ? AND PASSWORD = ?";

		try {
			// execute SQL and retrieve info
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql, cred.getUsername(), cred.getPassword());

			if (srs.next()) {
				return 1; // user found
			} else {
				return 0; // user not found
			}

		} catch (Exception e) {
			// database error. Throw exception.
			e.printStackTrace();
			throw new DatabaseException(e);
		}
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

}
