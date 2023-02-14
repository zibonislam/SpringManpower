package com.manpower.management.service;

import com.manpower.management.entity.UpdateEntity;
import com.manpower.management.repository.PostRepository;
import com.manpower.management.repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateService {

@Autowired
UpdateRepository updateRepository;

public Optional<UpdateEntity> findById(long id) {
    return updateRepository.findById(id);
}

}

