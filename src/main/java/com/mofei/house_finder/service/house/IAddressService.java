package com.mofei.house_finder.service.house;

import com.mofei.house_finder.controller.house.SupportAddressDTO;
import com.mofei.house_finder.service.ServiceMultiResult;

public interface IAddressService {
    ServiceMultiResult<SupportAddressDTO> findAllCities();
}
