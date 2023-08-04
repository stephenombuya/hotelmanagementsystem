package hotelmanagementsystem;

public class Guest {

	    private String name;
	    private String email;

	    public Guest(String name, String email) {
	        this.name = name;
	        this.email = email;
	    }

	    // Getters and setters

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	}
