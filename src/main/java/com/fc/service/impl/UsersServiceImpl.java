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
    //    @Autowired
//    private UsersMapper usersMapper;
//    @Autowired
//    private MenusMapper menusMapper;
//    @Override
//    public ResultVO login(String name, String pwd, MenusExample menusExample) {
//        ResultVO vo = new ResultVO();
//        Users users=usersMapper.selectById(name, pwd);
//
//        List<Menus> menus = menusMapper.selectByExample(menusExample);
//
//        if (users !=null){
//            vo.setCode(200);
//            vo.setSuccess(true);
//            vo.setMessage("登录成功");
//            vo.setData(menus);
//            return vo;
//        }else {
//            vo.setCode(-1);
//            vo.setSuccess(false);
//            vo.setMessage("登录失败");
//            vo.setData(null);
//
//        }
//
//        return vo ;
//    }
//    }
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
}

