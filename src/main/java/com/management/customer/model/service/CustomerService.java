package com.management.customer.model.service;

import com.common.SearchCondition;
import com.management.customer.model.dao.CustomerDAO;
import com.management.customer.model.dto.CustomerDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class CustomerService {

    private CustomerDAO customerDAO;

    public List<CustomerDTO> selectAllCustomerList() {

        SqlSession sqlSession = getSqlSession();
        customerDAO = sqlSession.getMapper(CustomerDAO.class);

        List<CustomerDTO> allMemberList = customerDAO.selectAllCustomerList();

        sqlSession.close();

        return allMemberList;

    }

    public List<CustomerDTO> selectCustomerByCondition(SearchCondition searchCondition) {

        SqlSession sqlSession = getSqlSession();
        customerDAO = sqlSession.getMapper(CustomerDAO.class);

        List<CustomerDTO> memberList = customerDAO.selectCustomerByCondition(searchCondition);

        sqlSession.close();

        return memberList;
    }

    public boolean registNewCustomer(CustomerDTO customer) {

        SqlSession sqlSession = getSqlSession();
        customerDAO = sqlSession.getMapper(CustomerDAO.class);

        int result = customerDAO.insertCustomer(customer);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;

    }

    public boolean modifyCustomerInfo(CustomerDTO customer) {

        SqlSession sqlSession = getSqlSession();
        customerDAO = sqlSession.getMapper(CustomerDAO.class);

        int result = customerDAO.updateCustomer(customer);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;

    }

    public boolean deleteCustomer(Map<String, String> parameter) {

        SqlSession sqlSession = getSqlSession();
        customerDAO = sqlSession.getMapper(CustomerDAO.class);

        int result = customerDAO.deleteCustomer(parameter);

        if(result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;

    }
}




