package com.management.customer.model.dao;



import com.common.SearchCondition;
import com.management.customer.model.dto.CustomerDTO;

import java.util.List;
import java.util.Map;

public interface CustomerDAO {

    List<CustomerDTO> selectAllCustomerList();

    List<CustomerDTO> selectCustomerByCondition(SearchCondition searchCondition);

    int insertCustomer(CustomerDTO customerDTO);

    int updateCustomer(CustomerDTO customerDTO);

    int deleteCustomer(Map<String, String> parameter);

}
