package com.mofei.house_finder.service.house;

import com.mofei.house_finder.controller.house.SupportAddressDTO;
import com.mofei.house_finder.entity.SupportAddress;
import com.mofei.house_finder.repository.SupportAddressRepository;
import com.mofei.house_finder.service.ServiceMultiResult;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements IAddressService{
    @Autowired
    private SupportAddressRepository supportAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllCities() {
        List<SupportAddress> list = supportAddressRepository.findAllByLevel(SupportAddress.Level.CITY.getValue());

        List<SupportAddressDTO> supportAddressDTOList = new ArrayList<>();

        for (SupportAddress supportAddress : list){
            SupportAddressDTO supportAddressDTO = modelMapper.map(supportAddress,SupportAddressDTO.class);

            supportAddressDTOList.add(supportAddressDTO);
        }
        return new ServiceMultiResult<>(supportAddressDTOList.size(),supportAddressDTOList);

    }
}
