package com.management.customer.view;

import com.common.SearchCondition;
import com.management.customer.controller.CustomerController;
import com.management.customer.model.dto.CustomerDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerMenu {
    private final CustomerController customerController = new CustomerController();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        do {
            System.out.println("======== 고객 Info 관리 ========");
            System.out.println("고객 정보 관리 화면입니다.");
            System.out.println("===================================");
            System.out.println("1. 전체 고객 정보 조회");
            System.out.println("2. 조건부 고객 정보 조회");
            System.out.println("3. 신규 고객 정보 등록");
            System.out.println("4. 기존 고객 정보 수정");
            System.out.println("5. 고객 정보 삭제");
            System.out.println("9. 이전 메뉴로 이동");
            System.out.println("===================================");
            System.out.println("원하는 관리 메뉴의 번호를 입력해 주세요 : ");
            int selectMenu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (selectMenu) {
                case 1:
                    customerController.selectAllCustomerList();
                    break;
                case 2:
                    customerController.selectCustomerByCondition(inputSearchCondition());
                    break;
                case 3:
                    customerController.registNewCustomer(inputNewCustomerInfo());
                    break;
                case 4:
                    customerController.modifyCustomerInfo(inputModifyCustomerInfo());
                    break;
                case 5:
                    customerController.deleteCustomer(inputCustomerCode());
                    break;
                case 9:
                    System.out.println("========상위 메뉴로 이동합니다.========");
                    return;
                default:
                    System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요.");
                    break;
            }

        } while (true);
    }

    private Map<String, String> inputCustomerCode() {
        System.out.println("===================================");
        System.out.println("삭제할 제품의 코드를 입력해 주세요 : ");
        String customerCode = scanner.nextLine();
        System.out.println("===================================");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("customerCode", customerCode);

        return parameter;
    }

    private SearchCondition inputSearchCondition() {
        System.out.println("===================================");
        System.out.println("조회하고 싶은 조건을 선택하세요. ");
        System.out.println("===================================");
        System.out.println("1. 고객 이름으로 조회");
        System.out.println("2. 고객 성별로 조회");
        System.out.println("9. 이전 메뉴로");
        System.out.println("===================================");
        System.out.println("원하는 조건의 번호를 입력해 주세요 : ");

        int selectMenu;
        try {
            selectMenu = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return null;
        }

        String searchOption = "";
        String searchValue = "";
        switch (selectMenu) {
            case 1:
                System.out.println("조회할 고객 이름을 입력해 주세요 : ");
                searchOption = "customerName";
                searchValue = scanner.nextLine();
                break;
            case 2:
                System.out.println("조회할 고객 성별을 입력해 주세요 : ");
                searchOption = "customerGender";
                searchValue = scanner.nextLine();
                break;
            case 9:
                System.out.println("========상위 메뉴로 이동합니다.========");
                return null;
            default:
                System.out.println("잘못된 번호입니다. 확인 후 다시 입력해 주세요.");
                break;
        }

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setOption(searchOption);
        searchCondition.setValue(searchValue);

        return searchCondition;
    }

    private Map<String, String> inputNewCustomerInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("등록할 새로운 고객 정보를 입력하세요. ");
        System.out.println("===================================");

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO = getCustomerInfo(customerDTO);
        System.out.println("===================================");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("customerName", customerDTO.getCustomerName());
        parameter.put("customerGender", customerDTO.getCustomerGender());
        parameter.put("customerAge", String.valueOf(customerDTO.getCustomerAge()));
        parameter.put("categoryNo", String.valueOf(customerDTO.getCategoryNo()));
        parameter.put("roomCode", String.valueOf(customerDTO.getRoomCode()));

        return parameter;
    }

    private static CustomerDTO getCustomerInfo(CustomerDTO customerDTO) {
        Scanner sc = new Scanner(System.in);

        System.out.println("고객 이름을 입력해 주세요 : ");
        String customerName = sc.nextLine();
        System.out.println("고객의 성별을 입력해 주세요 : ");
        String customerGender = sc.nextLine();
        System.out.println("고객의 나이를 입력해 주세요 : ");
        int customerAge = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        System.out.println("카테고리 번호를 입력해 주세요 : ");
        int categoryNo = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        System.out.println("방의 갯수 코드를 입력해 주세요 : ");
        int roomCode = sc.nextInt();
        sc.nextLine(); // Consume newline left-over

        customerDTO.setCustomerName(customerName);
        customerDTO.setCustomerGender(customerGender);
        customerDTO.setCustomerAge(customerAge);
        customerDTO.setCategoryNo(categoryNo);
        customerDTO.setRoomCode(roomCode);

        return customerDTO;
    }

    private Map<String, String> inputModifyCustomerInfo() {
        System.out.print("수정할 고객 코드를 입력하세요 : ");
        String customerCode = scanner.nextLine();
        System.out.print("수정할 고객 이름을 입력하세요 : ");
        String customerName = scanner.nextLine();
        System.out.print("수정할 고객 성별을 입력하세요 : ");
        String customerGender = scanner.nextLine();
        System.out.print("수정할 고객 나이를 입력하세요 : ");
        String customerAge = scanner.nextLine();
        System.out.print("수정할 카테고리 번호를 입력하세요 : ");
        String categoryNo = scanner.nextLine();
        System.out.print("수정할 방의 코드를 입력하세요 : ");
        String roomCode = scanner.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("customerCode", customerCode);
        parameter.put("customerName", customerName);
        parameter.put("customerGender", customerGender);
        parameter.put("categoryNo", categoryNo);
        parameter.put("roomCode", roomCode);

        return parameter;
    }
}