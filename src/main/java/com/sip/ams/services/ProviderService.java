package com.sip.ams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sip.ams.entities.Provider;
import com.sip.ams.exceptions.ResourceNotFoundException;
import com.sip.ams.repositories.ProviderRepository;




@Service
public class ProviderService {
	
	@Autowired
	private ProviderRepository providerRepository;

	public List<Provider> findAll() {
		return (List<Provider>) providerRepository.findAll();
	}
	
	public Provider findOneProvider(long id) {
		return  providerRepository.findById(id).get();
	}
	
	public Provider create(Provider provider) {
		return providerRepository.save(provider);
	}
	
	public Provider update(Long providerId,  Provider providerRequest) {
		return providerRepository.findById(providerId).map(provider -> {
			
			provider.setName(providerRequest.getName());
			provider.setEmail(providerRequest.getEmail());
			provider.setAddress(providerRequest.getAddress());
			
			return providerRepository.save(provider);
		}).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + providerId + " not found"));
	}
	
	public Provider delete(Long providerId) {
		return providerRepository.findById(providerId).map(provider -> {
			 providerRepository.delete(provider);
			return provider;
	
		}).orElseThrow(() -> new ResourceNotFoundException("ProviderId " + providerId + " not found"));
	}
}
