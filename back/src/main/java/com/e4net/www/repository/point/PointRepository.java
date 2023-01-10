package com.e4net.www.repository.point;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e4net.www.entity.point.PointEntity;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Long> , PointRepositoryCustom {

}
