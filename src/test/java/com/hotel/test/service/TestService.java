package com.hotel.test.service;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.model.base.ItemContent;
import com.hotel.viewmodel.base.HotelItemVM;


@Transactional
public interface TestService {

	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	void insertTest(HotelItemVM item, ItemContent ic);

}
