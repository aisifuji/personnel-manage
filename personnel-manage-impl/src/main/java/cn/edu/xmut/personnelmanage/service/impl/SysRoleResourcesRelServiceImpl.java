package cn.edu.xmut.personnelmanage.service.impl;

import cn.edu.xmut.personnelmanage.auth.util.SessionUtil;
import cn.edu.xmut.personnelmanage.dao.SysRoleResourcesRelDao;
import cn.edu.xmut.personnelmanage.domain.entity.SysResources;
import cn.edu.xmut.personnelmanage.domain.entity.SysRoleResourcesRel;
import cn.edu.xmut.personnelmanage.domain.vo.SysRoleResourcesVO;
import cn.edu.xmut.personnelmanage.service.SysRoleResourcesRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统角色资源表(cn.edu.xmut.personnelmanage.domain.entity.SysRoleResourcesRel)表服务实现类
 *
 * @author luols
 * @since 2021-03-11 11:15:43
 */
@Service("sysRoleResourcesRelService")
public class SysRoleResourcesRelServiceImpl implements SysRoleResourcesRelService {

    @Autowired
    private SysRoleResourcesRelDao sysRoleResourcesRelDao;

    @Override
    @Transactional
    public void saveSysRoleResourcesRel(SysRoleResourcesVO sysRoleResourcesVO) {
        sysRoleResourcesRelDao.deleteByRoleId(sysRoleResourcesVO.getRoleId());
        SysRoleResourcesRel sysRoleResourcesRel;
        for (Long rid : sysRoleResourcesVO.getResourcesIds()) {
            sysRoleResourcesRel = new SysRoleResourcesRel();
            sysRoleResourcesRel.setResourcesId(rid);
            sysRoleResourcesRel.setRoleId(sysRoleResourcesVO.getRoleId());
            sysRoleResourcesRelDao.insert(sysRoleResourcesRel);
        }
    }

    @Override
    public List<SysRoleResourcesRel> getRoleResources(Long roleId) {
        Map<String,Object> params = new HashMap<>();
        params.put("roleId",roleId);
        return sysRoleResourcesRelDao.queryList(params);
    }
}