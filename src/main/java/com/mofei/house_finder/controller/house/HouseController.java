package com.mofei.house_finder.controller.house;

import com.mofei.house_finder.base.APIResponse;
import com.mofei.house_finder.dto.SupportAddressDTO;
import com.mofei.house_finder.entity.SupportAddress;
import com.mofei.house_finder.service.ServiceMultiResult;
import com.mofei.house_finder.service.house.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HouseController {

    @Autowired
    private IAddressService addressService;

    /**
     * 获取区域列表
     *
     */

    @GetMapping("address/support/regions")
    @ResponseBody
    public APIResponse getSupportRegions(@RequestParam(name="city_name") String cityName){
        ServiceMultiResult<SupportAddressDTO> result = addressService.findAllRegionsByCityName(cityName);

        if(result.getResultSize() == 0){
            return APIResponse.ofStatus(APIResponse.Status.NOT_FOUND);
        }
        return APIResponse.ofSuccess(result);
    }
    /**
     * 获取支持城市列表
     * @return
     */
    @GetMapping("address/support/cities")
    @ResponseBody
    public APIResponse getSupportCities() {
        ServiceMultiResult<SupportAddressDTO> result = addressService.findAllCities();
        if (result.getResultSize() == 0) {
            return APIResponse.ofStatus(APIResponse.Status.NOT_FOUND);
        }
        return APIResponse.ofSuccess(result);
    }
}
