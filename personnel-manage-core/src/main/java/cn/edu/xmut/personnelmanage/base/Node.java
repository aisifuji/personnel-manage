package cn.edu.xmut.personnelmanage.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author jiangjx
 * @version V1.0
 * @Date 2021-03-18 09:07:25
 * 树形节点
 */
public class Node implements Serializable {
    //id
    private Long id;
    //pid
    private Long pid;
    //code
    private String code;
    //名称
    private String name;
    //父名
    private String parentNames;
    //地址
    private String url;
    //样式
    private String iconCls;
    //排序
    private int sort;
    //节点类型
    private int type;
    //状态
    private int status;
    //数据来源
    private String data_type;
    //子节点
    private List<Node> children;
    //备用id
    private Long trueId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentNames() {
        return parentNames;
    }

    public void setParentNames(String parentNames) {
        this.parentNames = parentNames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public List<Node> getChildren() {
        return children;//NOSONAR
    }

    public void setChildren(List<Node> children) {
        this.children = children;//NOSONAR
    }

    public Long getTrueId() {
        return trueId;
    }

    public void setTrueId(Long trueId) {
        this.trueId = trueId;
    }
}
