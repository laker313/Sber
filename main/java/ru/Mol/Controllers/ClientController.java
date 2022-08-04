package ru.Mol.Controllers;




import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Mol.Services.ClientService;

//@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping()
    public ResponseEntity index(@RequestBody String jsonClient) {

        return clientService.saveClient(jsonClient);
    }
}
