package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.dto.Account;
import com.example.entity.dto.AccountDetails;
import com.example.entity.vo.request.DetailsSaceVO;
import com.example.mapper.AccountDetailsMapper;
import com.example.service.AccountDetailsService;
import com.example.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsServiceImpl extends ServiceImpl<AccountDetailsMapper, AccountDetails> implements AccountDetailsService {

    @Resource
    AccountService accountService;

    @Override
    public AccountDetails findAccountDetailsById(int id) {
        return this.getById(id);
    }

    @Override
    public synchronized boolean saveAccountDetails(int id, DetailsSaceVO vo) {
        Account account=accountService.findAccountByNameOrEmail(vo.getUsername());
        if(account==null||account.getId()==id){
            if(accountService.update()
                    .eq("id",id)
                    .set("username",vo.getUsername())
                    .update()){
                this.saveOrUpdate(new AccountDetails(
                        id,vo.getGender(),vo.getPhone(),
                        vo.getQq(),vo.getWx(),vo.getDesc()
                ));
                return true;
            }else{
                System.out.println("saveAccountDetails的update操作出现异常");
            }
        }
        return false;
    }
}
