package com.tuananhdo.service.impl;

import com.tuananhdo.entity.Role;
import com.tuananhdo.repository.RoleRepository;
import com.tuananhdo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listRole() {
        return roleRepository.findAll();
    }
}

