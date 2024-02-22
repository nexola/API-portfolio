package com.nexola.apiportfolio.services;

import com.nexola.apiportfolio.models.dto.PortfolioDTO;
import com.nexola.apiportfolio.models.entities.Portfolio;
import com.nexola.apiportfolio.repositories.PortfolioRepository;
import com.nexola.apiportfolio.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository repository;

    @Transactional(readOnly = true)
    public PortfolioDTO getPortfolio(String id) {
        Portfolio entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new PortfolioDTO(entity);
    }
}
