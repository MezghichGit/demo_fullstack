package com.sip.ams.services;
import com.sip.ams.entities.Provider;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface ProviderService {
	
	List<Provider>listProviders();
	Provider getProvider(long id);
	//Provider saveProvider(Provider provider);
	Provider saveProvider(MultipartFile file,String name,String email,String address);
	void deleteProvider(long id);
	Optional<Provider>findProviderById(long id);

}
