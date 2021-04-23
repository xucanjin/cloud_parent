<!DOCTYPE html>
<html>
<head lang="en">
    <meta content="text/html;charset=UTF-8"/>
    <title></title>
    <script type="text/javascript" src="/static/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="/static/bootstrap.min.css"></script>
    <script type="text/javascript" src="/static/bootstrap.min.js"></script>
</head>
<body>

你好！ 
<h2>${date}</h2>

<p>当前时间：${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</p>
<div class="col-md-3 col-md-offset-4">
    <form action="/user/login" class="form-control">
             <div class="form-group"> 
                <label class="form-control-label">用户名</label>
                <input type="password" name="pwd"   class="form-control" id="password"> 
              </div>     
               
            <div class="form-group"> 
                <label class="form-control-label">密码</label>
                <input type="password" name="pwd"   class="form-control" id="password"> 
            </div>

            <div class="form-group"> 
                <button value="登录" class="btn btn-primary" id="button">登录</button>   
            </div>    
                  
    </form>
</div>

</body>
</html>