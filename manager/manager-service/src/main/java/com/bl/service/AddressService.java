package com.bl.service;

import com.bl.base.Response;
import com.bl.dao.AddressMapper;
import com.bl.model.Address;
import com.bl.model.AddressCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 根据用户标识获取地址集合
     * @param userId    用户标识
     * @param isDefault     是否是默认地址
     * @return
     */
    public Response getAddressListByUserId(Integer userId, boolean isDefault) {
        AddressCriteria addressCriteria = new AddressCriteria();
        AddressCriteria.Criteria criteria = addressCriteria.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if(isDefault){
            criteria.andIsDefaultEqualTo(isDefault);
        }
        return Response.createSuccessResult("根据用户标识获取地址集合", addressMapper.selectByExample(addressCriteria));
    }

    /**
     * 保存地址信息
     * @param address
     * @return
     */
    public Response saveAddress(Address address) {
        //当保存的地址信息是默认地址时,判断该用户的其他地址是否存在默认地址,存在则将其修改为不是默认地址
        if(address.getIsDefault()){
            updateAndJudgeIsDefault(address.getUserId());
        }

        address.setCreateTime(new Date());
        address.setUpdateTime(new Date());
        if(addressMapper.insertSelective(address) == 1){
            return Response.createSuccessResult("保存成功", null);
        }else{
            return Response.createFailResult("保存失败", null);
        }
    }

    /**
     * 当保存的地址信息是默认地址时,判断该用户的其他地址是否存在默认地址,存在则将其修改为不是默认地址
     * @param userId
     */
    public void updateAndJudgeIsDefault(int userId) {
        AddressCriteria addressCriteria = new AddressCriteria();
        addressCriteria.createCriteria().andUserIdEqualTo(userId);
        List<Address> addressList = addressMapper.selectByExample(addressCriteria);
        if(addressList != null && !addressList.isEmpty()){
            for(Address add : addressList){
                if(add.getIsDefault()){
                    add.setIsDefault(false);
                    addressMapper.updateByPrimaryKeySelective(add);
                }
            }
        }
    }

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    public Response updateDefaultAddress(Address address){
        //当保存的地址信息是默认地址时,判断该用户的其他地址是否存在默认地址,存在则将其修改为不是默认地址
        if(address.getIsDefault()){
            updateAndJudgeIsDefault(address.getUserId());
        }
        address.setUpdateTime(new Date());
        if(addressMapper.updateByPrimaryKeySelective(address) == 1){
            return Response.createSuccessResult("修改成功", null);
        }else{
            return Response.createFailResult("修改失败", null);
        }
    }

    public Response deleteAddress(Integer addressId) {
        if(addressMapper.deleteByPrimaryKey(addressId) == 1){
            return Response.createSuccessResult("删除成功", null);
        }else{
            return Response.createFailResult("删除失败", null);
        }
    }
}
