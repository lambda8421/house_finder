package com.mofei.house_finder.service.address;

import com.mofei.house_finder.HouseFinderApplicationTests;
import com.mofei.house_finder.service.ServiceResult;
import com.mofei.house_finder.service.house.IAddressService;
import com.mofei.house_finder.service.search.BaiduMapLocation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mofei.
 */
public class AddressServiceTests extends HouseFinderApplicationTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void testGetMapLocation() {
        String city = "北京";
        String address = "北京市昌平区巩华家园1号楼2单元";
        ServiceResult<BaiduMapLocation> serviceResult = addressService.getBaiduMapLocation(city, address);

        Assert.assertTrue(serviceResult.isSuccess());

        Assert.assertTrue(serviceResult.getResult().getLongitude() > 0);
        Assert.assertTrue(serviceResult.getResult().getLatitude() > 0);

    }
}
