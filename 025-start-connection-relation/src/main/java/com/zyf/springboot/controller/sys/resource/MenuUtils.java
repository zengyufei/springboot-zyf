package com.zyf.springboot.controller.sys.resource;

import com.zyf.springboot.entity.sys.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MenuUtils {

    public static List<Menu> toTree(List<Resource> list) {
        List<Menu> rootMenu = new ArrayList<>();
        try {//查询所有菜单
            //根节点
            for (Resource resource : list) {
                Menu nav = new Menu(resource);
                if (nav.getParentId() == 0) {//父节点是0的，为根节点。
                    rootMenu.add(nav);
                }
            }
            /* 根据Menu类的order排序 */
            Collections.sort(rootMenu, order());
            //为根菜单设置子菜单，getClild是递归调用的
            for (Menu menu : rootMenu) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<Menu> childList = getChild(menu.getId(), list);
                menu.setChildren(childList);//给根节点设置子节点
            }
            /*
             * 输出构建好的菜单数据。
             */
            return rootMenu;
        } catch (Exception e) {
            e.printStackTrace();
            return rootMenu;
        }
    }

    /**
     * 获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    private static List<Menu> getChild(Integer id, List<Resource> allMenu) {
        //子菜单
        List<Menu> childList = new ArrayList<>();
        for (Resource resource : allMenu) {
            Menu menu = new Menu(resource);
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if (menu.getParentId().equals(id)) {
                childList.add(menu);
            }
        }
        //递归
        for (Menu menu : childList) {
            menu.setChildren(getChild(menu.getId(), allMenu));
        }
        //排序
        Collections.sort(childList, order());
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<>();
        }
        return childList;
    }

    /*
     * 排序,根据order排序
     */
    private static Comparator<Menu> order() {
        return (o1, o2) -> {
            if (o1.getSort() > o2.getSort()) {
                return 1;
            } else if (o1.getSort().equals(o2.getSort())) {
                return 0;
            } else {
                return -1;
            }
        };
    }

    /*
     * 用于封装树形菜单，无具体表与之对应,根节点为-1，节点0，然后父节点0，节点001,父节点001，节点001001,001002,001...依次类推
     */
    public static class Menu {
        private Integer id;//id
        private Integer parentId;//父节点id
        private String name;//权限名
        private String permission;//权限标识
        private String icon;//显示节点的图标
        private String url;//点击树形菜单的叶子节点时，请求的url路径
        private Integer sort;

        private List<Menu> children = new ArrayList<>();

        public Menu(Resource resource) {
            this.id = resource.getId();
            this.parentId = resource.getParentId();
            this.name = resource.getResourceName();
            this.permission = resource.getPermission();
            this.icon = resource.getIconUrl();
            this.url = resource.getHrefUrl();
            this.sort = resource.getSort();
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

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPermission() {
            return this.permission;
        }

        public void setPermission(String permission) {
            this.permission = permission;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public List<Menu> getChildren() {
            return this.children;
        }

        public void setChildren(List<Menu> children) {
            this.children = children;
        }

        public Integer getSort() {
            return this.sort;
        }

        public void setSort(Integer sort) {
            this.sort = sort;
        }
    }
}
 