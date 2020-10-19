<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=request.getContextPath()%>/"/>
    <title>后台首页</title>
    
    <link type="text/css" rel="stylesheet" href="recources/css/style.css">
</head>
<body>
<%--&lt;%&ndash;模态框&ndash;%&gt;
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">用户ID:</label>
                        <input type="text" class="form-control" readonly="readonly" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">用户名:</label>
                        <input type="text" class="form-control" readonly="readonly"id="username">
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="btn1">确定</button>
            </div>
        </div>
    </div>
</div>--%>
    <center>
     
        <table border="0" cellpadding="0" cellspacing="0" width="688px" height="auto">
            <tr height="20px"><td><img src="resources/images/default_t.jpg"></td></tr>
            <tr><td background="resources/images/default_m.jpg" valign="top">
				<!-- 内容区 -->
				<iframe name="default" src="resources/admin/default.jsp" frameBorder="0" width="650px" scrolling="no" height="300px" style="margin-left:10px"></iframe>

				</td>
			</tr>
            <tr height="26px"><td><img src="resources/images/default_e.jpg"></td></tr>
        </table>
    </center>
</body>
</html>