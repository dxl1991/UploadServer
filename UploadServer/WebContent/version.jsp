<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>文件上传</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/servlet/SetStarGameVersion" method="post">
        设置版本号：<input type="text" name="version">请填写一个数字作为版本号，此版本号的分享按钮将被屏蔽，填-1则取消开关<br/>
        <input type="submit" value="提交">
    </form>
  </body>
</html>