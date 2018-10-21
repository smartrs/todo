<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>TODO LIST</title>
  <script type="text/javascript" src="/js/todo.js"></script>
  <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>

</head>
<body>
<table border="1">
  <h2 align="center">TODO WRITE</h2>
  <colgroup>
    <col width='25%' />
    <col width='*%' />
  </colgroup>
  <tbody>
  <tr>
    <td>할일</td>
    <td><input type="text" id="title"></td>
  </tr>
  </tbody>
</table>
<button onclick="javascript:todoSave()">할일 저장</button>
</body>
</html>
