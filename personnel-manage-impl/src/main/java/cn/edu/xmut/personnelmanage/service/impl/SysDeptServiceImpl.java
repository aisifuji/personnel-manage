package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.dao.SysDeptDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysDept;
import cn.edu.xmut.personnelmanage.domain.entity.SysRole;
import cn.edu.xmut.personnelmanage.domain.entity.SysUserDeptRel;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysDeptVO;
import cn.edu.xmut.personnelmanage.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.SysDept)表服务实现类
 *
 * @author luols
 * @since 2021-03-11 11:15:40
 */
@Service("sysDeptService")
public class SysDeptServiceImpl implements SysDeptService {


    @Autowired
    private SysDeptDao sysDeptDao;

    @Override
    public List<SysDept> queryList(Map<String, Object> params) {
        if(null == params){
            params = new HashMap<>();
        }
        return sysDeptDao.queryList(params);
    }

    @Override
    public SysDept queryById(Long id) {
        return sysDeptDao.queryById(id);
    }

    @Override
    public Page<SysDept> queryPage(QuerySysDeptVO querySysDeptVO) {
        Map<String,Object> params =  new HashMap<>();
        params.put("deptName", querySysDeptVO.getDeptName());
        Page<SysDept> page = Page.startPage(querySysDeptVO.getPageNo(), querySysDeptVO.getPageSize());
        List<SysDept> list = sysDeptDao.queryList(params);
        page.setDataList(list);
        return page;
    }

    @Override
    public void saveOrUpdateSysDept(SysDept sysDept) {
        if(null == sysDept.getId()){
            sysDeptDao.insert(sysDept);
        }else {
            sysDeptDao.update(sysDept);
        }
    }

    @Override
    public void delete(Long id) {
        SysDept sysDept = sysDeptDao.queryById(id);
        sysDept.setIsDelete(1);
        sysDeptDao.update(sysDept);
    }
}