package com.kubedemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kubedemo.dto.KubeDto;
import com.kubedemo.service.KubeService;

@RestController
@RequestMapping("/api/account")
public class KubeController {
	
	private KubeService kubeService;	
	
	@Autowired
	 public KubeController(KubeService kubeService){
	        this.kubeService=kubeService;
	    }

	    @PostMapping
	    public ResponseEntity<KubeDto> addAccount(@RequestBody KubeDto kubeDto){
	        return new ResponseEntity<>(kubeService.createAccount(kubeDto), HttpStatus.CREATED);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<KubeDto> getAccountById(@PathVariable Long id){
	    	KubeDto kubeDto= kubeService.getAccountbyId(id);
	        return ResponseEntity.ok(kubeDto);
	    }

	    @PutMapping("/{id}/deposit")
	    public ResponseEntity<KubeDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
	        Double amount = request.get("amount");
	        KubeDto kubeDto= kubeService.deposit(id, amount);
	        return ResponseEntity.ok(kubeDto);
	    }

	    @PutMapping("/{id}/withdraw")
	    public ResponseEntity<KubeDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
	        Double amount = request.get("amount");
	        KubeDto accountDto= kubeService.withdraw(id, amount);
	        return ResponseEntity.ok(accountDto);
	    }

	    @GetMapping
	    public ResponseEntity<List<KubeDto>> getAllAccounts(){
	        List<KubeDto> accounts = kubeService.getAllAccounts();
	        return ResponseEntity.ok(accounts);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
	        kubeService.deleteAccount(id);
	        return ResponseEntity.ok("Account deleted successfully");
	    }
	
}
