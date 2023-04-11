package pe.cibertec.Ecommerce.ApiCustomer.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
    //Vamos a crear un metodo que nos devuelve el email (Clase semana 04)
    Customer findByEmail(String email);
    @Query(value="select * from customer c where c.celular= :celular", nativeQuery=true)
    Customer findByPhone(String celular);
    
}
