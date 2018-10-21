<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>TODO EDIT</title>
  <script type="text/javascript" src="/js/todo.js"></script>
  <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
  <script>
    var vType = "${type}";
    var vId = "${id}";
  </script>

</head>
<body onload="javascript:todoInfo(vType, vId)">
<table border="1">
  <h2 align="center">TODO EDIT</h2>
  <colgroup>
    <col width='25%' />
    <col width='*%' />
  </colgroup>
  <tbody>
  <tr>
    <td>id</td>
    <td><input type="text" id="id" readonly="readonly" style="width:95%"></td>
  </tr>
  <tr>
    <td>할일</td>
    <td><input type="text" id="title" readonly="readonly" style="width:95%"></td>
  </tr>
  <tr>
    <td>작성일</td>
    <td><input type="text" id="createdAt" readonly="readonly" style="width:95%"></td>
  </tr>
  <tr>
    <td>최종수정일</td>
    <td><input type="text" id="updatedAt" readonly="readonly" style="width:95%"></td>
  </tr>
  <tr>
    <td>완료일</td>
    <td><input type="text" id="completedAt" readonly="readonly" style="width:95%"></td>
  </tr>
  <tr>
    <td>참조 할일 id</td>
    <td><input type="text" id="todoRefIds" readonly="readonly" style="width:95%"></td>
  </tr>
  </tbody>
</table>
<button id="updateBtn" onclick="javascript:todoUpdate(vType, vId)" style="visibility: hidden">할일 변경</button>
<button id="completeBtn" onclick="javascript:todoComplete(vId)" style="visibility: hidden">할일 완료</button>
</body>
</html>
