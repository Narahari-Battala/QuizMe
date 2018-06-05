package com.telusko.Bean;

public class UserBean {

		
	private String usertype; 
	private String email;
	
	private boolean valid; 
	

	




	public UserBean(String usertype, String email, String username, String password, String firstName,
			String lastName) {
		super();
		this.usertype = usertype;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}




	public UserBean() {
		super();
	}

	


	public boolean isValid() {
		return valid;
	}




	public void setValid(boolean valid) {
		this.valid = valid;
	}




	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	      private String username;
	      private String password;
	      private String firstName;
	      private String lastName;

		
		
	      public String getFirstName() {
	         return firstName;
		 }

	      public void setFirstName(String newFirstName) {
	         firstName = newFirstName;
		 }

		
	      public String getLastName() {
	         return lastName;
				}

	      public void setLastName(String newLastName) {
	         lastName = newLastName;
				}
				

	      public String getPassword() {
	         return password;
		}

	      public void setPassword(String newPassword) {
	         password = newPassword;
		}
		
				
	      public String getUsername() {
	         return username;
				}

	      public void setUserName(String newUsername) {
	         username = newUsername;
				}

					
	    

		
	}


