<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 左侧 -->
<aside class="sidebar canvas-left">
    <!-- 左侧选项栏 -->
    <nav class="main-navigation">
        <ul>
            <li class="active">
                <a href="<%=request.getContextPath()%>/home/">
                    <i class="fa fa-coffee"></i>
                    <span>首页</span>
                </a>
            </li>
            <shiro:hasAnyRoles name="admin,doctor">
            <li class="show-on-hover">
                <a href="<%=request.getContextPath()%>/post/">
                    <i class="fa fa-file"></i>
                    <span>推送管理</span>
                </a>
            </li>
            </shiro:hasAnyRoles>

            <shiro:hasAnyRoles name="admin">
            <li class="show-on-hover">
                <a href="<%=request.getContextPath()%>/consult/">
                    <i class="fa fa-comment"></i>
                    <span>咨询管理</span>
                </a>
            </li>
            </shiro:hasAnyRoles>

            <shiro:hasAnyRoles name="admin">
                <li class="show-on-hover">
                    <a href="<%=request.getContextPath()%>/health/">
                        <i class="fa fa-book"></i>
                        <span>知识条目管理</span>
                    </a>
                </li>
            </shiro:hasAnyRoles>

            <shiro:hasAnyRoles name="admin">
            <li class="show-on-hover">
                <a href="<%=request.getContextPath()%>/wx/user/">
                    <i class="fa fa-weixin"></i>
                    <span>微信用户管理</span>
                </a>
            </li>
            </shiro:hasAnyRoles>

            <shiro:hasAnyRoles name="admin">
            <li class="show-on-hover">
                <a href="<%=request.getContextPath()%>/user/">
                    <i class="fa fa-user"></i>
                    <span>系统用户管理</span>
                </a>
            </li>
            </shiro:hasAnyRoles>

            <shiro:hasAnyRoles name="doctor">
            <li class="show-on-hover">
                <a href="<%=request.getContextPath()%>/consult/doctor">
                    <i class="fa fa-comment"></i>
                    <span>咨询管理</span>
                </a>
            </li>
            </shiro:hasAnyRoles>
        </ul>
    </nav>
</aside>