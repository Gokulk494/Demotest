package eight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String gmail;
    private String dob;
    private String Interest;
    private String Domain;

	private String address;
   

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public  String getdob()
    {
    	return dob;
    }
    public void setdob(String Date_of_Birth)
    {
    	this.dob=Date_of_Birth;
    }
    public  String getaddress()
    {
    	return address;
    }
    public void setaddress(String Address)
    {
    	this.address=Address;
    }
    public  String getInterest()
    {
    	return Interest;
    }
    public void setInterest(String Interest)
    {
    	this.Interest=Interest;
    }
    	public  String getDomain()
        {
        	return Domain;
        }
        public void setDomain(String Domain)
        {
        	this.Domain=Domain;
        }
    }

