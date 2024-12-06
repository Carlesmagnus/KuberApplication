package com.kubedemo.mapper;

import com.kubedemo.dto.KubeDto;
import com.kubedemo.entity.KubeEntity;

public class KubeMapper {
	public static KubeEntity mapToAccount(KubeDto kubeDto) {
        KubeEntity entity = new KubeEntity(kubeDto.getId(),
        		kubeDto.getAccountHolderName(),
        		kubeDto.getBalance());
        return entity;
    }

    public static KubeDto mapToAccountDto(KubeEntity entity) {
    	KubeDto kubeDto = new KubeDto(entity.getId(),
    			entity.getAccountHolderName(),
    			entity.getBalance());
        return kubeDto;
    }
}
