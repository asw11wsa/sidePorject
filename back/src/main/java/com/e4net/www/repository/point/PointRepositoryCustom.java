package com.e4net.www.repository.point;

import java.util.List;

import com.e4net.www.domain.ParentDTO;

public interface PointRepositoryCustom {
	List<ParentDTO> findMemberPoint(Long membSn);
	List<ParentDTO> findMemberPointTest(Long membSn);
}
