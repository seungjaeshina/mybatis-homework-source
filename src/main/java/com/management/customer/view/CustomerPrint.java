package com.management.customer.view;

import com.common.SearchCondition;
import com.management.customer.model.dto.CustomerDTO;

import java.util.List;

public class CustomerPrint {
    public void printAllCustomerList(List<CustomerDTO> allCustomerList) {

        System.out.println("=========전체 고객 정보 목록==========");
        for (CustomerDTO product : allCustomerList) {
            System.out.println(product);
        }
        System.out.println("===================================");

    }

    public void printCustomerList(List<CustomerDTO> customerList, SearchCondition searchCondition) {
        String searchOption = "";
        switch (searchCondition.getOption()) {

            case "customerName":
                searchOption = "고객 이름 검색 결과";
                break;
            case "customerGender":
                searchOption = "고객 성별 검색 결과";
                break;
        }
        System.out.println("=========" + searchOption + " 목록==========");
        for (CustomerDTO product : customerList) {
            System.out.println(product);
        }
        System.out.println("=====================================");

    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode) {
            case "registCustomer":
                successMessage = "신규 고객을 등록하였습니다. 환영합니다!";
                break;
            case "modifyCustomer":
                successMessage = "고객 정보를 수정하였습니다. 감사합니다!";
                break;
            case "deleteCustomer":
                successMessage = "고객 정보를 삭제하였습니다. 수고하셨습니다.";
                break;
        }

    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch (errorCode) {
            case "selectAllCustomerList":
                errorMessage = "조회 결과가 없습니다. (about 전체 고객 정보 목록 조회)";
                break;
            case "selectCustomerList":
                errorMessage = "조회 결과가 없습니다. (about 선택 고객 정보 목록 조회)";
                break;
            case "registCustomer":
                errorMessage = "신규 고객 추가에 실패하셨습니다.";
                break;
            case "modifyCustomer":
                errorMessage = "고객 정보 수정에 실패하셨습니다.";
                break;
            case "deleteCustomer":
                errorMessage = "고객 정보 수정에 실패하셨습니다.";
                break;
        }
    }
}




