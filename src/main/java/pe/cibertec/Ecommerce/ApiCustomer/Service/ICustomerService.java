package pe.cibertec.Ecommerce.ApiCustomer.Service;

import java.util.List;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;

public interface ICustomerService {
    public List<Customer> ListadoClientes();
    public Customer BuscarXId(Long Id);
    //Semana 04
    public Customer BuscarXEmail(String email);
    public Customer BuscarXPhone(String celular);
    //Hasta aquí ya hicimos 2 formas de busqueda
    //Ahora el resto del CRUD, Insertar, Actualzar y Borrar, para ello ya no nececitas ir al CustumerReposotory(DAO)
    public Customer Insertar(Customer customer);
    public Customer Actualizar(Long Id, Customer customer);//Para el Upload 1ro realizo la busqueda por Id, y luego actualiza el Objeto Customer
    public void Borrar(Long Id); //Para el Delete devuelve un vacio, osea no devuelve nada
}
