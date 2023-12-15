package com.victorvaz.CrudClientes.services;

import com.victorvaz.CrudClientes.dto.ClientDTO;
import com.victorvaz.CrudClientes.entities.Client;
import com.victorvaz.CrudClientes.repositories.ClientRepository;
import com.victorvaz.CrudClientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){

        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente inexistente"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> client = clientRepository.findAll(pageable);
        return client.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){

        Client entity = new Client();
        copyDtoEntity(dto, entity);
        entity = clientRepository.save(entity);

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update (Long id, ClientDTO dto) {
    try {
        Client entity = clientRepository.getReferenceById(id);
        copyDtoEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }
    catch (EntityNotFoundException e) {
        throw new ResourceNotFoundException("Id Não encontrato!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete (Long id){
    if (!clientRepository.existsById(id)){
        throw new ResourceNotFoundException("Id não encontrado!");
    }

        clientRepository.deleteById(id);
    }

    public void copyDtoEntity (ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

}
