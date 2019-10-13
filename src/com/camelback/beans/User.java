package com.camelback.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull(message = "Please include first name.")
	private String firstName;

	@NotNull(message = "Please include last name.")
	private String lastName;

	private CredentialSet credentials;

	@NotNull(message = "Please include email address.")
	@Size(min = 6, max = 16, message = "Email Address must be between 6 and 16 characters.")
	private String email;

	// default constructor
	public User() {
		firstName = "";
		lastName = "";
		credentials = null;
		email = "";
	}

	/**
	 * A model of the user in the database.
	 * 
	 * @param firstName
	 *            The user's first name.
	 * @param lastName
	 *            The user's last name.
	 * @param credentials
	 *            The user's login credentials: username and password.
	 * @param email
	 *            The user's email address.
	 */
	public User(String firstName, String lastName, CredentialSet credentials, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.credentials = credentials;
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the credentials
	 */
	public CredentialSet getCredentials() {
		return credentials;
	}

	/**
	 * @param credentials
	 *            the credentials to set
	 */
	public void setCredentials(CredentialSet credentials) {
		this.credentials = credentials;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "user";
	}

}