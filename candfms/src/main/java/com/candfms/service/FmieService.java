package com.candfms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candfms.models.Fmie;
import com.candfms.repositories.FmieRepository;
@Service
public class FmieService {

	
	@Autowired
	private FmieRepository fmieRepository;
	
	//Return list of year
	public List<Fmie> getFmies(){
		return fmieRepository.findAll();
	}
	
	//SAve new year
		public void save(Fmie fmie) {
			fmieRepository.save(fmie);
		}
		
		//get by id
		public Optional<Fmie> findById(int id) {
			return fmieRepository.findById(id);
		}

		public void delete(Integer id) {
			fmieRepository.deleteById(id);
		}
		
		
		
}
