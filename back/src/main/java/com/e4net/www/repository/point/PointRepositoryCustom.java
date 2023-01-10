package com.e4net.www.repository.point;

import java.util.List;

import com.e4net.www.domain.point.PointDTO;

public interface PointRepositoryCustom {
	List<PointDTO> findMemberPoint(Long membSn);
}
