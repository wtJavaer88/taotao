/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-06-13 06:53:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>会员管理系统</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/jquery-easyui-1.4/themes/default/easyui.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/jquery-easyui-1.4/themes/icon.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui-1.4/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui-1.4/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/common.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("    <table class=\"easyui-datagrid\" id=\"userList\" title=\"会员列表\" \r\n");
      out.write("\t       data-options=\"singleSelect:false,collapsible:true,pagination:true,url:'/rest/user/list',method:'get',pageSize:5,toolbar:toolbar,pageList:[2,5,10]\">\r\n");
      out.write("\t    <thead>\r\n");
      out.write("\t        <tr>\r\n");
      out.write("\t        \t<th data-options=\"field:'ck',checkbox:true\"></th>\r\n");
      out.write("\t        \t<th data-options=\"field:'id',width:60\">ID</th>\r\n");
      out.write("\t            <th data-options=\"field:'userName',width:200\">用户名</th>\r\n");
      out.write("\t            <th data-options=\"field:'name',width:100\">姓名</th>\r\n");
      out.write("\t            <th data-options=\"field:'age',width:100\">年龄</th>\r\n");
      out.write("\t            <th data-options=\"field:'sex',width:80,align:'right',formatter:formatSet\">性别</th>\r\n");
      out.write("\t            <th data-options=\"field:'birthday',width:80,align:'right',formatter:formatBirthday\">出生日期</th>\r\n");
      out.write("\t            <th data-options=\"field:'created',width:130,align:'center',formatter:formatDate\">创建日期</th>\r\n");
      out.write("\t            <th data-options=\"field:'updated',width:130,align:'center',formatter:formatDate\">更新日期</th>\r\n");
      out.write("\t        </tr>\r\n");
      out.write("\t    </thead>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("<div id=\"userAdd\" class=\"easyui-window\" title=\"新增会员\" data-options=\"modal:true,closed:true,iconCls:'icon-save',href:'/user/page/add'\" style=\"width:800px;height:600px;padding:10px;\">\r\n");
      out.write("        The window content.\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function formatDate(val,row){\r\n");
      out.write("\tvar now = new Date(val);\r\n");
      out.write("\treturn now.format(\"yyyy-MM-dd hh:mm:ss\");\r\n");
      out.write("}\r\n");
      out.write("function formatBirthday(val,row){\r\n");
      out.write("\tvar now = new Date(val);\r\n");
      out.write("\treturn now.format(\"yyyy-MM-dd\");\r\n");
      out.write("}\r\n");
      out.write("function formatSet(val,row){\r\n");
      out.write("\tif(val == 1){\r\n");
      out.write("\t\treturn \"男\";\r\n");
      out.write("\t}else if(val == 2){\r\n");
      out.write("\t\treturn \"女\";\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\treturn \"未知\";\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("function getSelectionsIds(){\r\n");
      out.write("\tvar userList = $(\"#userList\");\r\n");
      out.write("\tvar sels = userList.datagrid(\"getSelections\");\r\n");
      out.write("\tvar ids = [];\r\n");
      out.write("\tfor(var i in sels){\r\n");
      out.write("\t\tids.push(sels[i].id);\r\n");
      out.write("\t}\r\n");
      out.write("\tids = ids.join(\",\");\r\n");
      out.write("\treturn ids;\r\n");
      out.write("}\r\n");
      out.write("var toolbar = [{\r\n");
      out.write("    text:'新增',\r\n");
      out.write("    iconCls:'icon-add',\r\n");
      out.write("    handler:function(){\r\n");
      out.write("    \t$('#userAdd').window('open');\r\n");
      out.write("    }\r\n");
      out.write("},{\r\n");
      out.write("    text:'编辑',\r\n");
      out.write("    iconCls:'icon-edit',\r\n");
      out.write("    handler:function(){\r\n");
      out.write("    \t$.messager.alert('提示','该功能由学员自己实现!');\r\n");
      out.write("    }\r\n");
      out.write("},{\r\n");
      out.write("    text:'删除',\r\n");
      out.write("    iconCls:'icon-cancel',\r\n");
      out.write("    handler:function(){\r\n");
      out.write("    \tvar ids = getSelectionsIds();\r\n");
      out.write("    \tif(ids.length == 0){\r\n");
      out.write("    \t\t$.messager.alert('提示','未选中用户!');\r\n");
      out.write("    \t\treturn ;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t$.messager.confirm('确认','确定删除ID为 '+ids+' 的会员吗？',function(r){\r\n");
      out.write("    \t    if (r){\r\n");
      out.write("            \t$.post(\"/user/delete\",{'ids':ids}, function(data){\r\n");
      out.write("        \t\t\tif(data.status == 200){\r\n");
      out.write("        \t\t\t\t$.messager.alert('提示','删除会员成功!',undefined,function(){\r\n");
      out.write("        \t\t\t\t\t$(\"#userList\").datagrid(\"reload\");\r\n");
      out.write("        \t\t\t\t});\r\n");
      out.write("        \t\t\t}\r\n");
      out.write("        \t\t});\r\n");
      out.write("    \t    }\r\n");
      out.write("    \t});\r\n");
      out.write("    }\r\n");
      out.write("},'-',{\r\n");
      out.write("    text:'导出',\r\n");
      out.write("    iconCls:'icon-remove',\r\n");
      out.write("    handler:function(){\r\n");
      out.write("    \tvar optins = $(\"#userList\").datagrid(\"getPager\").data(\"pagination\").options;\r\n");
      out.write("    \tvar page = optins.pageNumber;\r\n");
      out.write("    \tvar rows = optins.pageSize;\r\n");
      out.write("    \t$(\"<form>\").attr({\r\n");
      out.write("    \t\t\"action\":\"/user/export/excel\",\r\n");
      out.write("    \t\t\"method\":\"POST\"\r\n");
      out.write("    \t}).append(\"<input type='text' name='page' value='\"+page+\"'/>\")\r\n");
      out.write("    \t.append(\"<input type='text' name='rows' value='\"+rows+\"'/>\").submit();\r\n");
      out.write("    }\r\n");
      out.write("}];\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
