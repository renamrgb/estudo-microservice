package com.github.renamrgb.msclientes.application.representation;

import com.github.renamrgb.msclientes.domain.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel() {
        return new Client(cpf, name, age);
    }
}
