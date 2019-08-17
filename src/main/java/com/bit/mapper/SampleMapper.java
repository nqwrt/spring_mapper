package com.bit.mapper;

import org.apache.ibatis.annotations.Select;

public interface SampleMapper {

	@Select("select sysdate from dual")
	public String getTime();
}
