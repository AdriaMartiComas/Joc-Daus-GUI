package cat.itacademy.barcelonactiva.marti_comas.adria.s05.t02.n01.model.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t02.n01.model.domain.Partida;
import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t02.n01.model.domain.Usuari;
import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t02.n01.model.repository.PartidaRepository;
import cat.itacademy.barcelonactiva.marti_comas.adria.s05.t02.n01.model.repository.UsuariRepository;

@Service
public class PartidaServiceImpl implements PartidaService {

	@Autowired
	private PartidaRepository pRepo;
	
	@Autowired
	private UsuariRepository uRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Partida> mostrarPartidesUsuari(Integer pk_UsuariID) {
		List<Partida> partidesUsuari = pRepo.findAll().stream()
				.filter(u -> pk_UsuariID == u.getUsuari().getPk_UsuariID()).collect(Collectors.toList());

		return partidesUsuari;
	}

	@Override
	@Transactional
	public void guardar(Partida partida, Integer pk_UsuariID) {
		Usuari usuari = uRepo.findById(pk_UsuariID).get();
		partida.setUsuari(usuari);
		pRepo.save(partida);
	}

	@Override
	@Transactional
	public void eliminarPartides(Integer pk_UsuariID) {
		List<Partida> partidesUsuari = pRepo.findAll().stream()
				.filter(u -> pk_UsuariID == u.getUsuari().getPk_UsuariID()).collect(Collectors.toList());
		pRepo.deleteAll(partidesUsuari);

	}

}
