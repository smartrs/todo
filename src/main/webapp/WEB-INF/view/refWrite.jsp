<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>TODO REFER</title>
  <script type="text/javascript" src="/js/todo.js"></script>
  <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
  <script>
    var vId = "${id}";
  </script>

</head>
<body onload="javascropt:todoRef(vId)">
<table border="1">
  <h2 align="center">TODO REFER</h2>
  <colgroup>
    <col width='25%' />
    <col width='*%' />
  </colgroup>
  <tbody>
  <tr>
    <td>id</td>
    <td><input type="text" id="id" readonly="readonly"></td>
  </tr>
  <tr>
    <td>할일</td>
    <td><input type="text" id="title" readonly="readonly"></td>
  </tr>
  <tr>
    <td>참조 할일 id</td>
    <td><input type="number" id="todoRefId" min="0"></td>
  </tr>
  </tbody>
</table>
<button onclick="javascript:todoRefSave()">참조 할일 저장</button>
</body>
</html>
