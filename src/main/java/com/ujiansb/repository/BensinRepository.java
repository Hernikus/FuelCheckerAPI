package com.ujiansb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujiansb.model.Bensin;

public interface BensinRepository extends JpaRepository <Bensin, Long>{
	List<Bensin> findByid(Long id);
	List<Bensin> findByPerusahaan(String perusahaan);
	List<Bensin> findByOktan(int oktan);
	String deleteByNamaAndPerusahaan(String nama, String perusahaan);
	List<Bensin> findByNamaAndPerusahaan(String nama, String perusahaan);
}
