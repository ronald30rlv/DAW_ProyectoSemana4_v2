
package pe.cibertec.Ecommerce.ApiCustomer.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.Ecommerce.ApiCustomer.Entity.Customer;
import pe.cibertec.Ecommerce.ApiCustomer.Service.ICustomerService;

@RestController //En el Browser te va a devolver una vista en formato Json, para un WebService
//@Controller //Para cuando ya tengas tus propios html
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    ICustomerService reposiCustomerService ;//Esta inyeccion de dependencia de la Interface, busca y conecta con la clase o clases de Implementacion(que es la que tiene la coneccion a la BD)
    //Ahora vamos a construir nuestros EndPoint's
    @GetMapping("/findAll")
    public List<Customer> findAll(){                
        return reposiCustomerService.ListadoClientes(); //api/customer/findAll
    }
    @GetMapping("/findById/{Id}")
    public Customer findById(@PathVariable Long Id){
        return reposiCustomerService.BuscarXId(Id); //api/customer/findById/2
    }
    @GetMapping("/findByEmail/{email}")
    public Customer findByEmail(@PathVariable String email){
        return reposiCustomerService.BuscarXEmail(email); //api/customer/findByEmail/
    }
    @GetMapping("/findByPhone")
    public Customer findByPhone(@RequestParam String celular){ //@RequestParam nos permite extraer los parámetros de una consulta
        return reposiCustomerService.BuscarXPhone(celular); //api/customer/findByPhone
        //formato busqueva en browser localhost:8085/api/customer/findByPhone?celular=936825147
    } 
    //Ahora vamos a agregar los otros CRUD, 
    //recuerda que GET es para obtener(encontrar),POST es para Agregar(Insert), PUT es para Actualizar (Update) y Delete para borrar
    @PostMapping("/agregar")
    public Customer Agregar(@RequestBody Customer customer){
        return reposiCustomerService.Insertar(customer);
    }
    @PutMapping("/actualizar/{Id}")
    public Customer Actualizar(@PathVariable Long Id,@RequestBody Customer customer){
        return reposiCustomerService.Actualizar(Id, customer);
    }
    @DeleteMapping("/borrar/{Id}")
    public void Borrar(@PathVariable Long Id){
        reposiCustomerService.Borrar(Id);
    }
}
