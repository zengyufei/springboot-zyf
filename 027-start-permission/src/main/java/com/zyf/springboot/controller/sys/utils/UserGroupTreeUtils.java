package com.zyf.springboot.controller.sys.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.zyf.springboot.entity.sys.UserGroup;

import java.util.ArrayList;
import java.util.List;

public class UserGroupTreeUtils {

    public static List<Tree> toTree(List<UserGroup> list) {
        List<Tree> rootTree = new ArrayList<>();
        try {//查询所有菜单
            //根节点
            for (UserGroup userGroup : list) {
                Tree tree = new Tree(userGroup);
                if (tree.getParentId() == 0) {//父节点是0的，为根节点。
                    rootTree.add(tree);
                }
            }
            //为根菜单设置子菜单，getClild是递归调用的
            for (Tree menu : rootTree) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<Tree> childList = getChild(menu.getId(), list);
                menu.setChildren(childList);//给根节点设置子节点
            }
            /*
             * 输出构建好的菜单数据。
             */
            return rootTree;
        } catch (Exception e) {
            e.printStackTrace();
            return rootTree;
        }
    }

    /**
     * 获取子节点
     * @param id 父节点id
     * @param allTree 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    private static List<Tree> getChild(Integer id, List<UserGroup> allTree) {
        //子菜单
        List<Tree> childList = new ArrayList<>();
        for (UserGroup userGroup : allTree) {
            Tree menu = new Tree(userGroup);
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (ObjectUtil.equal(menu.getParentId(), id)) {
                childList.add(menu);
            }
        }
        //递归
        for (Tree menu : childList) {
            menu.setChildren(getChild(menu.getId(), allTree));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (CollUtil.isEmpty(childList)) {
            return new ArrayList<>();
        }
        return childList;
    }

    /*
     * 用于封装树形菜单，无具体表与之对应,根节点为-1，节点0，然后父节点0，节点001,父节点001，节点001001,001002,001...依次类推
     */
    public static class Tree {
        private Integer id;//id
        private Integer parentId;//父节点id
        private String name;//权限名

        private List<Tree> children = new ArrayList<>();

        Tree(UserGroup userGroup) {
            this.id = userGroup.getId();
            this.parentId = userGroup.getParentId();
            this.name = userGroup.getUserGroupName();
        }

        public Integer getParentId() {
            return this.parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public List<Tree> getChildren() {
            return this.children;
        }

        public void setChildren(List<Tree> children) {
            this.children = children;
        }

    }
}
 