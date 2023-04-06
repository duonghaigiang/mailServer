<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html" ; charset="UTF-8" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>mail page</title>
  </head>
  <body>
    <div class="container" style="margin-top: 10px;">
    <div class="row" style="border: 1px darkgrey solid ; border: radius 10px;width:50%;margin:0 auto; padding: 20px">
      <div class="col-sm-12">
        <h2 class="my-class">
          Infor
        </h2>
        <form action="./mailmain" method="post">
          <div class="form-group">
            <label>To:</label>
            <input type="text"
            class="form-control" name="to" placeholder="enter your email">
          </div>
          <div class="form-group">
            <label>SubJect:</label>
            <input type="text"
            class="form-control" name="subject" placeholder="enter your subject">
          </div>
          <div class="form-group">
            <label>content:</label>
            <textarea class="form-control" rows="3" name="content"></textarea>
          </div>
          <button type="submit" class="btn btn-primary">send</button>
          <button type="reset" class="btn btn-primary">cannel</button>

        </form>
      </div>

    </div>
  </body>
</html>
