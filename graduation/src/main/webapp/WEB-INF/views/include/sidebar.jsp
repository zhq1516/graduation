<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 左侧 -->
<aside class="sidebar canvas-left">
    <!-- 左侧选项栏 -->
    <nav class="main-navigation">
        <ul>
            <li class="active">
                <a href="<%=request.getContextPath()%>/">
                    <i class="fa fa-coffee"></i>
                    <span>首页</span>
                </a>
            </li>
            <li class="show-on-hover">
                <a href="<%=request.getContextPath()%>/article/">
                    <i class="fa fa-pencil"></i>
                    <span>推送管理</span>
                </a>
            </li>
            <li class="show-on-hover">
                <a href="<%=request.getContextPath()%>/user/">
                    <i class="fa fa-user"></i>
                    <span>系统用户管理</span>
                </a>
            </li>
            <li class="dropdown show-on-hover">
                <a href="javascript:;" data-toggle="dropdown">
                    <i class="fa fa-ellipsis-h"></i>
                    <span>其他内容</span>
                </a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="buttons.html">
                            <span>略略略</span>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>
    <!-- 左侧底部 -->
    <footer>
        <div class="about-app pd-md animated pulse">
            <a href="javascript:;">
                <img src="img/about.png" alt="">
            </a>
            <span>
                        <b>Cameo</b>&#32;is a responsive admin template powered by bootstrap 3.
                        <a href="javascript:;">
                            <b>Find out more</b>
                        </a>
                    </span>
        </div>
        <div class="footer-toolbar pull-left">
            <a href="javascript:;" class="pull-left help">
                <i class="fa fa-question-circle"></i>
            </a>
            <a href="javascript:;" class="toggle-sidebar pull-right hidden-xs">
                <i class="fa fa-angle-left"></i>
            </a>
        </div>
    </footer>
</aside>