function todoList(page) {
  $.ajax({
    url: "/todo?page=" + page,
    success: function (data) {

      if (data.status == "SUCCESS" || data.data.content.size > 0) {
        for (var i = 0; i < data.data.content.length; i++) {
          makeBody(data.data.content[i]);
        }
      }

      pagination(data.data.totalPages, page);
    }
  });
}

function makeBody(todo) {
  var refTodos = "";

  if (todo.todoRefers) {
    for (var i = 0; i < todo.todoRefers.length; i++) {
      refTodos = refTodos + " @" + todo.todoRefers[i].todoRefId;
    }
  }

  var idLink = "/web/rewrite?type=edit&id=" + todo.id;
  var html = "<tr></tr><th><a href=" + idLink + ">" + todo.id + "</a></th>"
    + "<th align='left'>" + todo.title + refTodos + "</th>"
    + "<th>" + todo.createdAt + "</th>"
    + "<th>" + todo.updatedAt + "</th>"
    + "<th>" + ((todo.completedAt) ? todo.completedAt:'') + "</th>"
    + "<th><a href='/web/refwrite?id=" + todo.id + "'>추가</a></th></tr>";

  $("#listBody").append(html);
}

function pagination(totalPage, page) {
  var naviMaxSize = 5;

  if (totalPage > 0) {

    var html = "";
    var startPagination = page - parseInt(naviMaxSize / 2);
    startPagination = (startPagination > 0) ? startPagination : 1;

    var endPagination = startPagination + naviMaxSize - 1;

    if (endPagination > totalPage) {
      endPagination = totalPage;
    }

    if (startPagination > 1) {
      html = html + pagingHtml("First", 0);
    }

    for (var i = startPagination; i <= endPagination; i++) {
      if ((page-1) == i) {
        html = html + pagingHtml(i, i-1, true);
      } else {
        html = html + pagingHtml(i, i-1);
      }
    }

    if (endPagination < totalPage) {
      html = html + pagingHtml("Last", totalPage);
    }

    $("#pagination").append(html);
  }
}

function pagingHtml(text, page, linkOff) {
  var listUrl = "#";

  if (!linkOff) {
    listUrl = "/web/list?page=" + page;
  }
  return " <a href="+ listUrl + ">" + text + "</a> ";
}

function todoSave() {
  var title = $("#title").val();

  if (!title) {
    alert("할 일을 입력 하세요.");
    return;
  }

  var obj = new Object();
  obj.title = title;

  var jsonObj = JSON.stringify(obj);

  $.ajax({
    type: "POST",
    contentType: "application/json; charset=utf-8",
    url: "/todo",
    data: jsonObj,
    success: function (data) {
      if (data.status == "SUCCESS") {
        alert("저장되었습니다.");
        location.href = "/web/list";
      }
    }
  });
}

function todoInfo(type, id) {

  $.ajax({
    url: "/todo/" + id,
    success: function (data) {
      if (data.status == "SUCCESS") {
        var todo = data.data;

        if (todo) {
          $("#id").val(todo.id);
          $("#title").val(todo.title);
          $("#createdAt").val(todo.createdAt);
          $("#updatedAt").val(todo.updatedAt);
          $("#completedAt").val(((todo.completedAt) ? todo.completedAt:''));

          if (todo.todoRefers) {

          }

          editControllByType(type);
        }
      }
    }
  });
}

function editControllByType(type) {
  if (type == "edit") {
    $('#title').removeAttr("readonly");

    $('#updateBtn').removeAttr("style");
    $('#completeBtn').removeAttr("style");
  }
}

function todoUpdate(type, id) {
  if (type == "edit") {

    var obj = new Object();
    obj.id = $('#id').val();
    obj.title = $('#title').val();
    obj.createdAt = $('#createdAt').val();
    obj.updatedAt = $('#updatedAt').val();
    obj.completedAt = $('#completedAt').val();

    var jsonObj = JSON.stringify(obj);

    $.ajax({
      type: "PUT",
      contentType: "application/json; charset=utf-8",
      url: "/todo/" + id,
      data: jsonObj,
      success: function (data) {
        if (data.status == "SUCCESS") {
          alert("저장되었습니다.");
          location.href = "/web/list";
        }
      }
    });
  }
}

function todoComplete(id) {
  $.ajax({
    type: "PUT",
    contentType: "application/json; charset=utf-8",
    url: "/todo/" + id + "/completed",
    success: function (data) {
      if (data.status == "SUCCESS") {
        alert("완료 처리 하였습니다.");
        location.href = "/web/list";
      } else {
        alert(data.message);
      }
    }
  });
}

function todoRef(id) {
  $.ajax({
    url: "/todo/" + id,
    success: function (data) {
      if (data.status == "SUCCESS") {
        var todo = data.data;

        if (todo) {
          $("#id").val(todo.id);
          $("#title").val(todo.title);
        }
      }
    }
  });
}

function todoRefSave() {
  var id = $("#id").val();
  var todoRefId = $("#todoRefId").val();

  if (!todoRefId) {
    alert("참조 할 일 ID를 입력 하세요.");
    return;
  }

  var obj = new Object();
  obj.todoRefId = todoRefId;

  var jsonObj = JSON.stringify(obj);

  $.ajax({
    type: "POST",
    contentType: "application/json; charset=utf-8",
    url: "/todo/" + id + "/refer",
    data: jsonObj,
    success: function (data) {
      if (data.status == "SUCCESS") {
        alert("저장되었습니다.");
        location.href = "/web/list";
      } else {
        alert(data.message);
      }
    }
  });
}