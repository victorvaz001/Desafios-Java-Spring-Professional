package com.victorvaz.CrudClientes.repositories;


import com.victorvaz.CrudClientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
