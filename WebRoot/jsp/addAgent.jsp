<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>加盟代理</title>
    <link rel="stylesheet" type="text/css" href="/business/style/main.css" />
    <link rel="stylesheet" type="text/css" href="/business/style/front.css" />
</head>
<body>
<div id="top">
    <div id="top_content">
        <div id="top_left">
            <a href="/business/index.jsp">首页</a>
            <a href="/business/jsp/companyProfile.jsp">企业简介</a>
            <a href="/business/jsp/companyNews.jsp">企业新闻</a>
            <a href="/business/jsp/productShow.jsp">产品展示</a>
            <a href="/business/jsp/addAgent.jsp">加盟代理</a>
            <a href="/business/jsp/addComment.jsp">用户评论</a>
        </div>
        <div id="top_right">
    			<c:if test="${empty inname}">
    	 			<a class="right" href="/business/jsp/register.jsp">免费注册</a>
   	     			<a class="right" id="lo" href="/business/jsp/login.jsp">请登录</a>
    			</c:if>
   				<c:if test="${!empty inname}">
   					<a href="/business/Exit">退出登录</a>
    				<div id="logover">您好，${inname}</div>
    			</c:if>
    		</div>
    </div>
</div>
<div id="banner"></div>
<div id="main">
    <div id="text">
    <h2>关于加盟 </h2>
<p>
加盟条件
一、	加盟商需要熟悉当地市场，有一定的经济实力，具有良好的商业信誉，在当地有一定的社会人脉资源；
二、	加盟商需具有维护企业品牌形象的责任意识，认同本公司的经营和管理理念；
三、	加盟商需具有积极的创富意愿、创新意识，并愿意长期合作，以此为事业的合作伙伴；
四、	加盟商需具有一定法律意识，有处理各种突发问题的能力；
五、	加盟商需具有独立，合法的营业执照；
</p>
<p>
二、    加盟流程
</p>
<p>
1、申请
由拓展部人员介绍详细加盟流程后，向“infinite power”总部申领加盟商与店铺的评估表（表格另附）。
</p>
<p>
2、递交评估表
选定商铺，如实填写评估表格，直接向“infinite power”总部递交或发传真和发送电子邮件。
</p>
<p>
3、评估
总部派员工对商铺及业主进行个人及风险评估
1.个人评估 2.商铺评估 3.风险评估
A.加盟者个人情况 A.商圈情况分析 A.加盟目的
B.加盟者个人资料 B.营业场地分析 B.投资分配
C.对加盟行业的认知度 C.店铺资料 C.资金来源
D.对加盟体系配合的意念 D.目标客户分析 D.对于在出资用于营运的态度
认定结果要求在申请人递交申请表后10个工作日内完成，专电或专函通知申情人认定结论。
</p>
<p>
4、签约
认定合格者了解加盟合同内容。正式签约成为加盟店后须交纳相应的保证金，签约同时加盟者应提供营业执照、本人身份证、税务登记证正本原件，由总部复印存档。
</p>
<p>
6、培训
加盟业主需派员工参加“infinite power”总部组织进培训。培训完毕，经考核合格后颁发培训结业证书方可于加盟公司上岗。
</p>
<p>
7、开业筹备
“infinite power”总部将在加盟公司开业前，指导加盟公司筹备店内事务用品及系列产品。
</p>
<p>
8、营运
“infinite power”总部与加盟公司将保持双向联系，并提供服务与支持，加盟公司则每月按一定额度进货。
</p>
<p>
9、续约
如要续约，加盟公司在合同到期前三个月的书面形式向“infinite power”总部提出申请。
</p>

<p>

梦想的成功始于实际的行动，不要让您伟大的梦想成为幻想。
相信科技的力量，相信科技改变世界，即可加入，成功将不再是梦想。
 </p>                                            
    
    </div>
</div>
<div id="bottom">©版权所有 第四组 企业网站</div>
</body>
</html>