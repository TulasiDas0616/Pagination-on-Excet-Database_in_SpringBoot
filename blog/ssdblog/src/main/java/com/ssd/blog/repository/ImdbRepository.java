package com.ssd.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ssd.blog.entity.ImdbData;

public interface ImdbRepository extends JpaRepository<ImdbData,String> {

}