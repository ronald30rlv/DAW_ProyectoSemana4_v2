
package pe.cibertec.Ecommerce.ApiCustomer.Service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.Ecommerce.ApiCustomer.DAO.CustomerRepository;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;

@Service
public class CustomerServiceImplement implements ICustomerService {
    @Autowired
    private CustomerRepository repository; //Esto es la inyeccion de dependencias
    
    @Override
    public List<Customer> ListadoClientes() {        
        return (List<Customer>) repository.findAll();
    }
    @Override
    public Customer BuscarXId(Long Id) {
     return repository.findById(Id).orElse(null);
    }    

    @Override
    public Customer BuscarXEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Customer BuscarXPhone(String celular) {
        return repository.findByPhone(celular);
    }

    @Override
    public Customer Insertar(Customer customer) {
     return repository.save(customer);
    }
    @Override
    public Customer Actualizar(Long Id, Customer customer) {
        //Para el Update, hay que hacer varios pasos, ya que 1ro nececitas traer los datos(Objeto Customer), para luego actualizarlos
        Customer customerDB=repository.findById(Id).get(); //Para saber a quien vas a actualizar, 1ro debes buscar por Id y obtener el Objeto
        //Ahora actualizamos, cada campo; OJO, la busqueda ya la hiciste por Id
        customerDB.setNombre(customer.getNombre());
        customerDB.setApepaterno(customer.getApepaterno());
        customerDB.setApematerno(customer.getApematerno());
        customerDB.setEdad(customer.getEdad());
        customerDB.setSexo(customer.getSexo());
        customerDB.setCelular(customer.getCelular());
        customerDB.setFechanacimiento(customer.getFechanacimiento());
        customerDB.setEmail(customer.getEmail());
        return repository.save(customerDB); //Guardas los cambios que hicistes
    }
    @Override
    public void Borrar(Long Id) {
     //Para el Delete, 1ro nececitas traer los datos(Objeto Customer), para luego eliminarlo
       Customer customerDB=repository.findById(Id).get();
       repository.delete(customerDB);
    }
}
