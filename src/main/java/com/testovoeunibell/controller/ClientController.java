package com.testovoeunibell.controller;

import com.testovoeunibell.dto.ClientDto;
import com.testovoeunibell.dto.ContactDto;
import com.testovoeunibell.entity.Client;
import com.testovoeunibell.entity.Contact;
import com.testovoeunibell.entity.ContactType;
import com.testovoeunibell.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody ClientDto clientDto) {
        var client = clientService.saveClient(clientDto);

        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Integer id) {
        var client = clientService.getClientById(id);

        return ResponseEntity.ok(client);
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getClients() {
        var clients = clientService.getClients();

        return ResponseEntity.ok(clients);
    }

    @PostMapping("/add/contact")
    public ResponseEntity<HttpStatus> addContact(@RequestBody ContactDto contactDto) {
        clientService.addContact(contactDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<List<Contact>> getContacts(@PathVariable Integer id, @RequestParam(required = false) ContactType type) {
        var contacts = clientService.getContacts(id, type);

        return ResponseEntity.ok(contacts);
    }
}
