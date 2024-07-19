package com.kubedemo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kubedemo.dto.KubeDto;
import com.kubedemo.entity.KubeEntity;
import com.kubedemo.mapper.KubeMapper;
import com.kubedemo.repository.KubeRepository;
import com.kubedemo.service.KubeService;

@Service
public class KubeImpl implements KubeService{

	private KubeRepository kubeRepository;

    private KubeImpl(KubeRepository kubeRepository){
        this.kubeRepository=kubeRepository;
    }
    
    public KubeDto createAccount(KubeDto kubeDto) {
        KubeEntity account = KubeMapper.mapToAccount(kubeDto);
        KubeEntity savedAccount = kubeRepository.save(account);
        return KubeMapper.mapToAccountDto(savedAccount);
    }

    public KubeDto getAccountbyId(Long id) {
        KubeEntity account= kubeRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        return KubeMapper.mapToAccountDto(account);
    }

    public KubeDto deposit(Long id, double amount) {
        KubeEntity account= kubeRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        KubeEntity savedAccount = kubeRepository.save(account);
        return KubeMapper.mapToAccountDto(savedAccount);
    }

    public KubeDto withdraw(Long id, double amount) {
        KubeEntity account= kubeRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));

        if(account.getBalance()< amount){
            throw  new RuntimeException("Insufficient amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        KubeEntity savedAccount = kubeRepository.save(account);
        return KubeMapper.mapToAccountDto(savedAccount);
    }

    public List<KubeDto> getAllAccounts() {
        List<KubeEntity> accounts = kubeRepository.findAll();
        return accounts.stream().map((account)-> KubeMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    public void deleteAccount(Long id) {
        KubeEntity account= kubeRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        kubeRepository.deleteById(id);
    }
}
