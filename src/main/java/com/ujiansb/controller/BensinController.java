package com.ujiansb.controller;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujiansb.model.Bensin;
import com.ujiansb.repository.BensinRepository;

@RestController
@RequestMapping("/bensin")
public class BensinController {

	@Autowired
	BensinRepository bensinRepo;

	@PostMapping("/insert")
	public String postData(@RequestBody Bensin bensin) {
		bensinRepo.save(bensin);
		return "Produk Bensin berhasil ditambahkan";
	}
	@GetMapping("/index")
	public List<Bensin> getAllData()	{
		return bensinRepo.findAll();
	}
	@GetMapping("/getById/{id}")
    public List<Bensin> getAllDataById(@PathVariable(value="id") Long id) {
		return bensinRepo.findByid(id);
     }
	@GetMapping("/getByPerusahaan/{perusahaan}")
    public List<Bensin> getAllDataByPerusahaan(@PathVariable(value="perusahaan") String perusahaan) {
		return bensinRepo.findByPerusahaan(perusahaan);
     }
	@GetMapping("/getByOktan/{oktan}")
    public List<Bensin> getAllDataByOktan(@PathVariable(value="oktan") int oktan) {
		return bensinRepo.findByOktan(oktan);
     }
	@GetMapping("/getByNama-Perusahaan/nama={nama}&perusahaan={perusahaan}")
    public List<Bensin> getAllDataByNamaUmur(@RequestParam(value = "nama", defaultValue = "{nama}") String nama, @RequestParam(value = "perusahaan", defaultValue = "{perusahaan}") String perusahaan) {
		return bensinRepo.findByNamaAndPerusahaan(nama,perusahaan);
     }
	@GetMapping("/update")
	public String updateId(@RequestBody Bensin bensin) 	{
		bensinRepo.save(bensin);
		return "Data bensin berhasil diubah";
	}
	@Transactional

	@DeleteMapping("/deleteByNama-Perusahaan/nama={nama}&perusahaan={perusahaan}")
	  public String deleteByNamaAndPerusahaan(@RequestParam(value = "nama", defaultValue = "{nama}") String nama, @RequestParam(value = "perusahaan", defaultValue = "{perusahaan}") String perusahaan)	{
		bensinRepo.deleteByNamaAndPerusahaan(nama,perusahaan);
		return "Produk bensin "+perusahaan+""+nama+" berhasil dihapus";
	}
}
