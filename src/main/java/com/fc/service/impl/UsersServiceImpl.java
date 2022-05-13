package com.fc.service.impl;

import com.fc.dao.UsersMapper;
import com.fc.entity.Users;
import com.fc.entity.UsersExample;
import com.fc.service.UsersService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public ResultVO login(String name, String pwd ) {
        ResultVO resultVO;

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPwdEqualTo(pwd);

        List<Users> users = usersMapper.selectByExample(example);
        if (users.size() > 0) {
            resultVO = new ResultVO(200, "登陆成功", true, users.get(0));
        } else {
            resultVO = new ResultVO(0, "登录失败", false, null);
        }

        return resultVO;
    }

    @Override
    public int insert(Users users) {
        return usersMapper.insert(users);
    }

    @Override
    public Users update(Users users) {
        usersMapper.updateByPrimaryKeySelective(users);
        return queryById(users.getId());
    }

    @Override
    public Users queryById(Integer id) {
        return usersMapper.queryById(id);
    }


}

