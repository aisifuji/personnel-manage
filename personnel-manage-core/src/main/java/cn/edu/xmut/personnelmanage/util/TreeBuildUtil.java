package cn.edu.xmut.personnelmanage.util;

import cn.edu.xmut.personnelmanage.base.Node;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangjx
 * @version V1.0
 * @Date 2021-03-18 09:07:25
 * 树形构建工具
 */
public class TreeBuildUtil {
    private List<Node> nodeList = new ArrayList<Node>();
    public TreeBuildUtil(List<Node> nodeList) {
        this.nodeList = nodeList;//NOSONAR
    }

    //建立树形结构
    public List<Node> builTree(){
        List<Node> treeNode =new  ArrayList<Node>();
        for(Node node : getRootNode()) {
            node = buildChildTree(node);
            treeNode.add(node);
        }
        return treeNode;
    }

    //递归，建立子树形结构
    private Node buildChildTree(Node pNode){
        List<Node> children =new  ArrayList<Node>();
        for(Node node : nodeList) {
            if(node.getPid().equals(pNode.getId())) {
                if(StringUtils.isBlank(pNode.getParentNames())){
                    node.setParentNames(pNode.getName());
                }else{
                    node.setParentNames(pNode.getParentNames()+"/"+pNode.getName());
                }
                children.add(buildChildTree(node));
            }
        }
        pNode.setChildren(children);
        return pNode;
    }

    //获取根节点
    private List<Node> getRootNode() {
        List<Node> rootNodeList =new ArrayList<Node>();
        for(Node pnode : nodeList) {
            boolean flag = true;
            for(Node cnode : nodeList) {
                if(pnode.getPid().equals(cnode.getId())) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                rootNodeList.add(pnode);
            }
        }
        return rootNodeList;
    }

}
