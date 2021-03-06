﻿<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.aggrepoint.com/adk" prefix="adk"%>
<%@ taglib tagdir="/WEB-INF/tags/ex" prefix="ex"%>
<%@ taglib tagdir="/WEB-INF/tags/adk/html/input" prefix="input"%>

<adk:form name="frmSelectInfo"
	action="doSelect">
	<adk:func name="doSelect" submit="yes" />
</adk:form> 
<adk:form name="frmCancelEdit" action="cancelEdit">
	<adk:func name="cancelEdit" submit="yes" />
</adk:form>
<adk:form name="frmReplace" action="doReplace">
	<adk:func name="doReplace" submit="yes" />
</adk:form>
<adk:form name="frmDownLoad" action="doDownLoadTemp">
	<adk:func name="doDownLoadTemp" submit="yes"/>
</adk:form>
<adk:form name="frmSelectSegment" action="selectSegment">
	<adk:func name="selectSegment" submit="yes" />
</adk:form>
<adk:form name="frmSaveFile" action="saveUpLoadFile">
	<adk:func name="saveUpLoadFile" submit="yes"/>
</adk:form> 
<adk:form name="frmSelectVoucherPool" action="selectVoucherPool">
	<adk:func name="selectVoucherPool" submit="yes" />
</adk:form>
<adk:form name="frmSaveEdit" action="saveEdit" vaction="saveEdit" resetref="${m.rule}">
	<adk:func name="saveEdit" submit="yes" />
		<div style="min-width: 650px">
		<div class="adk_tab2">
			<ul id="tab" style="cursor: pointer;">
				<li name="base" id="current">
					<a id="tab_base"><span>文件指定</span></a>
				</li>
			</ul>
		</div>
			<div id="div_address" style="max-height: 500px;overflow: auto;" class="adk_tab2box">
				<table id="baseaddresstable" width="100%" bordercolor="#CCCCCC" border="1" style=" background-color:#fbfbfb">
				<tbody>
					<tr>
						<td align="center" nowrap="nowrap">
							<button type="button" class="btn save" id="dowmLoadTemp">导入模板下载</button>
						</td>
						<td align="center" nowrap="nowrap">
						<c:choose>
							<c:when test="${empty m.uploadFile}">
								<input id="fileupload" type="file" name="files[]" data-url="${adk:resproxy('doUpload')}" multiple/><div id="importStatus"></div>
								<div id="fileuploadDiv"></div>
							</c:when>
							<c:otherwise>
								<input id="fileupload" type="file" name="files[]" data-url="${adk:resproxy('doUpload')}" multiple style="display:none"/><div id="importStatus"></div>
								<div id="fileuploadDiv">
									<button type="button" class="btn clear notext delfile">删除</button>
								</div>
							</c:otherwise>
						</c:choose>
							<button type="button" id="importFile" class="btn save" onclick="">导入</button>
						</td>
					</tr>
					<tr>
						<td align="center" nowrap="nowrap" id="importNumber">
							<strong>导入数量:</strong>
						</td>
					</tr>
				</tbody>
				</table>
			</div>
	</div>
	</adk:form>
	<div align="center" style="margin:10px 0 0 0">
		<button type="button" id="saveVoucherRule" class="btn save" onclick="${adk:func('saveEdit')}()">保存</button>
		<button type="button" id="replaceVoucherRule" class="btn save" onclick="${adk:func('doReplace')}()">发布</button>
		<button type="button" class="btn close"	onclick="${adk:func('cancelEdit')}()">取消</button>
	</div>
<script language="javascript">
$("#importFile").hide();
$("#importNumber").hide();
$("#saveVoucherRule").hide();
$("#replaceVoucherRule").hide();
$("#importFile").click(function() {
	$("b").hide();
	$("#fileuploadDiv").after("<b>处理中,请稍后...</b>");
	${adk:func('saveUpLoadFile')}();
	$("importNumber").show();
	$("#saveVoucherRule").show();
	$("#replaceVoucherRule").show();
	$("b").hide();
	$("#fileuploadDiv").after("<b>文件导入成功</b>");
});
$("#dowmLoadTemp").click(function() {
	var url = "${adk:resproxy('doDownLoadTemp')}";
	//window.open(url);火狐浏览器可以使用
	window.location = url;
});
$('#fileupload').fileupload({
	  dataType: 'json',
	  add: function (e, data) {
	  	$("#fileuploadDiv p").remove();
	      data.context = $('<p/>').text('文件读取中，请稍后...').appendTo($("#fileuploadDiv"));
	      data.submit();
	      
	  },
	  success: function(e, data) {
		$("#importFile").show();
		$("#fileuploadDiv").after("<b>该文件等待处理...</b>");
	  },
	  fail: function (e, data) {
	  	$("#fileuploadDiv p").remove();
	  	data.context = $('<p/>').text('Upload failed:'+data.errorThrown).appendTo($("#fileuploadDiv"));
	  },
	  done: function (e, data) {
	      //data.context.text('Upload finished.');
	      $("#fileuploadDiv p").remove();
	      $("#fileuploadDiv").append($('<a></a>').text(data.result[0].name)).append('<button type="button" class="btn clear notext delfile">删除</button>');
	      $('.delfile').click(function(){
	      	$.ajax({
					url : "${adk:resproxy('doUploadDel')}",
					data : {
						'fileId' : ''
					},// 请求参数，json格式
					success : function(data) {
						$("#fileuploadDiv").html("");
			        	$('#fileupload').show();
					}
				});
	      	$("#importFile").hide();
	    	$("b").hide();
	      });
	      data.context = $("#fileuploadDiv").html();
	      renderButtons();
	      $('#fileupload').hide();
	  }
	});
	$('.delfile').click(function(){
		$.ajax({
			url : "${adk:resproxy('doUploadDel')}",
			success : function(data) {
				$("#fileuploadDiv").html("");
	      	$('#fileupload').show();
			}
		});
	});
</script>
