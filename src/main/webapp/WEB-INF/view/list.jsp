<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>TODO LIST</title>
  <script type="text/javascript" src="/js/todo.js"></script>
  <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
  <script>
    var vPage = "${page}";
  </script>

</head>
<body onload="javascript:todoList(vPage)">
<button onclick="location.href='/web/write'">할일 추가</button>

<table border="1">
  <h2 align="center">TODO LIST</h2>
  <colgroup>
    <col width='8%' />
    <col width='*%' />
    <col width='25%' />
    <col width='25%' />
    <col width='25%' />
    <col width='12%' />
  </colgroup>
  <thead>
  <tr>
    <th>id</th>
    <th>할일</th>
    <th>작성일</th>
    <th>최종수정일</th>
    <th>완료일</th>
    <th>참조 할일 추가</th>
  </tr>
  </thead>
  <tbody id="listBody">
  </tbody>
</table>

<div align="center" id="pagination">
</div>
</body>
</html>
