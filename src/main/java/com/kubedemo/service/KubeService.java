package com.kubedemo.service;

import java.util.List;

import com.kubedemo.dto.KubeDto;

public interface KubeService {
	KubeDto createAccount(KubeDto kubeDto);
    KubeDto getAccountbyId(Long id);
    KubeDto deposit(Long id, double amount);
    KubeDto withdraw(Long id, double amount);
    List<KubeDto> getAllAccounts();
    void deleteAccount(Long id);
}
