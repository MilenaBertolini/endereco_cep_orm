package iftm.orm.endereco.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import iftm.orm.endereco.model.Endereco;

@Service
public class ViaCepService {
    
    private final RestTemplate restTemplate = new RestTemplate();

    public Endereco consultarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ResponseEntity<Endereco> response = restTemplate.getForEntity(url, Endereco.class);
        return response.getBody();
    }
}
