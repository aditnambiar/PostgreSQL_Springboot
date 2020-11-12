package com.cred.io.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cred.io.model.Address;
import com.cred.io.model.ContactInfo;
import com.cred.io.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/CRED_DB");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("123456");
        return dataSourceBuilder.build();
    }

	
	private JdbcTemplate createJdbcTemplate() {

		JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(getDataSource());
        return template;
	}
 
	@Override
	public void insertContactInfo(Customer cus) {
	        String sql = "INSERT INTO contactinfo(id, firstname, lastname, dateofbirth, email, phonenumber) "
	                + "VALUES(?,?,?,?,?,?)" ;
	        	  
	        
	        Object[] params = {cus.getContactInfo().getCustomerID(), 
	        					cus.getContactInfo().getFirstName(), 
	        					cus.getContactInfo().getLastName(),
	        					cus.getContactInfo().getDateOfBirth(),
	        					cus.getContactInfo().getEmail(),
	        					cus.getContactInfo().getPhoneNumber()};
	        
	        createJdbcTemplate().update(sql, params);
	        
	 }
	 
	@Override
	public void insertAddress(Customer cus) {
	        String sql = "INSERT INTO addressinfo(addressline1, addressline2, city, state, zipcode, id) "
	                + "VALUES(?,?,?,?,?,?)" ;
	        	     
	        
	        Object[] params = {cus.getAddress().getAddressLine1(),
	        					cus.getAddress().getAddressLine2(),
	        					cus.getAddress().getCity(),
	        					cus.getAddress().getState(),
	        					cus.getAddress().getZipCode(),
	        					cus.getContactInfo().getCustomerID()};
	        
	        createJdbcTemplate().update(sql, params);
	 }
	
	@Override
	public void insert(Customer cus) {
		
		this.insertContactInfo(cus);
		this.insertAddress(cus);
	        
	 }
	
	@Override
	public void deleteContactInfo(int id) {
		String sql = "DELETE FROM contactinfo WHERE id = ?";
		createJdbcTemplate().update(sql, id);
		
	}
	
	@Override
	public void deleteAddress(int id) {
		String sql = "DELETE FROM addressinfo WHERE id = ?";
		createJdbcTemplate().update(sql, id);
	}
	
	@Override
	public void delete(int id) {
		this.deleteContactInfo(id);
		this.deleteAddress(id);
	}
	
	
	@Override
	public void updateContactInfo(int id, String firstName, String lastName, String dateOfBirth, String email, int phoneNumber) {
		String sql = "UPDATE contactinfo "
                + "SET firstname = ?, "
                + "lastname = ?, "
                + "dateofbirth = ?, "
                + "email = ?, "
                + "phonenumber = ? "
                + "WHERE id = ?";
		
		createJdbcTemplate().update(sql, firstName, lastName, dateOfBirth, email, phoneNumber, id);
		
		
	}
	
	@Override
	public void updateAddress(int id, String addressline1, String addressline2, String city, String state, int zipcode) {
		String sql = "UPDATE addressinfo "
                + "SET addressline1 = ?, "
                + "addressline2 = ?, "
                + "city = ?, "
                + "state = ?, "
                + "zipcode = ? "
                + "WHERE id = ?";
		
		createJdbcTemplate().update(sql, addressline1, addressline2, city, state, zipcode, id);
		
	}
	
	@Override
	public List<Customer> returnCustomers() {
		String sql_1 = "SELECT * FROM contactinfo";
		String sql_2 = "SELECT * FROM addressinfo";
        List<Map<String, Object>> rows_1 = createJdbcTemplate().queryForList(sql_1);
        List<Map<String, Object>> rows_2 = createJdbcTemplate().queryForList(sql_2);
        
        
        List<Customer> result = new ArrayList<Customer>();
        for(Map<String, Object> row:rows_1){
        
          ContactInfo contactInfo = new ContactInfo();
          contactInfo.setCustomerID(((Long)row.get("id")).intValue());
          contactInfo.setFirstName((String)row.get("firstname"));
          contactInfo.setLastName((String)row.get("lastname"));
          contactInfo.setDateOfBirth((String)row.get("dateofbirth"));
          contactInfo.setEmail((String)row.get("email"));
          contactInfo.setPhoneNumber(((Long)row.get("phonenumber")).intValue());
          
          Customer cus = new Customer(contactInfo, true, new Address());
         
          result.add(cus);
        }
        
        for(int i = 0; i< rows_2.size(); i++){
            Customer cus = result.get(i);
            Map<String, Object> row = rows_2.get(i);
            cus.getAddress().setAddressLine1((String)row.get("addressline1"));
            cus.getAddress().setAddressLine2((String)row.get("addressline2"));
            cus.getAddress().setCity((String)row.get("city"));
            cus.getAddress().setState((String)row.get("state"));
            cus.getAddress().setZipcode((Integer)row.get("zipcode"));
           
          }
     
        return result;
	}
	
	@Override
	public String findNameByID(int id) {
		String sql_1 = "SELECT firstname FROM contactinfo WHERE id = ?";
		String firstName = createJdbcTemplate().queryForObject(sql_1, new Object[]{id}, String.class);
		String sql_2 = "SELECT lastname FROM contactinfo WHERE id = ?";
		String lastName = createJdbcTemplate().queryForObject(sql_2, new Object[]{id}, String.class);
		
		return (firstName + " " + lastName);
		
	}
	  
	@Override
	public ContactInfo findContactInfoByID(int id) {
		String sql = "SELECT * FROM contactinfo WHERE id = ?";
	      return (ContactInfo)createJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<ContactInfo>(){
	        @Override
	        public ContactInfo mapRow(ResultSet rs, int rwNumber) throws SQLException {
	          ContactInfo contactInfo = new ContactInfo();
	          contactInfo.setCustomerID(rs.getInt("id"));
	          contactInfo.setFirstName(rs.getString("firstname"));
	          contactInfo.setLastName(rs.getString("lastname"));
	          contactInfo.setDateOfBirth(rs.getString("dateofbirth"));
	          contactInfo.setEmail(rs.getString("email"));
	          contactInfo.setPhoneNumber(rs.getInt("phonenumber"));
	          return contactInfo;
	        }
	      });
	}
	
	@Override
	public Address findAddressByID(int id) {
		String sql = "SELECT * FROM addressinfo WHERE id = ?";
		return (Address)createJdbcTemplate().queryForObject(sql, new Object[]{id}, new RowMapper<Address>(){
	        @Override
	        public Address mapRow(ResultSet rs, int rwNumber) throws SQLException {
	          Address address = new Address();
	          address.setAddressLine1(rs.getString("addressline1"));
	          address.setAddressLine2(rs.getString("addressline2"));
	          address.setCity(rs.getString("city"));
	          address.setState(rs.getString("state"));
	          address.setZipCode(rs.getInt("zipcode"));
	          return address;
	        }
	      });
		
	}
	
	@Override
	public Customer findByID(int id) {
		
		return new Customer(
		this.findContactInfoByID(id),
		true,
		this.findAddressByID(id));
		
	}
	
	
	public int returnCount() {
		String sql = "SELECT count(*) FROM contactinfo";
		return createJdbcTemplate().queryForObject(sql, Integer.class);

	}
	
	
	  

}
