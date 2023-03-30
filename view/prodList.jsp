<%@page import="com.google.gson.JsonElement"%>
<%@page import="netscape.javascript.JSObject"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="prodVo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<%
	//Controller에서 저장된 처리결과 값을 꺼낸다.
	List<ProdVO> list = (List<ProdVO>) request.getAttribute("listvalue");
	
	JsonObject obj = new JsonObject();
	if(list != null && list.size()>0){
			obj.addProperty("flag", "ok");
			
			Gson gson = new Gson();
			JsonElement jele = gson.toJsonTree(list);
			
			obj.add("datas", jele);
	}else{
		obj.addProperty("flag", "no");
	}
	
	out.print(obj);
	out.flush();
%>
<%-- 
{
	"flag" : "ok",
	"datas" :
	[
	<%
		for (int i = 0; i < varlist.size(); i++) {
			ProdVO vo = varlist.get(i);
		   if (i > 0)
		      out.print(",");
	%>
		{ 
		  "id"  : "<%=vo.getProd_id()%>",
		  "name": "<%=vo.getProd_name()%>",
		  "lgu" : "<%=vo.getProd_lgu()%>",
		  "price": "<%=vo.getProd_price()%>",
		  "cost": "<%=vo.getProd_cost()%>"
		}
	<%
		}
	%>
	]
 }
--%>