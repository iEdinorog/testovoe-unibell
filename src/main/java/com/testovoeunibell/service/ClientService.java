package com.testovoeunibell.service;

import com.testovoeunibell.dto.ClientDto;
import com.testovoeunibell.dto.ContactDto;
import com.testovoeunibell.entity.Client;
import com.testovoeunibell.entity.Contact;
import com.testovoeunibell.entity.ContactType;
import com.testovoeunibell.respository.ClientRepository;
import com.testovoeunibell.respository.ContactRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private ContactRepository contactRepository;
    private ClientRepository clientRepository;

    public Client saveClient(ClientDto dto) {
        var client = Client.builder()
                .username(dto.username())
                .email(dto.email())
                .phoneNumber(dto.phoneNumber())
                .contacts(new ArrayList<>())
                .build();

        return clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void addContact(ContactDto contactDto) {
        var client = getClientById(contactDto.clientId());
        var contact = saveContact(contactDto);

        client.getContacts().add(contact);

        clientRepository.save(client);
    }

    private Contact saveContact(ContactDto dto) {
        var contact = new Contact();
        contact.setData(dto.data());
        contact.setType(dto.type());

        return contactRepository.save(contact);
    }

    public List<Contact> getContacts(Integer clientId, ContactType type) {
        var client = getClientById(clientId);
        if (type == null) {
            return client.getContacts();
        }

        return client.getContacts()
                .stream()
                .filter(contact -> contact.getType() == type)
                .toList();
    }
}
