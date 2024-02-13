package com.management.customer.controller;

import com.common.SearchCondition;
import com.management.customer.model.dto.CustomerDTO;
import com.management.customer.model.service.CustomerService;
import com.management.customer.view.CustomerMenu;
import com.management.customer.view.CustomerPrint;

import java.util.List;
import java.util.Map;

public class CustomerController {
    private final CustomerPrint customerPrint;
    private final CustomerService customerService;

    public CustomerController() {
        customerPrint = new CustomerPrint();
        customerService = new CustomerService();
    }

    public void selectAllCustomerList() {

        List<CustomerDTO> allCustomerList = customerService.selectAllCustomerList();

        if (allCustomerList != null && !allCustomerList.isEmpty()) {
            customerPrint.printAllCustomerList(allCustomerList);
        } else {
            customerPrint.printErrorMessage("selectAllCustomerList");
        }

    }

    public void selectCustomerByCondition(SearchCondition searchCondition) {

        List<CustomerDTO> customerList = customerService.selectCustomerByCondition(searchCondition);

        if (customerList != null && !customerList.isEmpty()) {
            customerPrint.printCustomerList(customerList, searchCondition);
        } else {
            customerPrint.printErrorMessage("selectCustomerList");
        }

    }

    public void registNewCustomer(Map<String, String> parameter) {
        CustomerDTO customer = new CustomerDTO();
        customer.setCustomerName(parameter.get("customerName"));
        customer.setCustomerGender(parameter.get("customerGender"));
        customer.setCustomerAge(Integer.parseInt(parameter.get("customerAge")));
        customer.setCategoryNo(Integer.parseInt(parameter.get("categoryNo")));
        customer.setRoomCode(Integer.parseInt(parameter.get("roomCode")));


        if (customerService.registNewCustomer(customer)) {
            customerPrint.printSuccessMessage("registCustomer");
        } else {
            customerPrint.printErrorMessage("registCustomer");
        }

    }

    public void modifyCustomerInfo(Map<String, String> parameter) {
        CustomerDTO customer = new CustomerDTO();

        try {
            customer.setCustomerCode(Integer.parseInt(parameter.get("customerCode")));
            customer.setCustomerName(parameter.get("customerName"));
            customer.setCustomerGender(parameter.get("customerGender"));
            customer.setCustomerAge(Integer.parseInt(parameter.get("customerAge")));
            customer.setCategoryNo(Integer.parseInt(parameter.get("categoryNo")));
            customer.setRoomCode(Integer.parseInt(parameter.get("roomCode")));

            if (customerService.registNewCustomer(customer)) {
                customerPrint.printSuccessMessage("modifyCustomer");
            } else {
                customerPrint.printErrorMessage("modifyCustomer");
            }
        } catch (NumberFormatException e) {


        }
    }
    public void deleteCustomer(Map<String, String> parameter) {

        if (customerService.deleteCustomer(parameter)) {
            customerPrint.printSuccessMessage("deleteCustomer");
        } else {
            customerPrint.printErrorMessage("deleteCustomer");
        }

    }


    }

