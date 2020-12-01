package com.tuananhdo.service.impl;

import com.tuananhdo.entity.SpecialMenu;
import com.tuananhdo.repository.SpecialMenuRepository;
import com.tuananhdo.service.SpecialMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialMenuServiceImpl implements SpecialMenuService {

    @Autowired
    private SpecialMenuRepository specialMenuRepository;
    @Override
    public List<SpecialMenu> findAll() {
        return specialMenuRepository.findAll();
    }
}
