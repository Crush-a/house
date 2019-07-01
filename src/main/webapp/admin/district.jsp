<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/18
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="Css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/district.js"></script>

</head>
<body>

<!--展示数据-->
<table id="dg"></table>

<!--定义工具栏-->
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a
                href="javascript:ModifyBySelect()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a>
        <a
                href="javascript:DeleteMore()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除选中项</a>
    </div>
</div>

<!--添加窗口-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="saveDialogForm" method="post">
        <table>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name" id="author" /></td>
            </tr>
        </table>
    </form>
</div>

<!--给添加对话框添加按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog('AddDialog')"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>



<!--修改对话框-->
<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="upDialogForm" method="post">
        <table>
            <tr>
                <td>编号:</td>
                <td><input type="text" readonly name="id" id="dd" /></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name" id="author" /></td>
            </tr>
        </table>
    </form>
</div>



<!--修改对话框-->
<div id="streetDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 600px; height: 450px; padding: 10px 20px;" closed="true">
     <table id="streetDg"></table>
     <hr/>
     <form>
         街道名称:<input type="text">
         区域id:<input type="text" id="districtId">
           <input type="button" value="添加">

     </form>
</div>

<!--给修改对话框添加修改按钮-->
<div id="upDialogButtons">
    <a href="javascript:upDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a>
    <a href="javascript:CloseDialog('upDialog')"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
