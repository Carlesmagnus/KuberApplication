package com.kubedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kubedemo.entity.KubeEntity;

public interface KubeRepository extends JpaRepository<KubeEntity, Long>{

}
