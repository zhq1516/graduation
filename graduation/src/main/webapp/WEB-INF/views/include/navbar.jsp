<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<header class="header header-fixed navbar">
    <!-- 系统标志及名称 -->
    <div class="brand">
        <a href="javascript:;" class="fa fa-bars off-left visible-xs" data-toggle="off-canvas" data-move="ltr"></a>
        <a href="" class="navbar-brand">
            <i class="fa fa-stop mg-r-sm"></i>
            <span class="heading-font"><b>管理系统</b></span>
        </a>
    </div>
    <!-- 查询栏 -->
    <form class="navbar-form navbar-left hidden-xs" role="search">
        <div class="form-group">
            <button class="btn no-border no-margin bg-none no-pd-l" type="submit">
                <i class="fa fa-cogs"></i>
            </button>
            <input type="text" class="form-control no-border no-padding search" placeholder="工作区间">
        </div>
    </form>
    <!-- 上边栏 -->
    <ul class="nav navbar-nav navbar-right off-right">
        <li class="hidden-xs">
            <a href="javascript:;">
                <shiro:principal type="com.platform.model.User" property="realName"/>
            </a>
        </li>
        <li class="quickmenu">
            <a href="javascript:;" data-toggle="dropdown">
                <img src="/staticResource<shiro:principal type="com.platform.model.User" property="avator"/>" class="avatar pull-left img-circle" alt="user" title="user">
                <i class="caret mg-l-xs hidden-xs no-margin"></i>
            </a>
            <ul class="dropdown-menu dropdown-menu-right mg-r-xs">
                <li>
                    <a href="/logout">登出</a>
                </li>
            </ul>
        </li>
    </ul>
</header>
