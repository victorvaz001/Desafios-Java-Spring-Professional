package com.victorvaz.CrudClientes.dto;

import com.victorvaz.CrudClientes.entities.Client;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ClientDTO {


    private Long id;

    @NotBlank(message = "O campo 'name' e requerido")
    private String name;

    @Size(min = 11, max = 11, message = "CPF deve conter 11 digitos")
    @NotBlank(message = "O CPF e requerido")
    private String cpf;
    private Double income;

    @PastOrPresent(message = "A data de nascimento não pode ser uma data futura")
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO (Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income =  entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
