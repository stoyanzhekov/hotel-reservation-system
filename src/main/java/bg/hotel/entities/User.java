/**
 * 
 */
package bg.hotel.entities;

/**
 * @author Siva
 *
 */
public class User 
{
	private Integer userId;
	private String userName;
	
	public User(String name, Integer id) {
		this.userId = id;
		this.userName = name;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
