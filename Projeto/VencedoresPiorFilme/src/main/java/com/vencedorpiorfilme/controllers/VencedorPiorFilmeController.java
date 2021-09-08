package com.vencedorpiorfilme.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.vencedorpiorfilme.entidades.IntervaloPremios;
import com.vencedorpiorfilme.entidades.MensagemRetorno;
import com.vencedorpiorfilme.entidades.VencedorPiorFilme;
import com.vencedorpiorfilme.repositories.VencedorPiorFilmeCN;
import com.vencedorpiorfilme.repositories.VencedorPiorFilmeRepository;

@RestController
@RequestMapping(value="/vencedores")
public class VencedorPiorFilmeController {

	@Autowired
	private VencedorPiorFilmeRepository repo;
	
	@GetMapping(value="getindicadosano/{ano}")
	public ResponseEntity<?> getIndicadosAno(@PathVariable Integer ano){
		List<VencedorPiorFilme> indicadosAno = repo.findByYear(ano);
		if(indicadosAno.size() > 0) {
			return ResponseEntity.ok(indicadosAno);
		}else {
			MensagemRetorno mensagem = new MensagemRetorno();
			mensagem.setMensagem("Não foi encontrado nenhum resultado para este ano."); 
			return ResponseEntity.ok(mensagem);
		}
		
	}
	
	@GetMapping(value="getvencedorano/{ano}")
	public ResponseEntity<?> getVencedorAno(@PathVariable Integer ano){
		List<VencedorPiorFilme> vencedor = repo.findByYearAndWinner(ano, "yes");
		if(vencedor.size() > 0) {
			return ResponseEntity.ok(vencedor);
		}else {
			MensagemRetorno mensagem = new MensagemRetorno();
			mensagem.setMensagem("Não foi encontrado nenhum resultado para este ano."); 
			return ResponseEntity.ok(mensagem);
		}
		
	}
	
	@GetMapping(value="getintervalo")
	public ResponseEntity<?> getVencedores(){
		IntervaloPremios intervalo = new VencedorPiorFilmeCN().findInterval(repo);
		if(intervalo != null) {
			return ResponseEntity.ok(intervalo);
		}else {
			MensagemRetorno mensagem = new MensagemRetorno();
			mensagem.setMensagem("Não foi encontrado nenhum resultado."); 
			return ResponseEntity.ok(mensagem);
		}		
	}
	
	@PostMapping(value="post")
	public ResponseEntity<?> postVencedor(@Valid @RequestBody VencedorPiorFilme vencedor) throws Exception {
			if(vencedor.getWinner() != null && !(vencedor.getWinner().equals("yes") || vencedor.getWinner().equals("no"))) {
				MensagemRetorno mensagem = new MensagemRetorno();
				mensagem.setMensagem("Para o campo Winner deve ser informado yes ou no."); 
				return ResponseEntity.ok(mensagem);
			}

			VencedorPiorFilme venc = repo.save(vencedor);
			if(venc != null) {
				return ResponseEntity.ok(venc);
			}else {
				MensagemRetorno mensagem = new MensagemRetorno();
				mensagem.setMensagem("Os dados não foram salvo."); 
				return ResponseEntity.ok(mensagem);
			}	
	}
	
	@PutMapping(value="put")
	public ResponseEntity<?> putVencedor(@Valid @RequestBody VencedorPiorFilme vencedor) throws Exception {
			if(vencedor.getWinner() != null && !(vencedor.getWinner().equals("yes") || vencedor.getWinner().equals("no"))) {
				MensagemRetorno mensagem = new MensagemRetorno();
				mensagem.setMensagem("Para o campo Winner deve ser informado yes ou no."); 
				return ResponseEntity.ok(mensagem);
			}

			VencedorPiorFilme venc = repo.save(vencedor);
			if(venc != null) {
				return ResponseEntity.ok(venc);
			}else {
				MensagemRetorno mensagem = new MensagemRetorno();
				mensagem.setMensagem("Os dados não foram salvo."); 
				return ResponseEntity.ok(mensagem);
			}	
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
}
