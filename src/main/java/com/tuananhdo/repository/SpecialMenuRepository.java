package com.tuananhdo.repository;

import com.tuananhdo.entity.SpecialMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialMenuRepository extends JpaRepository<SpecialMenu,Integer> {
}
