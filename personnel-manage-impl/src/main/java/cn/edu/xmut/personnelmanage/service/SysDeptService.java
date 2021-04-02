package cn.edu.xmut.personnelmanage.service;

import cn.edu.xmut.personnelmanage.base.Page;
import cn.edu.xmut.personnelmanage.domain.entity.SysDept;
import cn.edu.xmut.personnelmanage.domain.entity.SysRole;
import cn.edu.xmut.personnelmanage.domain.vo.QuerySysDeptVO;

import java.util.List;
import java.util.Map;

/**
 * (cn.edu.xmut.personnelmanage.domain.entity.SysDept)表服务接口
 *
 * @author luols
 * @since 2021-03-11 11:15:40
 */
public interface SysDeptService {

    List<SysDept> queryList(Map<String,Object> params);

    SysDept queryById(Long id);

    Page<SysDept> queryPage(QuerySysDeptVO querySysDeptVO);

    void saveOrUpdateSysDept(SysDept sysDept);

    void delete(Long id);


}